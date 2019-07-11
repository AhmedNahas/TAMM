package net.middledleeast.tamm;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.middledleeast.tamm.activities.RenewAccount;
import net.middledleeast.tamm.fragments.ForgotPasswordFragment;
import net.middledleeast.tamm.helper.SharedPreferencesManger;
import net.middledleeast.tamm.model.Freeuser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {

    private TextView txtForgotPassword;
    private Button btnSignIn;
    private EditText userName, pass;
    private static final String HI ="http://egyptgoogle.com/freeusers/checkusers.php" ;
  private List<Freeuser> freeusers =new ArrayList<>();
    private List<String> listUserName = new ArrayList<>();
    private List<String> listUserPass = new ArrayList<>();
    private String password;
    private String username;


    public SignInFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = getView(inflater, container);

        getFreeData();




        // for test
        userName.setText("ahmed");
        pass.setText("0125016341");


////        btnSignIn.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                if (userName.getText().toString().equals("tamm@gmail.com") && pass.getText().toString().equals("0123456")) {
//                    getActivity().getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.welcome_container, new UsersFreeFragment())
//                            .commit();
//                }
//
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    btnSignIn.setTextColor(Color.parseColor("#BE973B"));
//                    getActivity().getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.welcome_container, new PlansFragment())
//                            .commit();
//                } else if (event.getAction() == MotionEvent.ACTION_UP) {
//                    btnSignIn.setBackground(getActivity().getDrawable(R.drawable.border));
//                }
//                return false;
//
//
//            }
        //   });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user_Name = userName.getText().toString();
                String password = pass.getText().toString();


                if (TextUtils.isEmpty(user_Name)) {
                    userName.setError("Name Is Required");

                } else if (TextUtils.isEmpty(password)) {
                    pass.setError("Conf. Password Is Required");
                }



                if (listUserPass.contains(pass.getText().toString())&&listUserName.contains(userName.getText().toString())){

                    Intent intent =new Intent(getContext(), RenewAccount.class);
                    startActivity(intent);



                }else {

                    Toast.makeText(getContext(), "Your UserName Or Password Is Not Correct", Toast.LENGTH_SHORT).show();
                }



            }

        });


        txtForgotPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    txtForgotPassword.setTextColor(Color.parseColor("#BE973B"));
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.welcome_container, new ForgotPasswordFragment()).commit();

                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    txtForgotPassword.setBackground(getActivity().getDrawable(R.drawable.border));
                }
                return false;
            }

        });

        return view;
    }

    private void getFreeData() {

        StringRequest stringRequest=new StringRequest(Request.Method.GET, HI, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray array=jsonObject.getJSONArray("freeusers");
                    for (int i=0; i<array.length(); i++ ){
                        JSONObject ob=array.getJSONObject(i);
                        Freeuser listData=new Freeuser(ob.getString("username")
                                ,ob.getString("password"));
                        freeusers.add(listData);

                         password = freeusers.get(i).getPassword();
                         username = freeusers.get(i).getUsername();



                        SharedPreferencesManger.SaveData(getActivity(),"user",username);

                        listUserName.add(username);
                        listUserPass.add(password);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getContext(), ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }





    private View getView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        txtForgotPassword = view.findViewById(R.id.goto_forgot_pass);
        btnSignIn = view.findViewById(R.id.btn_sign_in_user);
        userName = view.findViewById(R.id.tv_signin_username);
        pass = view.findViewById(R.id.tv_signin_password);
        return view;
    }

}

