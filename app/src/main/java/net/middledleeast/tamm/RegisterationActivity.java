package net.middledleeast.tamm;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.CheckOutReq;
import com.Tamm.Hotels.wcf.CountryList;
import com.Tamm.Hotels.wcf.CountryListResponse;
import com.Tamm.Hotels.wcf.DestinationCityListResponse;
import com.Tamm.Hotels.wcf.CountryList;
import com.Tamm.Hotels.wcf.CountryListResponse;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import net.middledleeast.tamm.ActivityToFragment.PaymentActivityFragment;
import net.middledleeast.tamm.activities.FindHotels;
import net.middledleeast.tamm.activities.PaymentActivity;
import net.middledleeast.tamm.fragments.PlansFragment;
import net.middledleeast.tamm.fragments.TammFamilyFragment;
import net.middledleeast.tamm.fragments.PlansFragment;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RegisterationActivity extends Fragment {
    private EditText etFirstName;
    private EditText etLastName;
    private EditText etUserName;
    private Button register;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private TextView etDate;
    private AutoCompleteTextView country , city , ocupation;
    private EditText etCity;
    private EditText etVisa;
    private BasicHttpBinding_IHotelService1 service;
    private AuthenticationData authenticationData;
    RelativeLayout relative_visa;
    int free;
    int member;
    int user_id;

    RequestQueue requestQueue;
    private String register_url_free = "http://egyptgoogle.com/freeusers/insertusers.php";
    private String register_url_member = "http://egyptgoogle.com/paymentusers/insertstudents.php";


    private ArrayList<String> mrOrMissArray;
    private ArrayAdapter mrOrMissAdapter;
    private Spinner mrormissSpinner;
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private String day, month, year;


    List<String> list_country = new ArrayList<>();
    private List<String> listID = new ArrayList<>();
    private int nameCity;
    private String idCountry;
    private List<String> list_city = new ArrayList<>();

    Toolbar toolbar;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registeration, container, false);

        etFirstName = view.findViewById(R.id.ed_first_name);
        etLastName = view.findViewById(R.id.ed_last_name);
        etUserName = view.findViewById(R.id.ed_user_name);
        etPhone = view.findViewById(R.id.ed_phone);
        etEmail = view.findViewById(R.id.ed_email);
        etPassword = view.findViewById(R.id.ed_password);
        etDate = view.findViewById(R.id.ed_Date);
        country = view.findViewById(R.id.country);
        ocupation = view.findViewById(R.id.ed_occupation);
        city = view.findViewById(R.id.ed_city);

        toolbar = view.findViewById(R.id.welcome_toolbar);
        imageView = view.findViewById(R.id.back_pressed);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.welcome_container, new PlansFragment())
                        .commit();
            }
        });


        relative_visa = view.findViewById(R.id.relative_visa);
        etVisa = view.findViewById(R.id.ed_visa);
        register = view.findViewById(R.id.proceedcheck_out);

        Context context = getActivity();
        requestQueue = Volley.newRequestQueue(context);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        auth();
        getCountries();

        getOcupation();
        ArrayAdapter adapter = new ArrayAdapter<String>(getContext(), R.layout.item_spener_reg, list_country);


               country.setAdapter(adapter);


        relative_visa = view.findViewById(R.id.relative_visa);

        Bundle arguments = getArguments();
        try {
            free = arguments.getInt("free");

            member = arguments.getInt("member");

        } catch (Exception ignored) {

        }


        if (free == 2) {

            user_id = 1;
            relative_visa.setVisibility(View.GONE);


        } else if (member == 1) {
            user_id = 2;


        } else {
            return null;
        }



        mrOrMissArray = new ArrayList<>();
        mrOrMissArray.add("Mr.");
        mrOrMissArray.add("Mrs.");

//        mDisplayDate = view.findViewById(R.id.tvDate);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesManger.SaveData(getActivity(), "username", etUserName.getText().toString());
                connectdatabase();
                if (user_id == 2) {

                    Intent intent = new Intent(getContext(), PaymentActivity.class);
                    startActivity(intent);
                } else if (user_id == 1) {

                    Intent intent = new Intent(getContext(), PaymentActivityFragment.class);
                    startActivity(intent);
                }


            }
        });


        mrOrMissAdapter = new ArrayAdapter(getContext(), R.layout.item_spener, mrOrMissArray);
        mrormissSpinner = view.findViewById(R.id.mromiss);
        mrOrMissAdapter.setDropDownViewResource(R.layout.drop_dowen);
        mrormissSpinner.setSelection(1);
        mrormissSpinner.setAdapter(mrOrMissAdapter);


        etDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getContext(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }

        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int yea_, int month_, int day_) {


                etDate.setText(" " + day_ + " - " + month_ + " - " + yea_ + " ");

                day = String.valueOf(day_);

                month = String.valueOf(month_);
                year = String.valueOf(month_);


            }
        };
        return view;
    }

    private void connectdatabase() {
        if (user_id == 1) {
            StringRequest request = new StringRequest(Request.Method.POST, register_url_free, new Response.Listener<String>() {

                @Override

                public void onResponse(String response) {
                    Toast.makeText(getContext(), "" + response, Toast.LENGTH_SHORT).show();

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }

            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> parameters = new HashMap<String, String>();
                    parameters.put("firstname", etFirstName.getText().toString());
                    parameters.put("lastname", etLastName.getText().toString());
                    parameters.put("username", etUserName.getText().toString());
                    parameters.put("password", etPassword.getText().toString());
                    parameters.put("day", day);
                    parameters.put("month", month);
                    parameters.put("year", year);
                    parameters.put("location", country.getText().toString());
                    parameters.put("occupation", ocupation.getText().toString());
                    parameters.put("email", etEmail.getText().toString());
                    parameters.put("phone", etPhone.getText().toString());
                    parameters.put("city", etCity.getText().toString());


                    return parameters;
                }
            };
            requestQueue.add(request);

        } else if (user_id == 2) {
            StringRequest request = new StringRequest(Request.Method.POST, register_url_member, new Response.Listener<String>() {

                @Override

                public void onResponse(String response) {

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }

            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> parameters = new HashMap<String, String>();
                    parameters.put("firstname", etFirstName.getText().toString());
                    parameters.put("lastname", etLastName.getText().toString());
                    parameters.put("username", etUserName.getText().toString());
                    parameters.put("password", etPassword.getText().toString());
                    parameters.put("day", day);
                    parameters.put("month", month);
                    parameters.put("year", year);
                    parameters.put("location", country.getText().toString());
                    parameters.put("occupation", ocupation.getText().toString());
                    parameters.put("email", etEmail.getText().toString());
                    parameters.put("phone", etPhone.getText().toString());
                    parameters.put("city", etCity.getText().toString());
                    parameters.put("visa", etVisa.getText().toString());

                    return parameters;
                }
            };
            requestQueue.add(request);

        }


    }


    private void getCountries() {




        // get all name country in string
        String name_country = SharedPreferencesManger.LoadStringData(getActivity(), "name_country");
        Gson gson = new Gson();
        list_country = gson.fromJson(name_country,ArrayList.class);



        String code_country = SharedPreferencesManger.LoadStringData(getActivity(), "code_country");

        Gson gson2 = new Gson();
        listID = gson2.fromJson(code_country,ArrayList.class);


            for (int i = 0; i < list_country.size(); i++) {

                idCountry = listID.get(i);

              //  getCities(idCountry);


            }


            // String test = hotelSearchResponse.Status.Description;
//            System.out.println("Hello: " + test);


    }
    private void auth() {

        service = new BasicHttpBinding_IHotelService1();
        authenticationData = new AuthenticationData();
        authenticationData.UserName = ("Tammtest");
        authenticationData.Password = ("Tam@18418756");

    }




    private void getCities(String idCountry) {


        try {
            DestinationCityListResponse cities = service.DestinationCityList(idCountry, "true", authenticationData);
            for (int j = 0; j < cities.CityList.size(); j++) {


                String cityName = cities.CityList.get(j).CityName;
                list_city.add(cityName);


               // Toast.makeText(getContext(), "list size is  :"+list_city.size(), Toast.LENGTH_SHORT).show();


                ArrayAdapter adapter2 = new ArrayAdapter<String>(getContext(), R.layout.item_spener_reg, list_city);
                city.setAdapter(adapter2);

}

            } catch (Exception e1) {
            e1.printStackTrace();
            Toast.makeText(getContext(), ""+e1.getMessage(), Toast.LENGTH_SHORT).show();
        }





    }



    private void  getOcupation(){



        String [] ocupation_list = new String[]{

                "Abattoir worker",
                "Accounts clerk",
                "Actor",
                "Actuary",
                "Acupuncturist",

                "Aeroplane pilot",
                "Aged care worker",

                "Air combat officer",
                "Ambulance officer",
                "Anaesthetist",

                " farmer",
                "Arborist",
                "Archaeologist",
                "Architect",

                "Army officer",


                "Art teacher",
                "Auctioneer",
                "Audiologist",
                "Author",




        };


        ArrayAdapter adapter2 = new ArrayAdapter<String>(getContext(), R.layout.item_spener_reg, ocupation_list);
        ocupation.setAdapter(adapter2);

    }


}
