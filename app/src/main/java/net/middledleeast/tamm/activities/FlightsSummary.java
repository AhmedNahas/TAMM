package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
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

import FlightApi.BookFlight;
import FlightApi.City;
import FlightApi.Country;
import FlightApi.Fare;
import FlightApi.FareQuote;
import FlightApi.FareQuoteRespone;
import FlightApi.FareRuleRequest;
import FlightApi.FlightApiService;
import FlightApi.FlightAuthentication;
import FlightApi.FlightConstants;
import FlightApi.FlightGetBooking;
import FlightApi.FlightTicket;
import FlightApi.GetBookingResponse;
import FlightApi.Itinerary;
import FlightApi.Nationality;
import FlightApi.Passenger;
import FlightApi.Segment;

import FlightApi.TicketResponse;
import FlightApi.fare_rules.FareRule;
import FlightApi.fare_rules.FareRuleResponse;
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

import static net.middledleeast.tamm.helper.helperMethod.getLocalIpAddress;

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
    private String countryNameOrogin1, airlineCode_,
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

    private String airlineCode, countryNameOrogin1Return,
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
    //  private List<FareQuoteRespone.Result> result;
    double baseFare,
            serviceFee,
            tax;
    private List<Segment> segmentsList = new ArrayList<>();
    private String resultId,
            tokenId,
            trackingId;
    private String origin, destination;
//    private FareRuleResponse.FareRule fareRule1;
ProgressBar flight_progress;
    private String lastTicketDate, validatingAirline;
    private String totalFare;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flights_summary);
        ButterKnife.bind(this);
        password = getString(R.string.passowrd_flight);


        flight_progress =findViewById(R.id.flight_progress);


        flight_progress.setVisibility(View.INVISIBLE);

        resultId = SharedPreferencesManger.LoadStringData(this, "resultId");


        tokenId = SharedPreferencesManger.LoadStringData(this, "tokenId");
        trackingId = SharedPreferencesManger.LoadStringData(this, "trackingId");

        iv_booked_flight_summary = findViewById(R.id.iv_booked_flight_summary);
        iv_booked_flight_summary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlightsSummary.this, MyBookActivity.class);
                startActivity(intent);
            }
        });

        relative_back_flight_summary = findViewById(R.id.relative_back_flight_summary);
        relative_back_flight_summary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        proccedBtn = findViewById(R.id.procced_btn);
        assistantLabelVoiceRenewHotel = findViewById(R.id.assistant_label_voice_renew_flight_summary);
        relativeImgRenewHotelTamm = findViewById(R.id.relative_img_renew_flight_summary);
        assistantLabelCallRenewHotel = findViewById(R.id.assistant_label_call_renew_flight_summary);
        assistantLabelMessageRenewHotel = findViewById(R.id.assistant_label_message_renew_flight_summary);
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

                BookingFlight();

            }
        });


        int journyTipe = SharedPreferencesManger.LoadIntegerData(this, "journyTipe");
         totalFare = SharedPreferencesManger.LoadStringData(this, "totalFare");

        int size = SharedPreferencesManger.LoadIntegerData(FlightsSummary.this, "size");
        int sizeReturn = SharedPreferencesManger.LoadIntegerData(FlightsSummary.this, "sizeReturn");


        if (journyTipe == 1 && size == 1) {

            closure.setVisibility(View.GONE);

            setDataOneWayDirect();


        } else if (journyTipe == 2 && sizeReturn == 1) {

            setDataOneWayDirect();

            closure.setVisibility(View.VISIBLE);

            countryNameOrogin1Return = SharedPreferencesManger.LoadStringData(this, "countryNameOrogin1Return");

            countryNameDestination1Return = SharedPreferencesManger.LoadStringData(this, "countryNameDestination1Return");

            cabinBaggageReturn = SharedPreferencesManger.LoadStringData(this, "cabinBaggageReturn");

            CityNameDestination1Return = SharedPreferencesManger.LoadStringData(this, "CityNameDestination1Return");

            CityNameOrogin1Return = SharedPreferencesManger.LoadStringData(this, "CityNameOrogin1Return");


            groundTimeReturn = SharedPreferencesManger.LoadStringData(this, "groundTimeReturn");

            directReturn = SharedPreferencesManger.LoadStringData(this, "directReturn");

            additionalBaggageReturn = SharedPreferencesManger.LoadStringData(this, "additionalBaggageReturn");


            flightNumberSize1Return = SharedPreferencesManger.LoadStringData(this, "flightNumberSize1Return");

            departureTime_Return = SharedPreferencesManger.LoadStringData(this, "departureTimeReturn");

            arrivalTime_Return = SharedPreferencesManger.LoadStringData(this, "arrivalTimeReturn");

            countryCodeDestnation1Return = SharedPreferencesManger.LoadStringData(this, "countryCodeDestnation1Return");

            countryCodeOrigin1Return = SharedPreferencesManger.LoadStringData(this, "countryCodeOrigin1Return");
            airlineReturn = SharedPreferencesManger.LoadStringData(this, "airlineReturn");
            bookingClassReturn = SharedPreferencesManger.LoadStringData(this, "bookingClassReturn");
            airlineCode_return = SharedPreferencesManger.LoadStringData(this, "airlineCode_return");


            tvBey2.setText(countryCodeOrigin1Return);
            tvDxb2.setText(countryCodeDestnation1Return);
            tvCountry2.setText(CityNameOrogin1Return);
            tvCcountry2.setText(CityNameDestination1Return);
            tvFlight2.setText(
                    "Flight Nb: " + flightNumberSize1Return);
            tvAirline2.setText(airlineReturn);
            tvTime2.setText(groundTimeReturn);
            tvKg2.setText(additionalBaggageReturn);
            tvCabinClass2.setText(bookingClassReturn);

            ivIcon2.setImageResource(getResources().getIdentifier(airlineCode_return, "drawable", getPackageName()));


            String[] detimeSplit = departureTime_Return.split("T");

            String datDe = detimeSplit[0];
            String timeD = detimeSplit[1];

            tvDateDeparture2.setText("DATE : " + datDe);
            tvDeparture2.setText("Departure : " + timeD);


            String[] arrSplit = arrivalTime_Return.split("T");
            String arrDate = arrSplit[0];
            String arrTime = arrSplit[1];

            dateArrival2.setText("DATE : " + arrDate);


            tvArrival2.setText("Arrive : " + arrTime);


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


        airlineCode_ = SharedPreferencesManger.LoadStringData(this, "logoOneWaySize1");


        ivIcon.setImageResource(getResources().getIdentifier(airlineCode_, "drawable", getPackageName()));


        countryNameOrogin1 = SharedPreferencesManger.LoadStringData(this, "countryNameOrogin1");

        countryNameDestination1 = SharedPreferencesManger.LoadStringData(this, "countryNameDestination1");

        cabinBaggage = SharedPreferencesManger.LoadStringData(this, "cabinBaggage");

        CityNameDestination1 = SharedPreferencesManger.LoadStringData(this, "CityNameDestination1");

        CityNameOrogin1 = SharedPreferencesManger.LoadStringData(this, "CityNameOrogin1");


        groundTime = SharedPreferencesManger.LoadStringData(this, "groundTime");

        Direct = SharedPreferencesManger.LoadStringData(this, "direct");

        additionalBaggage = SharedPreferencesManger.LoadStringData(this, "additionalBaggage");


        flightNumberSize1 = SharedPreferencesManger.LoadStringData(this, "flightNumberSize1");

        departureTime = SharedPreferencesManger.LoadStringData(this, "departureTime");

        arrivalTime = SharedPreferencesManger.LoadStringData(this, "arrivalTime");

        countryCodeDestnation1 = SharedPreferencesManger.LoadStringData(this, "countryCodeDestnation1");

        countryCodeOrigin1 = SharedPreferencesManger.LoadStringData(this, "countryCodeOrigin1");


        tvBey.setText(countryCodeOrigin1);
        tvCountry.setText(CityNameOrogin1);

        tvDxb.setText(countryCodeDestnation1);
        tvCcountry.setText(CityNameDestination1);

        tvFlight.setText("Flight Nb: " + flightNumberSize1);

        tvAirline.setText(airlinenName);
        tvTime.setText(groundTime);
        tvCambainBages.setText(cabinBaggage);
        tvKg.setText(additionalBaggage);
        tvCabinClass.setText(bookingClass);


        String[] detimeSplit = departureTime.split("T");

        String datDe = detimeSplit[0];
        String timeD = detimeSplit[1];

        tvDateDeparture.setText("DATE : " + datDe);
        tvDeparture.setText("Departure : " + timeD);


        String[] arrSplit = arrivalTime.split("T");
        String arrDate = arrSplit[0];
        String arrTime = arrSplit[1];

        dateArrival.setText("DATE : " + arrDate);


        tvArrival.setText("Arrive : " + arrTime);


    }


    private void BookingFlight() {

        flight_progress.setVisibility(View.VISIBLE);
        Gson gson = new GsonBuilder()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(interceptor).connectTimeout(0, TimeUnit.SECONDS)
                .readTimeout(0, TimeUnit.SECONDS).build();

        connectAndGetApiData(gson, client);
        FlightApiService flightApiService = retrofit.create(FlightApiService.class);

//        final FlightAuthentication[] flightAuthentication = {new FlightAuthentication()};
//        flightAuthentication[0].setUserName(FlightConstants.API_USER_NAME);
//        flightAuthentication[0].setPassword(password);
//        flightAuthentication[0].setBookingMode("API");
//        flightAuthentication[0].setIPAddress("192.168.4.238");

        //--------------------------------------------------------------


        FareRuleRequest fareRules = new FareRuleRequest();


        fareRules.setResultId(resultId);
        fareRules.setTokenId(tokenId);
        fareRules.setTrackingId(trackingId);
//        fareRules.setPointOfSale("DOH");
//        fareRules.setEndUserBrowserAgent("Mozilla/5.0(Windows NT 6.1)");
//        fareRules.setIPAddress("192.168.4.238");
//        fareRules.setRequestOrigin("Doha International");

        Call<FareRuleResponse> fareRuleResponseCall = flightApiService.getFareRuleResponse("application/json", fareRules);
        fareRuleResponseCall.enqueue(new Callback<FareRuleResponse>() {
            @Override
            public void onResponse(Call<FareRuleResponse> call, Response<FareRuleResponse> response) {


                okhttp3.Response raw = response.raw();
                List<FareRule> fareRulesList = response.body().getFareRules().get(0);


                String tokenId = response.body().getTokenId();
                String trackingId = response.body().getTrackingId();
                FareQuote fareQuote = new FareQuote();

                fareQuote.setResultId(resultId);
                fareQuote.setTokenId(tokenId);
                fareQuote.setTrackingId(trackingId);
                fareQuote.setPointOfSale("AE");
                fareQuote.setEndUserBrowserAgent("Mozilla/5.0(Windows NT 6.1)");
                String localIpAddress = getLocalIpAddress();

                fareQuote.setIPAddress(localIpAddress);
                fareQuote.setRequestOrigin("Egypt");


                if (response.body().getIsSuccess()) {


                    Call<FareQuoteRespone> fareQuoteResponeCall = flightApiService.getFareQuote("application/json", fareQuote);
                    fareQuoteResponeCall.enqueue(new Callback<FareQuoteRespone>() {
                        @Override
                        public void onResponse(Call<FareQuoteRespone> call, Response<FareQuoteRespone> response) {


                            if (response.body().isIsSuccess()) {

                                String airlineCode = response.body().getResult().get(0).getSegments().get(0).get(0).getAirlineDetails().getAirlineCode();
                                String departureTime = response.body().getResult().get(0).getSegments().get(0).get(0).getDepartureTime();
                                String destination = response.body().getResult().get(0).getDestination();
                                List<Segment> segments = response.body().getResult().get(0).getSegments().get(0);
                                String arrivalTime = response.body().getResult().get(0).getSegments().get(0).get(0).getArrivalTime();
                                String origin = response.body().getResult().get(0).getOrigin();
                                Fare fare = response.body().getResult().get(0).getFare();
                                Object lastTicketDate = response.body().getResult().get(0).getLastTicketDate();
                                String validatingAirline = response.body().getResult().get(0).getValidatingAirline();

                                String tokenId1 = response.body().getTokenId();
                                String trackingId1 = response.body().getTrackingId();

                                BookFlight book = new BookFlight();

                                book.setTrackingId(trackingId1);
                                book.setResultId(resultId);
                                book.setTokenId(tokenId1);

                                String localIpAddress = getLocalIpAddress();


                                book.setiPAddress(localIpAddress);
                                book.setEndUserBrowserAgent("Mozilla/5.0(Windows NT 6.1)");

                                Itinerary itinerary = new Itinerary();
                                itinerary.setOrigin(origin);
                                itinerary.setDestination(destination);


                                Passenger passenger = new Passenger();

                                passenger.setFare(fare);
                                passenger.setAddressLine1("cairo");
                                passenger.setAddressLine2("cairo");
                                City city = new City();
                                city.setCityCode("CAI");
                                city.setCityName("cairo");
                                city.setCountryCode("Egypt");
                                passenger.setCity(city);
                                Country country = new Country();
                                country.setCountryCode("EG");
                                country.setCountryName("Egypt");
                                passenger.setCountry(country);
                                passenger.setEmail("abdallah@yahoo.com");
                                passenger.setFirstName(firstNameAduld);
                                passenger.setGender(1);
                                passenger.setIsLeadPax(true);
                                passenger.setLastName(lastNameAduld);
                                passenger.setType(1);
                                passenger.setTitle(MDataMrmisAdult);
                                Nationality nationality = new Nationality();

                                nationality.setCountryCode(countryCodeDestnation1);
                                nationality.setCountryName(countryNameDestination1);
                                passenger.setNationality(nationality);

                                passenger.setDateOfBirth(datebirthadult);
                                passenger.setFFNumber(flightNumberSize1);
                                passenger.setMobile1("01061213663");
                                passenger.setMobile1CountryCode("+2");


                                passenger.setPassportExpiry("02/02");
                                passenger.setPassportIssueCountryCode("2365");
                                passenger.setPassportIssueDate("01/01/1995");
                                passenger.setPassportNo("12542362198754");




                                itinerary.setTravelDate(departureTime);

                                itinerary.setTravelDate(arrivalTime);



                                itinerary.setAirlineCode(airlineCode);
                                itinerary.setLastTicketDate((String) lastTicketDate);
                                itinerary.setValidatingAirlineCode(validatingAirline);
                                itinerary.setSegments(segments);

                                itinerary.setFareRules(fareRulesList);

                                ArrayList<Passenger> passengerList = new ArrayList<>();
                                passengerList.add(passenger);
                                itinerary.setPassenger(passengerList);
                                itinerary.setIsLcc(false);
                                book.setItinerary(itinerary);


                                Call<GetBookingResponse> flightBookCall = flightApiService.getFlightBook("application/json", book);


                                flightBookCall.enqueue(new Callback<GetBookingResponse>() {
                                    @Override
                                    public void onResponse(Call<GetBookingResponse> call, Response<GetBookingResponse> response) {


                                        Itinerary itinerary1 = response.body().getItinerary();

//
//
                                       if (response.body().getItinerary().getPNR()!=null){

                                           FlightTicket flightTicket = new FlightTicket();
                                           String localIpAddress = getLocalIpAddress();
                                           flightTicket.setIPAddress(localIpAddress);

                                           flightTicket.setResultId(resultId);
                                           flightTicket.setTokenId(tokenId);
                                           flightTicket.setTrackingId(trackingId);
                                           flightTicket.setPNR(response.body().getItinerary().getPNR());

                                           flightTicket.setItinerary(itinerary1);

                                           flightApiService.getFlightTicket("application/json",flightTicket).enqueue(new Callback<TicketResponse>() {
                                               @Override
                                               public void onResponse(Call<TicketResponse> call, Response<TicketResponse> response) {

try {

    okhttp3.Response raw = response.raw();
    String pnr2 = response.body().getItinerary().getPNR();
    String tokenId2 = response.body().getTokenId();


    SharedPreferencesManger.SaveData(FlightsSummary.this,"pnr",pnr2);
    SharedPreferencesManger.SaveData(FlightsSummary.this,"tokenId2",tokenId2);
    Toast.makeText(FlightsSummary.this, "successful", Toast.LENGTH_SHORT).show();


}catch (Exception e){}

                                           Intent intent = new Intent(FlightsSummary.this,PaymentActivity.class);

                                           intent.putExtra("totalFare",totalFare);
                                           intent.putExtra("mId",3);

                                           startActivity(intent);


                                               }

                                               @Override
                                               public void onFailure(Call<TicketResponse> call, Throwable t) {
                                                   flight_progress.setVisibility(View.INVISIBLE);

                                               }
                                           });







//
//                                           Intent intent = new Intent(FlightsSummary.this,PaymentActivity.class);
//
//                                           intent.putExtra("totalFare",totalFare);
//                                           intent.putExtra("mId",3);
//
//                                           startActivity(intent);
                                       }

                                    }

                                    @Override
                                    public void onFailure(Call<GetBookingResponse> call, Throwable t) {
                                        t.getMessage();


                                        flight_progress.setVisibility(View.INVISIBLE);

                                    }
                                });

                            }


                        }


                        @Override
                        public void onFailure(Call<FareQuoteRespone> call, Throwable t) {
                            flight_progress.setVisibility(View.INVISIBLE);

                            t.getMessage();
                        }
                    });


                }

//


            }

            @Override
            public void onFailure(Call<FareRuleResponse> call, Throwable t) {
                flight_progress.setVisibility(View.INVISIBLE);

                t.getMessage();
            }
        });

        //-------------------------------------------------------------------


//
//        FlightSSR flightSSR = new FlightSSR();
//
//        flightSSR.setResultId(resultId);
//        flightSSR.setTokenId(tokenId);
//        flightSSR.setTrackingId(trackingId);
//        flightSSR.setPointOfSale("AE");
//        flightSSR.setEndUserBrowserAgent("Mozilla/5.0(Windows NT 6.1)");
//        flightSSR.setRequestOrigin("Egypt");
//
//        Call<FlightSSRRespone> flightSSRResponeCall = flightApiService.getSSRResponse("application/json", flightSSR);
//        flightSSRResponeCall.enqueue(new Callback<FlightSSRRespone>() {
//            @Override
//            public void onResponse(Call<FlightSSRRespone> call, Response<FlightSSRRespone> response) {
//
//
//                String tokenId1 = response.body().getTokenId();
//
//            }
//
//            @Override
//            public void onFailure(Call<FlightSSRRespone> call, Throwable t) {
//
//                t.getMessage();
//            }
//        });


        //--------------------------------------------------------------------------
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
