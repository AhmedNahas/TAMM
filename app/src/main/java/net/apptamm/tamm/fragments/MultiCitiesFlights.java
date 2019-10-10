package net.apptamm.tamm.fragments;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.res.Configuration;
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
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import net.apptamm.tamm.R;
import net.apptamm.tamm.helper.SharedPreferencesManger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import cn.pedant.SweetAlert.SweetAlertDialog;

import static java.util.Calendar.YEAR;

/**
 * A simple {@link Fragment} subclass.
 */
public class MultiCitiesFlights extends Fragment {


//    RelativeLayout addNewTrip;
//    RecyclerView addNewTripRv;
//    List<Integer> integers = new ArrayList<>();
//    FlightAddingAdapter adapter;
//    int count = 0;
//    private Button proccedBtn;

    Button next;
    RelativeLayout next_btn_multi1;

    Spinner adult_spinner, child_spinner, infant_spinner;

    private TextView fromTextView, toTextView, departure, from_country, to_country, departure_spinner;
    private Calendar myCalendar;
    private String daDepartureTimeyO;
    private boolean chicDateStart;
    private boolean notFailed;
    private int adult;
    private int child;
    private int infant;
    long flightCabinClass = 1;
    private CheckedTextView royalClass, firstClass, businessClass, economyClass;


    public MultiCitiesFlights() {
        // Required empty public constructor
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_multi_cities_flights, container, false);
        next = view.findViewById(R.id.next_btn_multi1);

        fromTextView = view.findViewById(R.id.from_multi);
        toTextView = view.findViewById(R.id.to_multi);
        departure = view.findViewById(R.id.departure_spinner);


        from_country = view.findViewById(R.id.from_country_multi);
        to_country = view.findViewById(R.id.to_country_multi);
        next_btn_multi1 = view.findViewById(R.id.rv_add);


        adult_spinner = view.findViewById(R.id.adult_spinner);
        child_spinner = view.findViewById(R.id.child_spinner);
        infant_spinner = view.findViewById(R.id.infant_spinner);

        royalClass = view.findViewById(R.id.royal_class);
        firstClass = view.findViewById(R.id.first_class);
        businessClass = view.findViewById(R.id.business_class);
        economyClass = view.findViewById(R.id.economy_class);




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
        adult_spinner.setDropDownWidth(420);
        adult_spinner.setDropDownVerticalOffset(200);
        adult_spinner.setAdapter(adapteradult);
        adult_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        child_spinner.setDropDownWidth(420);
        child_spinner.setDropDownVerticalOffset(200);
        child_spinner.setAdapter(adapterchild);
        child_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        infant_spinner.setDropDownWidth(420);
        infant_spinner.setDropDownVerticalOffset(200);
        infant_spinner.setAdapter(adapterinfant);
        infant_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
















        departure_spinner = view.findViewById(R.id.departure_spinner);
        myCalendar = Calendar.getInstance();
        String date_n = new SimpleDateFormat("dd", Locale.getDefault()).format(new Date());
        String date_m = new SimpleDateFormat("MMM", Locale.getDefault()).format(new Date());
        String date_d = new SimpleDateFormat("EEE", Locale.getDefault()).format(new Date());

        departure.setText(date_d + " , " + date_n + "  " + date_m + " ");

        departure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dilogstart();
            }
        });


        next_btn_multi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);

                fragmentTransaction.replace(R.id.flights_container, new MultiCities2())
                        .addToBackStack("MultiCitiesFlights").commit();
            }
        });



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);

                ProceedBeyBeyOriginal proceedBeyBeyOriginal = new ProceedBeyBeyOriginal();


                if (notFailed){
                    Bundle bundle = new Bundle();
                    bundle.putInt("multi", 1);

                    bundle.putInt("adult_multi", adult);
                    bundle.putInt("child_multi", child);
                    bundle.putInt("infant_multi", infant);




                    proceedBeyBeyOriginal.setArguments(bundle);

                    fragmentTransaction.replace(R.id.flights_container, proceedBeyBeyOriginal)
                            .addToBackStack("MultiCities2").commit();

                }else
                    {


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
                    }





            }
        });


        fromTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchFlightByCity searchFlightByCity = new SearchFlightByCity();

                Bundle bundle = new Bundle();
                bundle.putInt("id_t", 3);
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
                bundle.putInt("id_t", 4);
                searchFlightByCity.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.flights_container, searchFlightByCity)
                        .addToBackStack("ProceedBeyBeyOriginal").commit();

            }
        });


        try {

            String nameCountry2 = SharedPreferencesManger.LoadStringData(getContext(), "2name_country_multi");
            String city_cod2 = SharedPreferencesManger.LoadStringData(getContext(), "2city_code_multi");


            toTextView.setText(city_cod2);
            to_country.setText(nameCountry2);

            String nameCountry1 = SharedPreferencesManger.LoadStringData(getContext(), "1name_country_multi");
            String city_cod1 = SharedPreferencesManger.LoadStringData(getContext(), "1city_code_multi");


            from_country.setText(nameCountry1);
            fromTextView.setText(city_cod1);
            Bundle arguments = getArguments();
            int id = arguments.getInt("id", 0);
            if (id == 3) {
                String name_country = arguments.getString("name_country_multi");
                String city_code = arguments.getString("city_code_multi");

                from_country.setText(name_country);
                fromTextView.setText(city_code);

                SharedPreferencesManger.SaveData(getContext(), "1name_country_multi", name_country);
                SharedPreferencesManger.SaveData(getContext(), "1city_code_multi", city_code);

            } else if (id == 4) {

                String name_country = arguments.getString("name_country_multi");

                String city_code = arguments.getString("city_code_multi");
                toTextView.setText(city_code);
                to_country.setText(name_country);
                SharedPreferencesManger.SaveData(getContext(), "2name_country_multi", name_country);
                SharedPreferencesManger.SaveData(getContext(), "2city_code_multi", city_code);
            }

        } catch (Exception e) {

        }


        return view;
    }

    private void dilogstart() {


        chicDateStart = true;
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "yyyy-MM-dd' T'00:00:00"; //In which you need put here
//                SimpleDateFormat start = new SimpleDateFormat(myFormat, Locale.US);
                //  mstartTime = start.format(myCalendar.getTime());
                //  startDate.setText(mstartTime);
                Date time1 = myCalendar.getTime();

                long time = time1.getTime();

                String dayOfTheWeek = (String) DateFormat.format("EEE", time); // Thursday
                String day = (String) DateFormat.format("dd", time); // Thursday
                String monthString = (String) DateFormat.format("MMM", time); // Thursday

                daDepartureTimeyO = (String) DateFormat.format(myFormat, time); // 019-09-20 T00:00:00

                SharedPreferencesManger.SaveData(getActivity(), "A_startDateS", dayOfTheWeek + " " + day + " " + monthString);

// 2019-09-20 T00:00:00
                departure.setText(dayOfTheWeek + "," + day + " " + monthString);


            }
        };

        Locale locale = new Locale("EN");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        MultiCitiesFlights.this.getResources().updateConfiguration(config, null);

        new DatePickerDialog(getActivity(), date, myCalendar.get(YEAR),
                myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }


}