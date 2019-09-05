package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import FlightApi.BookResponse;
import FlightApi.FareQuote;
import FlightApi.FareQuoteRespone;
import FlightApi.FareRule;
import FlightApi.FareRuleResponse;
import FlightApi.FlightApiService;
import FlightApi.FlightAuthentication;
import FlightApi.FlightBook;
import FlightApi.FlightConstants;
import FlightApi.FlightSSR;
import FlightApi.FlightSSRRespone;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlightsSummary extends AppCompatActivity {

    Button proccedBtn;
    @BindView(R.id.toolbar_back1)
    ImageView toolbarBack1;
    @BindView(R.id.toolbar_back)
    RelativeLayout toolbarBack;
    @BindView(R.id.line1)
    View line1;
    @BindView(R.id.tv_price_summary)
    TextView tvPriceSummary;
    @BindView(R.id.line2)
    View line2;
    @BindView(R.id.tv_bey)
    TextView tvBey;
    @BindView(R.id.tv_to)
    TextView tvTo;
    @BindView(R.id.tv_dxb)
    TextView tvDxb;
    @BindView(R.id.tv_country)
    TextView tvCountry;
    @BindView(R.id.tv_ccountry)
    TextView tvCcountry;
    @BindView(R.id.relative_country)
    RelativeLayout relativeCountry;
    @BindView(R.id.tv_flight)
    TextView tvFlight;
    @BindView(R.id.iv_icon)
    CircleImageView ivIcon;
    @BindView(R.id.tv_airline)
    TextView tvAirline;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.relative_airline)
    RelativeLayout relativeAirline;
    @BindView(R.id.iv_bag)
    ImageView ivBag;
    @BindView(R.id.tv_kg)
    TextView tvKg;
    @BindView(R.id.iv_bag2)
    ImageView ivBag2;
    @BindView(R.id.relative_package)
    RelativeLayout relativePackage;
    @BindView(R.id.tv_cabin_class)
    TextView tvCabinClass;
    @BindView(R.id.tv_departure)
    TextView tvDeparture;
    @BindView(R.id.tv_date_departure)
    TextView tvDateDeparture;
    @BindView(R.id.tv_arrival)
    TextView tvArrival;
    @BindView(R.id.date_arrival)
    TextView dateArrival;
    @BindView(R.id.tv_bey2)
    TextView tvBey2;
    @BindView(R.id.tv_to2)
    TextView tvTo2;
    @BindView(R.id.tv_dxb2)
    TextView tvDxb2;
    @BindView(R.id.tv_country2)
    TextView tvCountry2;
    @BindView(R.id.tv_ccountry2)
    TextView tvCcountry2;
    @BindView(R.id.relative_country2)
    RelativeLayout relativeCountry2;
    @BindView(R.id.tv_flight2)
    TextView tvFlight2;
    @BindView(R.id.iv_icon2)
    ImageView ivIcon2;
    @BindView(R.id.tv_airline2)
    TextView tvAirline2;
    @BindView(R.id.tv_time2)
    TextView tvTime2;
    @BindView(R.id.relative_airline2)
    RelativeLayout relativeAirline2;
    @BindView(R.id.iv_bag21)
    ImageView ivBag21;
    @BindView(R.id.tv_kg2)
    TextView tvKg2;
    @BindView(R.id.iv_bag22)
    ImageView ivBag22;
    @BindView(R.id.relative_package2)
    RelativeLayout relativePackage2;
    @BindView(R.id.tv_cabin_class2)
    TextView tvCabinClass2;
    @BindView(R.id.tv_departure2)
    TextView tvDeparture2;
    @BindView(R.id.tv_date_departure2)
    TextView tvDateDeparture2;
    @BindView(R.id.tv_arrival2)
    TextView tvArrival2;
    @BindView(R.id.date_arrival2)
    TextView dateArrival2;
    @BindView(R.id.relalala)
    RelativeLayout relalala;
    @BindView(R.id.closure)
    RelativeLayout closure;
    @BindView(R.id.relative_all)
    RelativeLayout relativeAll;
    @BindView(R.id.tv_cambainBages)
    TextView tvCambainBages;
    private long flightCabinClass;
    private Retrofit retrofit;
    private String password;
    public static final String BASE_URL = "https://xmloutapi.tboair.com/api/v1/";
    private String a_deTime;
    private String MDataMrmisAdult,
            MDataMrmisChild,
            MDataMrmisInfent,
            firstNameAduld,
            firstNameChild,
            firstNameInfant,
            lastNameAduld,
            lastNameChild,
            lastNameInfant,
            datebirthadult,
            datebirthchild,
            datebirthinfant,
            nationality_adult,
            nationality_child,
            nationality_infant;
    private String countryNameOrogin1,
            countryNameDestination1,
            cabinBaggage,
            CityNameDestination1,
            CityNameOrogin1,
            groundTime,
            Direct,
            additionalBaggage,
            flightNumberSize1,
            departureTime,
            arrivalTime,
            countryCodeDestnation1,
            countryCodeOrigin1;
    private String airlinenName;
    RelativeLayout relative_back_flight_summary;
    ImageView iv_booked_flight_summary;

    private String airlineCode   , countryNameOrogin1Return,
            countryNameDestination1Return,
            cabinBaggageReturn,
            CityNameDestination1Return,
            CityNameOrogin1Return,
            groundTimeReturn,
            directReturn,
            additionalBaggageReturn,
            flightNumberSize1Return,
            departureTime_Return,
            arrivalTime_Return,
            countryCodeDestnation1Return,
            countryCodeOrigin1Return;
    private String airlineReturn;
    private String bookingClassReturn;
    private String airlineCode_return;
    TextView assistantLabelVoiceRenewHotel;
    RelativeLayout relativeImgRenewHotelTamm;
    TextView assistantLabelCallRenewHotel;
    TextView assistantLabelMessageRenewHotel;
    private boolean ClickRenewHotel = false;
    private List<FareQuoteRespone.Result> result;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flights_summary);
        ButterKnife.bind(this);
        password = getString(R.string.passowrd_flight);



        iv_booked_flight_summary=findViewById(R.id.iv_booked_flight_summary);
        iv_booked_flight_summary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(FlightsSummary.this,MyBookActivity.class);
                startActivity(intent);
            }
        });

        relative_back_flight_summary=findViewById(R.id.relative_back_flight_summary);
        relative_back_flight_summary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        BookingFlight();
        proccedBtn = findViewById(R.id.procced_btn);
        assistantLabelVoiceRenewHotel=findViewById(R.id.assistant_label_voice_renew_flight_summary);
        relativeImgRenewHotelTamm=findViewById(R.id.relative_img_renew_flight_summary);
        assistantLabelCallRenewHotel=findViewById(R.id.assistant_label_call_renew_flight_summary);
        assistantLabelMessageRenewHotel=findViewById(R.id.assistant_label_message_renew_flight_summary);
        relativeImgRenewHotelTamm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ClickRenewHotel == false) {
                    assistantLabelCallRenewHotel.setVisibility(View.VISIBLE);
                    assistantLabelMessageRenewHotel.setVisibility(View.VISIBLE);
                    assistantLabelVoiceRenewHotel.setVisibility(View.VISIBLE);
                    ClickRenewHotel = true;

                } else {
                    assistantLabelCallRenewHotel.setVisibility(View.INVISIBLE);
                    assistantLabelMessageRenewHotel.setVisibility(View.INVISIBLE);
                    assistantLabelVoiceRenewHotel.setVisibility(View.INVISIBLE);
                    ClickRenewHotel = false;

                }
            }
        });
        assistantLabelVoiceRenewHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlightsSummary.this, VoiceMessageActivity.class);
                startActivity(intent);
                Toast.makeText(FlightsSummary.this, "Voice", Toast.LENGTH_SHORT).show();
            }
        });
        assistantLabelCallRenewHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlightsSummary.this, AssistantActivity.class);
                startActivity(intent);

                Toast.makeText(FlightsSummary.this, "Call", Toast.LENGTH_SHORT).show();
            }
        });

        assistantLabelMessageRenewHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FlightsSummary.this, ContactUs.class);
                startActivity(intent);

                Toast.makeText(FlightsSummary.this, "Message", Toast.LENGTH_SHORT).show();
            }
        });

        proccedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //    BookingFlight();
            }
        });


        int journyTipe = SharedPreferencesManger.LoadIntegerData(this, "journyTipe");

        int size =  SharedPreferencesManger.LoadIntegerData(FlightsSummary.this, "size");
        int sizeReturn =  SharedPreferencesManger.LoadIntegerData(FlightsSummary.this, "sizeReturn");


        if (journyTipe==1&&size==1){


            setDataOneWayDirect();


        }else if (journyTipe==2&&sizeReturn==1){

            setDataOneWayDirect();

            closure.setVisibility(View.VISIBLE);

            countryNameOrogin1Return =    SharedPreferencesManger.LoadStringData(this, "countryNameOrogin1Return" );

            countryNameDestination1Return=  SharedPreferencesManger.LoadStringData(this, "countryNameDestination1Return" );

            cabinBaggageReturn    = SharedPreferencesManger.LoadStringData(this, "cabinBaggageReturn" );

            CityNameDestination1Return  =SharedPreferencesManger.LoadStringData(this, "CityNameDestination1Return" );

            CityNameOrogin1Return  = SharedPreferencesManger.LoadStringData(this, "CityNameOrogin1Return" );


            groundTimeReturn    = SharedPreferencesManger.LoadStringData(this, "groundTimeReturn" );

            directReturn =SharedPreferencesManger.LoadStringData(this, "directReturn");

            additionalBaggageReturn =SharedPreferencesManger.LoadStringData(this, "additionalBaggageReturn" );


            flightNumberSize1Return   = SharedPreferencesManger.LoadStringData(this, "flightNumberSize1Return" );

            departureTime_Return  =SharedPreferencesManger.LoadStringData(this, "departureTimeReturn" );

            arrivalTime_Return = SharedPreferencesManger.LoadStringData(this, "arrivalTimeReturn" );

            countryCodeDestnation1Return  = SharedPreferencesManger.LoadStringData(this, "countryCodeDestnation1Return" );

            countryCodeOrigin1Return    = SharedPreferencesManger.LoadStringData(this, "countryCodeOrigin1Return" );
            airlineReturn    = SharedPreferencesManger.LoadStringData(this, "airlineReturn" );
            bookingClassReturn    = SharedPreferencesManger.LoadStringData(this, "bookingClassReturn" );
            airlineCode_return    = SharedPreferencesManger.LoadStringData(this, "airlineCode_return" );


            tvBey2.setText(countryCodeOrigin1Return);
            tvDxb2.setText(countryCodeDestnation1Return);
            tvCountry2.setText(CityNameOrogin1Return);
            tvCcountry2.setText(CityNameDestination1Return);
            tvFlight2.setText(
                    "Flight Nb: "+flightNumberSize1Return);
            tvAirline2.setText(airlineReturn);
            tvTime2.setText(groundTimeReturn);
            tvKg2.setText(additionalBaggageReturn);
            tvCabinClass2.setText(bookingClassReturn);

            ivIcon2.setImageResource(getResources().getIdentifier(airlineCode_return, "drawable", getPackageName()));







            String[] detimeSplit = departureTime_Return.split("T");

            String datDe = detimeSplit[0];
            String timeD = detimeSplit[1];

            tvDateDeparture2.setText("DATE : "+datDe);
            tvDeparture2.setText("Departure : "+timeD);


            String[] arrSplit = arrivalTime_Return.split("T");
            String arrDate = arrSplit[0];
            String arrTime = arrSplit[1];

            dateArrival2.setText("DATE : "+arrDate);


            tvArrival2.setText("Arrive : "+arrTime);








        }


        SharedPreferencesManger.remove(FlightsSummary.this, "departureTime");
        SharedPreferencesManger.remove(FlightsSummary.this, "arrivalTime");





        flightCabinClass = SharedPreferencesManger.LoadLongData(this, "flightCabinClass");

        switch ((int) flightCabinClass) {

            case 1:
//                All

                tvCabinClass.setText("Cabin Class : All");
                break;
            case 2:
                tvCabinClass.setText("Cabin Class : Economy");
//
                break;
            case 3:
                break;
            case 4:

                tvCabinClass.setText("Cabin Class : Business");

//
                break;

            case 5:
                tvCabinClass.setText("Cabin Class : Royal");

//
                break;
            case 6:
                tvCabinClass.setText("Cabin Class : First");

//

                break;
        }



    }

    private void setDataOneWayDirect() {


        MDataMrmisAdult = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "MDataMrmisAdult");
        MDataMrmisChild = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "MDataMrmisChild");
        MDataMrmisInfent = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "MDataMrmisInfent");

        //first
        firstNameAduld = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "FirstNameAduld");
        firstNameChild = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "FirstNameChild");
        firstNameInfant = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "FirstNameInfant");

        //last
        lastNameAduld = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "LastNameAduld");
        lastNameChild = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "LastNameChild");
        lastNameInfant = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "LastNameInfant");


        //date
        datebirthadult = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "datebirthadult");
        datebirthchild = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "datebirthchild");
        datebirthinfant = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "datebirthinfant");

        // nationality
        nationality_adult = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "nationality_adult");
        nationality_child = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "nationality_child");
        nationality_infant = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "nationality_infant");










        String bookingClass = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "bookingClass");
        airlinenName = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "airline");




        airlineCode =  SharedPreferencesManger.LoadStringData(this, "logoOneWaySize1");



        ivIcon.setImageResource(getResources().getIdentifier(airlineCode, "drawable",getPackageName()));


        countryNameOrogin1 =  SharedPreferencesManger.LoadStringData(this, "countryNameOrogin1" );

        countryNameDestination1= SharedPreferencesManger.LoadStringData(this, "countryNameDestination1" );

        cabinBaggage =SharedPreferencesManger.LoadStringData(this, "cabinBaggage" );

        CityNameDestination1= SharedPreferencesManger.LoadStringData(this, "CityNameDestination1" );

        CityNameOrogin1= SharedPreferencesManger.LoadStringData(this, "CityNameOrogin1" );


        groundTime  = SharedPreferencesManger.LoadStringData(this, "groundTime" );

        Direct = SharedPreferencesManger.LoadStringData(this, "direct" );

        additionalBaggage = SharedPreferencesManger.LoadStringData(this, "additionalBaggage" );


        flightNumberSize1  = SharedPreferencesManger.LoadStringData(this, "flightNumberSize1" );

        departureTime=  SharedPreferencesManger.LoadStringData(this, "departureTime" );

        arrivalTime=  SharedPreferencesManger.LoadStringData(this, "arrivalTime" );

        countryCodeDestnation1 =SharedPreferencesManger.LoadStringData(this, "countryCodeDestnation1" );

        countryCodeOrigin1 = SharedPreferencesManger.LoadStringData(this, "countryCodeOrigin1" );









        tvBey.setText(countryCodeOrigin1);
        tvCountry.setText(CityNameOrogin1);

        tvDxb.setText(countryCodeDestnation1);
        tvCcountry.setText(CityNameDestination1);

        tvFlight.setText("Flight Nb: "+flightNumberSize1);

        tvAirline.setText(airlinenName);
        tvTime.setText(groundTime);
        tvCambainBages.setText(cabinBaggage);
        tvKg.setText(additionalBaggage);
        tvCabinClass.setText(bookingClass);


        String[] detimeSplit = departureTime.split("T");

        String datDe = detimeSplit[0];
        String timeD = detimeSplit[1];

        tvDateDeparture.setText("DATE : "+datDe);
        tvDeparture.setText("Departure : "+timeD);


        String[] arrSplit = arrivalTime.split("T");
        String arrDate = arrSplit[0];
        String arrTime = arrSplit[1];

        dateArrival.setText("DATE : "+arrDate);


        tvArrival.setText("Arrive : "+arrTime);


    }

//    private void BookingFlight() {
//
//        Gson gson = new GsonBuilder()
//                .create();
//
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//
//        OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(interceptor).connectTimeout(0, TimeUnit.SECONDS)
//                .readTimeout(0, TimeUnit.SECONDS).build();
//
//        connectAndGetApiData(gson, client);
//        FlightApiService flightApiService = retrofit.create(FlightApiService.class);
//
//        final FlightAuthentication[] flightAuthentication = {new FlightAuthentication()};
//        flightAuthentication[0].setUserName(FlightConstants.API_USER_NAME);
//        flightAuthentication[0].setPassword(password);
//        flightAuthentication[0].setBookingMode("API");
//        flightAuthentication[0].setIPAddress("192.168.4.238");
//
//        Call<FlightAuthentication> call = flightApiService.getAuthentication("application/json", flightAuthentication[0]);
//        call.enqueue(new Callback<FlightAuthentication>() {
//            @Override
//            public void onResponse(Call<FlightAuthentication> call, Response<FlightAuthentication> response) {
//                flightAuthentication[0] = response.body();
//
//
//                boolean successful = response.isSuccessful();
//
//
////
////
////
////                String resultId = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "resultId");
////
////
////
////                String totalFare = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "totalFare");
////
////
////                String baseFare = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "baseFare");
////                String tax = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tax");
////                String serviceFee = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "serviceFee");
////
////
////
////                String tokenId = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tokenId");
////                String trackingId = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "trackingId");
////
////
////
////
////                final FlightBook[] bookingFlights = {new FlightBook()};
////
////                bookingFlights[0].setIPAddress("192.168.4.238");
////
////                //Origin Country code
////                bookingFlights[0].setPointOfSale(countryCodeOrigin1);
////
////                bookingFlights[0].setTokenId(tokenId);
////                bookingFlights[0].setTrackingId(trackingId);
////
////                bookingFlights[0].setResultId((resultId));
////
////                bookingFlights[0].setUserData(firstNameAduld);
////
////
////                FlightBook.Itinerary itinerary = new FlightBook.Itinerary();
////
////                FlightBook.City city = new FlightBook.City();
////                FlightBook.Nationality nationality = new FlightBook.Nationality();
////                nationality.setCountryCode(countryCodeOrigin1);
////                nationality.setCountryName(countryNameOrogin1);
////
////                FlightBook.Country country = new FlightBook.Country();
////                country.setCountryCode(countryCodeOrigin1);
////                country.setCountryName(countryNameOrogin1);
////
////                city.setCityName(CityNameOrogin1);
////                List<FlightBook.Passenger> passengerList = new ArrayList<>();
////
////
////                FlightBook.Fare fare = new FlightBook.Fare();
////
////
////
////                fare.setBaseFare(Double.parseDouble(baseFare));
////                fare.setTax(Double.parseDouble(tax));
////                String[] split = totalFare.split(" ");
////                String tootal = split[0];
////                fare.setTotalFare(Double.parseDouble(tootal));
////                fare.setServiceFee(Long.parseLong(serviceFee));
////
////
////                FlightBook.Passenger passenger = new FlightBook.Passenger();
////                passenger.setNationality(nationality);
////                passenger.setFirstName(firstNameAduld);
////                passenger.setTitle(getString(R.string.adult));
////                passenger.setLastName(lastNameAduld);
////                passenger.setGender(1);
////                passenger.setCity(city);
////                passenger.setCountry(country);
////
////
////                 //passenger.setMobile1("00112545645");
////
////                passenger.setAddressLine1("cairo");
////                passenger.setFare(fare);
////                //  itinerary.setTravelDate(a_deTime);
////                passengerList.ic_add(passenger);
////
////                itinerary.setPassenger(passengerList);
////
////
////
////
////                bookingFlights[0].setItinerary(itinerary);
//
//
//                Call<BookResponse> flightBook = flightApiService.getFlightBook("application/json", bookingFlights[0]);
//                flightBook.enqueue(new Callback<BookResponse>() {
//                    @Override
//                    public void onResponse(Call<BookResponse> call, Response<BookResponse> response) {
//
//
//                        String ssrMessage = response.body().getTokenId();
//                        Toast.makeText(FlightsSummary.this, "" + ssrMessage, Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onFailure(Call<BookResponse> call, Throwable t) {
//
//                        Toast.makeText(FlightsSummary.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
////
//
//            }
//
//            @Override
//            public void onFailure(Call<FlightAuthentication> call, Throwable t) {
//
//
//                Toast.makeText(FlightsSummary.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//    }





    private void BookingFlight() {



        Gson gson = new GsonBuilder()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(interceptor).connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS).build();

        connectAndGetApiData(gson, client);
        FlightApiService flightApiService = retrofit.create(FlightApiService.class);

        final FlightAuthentication[] flightAuthentication = {new FlightAuthentication()};
        flightAuthentication[0].setUserName(FlightConstants.API_USER_NAME);
        flightAuthentication[0].setPassword(password);
        flightAuthentication[0].setBookingMode("API");
        flightAuthentication[0].setIPAddress("192.168.4.238");

        //--------------------------------------------------------------


        FareRule fareRule = new FareRule();
        String resultId = SharedPreferencesManger.LoadStringData(this, "resultId");


        String tokenId = SharedPreferencesManger.LoadStringData(this, "tokenId");
        String trackingId = SharedPreferencesManger.LoadStringData(this, "trackingId");

        fareRule.setResultId(resultId);
        fareRule.setTokenId(tokenId);
        fareRule.setTrackingId(trackingId);
        fareRule.setPointOfSale("AE");
        fareRule.setEndUserBrowserAgent("Mozilla/5.0(Windows NT 6.1)");
        fareRule.setIPAddress("192.168.4.238");
        fareRule.setRequestOrigin("Egypt");

        Call<FareRuleResponse> fareRuleResponseCall = flightApiService.getFareRuleResponse("application/json",fareRule);
        fareRuleResponseCall.enqueue(new Callback<FareRuleResponse>() {
            @Override
            public void onResponse(Call<FareRuleResponse> call, Response<FareRuleResponse> response) {


                FareRuleResponse body = response.body();
                Toast.makeText(FlightsSummary.this, ""+body, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<FareRuleResponse> call, Throwable t) {

                t.getMessage();
            }
        });

        //-------------------------------------------------------------------

        FareQuote fareQuote = new FareQuote();

        fareQuote.setResultId(resultId);
        fareQuote.setTokenId(tokenId);
        fareQuote.setTrackingId(trackingId);
        fareQuote.setPointOfSale("AE");
        fareQuote.setEndUserBrowserAgent("Mozilla/5.0(Windows NT 6.1)");
        fareQuote.setIPAddress("192.168.4.238");
        fareQuote.setRequestOrigin("Egypt");

        Call<FareQuoteRespone> fareQuoteResponeCall = flightApiService.getFareQuote("application/json",fareQuote);
        fareQuoteResponeCall.enqueue(new Callback<FareQuoteRespone>() {
            @Override
            public void onResponse(Call<FareQuoteRespone> call, Response<FareQuoteRespone> response) {


                result = response.body().getResult();
                result.get(0).getFare().getBaseFare();
                result.get(0).getFare().getServiceFee();
                result.get(0).getFare().getTax();

            }

            @Override
            public void onFailure(Call<FareQuoteRespone> call, Throwable t) {

            }
        });





        //--------------------------------------------------------------------------

        //-------------------------------------------------------------------

        FlightSSR flightSSR = new FlightSSR();

        flightSSR.setResultId(resultId);
        flightSSR.setTokenId(tokenId);
        flightSSR.setTrackingId(trackingId);
        flightSSR.setPointOfSale("AE");
        flightSSR.setEndUserBrowserAgent("Mozilla/5.0(Windows NT 6.1)");
        flightSSR.setRequestOrigin("Egypt");

        Call<FlightSSRRespone> flightSSRResponeCall = flightApiService.getSSRResponse("application/json",flightSSR);
        flightSSRResponeCall.enqueue(new Callback<FlightSSRRespone>() {
            @Override
            public void onResponse(Call<FlightSSRRespone> call, Response<FlightSSRRespone> response) {

            }

            @Override
            public void onFailure(Call<FlightSSRRespone> call, Throwable t) {

            }
        });





        //--------------------------------------------------------------------------

        Call<FlightAuthentication> call = flightApiService.getAuthentication("application/json", flightAuthentication[0]);
        call.enqueue(new Callback<FlightAuthentication>() {
            @Override
            public void onResponse(Call<FlightAuthentication> call, Response<FlightAuthentication> response) {
                flightAuthentication[0] = response.body();

                FlightBook.Itinerary itinerary = new FlightBook.Itinerary();

                boolean successful = response.isSuccessful();

                String tokenId = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tokenId");
                String trackingId = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "trackingId");


                String resultId1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "resultId1");
                String PointOfSale = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "PointOfSale");


                final FlightBook[] bookingFlights = {new FlightBook()};

                bookingFlights[0].setIPAddress("192.168.4.238");

                bookingFlights[0].setRequestOrigin("Egypt");

                //Origin Country code
                bookingFlights[0].setPointOfSale(PointOfSale);

                bookingFlights[0].setTokenId(tokenId);
                bookingFlights[0].setTrackingId(trackingId);

                bookingFlights[0].setResultId((resultId1));

                bookingFlights[0].setUserData("ahmed");
                bookingFlights[0].setItinerary(itinerary);


                List<FlightBook.Passenger> passengerList = new ArrayList<>();
                FlightBook.Passenger passenger  = new FlightBook.Passenger();

                passenger.setTitle("Mr");
                passenger.setFirstName("Abdallah");
                passenger.setLastName("Mohammed");
                passenger.setIsLeadPax(true);
                passenger.setGender("1");
                passenger.setAddressLine1("cairo");
                passenger.setAddressLine2("cairo");
                FlightBook.City city  = new FlightBook.City();
                city.setCityCode("CAI");
                city.setCityName("Cairo");
                city.setCountryCode("EG");
                passenger.setCity(city);

                FlightBook.Country country = new FlightBook.Country();
                country.setCountryName("Egypt");
                country.setCountryCode("EG");
                passenger.setCountry(country);
                passenger.setZipCode("11828");
                passenger.setEmail("abdallah@gmail.com");
                passenger.setMobile1CountryCode("002");
                passenger.setType(1);

                passengerList.add(passenger);
                itinerary.setTravelDate(departureTime);

//                itinerary.setSegments();
                itinerary.setPassenger(passengerList);









//                FlightBook.FareRule fareRule = new FlightBook.FareRule();
//
//                FlightBook.AirlineDetails  airlineDetails = new FlightBook.AirlineDetails();
//
//                FlightBook.Segment segment = new FlightBook.Segment();
//
//                FlightBook.Destination destination = new FlightBook.Destination();
//                FlightBook.Origin origin = new FlightBook.Origin();
//
//
//                List<FlightBook.Segment> segmentList = new ArrayList<>();
//
//                destination.setAirportCode("");
//                destination.setAirportName("");
//                destination.setCityName(CityNameDestination1);
//                destination.setCityCode("");
//                destination.setCountryCode(countryCodeDestnation1);
//                destination.setCountryName(countryNameDestination1);
//
//                //
//                origin.setAirportCode("");
//                origin.setAirportName(airlinenName);
//                origin.setCityName(CityNameOrogin1);
//                origin.setCityCode("");
//                origin.setCountryCode(countryCodeOrigin1);
//                origin.setCountryName(countryNameOrogin1);
//
//
//                segment.setNoOfSeatAvailable(7);
//                segment.setAirline(airlinenName);
//
//                segment.setOrigin(origin);
//                segment.setDestination(destination);
//                segment.setFlightNumber(flightNumberSize1);
//                segment.setDepartureTime(departureTime);
//                segment.setBookingClass(tvCabinClass.getText().toString());
//                segment.setETicketEligible(true);
//                segment.setDuration("17:10:00");
//                segment.setGroundTime(groundTime);
//
//
//
//
//                // AirlineDetails
//
//                airlineDetails.setAirlineCode("");
//                airlineDetails.setAirlineName(airlinenName);
//                airlineDetails.setFlightNumber(flightNumberSize1);
//
//                segment.setAirlineDetails(airlineDetails);
//
//
//                segmentList.ic_add(segment);
//                itinerary.setSegments(segmentList);



//                List<FlightBook.FareRule> fareRuleList = new ArrayList<>();








//
//                FlightBook.City city = new FlightBook.City();
//                FlightBook.Nationality nationality = new FlightBook.Nationality();
//                nationality.setCountryCode("EG");
//                nationality.setCountryName("Egypt");
////
//                FlightBook.Country country = new FlightBook.Country();
//                country.setCountryCode("EG");
//                country.setCountryName("Egypt");
////
//                city.setCityName("Ciro");
//                city.setCityCode("CAI");
//                List<FlightBook.Passenger> passengerList = new ArrayList<>();
//
//
////
//                FlightBook.Fare fare = new FlightBook.Fare();
//                fare.setBaseFare(1230);
//                fare.setTax(30);
//                fare.setTotalFare(1260);
//                fare.setServiceFee(500);
////





                bookingFlights[0].setItinerary(itinerary);





                Call<BookResponse> flightBook = flightApiService.getFlightBook("application/json", bookingFlights[0]);
                flightBook.enqueue(new Callback<BookResponse>() {
                    @Override
                    public void onResponse(Call<BookResponse> call, Response<BookResponse> response) {


                        String message = response.raw().message();
                        Toast.makeText(FlightsSummary.this, ""+message, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<BookResponse> call, Throwable t) {

                        Toast.makeText(FlightsSummary.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }

            @Override
            public void onFailure(Call<FlightAuthentication> call, Throwable t) {


                Toast.makeText(FlightsSummary.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }









    public Retrofit connectAndGetApiData(Gson gson, OkHttpClient client) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

}
