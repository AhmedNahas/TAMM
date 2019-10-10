package net.apptamm.tamm.activities;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.apptamm.tamm.R;
import net.apptamm.tamm.adapters.FlightTransitAdapter;
import net.apptamm.tamm.helper.SharedPreferencesManger;

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
import FlightApi.FlightTicket;
import FlightApi.GetBookingResponse;
import FlightApi.Itinerary;
import FlightApi.Nationality;
import FlightApi.Passenger;
import FlightApi.SearchFlightsResponse;
import FlightApi.Segment;
import FlightApi.TicketResponse;
import FlightApi.fare_rules.FareRule;
import FlightApi.fare_rules.FareRuleResponse;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static net.apptamm.tamm.helper.helperMethod.getLocalIpAddress;

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
    @BindView(R.id.relative_country)
    RecyclerView relativeCountry;
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
    @BindView(R.id.relative_country2)
    RecyclerView relativeCountry2;
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
    @BindView(R.id.tvDirect_)
    TextView tvDirect;
    @BindView(R.id.tvDirect2)
    TextView tvDirect2;
    @BindView(R.id.tvCambainBages2)
    TextView tvCambainBages2;
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
            nationality_infant,
            resultId,
            tokenId,
            trackingId,


            firstNameAduld2,
            lastNameAduld2, MDataMrmisAdult2,
            datebirthadult2,
            nationality_adult2,
            passportNo2,
            passportIssue2,
            passportEnd2, passportNo,
            passportIssue,
            passportEnd,

            firstNameAduld3,
            lastNameAduld3,
            MDataMrmisAdult3,
            datebirthadult3,
            nationality_adult3,
            passportNo3,
            passportIssue3,
            passportEnd3,

            firstNameAduld4,
            lastNameAduld4,
            MDataMrmisAdult4,
            datebirthadult4,
            nationality_adult4,
            passportNo4,
            passportIssue4,
            passportEnd4,

            firstNameAduld5,
            lastNameAduld5,
            MDataMrmisAdult5,
            datebirthadult5,
            nationality_adult5,
            passportNo5,
            passportIssue5,
            passportEnd5 ,



    MDataMrmisChild2,
    firstNameChild2,
            lastNameChild2,
    datebirthchild2,
            nationality_child2,
    MDataMrmisChild3,
            firstNameChild3,
    lastNameChild3,
            datebirthchild3,
    nationality_child3,
            MDataMrmisChild4,
    firstNameChild4,
            lastNameChild4,
    datebirthchild4,
            nationality_child4,
    MDataMrmisChild5,
            firstNameChild5,
    lastNameChild5,
            datebirthchild5,
    nationality_child5,
            MDataMrmisInfent2,
    firstNameInfant2,
            lastNameInfant2,
    datebirthinfant2,
            nationality_infant2,
    MDataMrmisInfent3,
            firstNameInfant3,
    lastNameInfant3,
            datebirthinfant3,
    nationality_infant3,
            MDataMrmisInfent4,
    firstNameInfant4,
            lastNameInfant4,
    datebirthinfant4,
            nationality_infant4,
    MDataMrmisInfent5,
            firstNameInfant5,
    lastNameInfant5,
            datebirthinfant5,
    nationality_infant5 ,


    passportChildNo1,
    tvIssueDateChild1,
            tvEndDateChild1;




            long adult,
            child,
            infant;


    RelativeLayout relative_back_flight_summary;
    ImageView iv_booked_flight_summary;


//    TextView assistantLabelVoiceRenewHotel;
    RelativeLayout relativeImgRenewHotelTamm;
//    TextView assistantLabelCallRenewHotel;
//    TextView assistantLabelMessageRenewHotel;
    private boolean ClickRenewHotel = false;

    ProgressBar flight_progress;
    private String passportChildNo2

            ,

    tvIssueDateChild2,
            tvEndDateChild2,
    passportChildNo3,
            tvIssueDateChild3,
    tvEndDateChild3,
            passportChildNo4,
    tvIssueDateChild4,
            tvEndDateChild4,
    passportChildNo5,
            tvIssueDateChild5,
    tvEndDateChild5,
            passportInfantNo1,
    tvIssueDateInfant1,
            tvEndDateInfant1,
    passportInfantNo2,
            tvIssueDateInfant2,
    tvEndDateInfant2,
            passportInfantNo3,
    tvIssueDateInfant3,
            tvEndDateInfant3,
    passportInfantNo4,
            tvIssueDateInfant4,
    tvEndDateInfant4,
            passportInfantNo5,
    tvIssueDateInfant5,
            tvEndDateInfant5;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flights_summary);
        ButterKnife.bind(this);
        password = getString(R.string.passowrd_flight);

        List<SearchFlightsResponse.Segment> segments = (List<SearchFlightsResponse.Segment>) getIntent().getSerializableExtra("segments");
        List<SearchFlightsResponse.Segment> segments2 = (List<SearchFlightsResponse.Segment>) getIntent().getSerializableExtra("segments");

        int journyTipe = SharedPreferencesManger.LoadIntegerData(this, "journyTipe");

        closure.setVisibility(View.GONE);


        if (journyTipe == 2) {


            closure.setVisibility(View.VISIBLE);

            List<SearchFlightsResponse.Segment> segmentsReturn = (List<SearchFlightsResponse.Segment>) getIntent().getSerializableExtra("segmentsReturn");
            List<SearchFlightsResponse.Segment> segmentsReturn2 = (List<SearchFlightsResponse.Segment>) getIntent().getSerializableExtra("segmentsReturn");


            relativeCountry2.setLayoutManager(new LinearLayoutManager(this));
            FlightTransitAdapter flightTransitAdapter = new FlightTransitAdapter(this, segmentsReturn2);
            relativeCountry2.setAdapter(flightTransitAdapter);
            flightTransitAdapter.notifyDataSetChanged();


            String flightNumber = segmentsReturn2.get(0).getFlightNumber();


            String cabinBaggage = (String) segmentsReturn2.get(0).getCabinBaggage();

            tvFlight2.setText("Flight Nb: " + flightNumber);

            String accumulatedDuration = segmentsReturn2.get(0).getGroundTime();
            String additionalBaggage = (String) segmentsReturn2.get(0).getAdditionalBaggage();


            String airline = "A" + segmentsReturn2.get(0).getAirlineDetails().getAirlineCode();
            String stringResourceByName = getStringResourceByName(airline);

            tvAirline2.setText(stringResourceByName);

            String bookingClass = segmentsReturn2.get(0).getBookingClass();
            String airlineCode_ = "a" + segmentsReturn2.get(0).getAirlineDetails().getAirlineCode().toLowerCase();
            ivIcon2.setImageResource(getResources().getIdentifier(airlineCode_, "drawable", getPackageName()));

            tvTime2.setText(accumulatedDuration);
            tvCambainBages2.setText(cabinBaggage);
            tvKg2.setText(additionalBaggage);
            tvCabinClass2.setText("Booking Class is : " + bookingClass);

            String departureTime = segmentsReturn2.get(0).getDepartureTime();
            String[] detimeSplit = departureTime.split("T");

            String datDe = detimeSplit[0];
            String timeD = detimeSplit[1];

            tvDateDeparture2.setText("DATE : " + datDe);
            tvDeparture2.setText("Departure : " + timeD);

            String arrivalTime = segmentsReturn2.get(0).getArrivalTime();
            String[] arrSplit = arrivalTime.split("T");
            String arrDate = arrSplit[0];
            String arrTime = arrSplit[1];

            dateArrival2.setText("DATE : " + arrDate);


            tvArrival2.setText("Arrive : " + arrTime);


            String to = SharedPreferencesManger.LoadStringData(this, "to");
            String from = SharedPreferencesManger.LoadStringData(this, "from");


            tvBey2.setText(to);
            tvDxb2.setText(from);


            if (segmentsReturn2.size() > 1) {
                tvDirect2.setText("Transit");

                tvDirect2.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.transit, 0, 0, 0);


            }


            flightCabinClass = SharedPreferencesManger.LoadLongData(this, "flightCabinClass");

            switch ((int) flightCabinClass) {

                case 1:
//                All

                    tvCabinClass2.setText("Cabin Class : All");
                    break;
                case 2:
                    tvCabinClass2.setText("Cabin Class : Economy");
//
                    break;
                case 3:
                    break;
                case 4:

                    tvCabinClass2.setText("Cabin Class : Business");

//
                    break;

                case 5:
                    tvCabinClass2.setText("Cabin Class : Royal");

//
                    break;
                case 6:
                    tvCabinClass2.setText("Cabin Class : First");


                    break;
            }


        }

        relativeCountry.setLayoutManager(new LinearLayoutManager(this));

        FlightTransitAdapter flightTransitAdapter = new FlightTransitAdapter(this, segments2);
        relativeCountry.setAdapter(flightTransitAdapter);
        flightTransitAdapter.notifyDataSetChanged();
        flightTransitAdapter.onDetachedFromRecyclerView(relativeCountry);
        flight_progress = findViewById(R.id.flight_progress);

        flight_progress.setVisibility(View.INVISIBLE);

        resultId = SharedPreferencesManger.LoadStringData(this, "resultId");

        tokenId = SharedPreferencesManger.LoadStringData(this, "tokenId");
        trackingId = SharedPreferencesManger.LoadStringData(this, "trackingId");

        iv_booked_flight_summary = findViewById(R.id.iv_booked_flight_summary);
        iv_booked_flight_summary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FlightsSummary.this, MyTripsActivity.class));
            }
        });

        relative_back_flight_summary = findViewById(R.id.relative_back_flight_summary);
        relative_back_flight_summary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlightsSummary.this, Passenger_inform.class);
                startActivity(intent);
            }
        });


        proccedBtn = findViewById(R.id.procced_btn);
//        assistantLabelVoiceRenewHotel = findViewById(R.id.assistant_label_voice_renew_flight_summary);
        relativeImgRenewHotelTamm = findViewById(R.id.relative_img_renew_flight_summary);
//        assistantLabelCallRenewHotel = findViewById(R.id.assistant_label_call_renew_flight_summary);
//        assistantLabelMessageRenewHotel = findViewById(R.id.assistant_label_message_renew_flight_summary);
        relativeImgRenewHotelTamm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ClickRenewHotel == false) {
//                    assistantLabelCallRenewHotel.setVisibility(View.VISIBLE);
//                    assistantLabelMessageRenewHotel.setVisibility(View.VISIBLE);
//                    assistantLabelVoiceRenewHotel.setVisibility(View.VISIBLE);
                    ClickRenewHotel = true;

                } else {
//                    assistantLabelCallRenewHotel.setVisibility(View.INVISIBLE);
//                    assistantLabelMessageRenewHotel.setVisibility(View.INVISIBLE);
//                    assistantLabelVoiceRenewHotel.setVisibility(View.INVISIBLE);
                    ClickRenewHotel = false;

                }
            }
        });
//        assistantLabelVoiceRenewHotel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(FlightsSummary.this, VoiceMessageActivity.class);
//                startActivity(intent);
//                Toast.makeText(FlightsSummary.this, "Voice", Toast.LENGTH_SHORT).show();
//            }
//        });
//        assistantLabelCallRenewHotel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(FlightsSummary.this, AssistantActivity.class);
//                startActivity(intent);
//
//                Toast.makeText(FlightsSummary.this, "Call", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        assistantLabelMessageRenewHotel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(FlightsSummary.this, ContactUs.class);
//                startActivity(intent);
//
//                Toast.makeText(FlightsSummary.this, "Message", Toast.LENGTH_SHORT).show();
//            }
//        });

        proccedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BookingFlight();

            }
        });


        adult = SharedPreferencesManger.LoadLongData(FlightsSummary.this, "adult");
        child = SharedPreferencesManger.LoadLongData(FlightsSummary.this, "child");
        infant = SharedPreferencesManger.LoadLongData(FlightsSummary.this, "infant");


        getAllDataPassengers();


        String airlineName = segments.get(0).getAirlineName();

        String flightNumber = segments.get(0).getFlightNumber();

        String countryCodeOrigin = segments.get(0).getOrigin().getCountryCode();

        String countryDestinationCode = segments.get(0).getDestination().getCountryCode();


        String cabinBaggage = (String) segments.get(0).getCabinBaggage();

        tvFlight.setText("Flight Nb: " + flightNumber);

        String accumulatedDuration = segments.get(0).getGroundTime();
        String additionalBaggage = (String) segments.get(0).getAdditionalBaggage();


        String airline = "A" + segments.get(0).getAirlineDetails().getAirlineCode();
        String stringResourceByName = getStringResourceByName(airline);

        tvAirline.setText(stringResourceByName);

        String bookingClass = segments.get(0).getBookingClass();
        String airlineCode_ = "a" + segments.get(0).getAirlineDetails().getAirlineCode().toLowerCase();
        ivIcon.setImageResource(getResources().getIdentifier(airlineCode_, "drawable", getPackageName()));

        tvTime.setText(accumulatedDuration);
        tvCambainBages.setText(cabinBaggage);
        tvKg.setText(additionalBaggage);
        tvCabinClass.setText("Booking Class is : " + bookingClass);

        String departureTime = segments.get(0).getDepartureTime();
        String[] detimeSplit = departureTime.split("T");

        String datDe = detimeSplit[0];
        String timeD = detimeSplit[1];

        tvDateDeparture.setText("DATE : " + datDe);
        tvDeparture.setText("Departure : " + timeD);

        String arrivalTime = segments.get(0).getArrivalTime();
        String[] arrSplit = arrivalTime.split("T");
        String arrDate = arrSplit[0];
        String arrTime = arrSplit[1];

        dateArrival.setText("DATE : " + arrDate);


        tvArrival.setText("Arrive : " + arrTime);


        String to = SharedPreferencesManger.LoadStringData(this, "to");
        String from = SharedPreferencesManger.LoadStringData(this, "from");


        tvBey.setText(from);
        tvDxb.setText(to);


        if (segments.size() > 1) {

            tvDirect.setText("Transit");

            tvDirect.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.transit, 0, 0, 0);


        }


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

    private void getAllDataPassengers() {


//        MDataMrmisChild = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "MDataMrmisChild");
//        MDataMrmisInfent = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "MDataMrmisInfent");
//
//        //first
//        firstNameChild = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "FirstNameChild");
//        firstNameInfant = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "FirstNameInfant");
//
//        //last
//        lastNameChild = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "LastNameChild");
//        lastNameInfant = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "LastNameInfant");
//
//
//        //date
//        datebirthchild = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "datebirthchild");
//        datebirthinfant = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "datebirthinfant");
//
//        // nationality
//        nationality_child = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "nationality_child");
//        nationality_infant = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "nationality_infant");


        // adult 1
        MDataMrmisAdult = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "MDataMrmisAdult");

        firstNameAduld = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "FirstNameAduld");

        lastNameAduld = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "LastNameAduld");

        datebirthadult = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "datebirthadult");

        nationality_adult = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "nationality_adult");

        passportNo = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportNo");

        passportIssue = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportIssue");

        passportEnd = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportEnd");



        //adult 2
        firstNameAduld2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "FirstNameAduld2");

        lastNameAduld2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "LastNameAduld2");
        MDataMrmisAdult2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "MDataMrmisAdult2");


        datebirthadult2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "datebirthadult2");

        nationality_adult2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "nationality_adult2");


        passportNo2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportNo2");
        passportIssue2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportIssue2");
        passportEnd2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportEnd2");

        //adult 3


        firstNameAduld3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "FirstNameAduld3");

        lastNameAduld3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "LastNameAduld3");
        MDataMrmisAdult3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "MDataMrmisAdult3");


        datebirthadult3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "datebirthadult3");

        nationality_adult3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "nationality_adult3");


        passportNo3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportNo3");
        passportIssue3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportIssue3");
        passportEnd3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportEnd3");

        //adult 4


        firstNameAduld4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "FirstNameAduld4");

        lastNameAduld4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "LastNameAduld4");
        MDataMrmisAdult4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "MDataMrmisAdult4");


        datebirthadult4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "datebirthadult4");

        nationality_adult4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "nationality_adult4");


        passportNo4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportNo4");
        passportIssue4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportIssue4");
        passportEnd4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportEnd4");


        //adult 5
        firstNameAduld5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "FirstNameAduld5");

        lastNameAduld5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "LastNameAduld5");
        MDataMrmisAdult5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "MDataMrmisAdult5");


        datebirthadult5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "datebirthadult5");

        nationality_adult5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "nationality_adult5");


        passportNo5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportNo5");
        passportIssue5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportIssue5");
        passportEnd5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportEnd5");



        // child 1


         passportChildNo1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportChildNo1");
         tvIssueDateChild1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tvIssueDateChild1");
         tvEndDateChild1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tvEndDateChild1");

        MDataMrmisChild =  SharedPreferencesManger.LoadStringData(FlightsSummary.this, "MDataMrmisChild");

         firstNameChild = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "FirstNameChild");

         lastNameChild = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "LastNameChild");

        datebirthchild = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "datebirthchild");

        nationality_child =   SharedPreferencesManger.LoadStringData(FlightsSummary.this, "nationality_child");


//child 2

        passportChildNo2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportChildNo2");
        tvIssueDateChild2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tvIssueDateChild2");
        tvEndDateChild2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tvEndDateChild2");


        MDataMrmisChild2 =  SharedPreferencesManger.LoadStringData(FlightsSummary.this, "MDataMrmisChild2");

        firstNameChild2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "FirstNameChild2");

        lastNameChild2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "LastNameChild2");

        datebirthchild2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "datebirthchild2");

        nationality_child2 =   SharedPreferencesManger.LoadStringData(FlightsSummary.this, "nationality_child2");


        // child 3

        passportChildNo3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportChildNo3");
        tvIssueDateChild3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tvIssueDateChild3");
        tvEndDateChild3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tvEndDateChild3");


        MDataMrmisChild3 =  SharedPreferencesManger.LoadStringData(FlightsSummary.this, "MDataMrmisChild3");

        firstNameChild3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "FirstNameChild3");

        lastNameChild3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "LastNameChild3");

        datebirthchild3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "datebirthchild3");

        nationality_child3 =   SharedPreferencesManger.LoadStringData(FlightsSummary.this, "nationality_child3");


        // child 4

        passportChildNo4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportChildNo4");
        tvIssueDateChild4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tvIssueDateChild4");
        tvEndDateChild4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tvEndDateChild4");

        MDataMrmisChild4 =  SharedPreferencesManger.LoadStringData(FlightsSummary.this, "MDataMrmisChild4");

        firstNameChild4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "FirstNameChild4");

        lastNameChild4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "LastNameChild4");

        datebirthchild4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "datebirthchild4");

        nationality_child4 =   SharedPreferencesManger.LoadStringData(FlightsSummary.this, "nationality_child4");


        // child 5



        passportChildNo5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportChildNo5");
        tvIssueDateChild5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tvIssueDateChild5");
        tvEndDateChild5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tvEndDateChild5");


        MDataMrmisChild5 =  SharedPreferencesManger.LoadStringData(FlightsSummary.this, "MDataMrmisChild5");

        firstNameChild5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "FirstNameChild5");

        lastNameChild5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "LastNameChild5");

        datebirthchild5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "datebirthchild5");

        nationality_child5 =   SharedPreferencesManger.LoadStringData(FlightsSummary.this, "nationality_child5");


        // infant 1

         passportInfantNo1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportInfantNo1");
         tvIssueDateInfant1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tvIssueDateInfant1");
         tvEndDateInfant1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tvEndDateInfant1");


        MDataMrmisInfent= SharedPreferencesManger.LoadStringData(FlightsSummary.this, "MDataMrmisInfent");

         firstNameInfant = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "FirstNameInfant");

         lastNameInfant = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "LastNameInfant");

         datebirthinfant = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "datebirthinfant");

         nationality_infant = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "nationality_infant");

        // infant 2

        passportInfantNo2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportInfantNo2");
        tvIssueDateInfant2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tvIssueDateInfant2");
        tvEndDateInfant2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tvEndDateInfant2");

MDataMrmisInfent2= SharedPreferencesManger.LoadStringData(FlightsSummary.this, "MDataMrmisInfent2");

         firstNameInfant2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "FirstNameInfant2");

         lastNameInfant2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "LastNameInfant2");

         datebirthinfant2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "datebirthinfant2");

         nationality_infant2 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "nationality_infant2");


        // infant 3


        passportInfantNo3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportInfantNo3");
        tvIssueDateInfant3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tvIssueDateInfant3");
        tvEndDateInfant3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tvEndDateInfant3");


        MDataMrmisInfent3= SharedPreferencesManger.LoadStringData(FlightsSummary.this, "MDataMrmisInfent3");

         firstNameInfant3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "FirstNameInfant3");

         lastNameInfant3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "LastNameInfant3");

         datebirthinfant3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "datebirthinfant3");

         nationality_infant3 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "nationality_infant3");



        // infant 4

        passportInfantNo4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportInfantNo4");
        tvIssueDateInfant4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tvIssueDateInfant4");
        tvEndDateInfant4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tvEndDateInfant4");




        MDataMrmisInfent4= SharedPreferencesManger.LoadStringData(FlightsSummary.this, "MDataMrmisInfent4");

        firstNameInfant4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "FirstNameInfant4");

        lastNameInfant4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "LastNameInfant4");

        datebirthinfant4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "datebirthinfant4");

        nationality_infant4 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "nationality_infant4");


        // infant 5


        passportInfantNo5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "passportInfantNo5");
        tvIssueDateInfant5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tvIssueDateInfant5");
        tvEndDateInfant5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tvEndDateInfant5");



        MDataMrmisInfent5= SharedPreferencesManger.LoadStringData(FlightsSummary.this, "MDataMrmisInfent5");

        firstNameInfant5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "FirstNameInfant5");

        lastNameInfant5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "LastNameInfant5");

        datebirthinfant5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "datebirthinfant5");

        nationality_infant5 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "nationality_infant5");

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
                    Toast.makeText(FlightsSummary.this, "Please Wait", Toast.LENGTH_SHORT).show();


                    Call<FareQuoteRespone> fareQuoteResponeCall = flightApiService.getFareQuote("application/json", fareQuote);
                    fareQuoteResponeCall.enqueue(new Callback<FareQuoteRespone>() {
                        @Override
                        public void onResponse(Call<FareQuoteRespone> call, Response<FareQuoteRespone> response) {


                            if (response.body().isIsSuccess()) {

                                Toast.makeText(FlightsSummary.this, "Please Wait", Toast.LENGTH_SHORT).show();

                                List<Segment> segments = response.body().getResult().get(0).getSegments().get(0);





                                String flightNumber = segments.get(0).getFlightNumber();

                                String airlineCode = segments.get(0).getAirlineDetails().getAirlineCode();

                                String departureTime = segments.get(0).getDepartureTime();
                                String arrivalTime = segments.get(0).getArrivalTime();


                                String destination = response.body().getResult().get(0).getDestination();
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


                                // passenger information by method
                                Passenger passenger2 = passenger2(fare, flightNumber);
                                Passenger passenger = passenger1(fare, flightNumber);
                                Passenger passenger3 = passenger3(fare, flightNumber);
                                Passenger passenger4 = passenger4(fare, flightNumber);
                                Passenger passenger5 = passenger5(fare, flightNumber);





                                // child info
                                Passenger passenger2Child = passenger2Child(fare, flightNumber);
                                Passenger passengerChild = passenger1Child(fare, flightNumber);
                                Passenger passenger3Child = passenger3Child(fare, flightNumber);
                                Passenger passenger4Child = passenger4Child(fare, flightNumber);
                                Passenger passenger5Child = passenger5Child(fare, flightNumber);





                                // Infant info
                                Passenger passenger2Infant = passenger2Infant(fare, flightNumber);
                                Passenger passengerInfant = passenger1Infant(fare, flightNumber);
                                Passenger passenger3Infant = passenger3Infant(fare, flightNumber);
                                Passenger passenger4Infant = passenger4Infant(fare, flightNumber);
                                Passenger passenger5Infant = passenger5Infant(fare, flightNumber);



                                itinerary.setTravelDate(departureTime);

                                itinerary.setTravelDate(arrivalTime);


                                itinerary.setAirlineCode(airlineCode);
                                itinerary.setLastTicketDate((String) lastTicketDate);
                                itinerary.setValidatingAirlineCode(validatingAirline);

                                int journyTipe = SharedPreferencesManger.LoadIntegerData(FlightsSummary.this, "journyTipe");

                                if (journyTipe==2){


                                    List<Segment> segments1Return = response.body().getResult().get(0).getSegments().get(1);

                                    segments.addAll(1,segments1Return);

                                    itinerary.setSegments(segments);


                                }else {
                                    itinerary.setSegments(segments);

                                }



                                itinerary.setFareRules(fareRulesList);


                                ArrayList<Passenger> passengerList = new ArrayList<>();




                                switch ((int) adult) {

                                    case 1:
                                        passengerList.add(passenger);
                                        break;

                                    case 2:
                                        passengerList.add(passenger);
                                        passengerList.add(passenger2);
                                        break;


                                    case 3:
                                        passengerList.add(passenger);
                                        passengerList.add(passenger2);
                                        passengerList.add(passenger3);

                                        break;

                                    case 4:
                                        passengerList.add(passenger);
                                        passengerList.add(passenger2);
                                        passengerList.add(passenger3);
                                        passengerList.add(passenger4);

                                        break;

                                    case 5:
                                        passengerList.add(passenger);
                                        passengerList.add(passenger2);
                                        passengerList.add(passenger3);
                                        passengerList.add(passenger4);
                                        passengerList.add(passenger5);

                                        break;
                                }

                                switch ((int) child){

                                    case 1:
                                        passengerList.add(passengerChild);
                                        break;

                                    case 2:
                                        passengerList.add(passengerChild);
                                        passengerList.add(passenger2Child);
                                        break;


                                    case 3:
                                        passengerList.add(passengerChild);
                                        passengerList.add(passenger2Child);
                                        passengerList.add(passenger3Child);

                                        break;

                                    case 4:
                                        passengerList.add(passengerChild);
                                        passengerList.add(passenger2Child);
                                        passengerList.add(passenger3Child);
                                        passengerList.add(passenger4Child);

                                        break;

                                    case 5:
                                        passengerList.add(passengerChild);
                                        passengerList.add(passenger2Child);
                                        passengerList.add(passenger3Child);
                                        passengerList.add(passenger4Child);
                                        passengerList.add(passenger5Child);
                                        break;


                                }


                                switch ((int) infant){

                                    case 1:
                                        passengerList.add(passengerInfant);
                                        break;

                                    case 2:
                                        passengerList.add(passengerInfant);
                                        passengerList.add(passenger2Infant);
                                        break;


                                    case 3:
                                        passengerList.add(passengerInfant);
                                        passengerList.add(passenger2Infant);
                                        passengerList.add(passenger3Infant);

                                        break;

                                    case 4:
                                        passengerList.add(passengerInfant);
                                        passengerList.add(passenger2Infant);
                                        passengerList.add(passenger3Infant);
                                        passengerList.add(passenger4Infant);

                                        break;

                                    case 5:
                                        passengerList.add(passengerInfant);
                                        passengerList.add(passenger2Infant);
                                        passengerList.add(passenger3Infant);
                                        passengerList.add(passenger4Infant);
                                        passengerList.add(passenger5Infant);
                                        break;


                                }

                                itinerary.setPassenger(passengerList);
                                itinerary.setIsLcc(false);
                                book.setItinerary(itinerary);





                                Call<GetBookingResponse> flightBookCall = flightApiService.getFlightBook("application/json", book);


                                flightBookCall.enqueue(new Callback<GetBookingResponse>() {
                                    @Override
                                    public void onResponse(Call<GetBookingResponse> call, Response<GetBookingResponse> response) {



                                        if (response.body().getStatus()!=0){


                                            Itinerary itinerary1 = response.body().getItinerary();

                                            Toast.makeText(FlightsSummary.this, "Please Wait", Toast.LENGTH_SHORT).show();

                                            FlightTicket flightTicket = new FlightTicket();
                                            String localIpAddress = getLocalIpAddress();
                                            flightTicket.setIPAddress(localIpAddress);

                                            flightTicket.setResultId(resultId);
                                            flightTicket.setTokenId(tokenId);
                                            flightTicket.setTrackingId(trackingId);
                                            flightTicket.setPNR(response.body().getItinerary().getPNR());

                                            flightTicket.setItinerary(itinerary1);

                                            flightApiService.getFlightTicket("application/json", flightTicket).enqueue(new Callback<TicketResponse>() {
                                                @Override
                                                public void onResponse(Call<TicketResponse> call, Response<TicketResponse> response) {



                                                    if (response.isSuccessful()&&response.body().getStatus()!=0){


                                                        okhttp3.Response raw = response.raw();

                                                        String pnr2 = response.body().getItinerary().getPNR();
                                                        String tokenId2 = response.body().getTokenId();



                                                        SharedPreferencesManger.SaveData(FlightsSummary.this, "pnr", pnr2);
                                                        SharedPreferencesManger.SaveData(FlightsSummary.this, "tokenId2", tokenId2);



                                                        double totalFare = response.body().getItinerary().getPassenger().get(0).getFare().getTotalFare();

                                                        Intent intent = new Intent(FlightsSummary.this, PaymentActivity.class);

//                                                        intent.putExtra("totalFare", String.valueOf(totalFare));

                                                        SharedPreferencesManger.SaveData(FlightsSummary.this,"totalFare",String.valueOf(totalFare));
                                                        SharedPreferencesManger.SaveData(FlightsSummary.this,"mId",3);

                                                        startActivity(intent);

                                                    }else {

                                                        flight_progress.setVisibility(View.INVISIBLE);

                                                        new SweetAlertDialog(FlightsSummary.this, SweetAlertDialog.WARNING_TYPE)
                                                                .setTitleText(response.body().getErrors().get(0).getUserMessage())
                                                                .setConfirmText("Go  Back")
                                                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                                    @Override
                                                                    public void onClick(SweetAlertDialog sDialog) {
                                                                        sDialog.dismissWithAnimation();
                                                                        onBackPressed();
                                                                    }
                                                                })
                                                                .show();


                                                    }






                                                }

                                                @Override
                                                public void onFailure(Call<TicketResponse> call, Throwable t) {
                                                    Toast.makeText(FlightsSummary.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                                                    flight_progress.setVisibility(View.INVISIBLE);

                                                }
                                            });




                                        }else {
                                            flight_progress.setVisibility(View.INVISIBLE);

                                            new SweetAlertDialog(FlightsSummary.this, SweetAlertDialog.WARNING_TYPE)
                                                    .setTitleText(response.body().getErrors().get(0).getUserMessage())
                                                    .setConfirmText("Go  Back")
                                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                        @Override
                                                        public void onClick(SweetAlertDialog sDialog) {
                                                            sDialog.dismissWithAnimation();
                                                            onBackPressed();
                                                        }
                                                    })
                                                    .show();

                                        }





//
//                                           Intent intent = new Intent(FlightsSummary.this,PaymentActivity.class);
//
//                                           intent.putExtra("totalFare",totalFare);
//                                           intent.putExtra("mId",3);
//
//                                           startActivity(intent);



                                    }

                                    @Override
                                    public void onFailure(Call<GetBookingResponse> call, Throwable t) {

                                        flight_progress.setVisibility(View.INVISIBLE);

                                    }
                                });

                            } else {

                                flight_progress.setVisibility(View.INVISIBLE);

                                 new SweetAlertDialog(FlightsSummary.this, SweetAlertDialog.WARNING_TYPE)
                                        .setTitleText(response.body().getErrors().get(0).getUserMessage())
                                        .setConfirmText("Go  Back")
                                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                            @Override
                                            public void onClick(SweetAlertDialog sDialog) {
                                                sDialog.dismissWithAnimation();
                                                onBackPressed();
                                            }
                                        })
                                        .show();

                            }


                        }


                        @Override
                        public void onFailure(Call<FareQuoteRespone> call, Throwable t) {
                            flight_progress.setVisibility(View.INVISIBLE);
                            Toast.makeText(FlightsSummary.this, ""+response.body().getErrors().get(0).getUserMessage(), Toast.LENGTH_SHORT).show();
                            t.getMessage();
                        }
                    });


                } else {

                    flight_progress.setVisibility(View.INVISIBLE);



                    new SweetAlertDialog(FlightsSummary.this, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText(response.body().getErrors().get(0).getUserMessage())
                            .setConfirmText("Go  Back")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    sDialog.dismissWithAnimation();
                                    onBackPressed();
                                }
                            })
                            .show();


                }

//


            }

            @Override
            public void onFailure(Call<FareRuleResponse> call, Throwable t) {
                flight_progress.setVisibility(View.INVISIBLE);
                Toast.makeText(FlightsSummary.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

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

    private Passenger passenger5(Fare fare, String flightNumber) {


        String country1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "country");
        String phone = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "phone");
        String email = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "email");
        String city1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "city");

        Passenger passenger = new Passenger();
        passenger.setFare(fare);
        passenger.setAddressLine1(city1);
        passenger.setAddressLine2(city1);
        City city = new City();
        city.setCityCode("CAI");
        city.setCityName(city1);
        city.setCountryCode(country1);
        passenger.setCity(city);
        Country country = new Country();
        country.setCountryCode("EG");
        country.setCountryName(country1);
        passenger.setCountry(country);
        passenger.setEmail(email);
        passenger.setFirstName(firstNameAduld5);
        passenger.setGender(1);
        passenger.setLastName(lastNameAduld5);
        passenger.setType(1);
        passenger.setTitle(MDataMrmisAdult5);
        Nationality nationality = new Nationality();

        nationality.setCountryCode("EG");
        nationality.setCountryName(country1);
        passenger.setNationality(nationality);

        passenger.setDateOfBirth(datebirthadult5);

        passenger.setFFNumber(flightNumber);
        passenger.setMobile1(phone);
        passenger.setMobile1CountryCode("12");


        passenger.setPassportExpiry(passportEnd5);
        passenger.setPassportIssueCountryCode("2365");
        passenger.setPassportIssueDate(passportIssue5);
        passenger.setPassportNo(passportNo5);

        return passenger;
    }

    private Passenger passenger4(Fare fare, String flightNumber) {


        String country1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "country");
        String phone = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "phone");
        String email = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "email");
        String city1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "city");

        Passenger passenger = new Passenger();
        passenger.setFare(fare);
        passenger.setAddressLine1(city1);
        passenger.setAddressLine2(city1);
        City city = new City();
        city.setCityCode("CAI");
        city.setCityName(city1);
        city.setCountryCode(country1);
        passenger.setCity(city);
        Country country = new Country();
        country.setCountryCode("EG");
        country.setCountryName(country1);
        passenger.setCountry(country);
        passenger.setEmail(email);
        passenger.setFirstName(firstNameAduld4);
        passenger.setGender(1);
        passenger.setLastName(lastNameAduld4);
        passenger.setType(1);
        passenger.setTitle(MDataMrmisAdult4);
        Nationality nationality = new Nationality();

        nationality.setCountryCode("EG");
        nationality.setCountryName(country1);
        passenger.setNationality(nationality);

        passenger.setDateOfBirth(datebirthadult4);

        passenger.setFFNumber(flightNumber);
        passenger.setMobile1(phone);
        passenger.setMobile1CountryCode("+2");


        passenger.setPassportExpiry(passportEnd4);
        passenger.setPassportIssueCountryCode("2365");
        passenger.setPassportIssueDate(passportIssue4);
        passenger.setPassportNo(passportNo4);

        return passenger;
    }

    private Passenger passenger3(Fare fare, String flightNumber) {


        String country1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "country");
        String phone = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "phone");
        String email = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "email");
        String city1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "city");


        Passenger passenger = new Passenger();
        passenger.setFare(fare);
        passenger.setAddressLine1(city1);
        passenger.setAddressLine2(city1);
        City city = new City();
        city.setCityCode("CAI");
        city.setCityName(city1);
        city.setCountryCode(country1);
        passenger.setCity(city);
        Country country = new Country();
        country.setCountryCode("EG");
        country.setCountryName(country1);
        passenger.setCountry(country);
        passenger.setEmail(email);
        passenger.setFirstName(firstNameAduld3);
        passenger.setGender(1);
        passenger.setLastName(lastNameAduld3);
        passenger.setType(1);
        passenger.setTitle(MDataMrmisAdult3);
        Nationality nationality = new Nationality();

        nationality.setCountryCode("EG");
        nationality.setCountryName(country1);
        passenger.setNationality(nationality);

        passenger.setDateOfBirth(datebirthadult3);

        passenger.setFFNumber(flightNumber);
        passenger.setMobile1(phone);
        passenger.setMobile1CountryCode("+2");


        passenger.setPassportExpiry(passportEnd3);
        passenger.setPassportIssueCountryCode("2365");
        passenger.setPassportIssueDate(passportIssue3);
        passenger.setPassportNo(passportNo3);

        return passenger;

    }

    private Passenger passenger1(Fare fare, String flightNumber) {

        String country1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "country");
        String phone = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "phone");
        String email = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "email");
        String city1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "city");


        Passenger passenger = new Passenger();
        passenger.setFare(fare);
        passenger.setAddressLine1(city1);
        passenger.setAddressLine2(city1);
        City city = new City();
        city.setCityCode("CAI");
        city.setCityName(city1);
        city.setCountryCode("EG");
        passenger.setCity(city);
        Country country = new Country();
        country.setCountryCode("EG");
        country.setCountryName(country1);
        passenger.setCountry(country);
        passenger.setEmail(email);
        passenger.setFirstName(firstNameAduld);
        passenger.setGender(1);
        passenger.setIsLeadPax(true);
        passenger.setLastName(lastNameAduld);
        passenger.setType(1);
        passenger.setTitle(MDataMrmisAdult);
        Nationality nationality = new Nationality();

        nationality.setCountryCode("EG");
        nationality.setCountryName(country1);
        passenger.setNationality(nationality);

        passenger.setDateOfBirth(datebirthadult);

        passenger.setFFNumber(flightNumber);
        passenger.setMobile1(phone);
        passenger.setMobile1CountryCode("+2");


        passenger.setPassportExpiry(passportEnd);
        passenger.setPassportIssueCountryCode("123");
        passenger.setPassportIssueDate(passportIssue);
        passenger.setPassportNo(passportNo);

        return passenger;

    }
    private Passenger passenger2(Fare fare, String flightNumber) {


        String country1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "country");
        String phone = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "phone");
        String email = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "email");
        String city1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "city");


        Passenger passenger2 = new Passenger();
        passenger2.setFare(fare);
        passenger2.setAddressLine1(city1);
        passenger2.setAddressLine2(city1);
        City city2 = new City();
        city2.setCityCode("");
        city2.setCityName(city1);
        city2.setCountryCode("");
        passenger2.setCity(city2);
        Country country2 = new Country();
        country2.setCountryCode("");
        country2.setCountryName(country1);
        passenger2.setCountry(country2);
        passenger2.setEmail(email);
        passenger2.setFirstName(firstNameAduld2);
        passenger2.setGender(1);
        passenger2.setLastName(lastNameAduld2);
        passenger2.setType(1);
        passenger2.setTitle(MDataMrmisAdult2);
        Nationality nationality2 = new Nationality();

        nationality2.setCountryCode("EG");
        nationality2.setCountryName(country1);
        passenger2.setNationality(nationality2);

        passenger2.setDateOfBirth(datebirthadult2);

        passenger2.setFFNumber(flightNumber);
        passenger2.setMobile1(phone);
        passenger2.setMobile1CountryCode("+2");


        passenger2.setPassportExpiry(passportEnd2);
        passenger2.setPassportIssueCountryCode("2365");
        passenger2.setPassportIssueDate(passportIssue2);
        passenger2.setPassportNo(passportNo2);

        return passenger2;
    }

    private Passenger passenger1Child(Fare fare, String flightNumber) {

        String country1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "country");
        String phone = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "phone");
        String email = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "email");
        String city1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "city");


        Passenger passenger = new Passenger();
        passenger.setFare(fare);
        passenger.setAddressLine1(city1);
        passenger.setAddressLine2(city1);
        City city = new City();
        city.setCityCode("CAI");
        city.setCityName(city1);
        city.setCountryCode("EG");
        passenger.setCity(city);
        Country country = new Country();
        country.setCountryCode("EG");
        country.setCountryName(country1);
        passenger.setCountry(country);
        passenger.setEmail(email);
        passenger.setFirstName(firstNameChild);
        passenger.setGender(1);
        passenger.setIsLeadPax(true);
        passenger.setLastName(lastNameChild);
        passenger.setType(2);
        passenger.setTitle(MDataMrmisChild);
        Nationality nationality = new Nationality();

        nationality.setCountryCode("EG");
        nationality.setCountryName(country1);
        passenger.setNationality(nationality);

        passenger.setDateOfBirth(datebirthchild);

        passenger.setFFNumber(flightNumber);
        passenger.setMobile1(phone);
        passenger.setMobile1CountryCode("+2");

//
        passenger.setPassportExpiry(tvEndDateChild1);
        passenger.setPassportIssueCountryCode("123");
        passenger.setPassportIssueDate(tvIssueDateChild1);
        passenger.setPassportNo(passportChildNo1);

        return passenger;

    }
    private Passenger passenger2Child(Fare fare, String flightNumber) {


        String country1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "country");
        String phone = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "phone");
        String email = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "email");
        String city1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "city");


        Passenger passenger2 = new Passenger();
        passenger2.setFare(fare);
        passenger2.setAddressLine1(city1);
        passenger2.setAddressLine2(city1);
        City city2 = new City();
        city2.setCityCode("");
        city2.setCityName(city1);
        city2.setCountryCode("");
        passenger2.setCity(city2);
        Country country2 = new Country();
        country2.setCountryCode("");
        country2.setCountryName(country1);
        passenger2.setCountry(country2);
        passenger2.setEmail(email);
        passenger2.setFirstName(firstNameChild2);
        passenger2.setGender(1);
        passenger2.setLastName(lastNameChild2);
        passenger2.setType(2);
        passenger2.setTitle(MDataMrmisChild2);
        Nationality nationality2 = new Nationality();

        nationality2.setCountryCode("EG");
        nationality2.setCountryName(country1);
        passenger2.setNationality(nationality2);

        passenger2.setDateOfBirth(datebirthchild2);

        passenger2.setFFNumber(flightNumber);
        passenger2.setMobile1(phone);
        passenger2.setMobile1CountryCode("+2");


        passenger2.setPassportExpiry(tvEndDateChild1);
        passenger2.setPassportIssueCountryCode("123");
        passenger2.setPassportIssueDate(tvIssueDateChild2);
        passenger2.setPassportNo(passportChildNo2);

        return passenger2;
    }
    private Passenger passenger3Child(Fare fare, String flightNumber) {


        String country1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "country");
        String phone = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "phone");
        String email = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "email");
        String city1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "city");


        Passenger passenger2 = new Passenger();
        passenger2.setFare(fare);
        passenger2.setAddressLine1(city1);
        passenger2.setAddressLine2(city1);
        City city2 = new City();
        city2.setCityCode("");
        city2.setCityName(city1);
        city2.setCountryCode("");
        passenger2.setCity(city2);
        Country country2 = new Country();
        country2.setCountryCode("");
        country2.setCountryName(country1);
        passenger2.setCountry(country2);
        passenger2.setEmail(email);
        passenger2.setFirstName(firstNameChild3);
        passenger2.setGender(1);
        passenger2.setLastName(lastNameChild3);
        passenger2.setType(2);
        passenger2.setTitle(MDataMrmisChild3);
        Nationality nationality2 = new Nationality();

        nationality2.setCountryCode("EG");
        nationality2.setCountryName(country1);
        passenger2.setNationality(nationality2);

        passenger2.setDateOfBirth(datebirthchild3);

        passenger2.setFFNumber(flightNumber);
        passenger2.setMobile1(phone);
        passenger2.setMobile1CountryCode("+2");


        passenger2.setPassportExpiry(tvEndDateChild3);
        passenger2.setPassportIssueCountryCode("123");
        passenger2.setPassportIssueDate(tvIssueDateChild3);
        passenger2.setPassportNo(passportChildNo3);

        return passenger2;
    }
    private Passenger passenger4Child(Fare fare, String flightNumber) {


        String country1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "country");
        String phone = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "phone");
        String email = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "email");
        String city1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "city");


        Passenger passenger2 = new Passenger();
        passenger2.setFare(fare);
        passenger2.setAddressLine1(city1);
        passenger2.setAddressLine2(city1);
        City city2 = new City();
        city2.setCityCode("");
        city2.setCityName(city1);
        city2.setCountryCode("");
        passenger2.setCity(city2);
        Country country2 = new Country();
        country2.setCountryCode("");
        country2.setCountryName(country1);
        passenger2.setCountry(country2);
        passenger2.setEmail(email);
        passenger2.setFirstName(firstNameChild4);
        passenger2.setGender(1);
        passenger2.setLastName(lastNameChild4);
        passenger2.setType(2);
        passenger2.setTitle(MDataMrmisChild4);
        Nationality nationality2 = new Nationality();

        nationality2.setCountryCode("EG");
        nationality2.setCountryName(country1);
        passenger2.setNationality(nationality2);

        passenger2.setDateOfBirth(datebirthchild4);

        passenger2.setFFNumber(flightNumber);
        passenger2.setMobile1(phone);
        passenger2.setMobile1CountryCode("+2");


        passenger2.setPassportExpiry(tvEndDateChild4);
        passenger2.setPassportIssueCountryCode("123");
        passenger2.setPassportIssueDate(tvIssueDateChild4);
        passenger2.setPassportNo(passportChildNo4);

        return passenger2;
    }
    private Passenger passenger5Child(Fare fare, String flightNumber) {


        String country1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "country");
        String phone = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "phone");
        String email = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "email");
        String city1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "city");


        Passenger passenger2 = new Passenger();
        passenger2.setFare(fare);
        passenger2.setAddressLine1(city1);
        passenger2.setAddressLine2(city1);
        City city2 = new City();
        city2.setCityCode("");
        city2.setCityName(city1);
        city2.setCountryCode("");
        passenger2.setCity(city2);
        Country country2 = new Country();
        country2.setCountryCode("");
        country2.setCountryName(country1);
        passenger2.setCountry(country2);
        passenger2.setEmail(email);
        passenger2.setFirstName(firstNameChild5);
        passenger2.setGender(1);
        passenger2.setLastName(lastNameChild5);
        passenger2.setType(2);
        passenger2.setTitle(MDataMrmisChild5);
        Nationality nationality2 = new Nationality();

        nationality2.setCountryCode("EG");
        nationality2.setCountryName(country1);
        passenger2.setNationality(nationality2);

        passenger2.setDateOfBirth(datebirthchild5);

        passenger2.setFFNumber(flightNumber);
        passenger2.setMobile1(phone);
        passenger2.setMobile1CountryCode("+2");


        passenger2.setPassportExpiry(tvEndDateChild5);
        passenger2.setPassportIssueCountryCode("123");
        passenger2.setPassportIssueDate(tvIssueDateChild5);
        passenger2.setPassportNo(passportChildNo5);

        return passenger2;
    }
























































    // Infant


    private Passenger passenger1Infant(Fare fare, String flightNumber) {

        String country1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "country");
        String phone = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "phone");
        String email = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "email");
        String city1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "city");


        Passenger passenger = new Passenger();
        passenger.setFare(fare);
        passenger.setAddressLine1(city1);
        passenger.setAddressLine2(city1);
        City city = new City();
        city.setCityCode("CAI");
        city.setCityName(city1);
        city.setCountryCode("EG");
        passenger.setCity(city);
        Country country = new Country();
        country.setCountryCode("EG");
        country.setCountryName(country1);
        passenger.setCountry(country);
        passenger.setEmail(email);
        passenger.setFirstName(firstNameInfant);
        passenger.setGender(1);
        passenger.setIsLeadPax(true);
        passenger.setLastName(lastNameInfant);
        passenger.setType(3);
        passenger.setTitle(MDataMrmisInfent);
        Nationality nationality = new Nationality();

        nationality.setCountryCode("EG");
        nationality.setCountryName(country1);
        passenger.setNationality(nationality);

        passenger.setDateOfBirth(datebirthinfant);

        passenger.setFFNumber(flightNumber);
        passenger.setMobile1(phone);
        passenger.setMobile1CountryCode("+2");

//
        passenger.setPassportExpiry(tvEndDateInfant1);
        passenger.setPassportIssueCountryCode("123");
        passenger.setPassportIssueDate(tvIssueDateInfant1);
        passenger.setPassportNo(passportInfantNo1);

        return passenger;

    }
    private Passenger passenger2Infant(Fare fare, String flightNumber) {


        String country1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "country");
        String phone = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "phone");
        String email = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "email");
        String city1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "city");


        Passenger passenger2 = new Passenger();
        passenger2.setFare(fare);
        passenger2.setAddressLine1(city1);
        passenger2.setAddressLine2(city1);
        City city2 = new City();
        city2.setCityCode("");
        city2.setCityName(city1);
        city2.setCountryCode("");
        passenger2.setCity(city2);
        Country country2 = new Country();
        country2.setCountryCode("");
        country2.setCountryName(country1);
        passenger2.setCountry(country2);
        passenger2.setEmail(email);
        passenger2.setFirstName(firstNameInfant2);
        passenger2.setGender(1);
        passenger2.setLastName(lastNameInfant2);
        passenger2.setType(3);
        passenger2.setTitle(MDataMrmisInfent2);
        Nationality nationality2 = new Nationality();

        nationality2.setCountryCode("EG");
        nationality2.setCountryName(country1);
        passenger2.setNationality(nationality2);

        passenger2.setDateOfBirth(datebirthinfant2);

        passenger2.setFFNumber(flightNumber);
        passenger2.setMobile1(phone);
        passenger2.setMobile1CountryCode("+2");


        passenger2.setPassportExpiry(tvEndDateInfant2);
        passenger2.setPassportIssueCountryCode("123");
        passenger2.setPassportIssueDate(tvIssueDateInfant2);
        passenger2.setPassportNo(passportInfantNo2);

        return passenger2;
    }
    private Passenger passenger3Infant(Fare fare, String flightNumber) {


        String country1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "country");
        String phone = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "phone");
        String email = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "email");
        String city1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "city");


        Passenger passenger2 = new Passenger();
        passenger2.setFare(fare);
        passenger2.setAddressLine1(city1);
        passenger2.setAddressLine2(city1);
        City city2 = new City();
        city2.setCityCode("");
        city2.setCityName(city1);
        city2.setCountryCode("");
        passenger2.setCity(city2);
        Country country2 = new Country();
        country2.setCountryCode("");
        country2.setCountryName(country1);
        passenger2.setCountry(country2);
        passenger2.setEmail(email);
        passenger2.setFirstName(firstNameInfant3);
        passenger2.setGender(1);
        passenger2.setLastName(lastNameInfant3);
        passenger2.setType(3);
        passenger2.setTitle(MDataMrmisInfent3);
        Nationality nationality2 = new Nationality();

        nationality2.setCountryCode("EG");
        nationality2.setCountryName(country1);
        passenger2.setNationality(nationality2);

        passenger2.setDateOfBirth(datebirthinfant3);

        passenger2.setFFNumber(flightNumber);
        passenger2.setMobile1(phone);
        passenger2.setMobile1CountryCode("+2");


        passenger2.setPassportExpiry(tvEndDateInfant3);
        passenger2.setPassportIssueCountryCode("123");
        passenger2.setPassportIssueDate(tvIssueDateInfant3);
        passenger2.setPassportNo(passportInfantNo3);

        return passenger2;
    }
    private Passenger passenger4Infant(Fare fare, String flightNumber) {


        String country1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "country");
        String phone = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "phone");
        String email = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "email");
        String city1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "city");


        Passenger passenger2 = new Passenger();
        passenger2.setFare(fare);
        passenger2.setAddressLine1(city1);
        passenger2.setAddressLine2(city1);
        City city2 = new City();
        city2.setCityCode("");
        city2.setCityName(city1);
        city2.setCountryCode("");
        passenger2.setCity(city2);
        Country country2 = new Country();
        country2.setCountryCode("");
        country2.setCountryName(country1);
        passenger2.setCountry(country2);
        passenger2.setEmail(email);
        passenger2.setFirstName(firstNameInfant4);
        passenger2.setGender(1);
        passenger2.setLastName(lastNameInfant4);
        passenger2.setType(3);
        passenger2.setTitle(MDataMrmisInfent4);
        Nationality nationality2 = new Nationality();

        nationality2.setCountryCode("EG");
        nationality2.setCountryName(country1);
        passenger2.setNationality(nationality2);

        passenger2.setDateOfBirth(datebirthinfant4);

        passenger2.setFFNumber(flightNumber);
        passenger2.setMobile1(phone);
        passenger2.setMobile1CountryCode("+2");

        passenger2.setPassportExpiry(tvEndDateInfant4);
        passenger2.setPassportIssueCountryCode("123");
        passenger2.setPassportIssueDate(tvIssueDateInfant4);
        passenger2.setPassportNo(passportInfantNo4);
        return passenger2;
    }
    private Passenger passenger5Infant(Fare fare, String flightNumber) {


        String country1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "country");
        String phone = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "phone");
        String email = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "email");
        String city1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "city");


        Passenger passenger2 = new Passenger();
        passenger2.setFare(fare);
        passenger2.setAddressLine1(city1);
        passenger2.setAddressLine2(city1);
        City city2 = new City();
        city2.setCityCode("");
        city2.setCityName(city1);
        city2.setCountryCode("");
        passenger2.setCity(city2);
        Country country2 = new Country();
        country2.setCountryCode("");
        country2.setCountryName(country1);
        passenger2.setCountry(country2);
        passenger2.setEmail(email);
        passenger2.setFirstName(firstNameInfant5);
        passenger2.setGender(1);
        passenger2.setLastName(lastNameInfant5);
        passenger2.setType(3);
        passenger2.setTitle(MDataMrmisInfent5);
        Nationality nationality2 = new Nationality();

        nationality2.setCountryCode("EG");
        nationality2.setCountryName(country1);
        passenger2.setNationality(nationality2);

        passenger2.setDateOfBirth(datebirthinfant5);

        passenger2.setFFNumber(flightNumber);
        passenger2.setMobile1(phone);
        passenger2.setMobile1CountryCode("+2");


        passenger2.setPassportExpiry(tvEndDateInfant5);
        passenger2.setPassportIssueCountryCode("123");
        passenger2.setPassportIssueDate(tvIssueDateInfant5);
        passenger2.setPassportNo(passportInfantNo5);

        return passenger2;
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


    private String getStringResourceByName(String aString) {
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(aString, "string", packageName);
        return getString(resId);
    }

    @Override
    protected void onStart() {
        super.onStart();


        flight_progress.setVisibility(View.INVISIBLE);

    }
}
