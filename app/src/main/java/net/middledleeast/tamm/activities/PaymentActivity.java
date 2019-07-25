package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.wirecard.ecom.Client;
import com.wirecard.ecom.model.out.PaymentResponse;

import net.middledleeast.tamm.ActivityToFragment.PaymentActivityFragment;
import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import payments.PaymentObjectProvider;
import payments.ResponseHelper;

public class PaymentActivity extends AppCompatActivity {

    @BindView(R.id.ed_visa)
    Spinner visa;
    @BindView(R.id.tv_mr_mrs)
    TextView tvMrMrs;
    @BindView(R.id.tv_firstName)
    TextView tvFirstName;
    @BindView(R.id.tv_last_name)
    TextView tvLastName;
    @BindView(R.id.tv_kd)
    TextView tvKd;
    @BindView(R.id.check_box_agerr2)
    CheckBox checkBoxAgerr2;
    @BindView(R.id.terms_conditions_tv2)
    TextView termsConditionsTv2;
    @BindView(R.id.sp_convert_to)
    Spinner spConvertTo;
    private Button button;
    private AuthenticationData authenticandata;
    private BasicHttpBinding_IHotelService1 service;
    private static final String urlmemberfees = "http://egyptgoogle.com/backend/memberfees/memberfees.php";
    Toolbar toolbar;
    ImageView imageView;
    private List<String> spinnerTitles = new ArrayList<>();
    private List<Integer> spinnerImages = new ArrayList<>();
    private boolean paymentChekd = false;
    private int mId;
    private String roomPrice;
    private String currency;
    private String msgbody;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);

        button = findViewById(R.id.proceed_check_out_hotels);

        toolbar = findViewById(R.id.welcome_toolbar);
        imageView = findViewById(R.id.back_pressed);


        Intent intent = getIntent();
        // test 2 id
        mId = intent.getIntExtra("mId", 2);

        roomPrice = SharedPreferencesManger.LoadStringData(this, "roomPrice");
        currency = SharedPreferencesManger.LoadStringData(this, "currency");
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        if (mId == 2) {

            String last_name = SharedPreferencesManger.LoadStringData(this, "lastName");
            String first_name = SharedPreferencesManger.LoadStringData(this, "firstName");


            tvLastName.setText(last_name);
            tvFirstName.setText(first_name);

            tvKd.setText(currency + " " + roomPrice);
//            BigDecimal amount = new BigDecimal(roomPrice);
//            PaymentObjectProvider mPaymentObjectProvider = new PaymentObjectProvider();
//            BigDecimal finalAmount = amount;
//            String finalCurrency = currency;
//
//            Client client = new Client(PaymentActivity.this, "https://api-test.wirecard.com");
//               client.startPayment(mPaymentObjectProvider.getCardPayment(true, finalAmount, finalCurrency));


        } else {

            getmemberfees();

            String last_name = SharedPreferencesManger.LoadStringData(this, "last_name");
            String first_name = SharedPreferencesManger.LoadStringData(this, "first_name");
            String mr = SharedPreferencesManger.LoadStringData(this, "mr");
            tvMrMrs.setText(mr);

            tvLastName.setText(last_name);
            tvFirstName.setText(first_name);

        }




        spinnerTitles.add("PAYMENT METHOD");
        spinnerTitles.add("VISA");
        spinnerTitles.add("MASTER CARD");
        spinnerTitles.add("KNET");
        spinnerImages.add(0);

        spinnerImages.add(R.drawable.wd_ecom_visa);
        spinnerImages.add(R.drawable.wd_ecom_mastercard);
        spinnerImages.add(R.drawable.ic_knet);


        AdapterPayment adapter2 = new AdapterPayment(PaymentActivity.this, spinnerTitles, spinnerImages);

        visa.setAdapter(adapter2);

        visa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                if (i == 0) {

                    paymentChekd = false;
                } else {

                    paymentChekd = true;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mId == 1) {

                    openbankRegisrat(msgbody, "KD");


                } else {


                    openBankRoom(roomPrice, currency);
                }
            }
        });


//        Gson gson = new Gson();
//        Intent intent = getIntent();
        service = new BasicHttpBinding_IHotelService1();
        service.enableLogging = true;
        authenticandata = new AuthenticationData();
        authenticandata.UserName = ("Tammtest");
        authenticandata.Password = ("Tam@18418756");


    }

    private void openbankRegisrat(String mSgbody, String kd) {

        try {
//
            BigDecimal amount = new BigDecimal(mSgbody);
            PaymentObjectProvider mPaymentObjectProvider = new PaymentObjectProvider();
            BigDecimal finalAmount = amount;
            String finalCurrency = kd;

            if (paymentChekd && checkBoxAgerr2.isChecked()) {
                Client client = new Client(PaymentActivity.this, "https://api-test.wirecard.com");
                client.startPayment(mPaymentObjectProvider.getCardPayment(true, finalAmount, finalCurrency));

            } else {

                Toast.makeText(PaymentActivity.this, "Choose Payment Method and agree in Terms and conditions", Toast.LENGTH_SHORT).show();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openBankRoom(String roomPrice, String currency) {

        try {
//
            BigDecimal amount = new BigDecimal(roomPrice);
            PaymentObjectProvider mPaymentObjectProvider = new PaymentObjectProvider();
            BigDecimal finalAmount = amount;
            String finalCurrency = currency;

            if (paymentChekd && checkBoxAgerr2.isChecked()) {
                Client client = new Client(PaymentActivity.this, "https://api-test.wirecard.com");
                client.startPayment(mPaymentObjectProvider.getCardPayment(true, finalAmount, finalCurrency));

            } else {

                Toast.makeText(PaymentActivity.this, "Choose Payment Method and agree in Terms and conditions", Toast.LENGTH_SHORT).show();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Serializable paymentSdkResponse = data.getSerializableExtra(Client.EXTRA_PAYMENT_SDK_RESPONSE);
        if (paymentSdkResponse instanceof PaymentResponse) {
            String formattedResponse = ResponseHelper.getFormattedResponse((PaymentResponse) paymentSdkResponse);


        }
        if (resultCode == RESULT_OK) {
            Toast.makeText(this, "your payment is successful", Toast.LENGTH_SHORT).show();


            if (mId == 2) {
                startActivity(new Intent(PaymentActivity.this, RoomBooked.class));
            } else {
                startActivity(new Intent(PaymentActivity.this, PaymentActivityFragment.class));
            }

        }
    }


    private void getmemberfees() {


        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlmemberfees, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("memeberfees");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject ob = array.getJSONObject(i);


                        msgbody = ob.getString("Msgbody");
                        tvKd.setText("KD " + msgbody);


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
        RequestQueue requestQueue = Volley.newRequestQueue(PaymentActivity.this);
        requestQueue.add(stringRequest);
    }

    @OnClick(R.id.terms_conditions_tv2)
    public void onViewClicked() {

//
//        Intent intent = new Intent(PaymentActivity.this, TermsFragment.class);
//        startActivity(intent);


    }


}
