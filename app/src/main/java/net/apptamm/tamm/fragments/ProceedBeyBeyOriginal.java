package net.apptamm.tamm.fragments;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.apptamm.tamm.R;
import net.apptamm.tamm.activities.RecommendedOneWay;
import net.apptamm.tamm.helper.SharedPreferencesManger;

import java.io.InputStream;
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
import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.util.Calendar.YEAR;
import static net.apptamm.tamm.helper.helperMethod.getLocalIpAddress;
import static net.apptamm.tamm.helper.helperMethod.isNetworkConnected;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProceedBeyBeyOriginal extends Fragment  {
    private CheckedTextView passenger, jet, one_way, return_passe, multi_cities;
    private CheckedTextView royalClass, firstClass, businessClass, economyClass;
    private TextView fromTextView, toTextView, departure, returnFrom , from_country , to_country;
    private Button proccedBtn;
    private Spinner passengerAdult, passengerChild, passengerInfant;
    public static final String BASE_URL = "https://xmloutapi.tboair.com/api/v1/";
    private static Retrofit retrofit = null;
    String password;
    private TextView country_selected_from_spinner, to_country_name, return_date, icon2;
    private boolean chicDateStart;
    private Calendar myCalendar;
    private Date time1, time2;
    private String mstartTime;
    private boolean chicDateEnd;
    private int nom_adultRoom1;
    private boolean notFailed;
    private long adult, child, infant;

    ProgressBar progressFlight;
    View line3;
    long flightCabinClass = 1;


    ArrayList<SearchFlightsResponse.Result> ListResult = new ArrayList<>();



    private InputStream inputStream;
    private long JourneyType = 1;
    private String mReturnTime;
    private String daDepartureTimeyO;
    private int sizeSegments;
    private String daDepartureTimeyR;

    RelativeLayout relative_from_to   , parent_relative;
    private int id = 0;
    private String from , to;

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
        relative_from_to = view.findViewById(R.id.relative_from_to);
        from_country = view.findViewById(R.id.from_country);
        to_country = view.findViewById(R.id.to_country);
        parent_relative = view.findViewById(R.id.parent_relative);


        SharedPreferencesManger.remove(getContext(), "to");
        SharedPreferencesManger.remove(getContext(), "from");


        royalClass = view.findViewById(R.id.royal_class);
        firstClass = view.findViewById(R.id.first_class);
        businessClass = view.findViewById(R.id.business_class);
        economyClass = view.findViewById(R.id.economy_class);
        fromTextView = view.findViewById(R.id.from_multi_1);
        toTextView = view.findViewById(R.id.to_multi_1);
        country_selected_from_spinner = view.findViewById(R.id.from_country_multi_1);
        return_date = view.findViewById(R.id.return_date);

        line3 = view.findViewById(R.id.line3_);
        icon2 = view.findViewById(R.id.icon2_);
        proccedBtn = view.findViewById(R.id.procced_btn);
        departure = view.findViewById(R.id.departure_spinner);
        returnFrom = view.findViewById(R.id.return_spinner);
        passengerAdult = view.findViewById(R.id.adult_spinner);
        passengerChild = view.findViewById(R.id.child_spinner);
        passengerInfant = view.findViewById(R.id.infant_spinner);
        to_country_name = view.findViewById(R.id.to_country_multi_1);

        passenger = view.findViewById(R.id.passen_air);
        jet = view.findViewById(R.id.private_jet);
        one_way = view.findViewById(R.id.one_way);
        return_passe = view.findViewById(R.id.return_passe);
        multi_cities = view.findViewById(R.id.multi_cities);
        progressFlight = view.findViewById(R.id.circle_loading_view_flight);




        progressFlight.setVisibility(View.INVISIBLE);

        if (JourneyType == 1) {


            returnFrom.setVisibility(View.GONE);
            return_date.setVisibility(View.GONE);
            line3.setVisibility(View.GONE);
            icon2.setVisibility(View.GONE);
        } else {
            return_date.setVisibility(View.VISIBLE);
            returnFrom.setVisibility(View.VISIBLE);
            line3.setVisibility(View.VISIBLE);
            icon2.setVisibility(View.VISIBLE);


        }

        try {
             id = getArguments().getInt("multi");

            if (id==1){

                from_country.setVisibility(View.INVISIBLE);
                to_country.setVisibility(View.INVISIBLE);
                relative_from_to.setVisibility(View.GONE);

                return_passe.setTextColor(0xFFBE973B);
                one_way.setTextColor(0xFFBE973B);
                multi_cities.setTextColor(0xFFFFFFFF);
                parent_relative.setVisibility(View.GONE);

            }
        } catch (Exception e) {
            e.printStackTrace();

        }


        myCalendar = Calendar.getInstance();
        String date_n = new SimpleDateFormat("dd", Locale.getDefault()).format(new Date());
        String date_m = new SimpleDateFormat("MMM", Locale.getDefault()).format(new Date());
        String date_d = new SimpleDateFormat("EEE", Locale.getDefault()).format(new Date());

        departure.setText(date_d + " , " + date_n + "  " + date_m + " ");
        returnFrom.setText(date_d + " , " + date_n + "  " + date_m + " ");

        if (!isNetworkConnected(getActivity())) {

            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Please Check Your Internet first ")
                    .setConfirmText("Ok")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {

                            sDialog.dismissWithAnimation();
                        }
                    })
                    .show();
        }

        one_way.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    one_way.setTextColor(0xFFFFFFFF);
                    return_passe.setTextColor(0xFFBE973B);
                    multi_cities.setTextColor(0xFFBE973B);
                    JourneyType = 1;
                    returnFrom.setVisibility(View.GONE);
                    return_date.setVisibility(View.GONE);
                    line3.setVisibility(View.GONE);
                    icon2.setVisibility(View.GONE);
                    from_country.setVisibility(View.VISIBLE);
                    to_country.setVisibility(View.VISIBLE);
                    relative_from_to.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });

//        multi_cities.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//
//
//                    from_country.setVisibility(View.INVISIBLE);
//                    to_country.setVisibility(View.INVISIBLE);
//                    relative_from_to.setVisibility(View.GONE);
//
//                    return_passe.setTextColor(0xFFBE973B);
//                    one_way.setTextColor(0xFFBE973B);
//                    multi_cities.setTextColor(0xFFFFFFFF);
//
//                    JourneyType = 1;
//                    returnFrom.setVisibility(View.VISIBLE);
//                    return_date.setVisibility(View.VISIBLE);
//                    line3.setVisibility(View.VISIBLE);
//                    icon2.setVisibility(View.VISIBLE);
//
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flights_container, new MultiCitiesFlights())
//                            .addToBackStack("ProceedBeyBeyOriginal").commit();
//
//
//                }
//                return false;
//
//            }
//        });

        return_passe.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    return_passe.setTextColor(0xFFFFFFFF);
                    one_way.setTextColor(0xFFBE973B);
                    multi_cities.setTextColor(0xFFBE973B);
                    JourneyType = 2;
                    returnFrom.setVisibility(View.VISIBLE);
                    return_date.setVisibility(View.VISIBLE);
                    line3.setVisibility(View.VISIBLE);
                    icon2.setVisibility(View.VISIBLE);
                    from_country.setVisibility(View.VISIBLE);
                    to_country.setVisibility(View.VISIBLE);
                    relative_from_to.setVisibility(View.VISIBLE);

                }
                return false;
            }
        });

        departure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dilogstart();
            }
        });
        returnFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dilogreturn();
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


                if (adult == 0) {

                    new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("Select At Least 1 Passenger")
                            .setConfirmText("ok")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {

                                    sDialog.dismissWithAnimation();
                                }
                            })
                            .show();

                } else {


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

        ArrayList<String> listOfChilds = new ArrayList<>();
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


                if (i != 0) {
                    notFailed = true;
                    infant = i;

                } else {
                    notFailed = false;
                }
                //SharedPreferencesManger.SaveData(getActivity(), "no_adultroom1", nom_adultRoom1);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        return view;
    }

    private void dilogreturn() {


        chicDateStart = true;
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat ="yyyy-MM-dd' T'00:00:00";
                SimpleDateFormat start = new SimpleDateFormat(myFormat, Locale.US);
                time2 = myCalendar.getTime();
                mReturnTime = start.format(myCalendar.getTime());
                //  startDate.setText(mstartTime);

                long time = time2.getTime();

                String dayOfTheWeek = (String) DateFormat.format("EEE", time); // Thursday
                String day = (String) DateFormat.format("dd", time); // Thursday
                String monthString = (String) DateFormat.format("MMM", time); // Thursday




                daDepartureTimeyR = (String) DateFormat.format(myFormat, time);

                SharedPreferencesManger.SaveData(getActivity(), "returnDateS", dayOfTheWeek + " " + day + " " + monthString + " " + "till ");


                returnFrom.setText(dayOfTheWeek + "," + day + " " + monthString);

            }
        };


        new DatePickerDialog(getActivity(), date, myCalendar.get(YEAR),
                myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }


    private void searchFlight() {

        progressFlight.setVisibility(View.VISIBLE);


        ListResult.clear();

        Gson gson = new GsonBuilder()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(interceptor).connectTimeout(0, TimeUnit.SECONDS)
                .readTimeout(0, TimeUnit.SECONDS).build();

        connectAndGetApiData(gson, client);
        FlightApiService flightApiService = retrofit.create(FlightApiService.class);

        final FlightAuthentication[] flightAuthentication = {new FlightAuthentication()};
        flightAuthentication[0].setUserName(FlightConstants.API_USER_NAME);
        flightAuthentication[0].setPassword(password);
        flightAuthentication[0].setBookingMode("API");


        String localIpAddress = getLocalIpAddress();


        flightAuthentication[0].setIPAddress(localIpAddress);
        FlightAuthentication.Agency ag = null;

        flightAuthentication[0].setAgency(ag);

        Call<FlightAuthentication> call = flightApiService.getAuthentication("application/json", flightAuthentication[0]);

        call.enqueue(new Callback<FlightAuthentication>() {
            @Override
            public void onResponse(Call<FlightAuthentication> call, Response<FlightAuthentication> response) {
                flightAuthentication[0] = response.body();

                final SearchFlights[] searchFlights = {new SearchFlights()};
                //1
                searchFlights[0].setIPAddress(localIpAddress);

                //2
                // searchFlights[0].setEndUserBrowserAgent("Mozilla/5.0(Windows NT 6.1)");
                 to = toTextView.getText().toString();


                 from = fromTextView.getText().toString();
                //3 test
                searchFlights[0].setPointOfSale(to);

                //4 test
                searchFlights[0].setRequestOrigin(country_selected_from_spinner.getText().toString());
                //5
                searchFlights[0].setTokenId(flightAuthentication[0].getTokenId());
                //6
                searchFlights[0].setJourneyType(JourneyType);

                //7
                searchFlights[0].setAdultCount(adult);

                //8
                searchFlights[0].setChildCount(child);

                //9
                searchFlights[0].setInfantCount(infant);

                //10
                searchFlights[0].setFlightCabinClass(flightCabinClass);

                //11
                List<SearchFlights.Segment> segments = new ArrayList<>();
                SearchFlights.Segment segment = new SearchFlights.Segment();
                SearchFlights.Segment segment2 = new SearchFlights.Segment();

                //11.1
                segment.setDestination(to);
                //11.2
                segment.setOrigin(from);


                //just 4 return trip
                segment2.setDestination(from);
                segment2.setOrigin(to);
                // List<String> airlines = new ArrayList<>();
                //11.3    // "2019-09-20 T00:00:00" 2019-09-20 T18:56:17



                segment.setPreferredDepartureTime(daDepartureTimeyO);
                segment.setPreferredArrivalTime(daDepartureTimeyO);

                segment2.setPreferredDepartureTime(daDepartureTimeyR);
                segment2.setPreferredArrivalTime(daDepartureTimeyR);
                //  11.4



               // segment.setPreferredArrivalTime(mReturnTime);
                // ic_add segments


                if (JourneyType==1){

                    segments.add(segment);
                }else {
                    segments.add(segment);
                    segments.add(segment2);

                }

                searchFlights[0].setSegment(segments);

                Call<SearchFlightsResponse> searchCall = flightApiService.getFlightSearch("application/json", searchFlights[0]);
                searchCall.enqueue(new Callback<SearchFlightsResponse>() {

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onResponse(Call<SearchFlightsResponse> call, Response<SearchFlightsResponse> response) {
                        boolean successful = response.isSuccessful();

                        String trackingId = response.body().getTrackingId();

                        String tokenId = response.body().getTokenId();
                        List<List<SearchFlightsResponse.Result>> results = response.body().getResults();






                        if (successful && results != null && results.size() > 0) {


                            SharedPreferencesManger.SaveData(getContext(), "adult", adult);
                            SharedPreferencesManger.SaveData(getContext(), "child", child);
                            SharedPreferencesManger.SaveData(getContext(), "infant", infant);


                            SharedPreferencesManger.SaveData(getContext(), "tokenId", tokenId);
                            SharedPreferencesManger.SaveData(getContext(), "trackingId", trackingId);


                            SharedPreferencesManger.SaveData(getContext(), "to", to);
                            SharedPreferencesManger.SaveData(getContext(), "from", from);


                            SharedPreferencesManger.SaveData(getContext(), "PointOfSale", to);
                            progressFlight.setVisibility(View.INVISIBLE);


                            List<SearchFlightsResponse.Result> results1 = results.get(0);

                            ListResult.addAll(results1);


                            Intent intent = new Intent(getContext(), RecommendedOneWay.class);

                            intent.putExtra("ListResult", ListResult);



                            if (JourneyType==1){

                                SharedPreferencesManger.SaveData(getContext(),"journyTipe", 1);

                            }else {
                                SharedPreferencesManger.SaveData(getContext(),"journyTipe", 2);


                            }
                            SharedPreferencesManger.SaveData(getContext(),"flightCabinClass",flightCabinClass);

                            getContext().startActivity(intent);

                        } else {

                            progressFlight.setVisibility(View.INVISIBLE);

                            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                                    .setTitleText("No Result Found")
                                    .setConfirmText("Search Again")
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sDialog) {

                                            sDialog.dismissWithAnimation();
                                        }
                                    })
                                    .show();


                            String s = response.raw().body().toString();

                            System.out.println("How: " + s);
                        }
                    }


                    @Override
                    public void onFailure(Call<SearchFlightsResponse> call, Throwable throwable) {
                        Toast.makeText(getContext(), "onFailure" + response.message(), Toast.LENGTH_SHORT).show();
                        progressFlight.setVisibility(View.INVISIBLE);

                    }
                });

            }

            @Override
            public void onFailure(Call<FlightAuthentication> call, Throwable throwable) {
                Toast.makeText(getContext(), "onFailure" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                progressFlight.setVisibility(View.INVISIBLE);

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


    private void dilogstart() {

        chicDateStart = true;
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat ="yyyy-MM-dd' T'00:00:00"; //In which you need put here
//                SimpleDateFormat start = new SimpleDateFormat(myFormat, Locale.US);
              //  mstartTime = start.format(myCalendar.getTime());
                //  startDate.setText(mstartTime);
                time1 = myCalendar.getTime();

                long time = time1.getTime();

                String dayOfTheWeek = (String) DateFormat.format("EEE", time); // Thursday
                String day = (String) DateFormat.format("dd", time); // Thursday
                String monthString = (String) DateFormat.format("MMM", time); // Thursday

                 daDepartureTimeyO = (String) DateFormat.format(myFormat, time); // 019-09-20 T00:00:00
                SharedPreferencesManger.SaveData(getActivity(), "A_startDateS", dayOfTheWeek + " " + day + " " + monthString );

// 2019-09-20 T00:00:00
                departure.setText(dayOfTheWeek + "," + day + " " + monthString);


            }
        };

        Locale locale = new Locale("EN");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        ProceedBeyBeyOriginal.this.getResources().updateConfiguration(config, null);

        new DatePickerDialog(getActivity(), date, myCalendar.get(YEAR),
                myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }




}
