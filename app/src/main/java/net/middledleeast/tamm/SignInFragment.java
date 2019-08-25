package net.middledleeast.tamm;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import static net.middledleeast.tamm.helper.helperMethod.isInternetAvailable;
import static net.middledleeast.tamm.helper.helperMethod.isNetworkConnected;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.middledleeast.tamm.activities.RenewAccount;
import net.middledleeast.tamm.fragments.AuthenticationFragment;
import net.middledleeast.tamm.fragments.Buttons;
import net.middledleeast.tamm.fragments.ForgotPasswordFragment;
import net.middledleeast.tamm.fragments.LanguangeFragment;
import net.middledleeast.tamm.fragments.PlansFragment;
import net.middledleeast.tamm.helper.SharedPreferencesManger;
import net.middledleeast.tamm.model.Freeuser;
import net.middledleeast.tamm.model.MemberAccount;
import net.middledleeast.tamm.model.Paymentuser;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import cn.pedant.SweetAlert.SweetAlertDialog;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {

    private TextView txtForgotPassword;
    private Button btnSignIn;
    private EditText userName, pass;
    private static final String HI = "http://egyptgoogle.com/freeusers/checkusers.php";
    private List<Freeuser> freeusers = new ArrayList<>();

    private List<String> listUserName = new ArrayList<>();
    private List<String> listUserPass = new ArrayList<>();

    private static final String HIMEMBER = "http://egyptgoogle.com/paymentusers/checkpayment.php";

    private List<Paymentuser> paymentusers = new ArrayList<>();
    private List<String> listUserNamemember = new ArrayList<>();
    private List<String> listUserPassmember = new ArrayList<>();

    private String password;
    private String username;
    private Dialog dialog;

    List<String> listCountry = new ArrayList<>();

    Toolbar toolbar;
    LinearLayout imageView;
    private String HI_ = "http://egyptgoogle.com/backend/freeamountformember/freememberfees.php";
    private String HI2_ = "http://egyptgoogle.com/backend/amountformember/amountformember.php";
    private int accountType = 0;


    public SignInFragment() {
        // Required empty public constructor
    }

    @SuppressLint({"ClickableViewAccessibility", "StaticFieldLeak"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = getView(inflater, container);

        toolbar = view.findViewById(R.id.welcome_toolbar);
        imageView = view.findViewById(R.id.back_pressed);




//
//        userName.setText("ahmed");
//        pass.setText("123456");

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.welcome_container, new AuthenticationFragment())
                        .addToBackStack("SignInFragment").commit();
            }
        });



        String username = SharedPreferencesManger.LoadStringData(getActivity(), "username");

       userName.setText(username);
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.custom_dialog);
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {

                getFreeData();
                getMemberData();

                return null;
            }
        }.execute();


        // for test
//        userName.setText("ahmed");
//        pass.setText("0125016341");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                    SharedPreferencesManger.remove(getContext(), "gustMode");

                    String mUsrename = userName.getText().toString();

                    SharedPreferencesManger.SaveData(getActivity(), "user", mUsrename);


                    dialog.show();


                    String user_Name = userName.getText().toString();
                    String password = pass.getText().toString();


                    if (TextUtils.isEmpty(user_Name)) {
                        userName.setError("Name Is Required");
                        dialog.cancel();
                    } else if (TextUtils.isEmpty(password)) {
                        pass.setError("Conf. Password Is Required");
                        dialog.cancel();
                    }


                    if (listUserPass.contains(pass.getText().toString()) && listUserName.contains(userName.getText().toString())) {
                        dialog.cancel();

                        accountType = 1;
                        SharedPreferencesManger.SaveData(getActivity(), "accountType", accountType);
                        Intent intent = new Intent(getContext(), RenewAccount.class);


                        startActivity(intent);

                    } else if (listUserNamemember.contains(userName.getText().toString()) && listUserPassmember.contains(pass.getText().toString())) {
                        dialog.cancel();

                        accountType = 2;
                        SharedPreferencesManger.SaveData(getActivity(), "accountType", accountType);


                        Intent intent = new Intent(getContext(), RenewAccount.class);

                        startActivity(intent);


                    } else {
                        Toast.makeText(getContext(), "wrong user name or password", Toast.LENGTH_SHORT).show();
                        dialog.cancel();


                    }


                    if (userName.getText().toString().equals("tamm") && pass.getText().toString().equals("0123456")) {
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.welcome_container, new Buttons())
                                .commit();
                        dialog.cancel();
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

    private void getMemberData() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, HIMEMBER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("paymentusers");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject ob = array.getJSONObject(i);

                        Paymentuser listData = new Paymentuser(ob.getString("username")
                                , ob.getString("password"));
                        paymentusers.add(listData);

                        password = paymentusers.get(i).getPassword();
                        username = paymentusers.get(i).getUsername();


                        SharedPreferencesManger.SaveData(getActivity(), "user", username);

                        listUserNamemember.add(username);
                        listUserPassmember.add(password);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                dialog.cancel();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }


    private void getFreeData() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, HI, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("freeusers");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject ob = array.getJSONObject(i);
                        Freeuser listData = new Freeuser(ob.getString("username")
                                , ob.getString("password"));
                        freeusers.add(listData);

                        password = freeusers.get(i).getPassword();
                        username = freeusers.get(i).getUsername();


                        SharedPreferencesManger.SaveData(getActivity(), "user", username);

                        listUserName.add(username);
                        listUserPass.add(password);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();

                    dialog.cancel();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                dialog.cancel();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
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


    @Override
    public void onDestroy() {
        super.onDestroy();

        dialog.dismiss();
    }


    private void getmember() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, HI2_, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("amountformember");
                    for (int i = 0; i < 1; i++) {
                        JSONObject ob = array.getJSONObject(i);
                        String msgbody = ob.getString("Msgbody");


                        SharedPreferencesManger.SaveData(getActivity(), "fees", msgbody);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

    }

    private void getFree() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, HI_, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("freeamountformember");
                    for (int i = 0; i < 1; i++) {
                        JSONObject ob = array.getJSONObject(i);
                        String msgbody = ob.getString("Msgbody");


                        SharedPreferencesManger.SaveData(getActivity(), "fees", msgbody);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }


}

