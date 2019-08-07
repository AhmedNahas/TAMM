package net.middledleeast.tamm.fragments;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.github.jlmd.animatedcircleloadingview.AnimatedCircleLoadingView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.FindHotels;
import net.middledleeast.tamm.activities.MainActivity;
import net.middledleeast.tamm.activities.RecommendedOneWay;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import FlightApi.FlightApiService;
import FlightApi.FlightAuthentication;
import FlightApi.FlightConstants;
import FlightApi.SearchFlights;
import FlightApi.SearchFlightsResponse;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.util.Calendar.YEAR;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProceedBeyBeyOriginal extends Fragment {

    private CheckedTextView royalClass, firstClass, businessClass, economyClass;
    private TextView fromTextView, toTextView, departure, returnFrom;
    private RecyclerView fromToRecycler;
    private Button proccedBtn;
    private Spinner passengerAdult, passengerChild, passengerInfant;
    public static final String BASE_URL = "https://xmloutapi.tboair.com/api/v1/";
    private static Retrofit retrofit = null;
    String password;
    private TextView country_selected_from_spinner, to_country_name;
    private boolean chicDateStart;
    private Calendar myCalendar;
    private Date time1;
    private String mstartTime;
    private boolean chicDateEnd;
    private Date time2;
    private String mendTime;
    private int nom_adultRoom1;
    private boolean notFailed ;
    private long adult , child , infant;
    long oneWay = 1;
    private AnimatedCircleLoadingView animatedCircleLoadingView;

    long flightCabinClass = 1;
    private String departureTimeConfirmed;

    ArrayList<String> ListnameLine = new ArrayList<>();
    ArrayList<String> Listduration = new ArrayList<>();
    ArrayList<String> ListArriveTime = new ArrayList<>();
    ArrayList<String> ListdeparuerTime = new ArrayList<>();
    ArrayList<String> countryNameDestinationList = new ArrayList<>();
    ArrayList<String> countryNameOriginList = new ArrayList<>();
    ArrayList<String> listIncludedBaggage = new ArrayList<>();
    ArrayList<String> listCabinBaggage = new ArrayList<>();
    ArrayList<Double> listTotalFare = new ArrayList<>();
    ArrayList<String> listTypeFare = new ArrayList<>();


    public ProceedBeyBeyOriginal() {
        // Required empty public constructor
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_proceed_bey_bey_original, container, false);
        password = "App02072019";

        royalClass = view.findViewById(R.id.royal_class);
        firstClass = view.findViewById(R.id.first_class);
        businessClass = view.findViewById(R.id.business_class);
        economyClass = view.findViewById(R.id.economy_class);
        fromTextView = view.findViewById(R.id.country_from_textview);
        toTextView = view.findViewById(R.id.country_to_textview);
        country_selected_from_spinner = view.findViewById(R.id.country_selected_from_spinner);
        animatedCircleLoadingView = (AnimatedCircleLoadingView) view.findViewById(R.id.circle_loading_view_flight);


        proccedBtn = view.findViewById(R.id.procced_btn);
        departure = view.findViewById(R.id.departure_spinner);
        returnFrom = view.findViewById(R.id.return_spinner);
        passengerAdult = view.findViewById(R.id.adult_spinner);
        passengerChild = view.findViewById(R.id.child_spinner);
        passengerInfant = view.findViewById(R.id.infant_spinner);
        to_country_name = view.findViewById(R.id.to_country_name);


        myCalendar = Calendar.getInstance();
        String date_n = new SimpleDateFormat("dd", Locale.getDefault()).format(new Date());
        String date_m = new SimpleDateFormat("MMM", Locale.getDefault()).format(new Date());
        String date_d = new SimpleDateFormat("EEE", Locale.getDefault()).format(new Date());

        departure.setText(date_d + " , " + date_n + "  " + date_m + " ");
        returnFrom.setText(date_d + " , " + date_n + "  " + date_m + " ");


        departure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dilogstart();
            }
        });


        try {

            String nameCountry2 = SharedPreferencesManger.LoadStringData(getContext(), "2name_country");
            String city_cod2 = SharedPreferencesManger.LoadStringData(getContext(), "2city_code");


            toTextView.setText(city_cod2);
            to_country_name.setText(nameCountry2);

            String nameCountry1 = SharedPreferencesManger.LoadStringData(getContext(), "1name_country");
            String city_cod1 = SharedPreferencesManger.LoadStringData(getContext(), "1city_code");

            country_selected_from_spinner.setText(nameCountry1);

            fromTextView.setText(city_cod1);
            Bundle arguments = getArguments();
            int id = arguments.getInt("id", 0);
            if (id == 1) {
                String name_country = arguments.getString("name_country");
                String city_code = arguments.getString("city_code");
                country_selected_from_spinner.setText(name_country);

                fromTextView.setText(city_code);

                SharedPreferencesManger.SaveData(getContext(), "1name_country", name_country);
                SharedPreferencesManger.SaveData(getContext(), "1city_code", city_code);

            } else if (id == 2) {


                String name_country = arguments.getString("name_country");

                String city_code = arguments.getString("city_code");
                toTextView.setText(city_code);
                to_country_name.setText(name_country);
                SharedPreferencesManger.SaveData(getContext(), "2name_country", name_country);
                SharedPreferencesManger.SaveData(getContext(), "2city_code", city_code);
            }

        } catch (Exception e) {

        }


        proccedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (adult==0){



                }else {


                    searchFlight();



                }





            }
        });


        fromTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchFlightByCity searchFlightByCity = new SearchFlightByCity();

                Bundle bundle = new Bundle();
                bundle.putInt("id_t", 1);
                searchFlightByCity.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.flights_container, searchFlightByCity)
                        .addToBackStack("ProceedBeyBeyOriginal").commit();


            }
        });

        toTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchFlightByCity searchFlightByCity = new SearchFlightByCity();

                Bundle bundle = new Bundle();
                bundle.putInt("id_t", 2);
                searchFlightByCity.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.flights_container, searchFlightByCity)
                        .addToBackStack("ProceedBeyBeyOriginal").commit();

            }
        });

        // 5 for royal ( premium business )
        royalClass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    royalClass.setTextColor(0xFFFFFFFF);
                    businessClass.setTextColor(0xFFBE973B);
                    economyClass.setTextColor(0xFFBE973B);
                    firstClass.setTextColor(0xFFBE973B);


                    flightCabinClass = 5;

                }
                return false;
            }
        });

        // 6 for first
        firstClass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    firstClass.setTextColor(0xFFFFFFFF);
                    royalClass.setTextColor(0xFFBE973B);
                    businessClass.setTextColor(0xFFBE973B);
                    economyClass.setTextColor(0xFFBE973B);

                    flightCabinClass = 6;

                }
                return false;
            }
        });

        // 4 for business
        businessClass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    businessClass.setTextColor(0xFFFFFFFF);
                    royalClass.setTextColor(0xFFBE973B);
                    firstClass.setTextColor(0xFFBE973B);
                    economyClass.setTextColor(0xFFBE973B);

                    flightCabinClass = 4;
                }
                return false;
            }
        });

        // 2 for economy
        economyClass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    economyClass.setTextColor(0xFFFFFFFF);
                    royalClass.setTextColor(0xFFBE973B);
                    firstClass.setTextColor(0xFFBE973B);
                    businessClass.setTextColor(0xFFBE973B);

                    flightCabinClass = 2;
                }
                return false;
            }
        });

        ArrayList<String> listOfAdults = new ArrayList<>();
        listOfAdults.add("Adults");
        listOfAdults.add("1 Adult");
        listOfAdults.add("2 Adults");
        listOfAdults.add("3 Adults");
        listOfAdults.add("4 Adults");
        listOfAdults.add("5 Adults");


        ArrayAdapter adapteradult = new ArrayAdapter(getActivity(), R.layout.item_spener, listOfAdults);

        adapteradult.setDropDownViewResource(R.layout.drop_dowen);
        passengerAdult.setDropDownWidth(420);
        passengerAdult.setDropDownVerticalOffset(200);
        passengerAdult.setAdapter(adapteradult);
        passengerAdult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                if (i != 0) {
                    notFailed = true;

                    adult = i;


                } else {
                    notFailed = false;

                }

                //SharedPreferencesManger.SaveData(getActivity(), "no_adultroom1", nom_adultRoom1);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> listOfChilds  = new ArrayList<>();
        listOfChilds.add("Childs");
        listOfChilds.add("1 Child");
        listOfChilds.add("2 Child");
        listOfChilds.add("3 Child");
        listOfChilds.add("4 Child");
        listOfChilds.add("5 Child");


        ArrayAdapter adapterchild = new ArrayAdapter(getActivity(), R.layout.item_spener, listOfChilds);

        adapterchild.setDropDownViewResource(R.layout.drop_dowen);
        passengerChild.setDropDownWidth(420);
        passengerChild.setDropDownVerticalOffset(200);
        passengerChild.setAdapter(adapterchild);
        passengerChild.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                if (i != 0) {
                    notFailed = true;
                    child = i;
                } else {
                    notFailed = false;
                }

                //SharedPreferencesManger.SaveData(getActivity(), "no_adultroom1", nom_adultRoom1);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayList<String> listOfinfants = new ArrayList<>();
        listOfinfants.add("Infants");
        listOfinfants.add("1 Infant");
        listOfinfants.add("2 Infant");
        listOfinfants.add("3 Infant");
        listOfinfants.add("4 Infant");
        listOfinfants.add("5 Infant");

        ArrayAdapter adapterinfant = new ArrayAdapter(getActivity(), R.layout.item_spener, listOfinfants);

        adapterinfant.setDropDownViewResource(R.layout.drop_dowen);
        passengerInfant.setDropDownWidth(420);
        passengerInfant.setDropDownVerticalOffset(200);
        passengerInfant.setAdapter(adapterinfant);
        passengerInfant.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {



                if (i != 0){
                    notFailed=true;
                    infant = i;

                }else {
                    notFailed=false;
                }
                //SharedPreferencesManger.SaveData(getActivity(), "no_adultroom1", nom_adultRoom1);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        return view;
    }

    private void searchFlight() {
        animatedCircleLoadingView.startDeterminate();
        ListnameLine.clear();
        Listduration.clear();
        ListdeparuerTime.clear();
        ListArriveTime.clear();
        listTypeFare.clear();
        countryNameDestinationList.clear();
        countryNameOriginList.clear();
        listCabinBaggage.clear();
        listIncludedBaggage.clear();
        listTotalFare.clear();
        password = "App02072019";

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

        Call<FlightAuthentication> call = flightApiService.getAuthentication("application/json", flightAuthentication[0]);

        call.enqueue(new Callback<FlightAuthentication>() {
            @Override
            public void onResponse(Call<FlightAuthentication> call, Response<FlightAuthentication> response) {
                flightAuthentication[0] = response.body();
                System.out.println("Helper: " + flightAuthentication[0].getTokenId());
                final SearchFlights[] searchFlights = {new SearchFlights()};
                searchFlights[0].setTokenId(flightAuthentication[0].getTokenId());
                String test = flightAuthentication[0].getTokenId();
                searchFlights[0].setAdultCount(adult);
                searchFlights[0].setChildCount(child);
                searchFlights[0].setFlightCabinClass(flightCabinClass);
                searchFlights[0].setInfantCount(infant);
                searchFlights[0].setJourneyType(oneWay);
                searchFlights[0].setIPAddress("192.168.4.238");
                List<SearchFlights.Segment> segments = new ArrayList<>();
                SearchFlights.Segment segment = new SearchFlights.Segment();

                String to = toTextView.getText().toString();
                String from = fromTextView.getText().toString();
                segment.setDestination(to);
                segment.setOrigin(from);
                //wtf

                List<String> airlines = new ArrayList<>();
                airlines.add("EK");
                airlines.add("AI");
                segment.setPreferredAirlines(airlines);

                segment.setPreferredDepartureTime("2019-09-20 T00:00:00");


                segments.add(segment);
                searchFlights[0].setSegment(segments);
                Call<SearchFlightsResponse> searchCall = flightApiService.getFlightSearch("application/json", searchFlights[0]);
                searchCall.enqueue(new Callback<SearchFlightsResponse>() {

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onResponse(Call<SearchFlightsResponse> call, Response<SearchFlightsResponse> response) {
                        boolean successful = response.isSuccessful();
                        String trackingId = response.body().getTrackingId();

                        List<List<SearchFlightsResponse.Result>> results = response.body().getResults();
                        if (successful&&results.size()!=0) {

                            animatedCircleLoadingView.setVisibility(View.GONE);







                            List<SearchFlightsResponse.Result> results1 = results.get(0);

                            for (int j = 0; j < results1.size(); j++) {

                                String airlineRemark = results1.get(j).getAirlineRemark();
                                String destination = results1.get(j).getDestination();
                                String lastTicketDate = results1.get(j).getLastTicketDate();
                                String origin = results1.get(j).getOrigin();
                                String ticketAdvisory = results1.get(j).getTicketAdvisory();
                                String validatingAirline = results1.get(j).getValidatingAirline();

                                double totalFare = results1.get(j).getFare().getTotalFare();

                                String fareType = results1.get(j).getFare().getAgentPreferredCurrency();

                                listTypeFare.add(fareType);
                                listTotalFare.add(totalFare);


                                List<SearchFlightsResponse.Segment> segments2 = results1.get(j).getSegments().get(0);


                                for (int t = 0; t < segments2.size(); t++) {


                                    String airlineName = segments2.get(t).getAirlineName();
                                    String arrivalTime = segments2.get(t).getArrivalTime();
                                    String departureTime = segments2.get(t).getDepartureTime();

                                    String countryNameDestination = segments2.get(t).getDestination().getCountryName();
                                    String countryNameOrigin = segments2.get(t).getOrigin().getCountryName();

                                    String includedBaggage = segments2.get(t).getIncludedBaggage();

                                    String cabinBaggage = (String) segments2.get(t).getCabinBaggage();

                                    String duration = segments2.get(t).getDuration();


                                    ListnameLine.add(airlineName);
                                    Listduration.add(duration);
                                    ListArriveTime.add(arrivalTime);
                                    ListdeparuerTime.add(departureTime);
                                    countryNameDestinationList.add(countryNameDestination);
                                    countryNameOriginList.add(countryNameOrigin);
                                    listCabinBaggage.add(cabinBaggage);
                                    listIncludedBaggage.add(includedBaggage);

                                }



                            }



                            Intent intent = new Intent(getContext(), RecommendedOneWay.class);

                            intent.putExtra("airlineName", ListnameLine);
                            intent.putExtra("Listduration", Listduration);

                            intent.putExtra("arrivalTime", ListArriveTime);
                            intent.putExtra("departureTime", ListdeparuerTime);

                            intent.putExtra("countryNameDestinationList", countryNameDestinationList);
                            intent.putExtra("countryNameOriginList", countryNameOriginList);

                            intent.putExtra("listCabinBaggage", listCabinBaggage);
                            intent.putExtra("listIncludedBaggage", listIncludedBaggage);

                            intent.putExtra("listTotalFare", listTotalFare);
                            intent.putExtra("listTypeFare", listTypeFare);



                            getContext().startActivity(intent);

                        } else {
                            String s = response.raw().body().toString();
                            Toast.makeText(getContext(), "no Result" + response.message(), Toast.LENGTH_SHORT).show();
                            animatedCircleLoadingView.setVisibility(View.GONE);

                            System.out.println("How: " + s);
                        }

                    }

                    @Override
                    public void onFailure(Call<SearchFlightsResponse> call, Throwable throwable) {
                        Toast.makeText(getContext(), "onFailure" + response.message(), Toast.LENGTH_SHORT).show();
                        animatedCircleLoadingView.setVisibility(View.GONE);

                    }
                });

            }

            @Override
            public void onFailure(Call<FlightAuthentication> call, Throwable throwable) {
                Toast.makeText(getContext(), "onFailure" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                animatedCircleLoadingView.setVisibility(View.GONE);

            }
        });
//        if (flightAuthentication[0].getTokenId() != null) {
//            final SearchFlights[] searchFlights = {new SearchFlights()};
//            searchFlights[0].setTokenId(flightAuthentication[0].getTokenId());
//            String test = flightAuthentication[0].getTokenId();
//            searchFlights[0].setAdultCount(1);
//            searchFlights[0].setChildCount(1);
//            searchFlights[0].setFlightCabinClass(1);
//            searchFlights[0].setInfantCount(1);
//            searchFlights[0].setJourneyType(1);
//            searchFlights[0].setIPAddress("192.168.4.238");
//            List<SearchFlights.Segment> segments = new ArrayList<>();
//            SearchFlights.Segment segment = new SearchFlights.Segment();
//            segment.setDestination("DEL");
//            segment.setOrigin("DXB");
//            segment.setPreferredArrivalTime("2018-12-29T00:00:00");
//            segment.setPreferredDepartureTime("2018-12-29T00:00:00");
//            List<String> airlines = new ArrayList<>();
//            airlines.add("EK");
//            airlines.add("AI");
//            segment.setPreferredAirlines(airlines);
//            segments.add(segment);
//            searchFlights[0].setSegment(segments);
//            Call<SearchFlights> searchCall = flightApiService.getFlightSearch("application/json", searchFlights[0]);
//            searchCall.enqueue(new Callback<SearchFlights>() {
//
//                @Override
//                public void onResponse(Call<SearchFlights> call, Response<SearchFlights> response) {
//                    searchFlights[0] = response.body();
//                    Toast.makeText(getContext(), "searchFlights"+response.message(), Toast.LENGTH_SHORT).show();
//
//                    System.out.println("How: " + searchFlights[0].searchFlightsResponse.getResults());
//                }
//
//                @Override
//                public void onFailure(Call<SearchFlights> call, Throwable throwable) {
//                    Toast.makeText(getContext(), "onFailure"+throwable.getMessage(), Toast.LENGTH_SHORT).show();
//
//                }
//            });
//        }
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


    private void dilogstart() {

        chicDateStart = true;
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"; //In which you need put here
                SimpleDateFormat start = new SimpleDateFormat(myFormat, Locale.US);
                time1 = myCalendar.getTime();
                mstartTime = start.format(myCalendar.getTime());
                //  startDate.setText(mstartTime);

                long time = time1.getTime();

                String dayOfTheWeek = (String) DateFormat.format("EEE", time); // Thursday
                String day = (String) DateFormat.format("dd", time); // Thursday
                String monthString = (String) DateFormat.format("MMM", time); // Thursday



                SharedPreferencesManger.SaveData(getActivity(), "startDateS", dayOfTheWeek + " " + day + " " + monthString + " " + "till ");


                departure.setText(dayOfTheWeek+","+day+" "+monthString);

            }
        };


        new DatePickerDialog(getActivity(), date, myCalendar.get(YEAR),
                myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();

    }


}





