package net.middledleeast.tamm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

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

import net.middledleeast.tamm.activities.PaymentActivity;
import net.middledleeast.tamm.fragments.PlansFragment;
import net.middledleeast.tamm.fragments.TammFamilyFragment;
import net.middledleeast.tamm.helper.SharedPreferencesManger;
import net.middledleeast.tamm.model.PaymentActivityFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RegisterationActivity extends Fragment {
    private EditText etFirstName;
    private EditText etLastName;
    private EditText etUserName;
    private Button register;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private EditText etDay;
    private EditText etMonth;
    private EditText etYear;
    private EditText etLocation;
    private EditText etOccupation;
    private EditText etCity;
    private EditText etVisa;


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

    Toolbar toolbar;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registeration, container, false);


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

        etFirstName=view.findViewById(R.id.ed_first_name);
        etLastName=view.findViewById(R.id.ed_last_name);
        etUserName =view.findViewById(R.id.ed_user_name);
        etPhone=view.findViewById(R.id.ed_phone);
        etEmail=view.findViewById(R.id.ed_email);
        etPassword =view.findViewById(R.id.ed_password);
        etDay=view.findViewById(R.id.ed_Day);
        etMonth=view.findViewById(R.id.ed_Month);
        etYear=view.findViewById(R.id.ed_Year);
        etLocation=view.findViewById(R.id.ed_location);
        etOccupation=view.findViewById(R.id.ed_occupation);
        etCity=view.findViewById(R.id.ed_city);

        etVisa=view.findViewById(R.id.ed_visa);
        register = view.findViewById(R.id.proceedcheck_out);

        Context context = getActivity();
        requestQueue = Volley.newRequestQueue(context);







        relative_visa = view.findViewById(R.id.relative_visa);

        Bundle arguments = getArguments();
        try {
            free = arguments.getInt("free");

            member = arguments.getInt("member");

        }catch (Exception ignored){

        }


        if (free==2){

            user_id = 1 ;
            relative_visa.setVisibility(View.GONE);


        }else if (member==1){
            user_id = 2;


        }else {
            return null;
        }



        mrOrMissArray = new ArrayList<>();
        mrOrMissArray.add("Mr.");
        mrOrMissArray.add("Mrs.");

//        mDisplayDate = view.findViewById(R.id.tvDate);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesManger.SaveData(getActivity(),"username",etUserName.getText().toString());
                connectdatabase();
                if (user_id == 2){

                    Intent intent= new Intent(getContext(), PaymentActivity.class);
                    startActivity(intent);
                }else if (user_id == 1) {

                    Intent intent= new Intent(getContext(), PaymentActivityFragment.class);
                    startActivity(intent);
                }


            }
        });


        mrOrMissAdapter = new ArrayAdapter(getContext(), R.layout.item_spener, mrOrMissArray);
        mrormissSpinner = view.findViewById(R.id.mromiss);
        mrOrMissAdapter.setDropDownViewResource(R.layout.drop_dowen);
        mrormissSpinner.setSelection(1);
        mrormissSpinner.setAdapter(mrOrMissAdapter);


//        mDisplayDate.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Calendar cal = Calendar.getInstance();
//                int year = cal.get(Calendar.YEAR);
//                int month = cal.get(Calendar.MONTH);
//                int day = cal.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog dialog = new DatePickerDialog(getContext(),
//                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
//                        mDateSetListener,
//                        year, month, day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//            }
//
//        });
//
//        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                mDisplayDate.setText(date);
//            }
//        };
        return view;
    }

    private void connectdatabase() {
        if (user_id==1){
            StringRequest request = new StringRequest(Request.Method.POST, register_url_free, new Response.Listener<String>() {

                @Override

                public void onResponse(String response) {
                    Toast.makeText(getContext(), ""+response, Toast.LENGTH_SHORT).show();

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
                    parameters.put("day", etDay.getText().toString());
                    parameters.put("month", etMonth.getText().toString());
                    parameters.put("year", etYear.getText().toString());
                    parameters.put("location", etLocation.getText().toString());
                    parameters.put("occupation", etOccupation.getText().toString());
                    parameters.put("email", etEmail.getText().toString());
                    parameters.put("phone", etPhone.getText().toString());
                    parameters.put("city", etCity.getText().toString());


                    return parameters;
                }
            };
            requestQueue.add(request);

        }else if (user_id==2){
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
                    parameters.put("day", etDay.getText().toString());
                    parameters.put("month", etMonth.getText().toString());
                    parameters.put("year", etYear.getText().toString());
                    parameters.put("location", etLocation.getText().toString());
                    parameters.put("occupation", etOccupation.getText().toString());
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
}
