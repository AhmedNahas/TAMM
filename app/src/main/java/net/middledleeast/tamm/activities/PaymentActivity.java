package net.middledleeast.tamm.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.Tamm.Hotels.wcf.AmendmentResponse;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.wirecard.ecom.Client;
import com.wirecard.ecom.model.out.PaymentResponse;

import net.middledleeast.tamm.KnetPaymentDelails;
import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.AdapterPayment;
import net.middledleeast.tamm.fragments.TermsFragment;
import net.middledleeast.tamm.helper.SharedPreferencesManger;
import net.middledleeast.tamm.model.AllLinks.LinksUrl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private String bookedOn;
    private RelativeLayout relativeLayout;
    private AuthenticationData authenticandata;
    private BasicHttpBinding_IHotelService1 service;
//    private static final String urlmemberfees = "http://egyptgoogle.com/backend/memberfees/memberfessjson.php";
    Toolbar toolbar;
    ImageView imageView;
    private List<String> spinnerTitles = new ArrayList<>();
    private List<Integer> spinnerImages = new ArrayList<>();
    private boolean paymentChekd = false;

    private int mId ;
    private String roomPrice = "";
    private String currency;
    private  String flightCurrency;
    private String msgbody = "";
    String first_name1 , last_name1 ,birthdate , country ,city,email,phone,ocupation,username ,pass ;

//    private String register_url_member = "http://egyptgoogle.com/paymentusers/insertstudents.php";
    private String day , month , year ;
    private int RIGISTRATHION = 1;
    private int BOOKING_ROOM = 2 ;
    private int FLIGHT =3;
    private boolean knet = false;
//    private String urlAmount = "http://egyptgoogle.com/k/jsoninsert.php";
    private Handler handler;
    private Runnable runnable;
    private long days;
    private Date currentDate;

    private String pricepffers;
    private String priceFligt;
    private int isfree=0;
    private String last_name;
    private String first_name;
    WebView webviewKnet;

    RelativeLayout relative_radio_btn;
    private String uid;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);

        webviewKnet=findViewById(R.id.webview_knet);
        relativeLayout = findViewById(R.id.relative_back);
        button = findViewById(R.id.proceed_check_out_hotels);

        toolbar = findViewById(R.id.welcome_toolbar);
        imageView = findViewById(R.id.back_pressed);

        relative_radio_btn=findViewById(R.id.relative_radio_btn);


        Calendar calendar = Calendar.getInstance();

        Date futureDate = calendar.getTime();
        bookedOn = new SimpleDateFormat("yyyy-MM-dd").format(futureDate);

        Intent intent = getIntent();

        mId = SharedPreferencesManger.LoadIntegerData(PaymentActivity.this,"mId");



        uid = SharedPreferencesManger.LoadStringData(this, "uid");


        if (uid==null){

        }


        relativeLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {




        }
        });










        List<String> listTypeMony = new ArrayList<>();


        listTypeMony.add(getString(R.string.usd));
        listTypeMony.add(getString(R.string.euro));
        listTypeMony.add(getString(R.string.eg_pound));
        listTypeMony.add(getString(R.string.kd));

        ArrayAdapter adapter = new ArrayAdapter(PaymentActivity.this, R.layout.item_spener, listTypeMony);
        adapter.setDropDownViewResource(R.layout.drop_dowen_convert);

        spConvertTo.setAdapter(adapter);

        spConvertTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                DecimalFormat df = new DecimalFormat("#,###.##");

                if (mId==2){


                    if (roomPrice.equals("")){


                    }else {

                        final   double priceDouble = Double.parseDouble(roomPrice);



                        if (i == 3) {

                            double convirtKD = priceDouble * 0.30;

                            tvKd.setText("KD " + df.format(convirtKD));
                            currency = "KD";

                        } else if (i == 2) {

                            double convirtEG = priceDouble * 16.58;

                            tvKd.setText("EG " + df.format(convirtEG));
                            currency = "EG";

                        } else if (i == 1) {

                            double convirtEU = priceDouble * 0.90;

                            tvKd.setText("EURO " + df.format(convirtEU));

                            currency = "EURO";


                        } else {


                            tvKd.setText("USD " + roomPrice);
                            currency = "USD";

                        }

                    }


                }else if (mId==1){


                    if (!msgbody.equals("")){

                        final   double priceDouble = Double.parseDouble(msgbody);


                        if (i == 3) {

                            double convirtKD = priceDouble * 0.30;

                            tvKd.setText("KD " +df.format(convirtKD));
                            currency = "KD";

                        } else if (i == 2) {

                            double convirtEG = priceDouble * 16.58;
                            tvKd.setText("EG " +df.format(convirtEG));

                            currency = "EG";
                        } else if (i == 1) {

                            double convirtEU = priceDouble * 0.90;

                            tvKd.setText("EURO " +df.format(convirtEU));

                            currency = "EURO";


                        } else {


                            tvKd.setText("USD " + msgbody);
                            currency = "USD";

                        }

                    }else if (mId==3) {

                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mId == BOOKING_ROOM) {

                    startActivity(new Intent(PaymentActivity.this, ConfirmBookingRoom.class));


                } else if (mId==1){


                    onBackPressed();

                }else if (mId==3){

                    startActivity(new Intent(PaymentActivity.this, Proceedbeybey.class));

                }
            }
        });

        AmendmentResponse amendmentResponse = new AmendmentResponse();
        Integer bookingId = amendmentResponse.BookingId;


        if (mId == BOOKING_ROOM) {

//            SharedPreferencesManger.SaveData(checkroom.this, "finalpriceRoom",String.valueOf(sum));

            roomPrice = SharedPreferencesManger.LoadStringData(this, "finalpriceRoom");
            currency = SharedPreferencesManger.LoadStringData(this, "currency");
            last_name = SharedPreferencesManger.LoadStringData(this, "lastName1GustOne");
            first_name = SharedPreferencesManger.LoadStringData(this, "firstName1GustOne");


            tvLastName.setText(last_name);
            tvFirstName.setText(first_name);

            double v = Double.parseDouble(roomPrice);

            double sum = v * 0.304380 ;


            NumberFormat formatter = new DecimalFormat("#,###.##");

            String formattedNumber = formatter.format(sum);

            tvKd.setText("KD" + " " + formattedNumber);
            BigDecimal amount = new BigDecimal(formattedNumber);
            PaymentObjectProvider mPaymentObjectProvider = new PaymentObjectProvider();
            BigDecimal finalAmount = amount;
            String finalCurrency = currency;




//            Client client = new Client(PaymentActivity.this, "https://api-test.wirecard.com");
//               client.startPayment(mPaymentObjectProvider.getCardPayment(true, finalAmount, finalCurrency));


        } else if (mId==1){





            getmemberfees();
            tvKd.setText("KD " + msgbody);

            String last_name = SharedPreferencesManger.LoadStringData(this, "last_name");
            String first_name = SharedPreferencesManger.LoadStringData(this, "first_name");
            String mr = SharedPreferencesManger.LoadStringData(this, "mr");
            tvMrMrs.setText(mr);
            tvLastName.setText(last_name);
            tvFirstName.setText(first_name);

            first_name1 = intent.getStringExtra("first_name");
            last_name1 = intent.getStringExtra("last_name");
            day = intent.getStringExtra("day");
            month = intent.getStringExtra("month");
            year = intent.getStringExtra("year");
            country = intent.getStringExtra("country");
            city = intent.getStringExtra("city");
            email = intent.getStringExtra("mail");
            phone = intent.getStringExtra("phone");
            ocupation = intent.getStringExtra("ocupation");
            username = intent.getStringExtra("username");
            pass = intent.getStringExtra("pass");




        }else if (mId==FLIGHT){

//            String TotalFare = SharedPreferencesManger.LoadStringData(this, "TotalFare");
//            flightCurrency = SharedPreferencesManger.LoadStringData(this, "typeFare");

            String totalFare = getIntent().getStringExtra("totalFare");
            String firstNameAduld = SharedPreferencesManger.LoadStringData(PaymentActivity.this, "FirstNameAduld");
            String lastNameAduld = SharedPreferencesManger.LoadStringData(PaymentActivity.this, "LastNameAduld");



            double v = Double.parseDouble(totalFare);
            double sum = v * 0.304380 ;


            NumberFormat formatter = new DecimalFormat("#,###.##");

            String formattedNumber = formatter.format(sum);

            tvMrMrs.setText(getString(R.string.mr));
            tvLastName.setText(lastNameAduld);
            tvFirstName.setText(firstNameAduld);
            tvKd.setText("KD "+formattedNumber);


        }else if (mId == 6){

            pricepffers = SharedPreferencesManger.LoadStringData(this, "pricepffers");

            tvLastName.setText(last_name);
            tvFirstName.setText(first_name);
            tvKd.setText("USD" + " " + pricepffers);

        }else if (mId == 7){

            priceFligt = SharedPreferencesManger.LoadStringData(this, "priceflight");

            tvLastName.setText(last_name);
            tvFirstName.setText(first_name);
            tvKd.setText("USD" + " " + priceFligt);

        }


        spinnerTitles.add(getString(R.string.payment_method));
        spinnerTitles.add(getString(R.string.visa_));
        spinnerTitles.add(getString(R.string.master));
        spinnerTitles.add(getString(R.string.knet));

        spinnerImages.add(0);

        spinnerImages.add(R.drawable.wd_ecom_visa);
        spinnerImages.add(R.drawable.wd_ecom_mastercard);
        spinnerImages.add(R.drawable.ic_knet);


        AdapterPayment adapter2 = new AdapterPayment(PaymentActivity.this, spinnerTitles, spinnerImages);

        visa.setAdapter(adapter2);

        visa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


//                if (i == 0) {
//
//                    paymentChekd = false;
//                } else {
//
//                    paymentChekd = true;
//                    String s = spinnerTitles.get(i);
//                    if (s.equals(getString(R.string.knet))){
//
//
//                        knet = true ;
//
//                    }else {
//
//                        knet = false;
//
//                    }
//                }


                String s = spinnerTitles.get(i);
                if (s.equals(getString(R.string.knet))){
                    knet = true ;


                }else {

                    knet = false ;

                }

                if (i==0){
                    paymentChekd = false;

                }else {

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

                    String[] s = tvKd.getText().toString().split(" ");
                    String s1 = s[0];
                    String s2 = s[1];



                    openbankRegisrat(s2, s1);


                } else if (mId==2){



                    String[] s = tvKd.getText().toString().split(" ");
                    String s2 = s[1];
                    openBankRoom(s2, currency);




                }else if(mId==3){


                    String[] s = tvKd.getText().toString().split(" ");
                    String s2 = s[1];
                    openbankFlight(s2);


                }else if(mId==6){


                    openbankBestHotel("USD",pricepffers);

                }else if(mId==7){


                  openbankBestHotel("USD",priceFligt);

                }

            }
        });


//        Gson gson = new Gson();
//        Intent intent = getIntent();
        service = new BasicHttpBinding_IHotelService1();
        service.enableLogging = true;
        authenticandata = new AuthenticationData();
        authenticandata.UserName = (getString(R.string.user_name_tamm));
        authenticandata.Password = (getString(R.string.passowrd_tamm));


        }




    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            if (url.contains("CAPTURED")) {
                showProgressingView();
                Intent intent=new Intent(PaymentActivity.this, KnetPaymentDelails.class);
                startActivity(intent);
                hideProgressingView();
                webviewKnet.destroy();
                finish();


//                if (mId==1){
//                    startActivity(new Intent(PaymentActivity.this, MemberCongratsActivity.class));
//                }else if (mId==2) {
//
//                    startActivity(new Intent(PaymentActivity.this, KnetPaymentDelails.class));

//                }else if (mId==3){
//
//                    startActivity(new Intent(PaymentActivity.this, FlightDetails.class));
//
//                }

            }
//            else{
//
////                Toast.makeText(PaymentActivity.this, "Failed Unknown Error() 2145012114(Json)  ", Toast.LENGTH_SHORT).show();
//
//            }



        }
    }

        private void openbankBestHotel(String usd, String offerActivityprice) {

        try {
//
            BigDecimal amount = new BigDecimal(offerActivityprice);
            PaymentObjectProvider mPaymentObjectProvider = new PaymentObjectProvider();
            BigDecimal finalAmount = amount;
            String finalCurrency = usd;

            if (paymentChekd && checkBoxAgerr2.isChecked()) {

                if (knet){

                    sendamount(offerActivityprice);
                    relative_radio_btn.setVisibility(View.GONE);
                    button.setVisibility(View.GONE);
                    webviewKnet.setVisibility(View.VISIBLE);
                    String url = "http://www.egyptgoogle.com/k";
                    webviewKnet.getSettings().setJavaScriptEnabled(true);
                    webviewKnet.loadUrl( url); // load a web page in a web vie
                    webviewKnet.setWebViewClient(new MyWebViewClient());

                  //  startActivity(new Intent(PaymentActivity.this,KnetActivity.class));

                }else {

                    Client client = new Client(PaymentActivity.this, "https://api-test.wirecard.com");
                    client.startPayment(mPaymentObjectProvider.getCardPayment(true, finalAmount, finalCurrency));
                }


            } else {

                Toast.makeText(PaymentActivity.this, "Choose Payment Method and agree in Terms and conditions", Toast.LENGTH_SHORT).show();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        }

         private void openbankFlight(String Price) {



        try {
//
            BigDecimal amount = new BigDecimal(Price);
            PaymentObjectProvider mPaymentObjectProvider = new PaymentObjectProvider();
            BigDecimal finalAmount = amount;
            String finalCurrency = "KD";

            if (paymentChekd && checkBoxAgerr2.isChecked()) {

                if (knet){
                    sendamount(Price);
                    relative_radio_btn.setVisibility(View.GONE);
                    button.setVisibility(View.GONE);
                    webviewKnet.setVisibility(View.VISIBLE);
                    String url = "http://www.egyptgoogle.com/k";
                    webviewKnet.getSettings().setJavaScriptEnabled(true);
                    webviewKnet.loadUrl(url); // load a web page in a web vie
                    webviewKnet.setWebViewClient(new MyWebViewClient());

                    //startActivity(new Intent(PaymentActivity.this,KnetActivity.class));

                }else {

                    Client client = new Client(PaymentActivity.this, "https://api-test.wirecard.com");
                    client.startPayment(mPaymentObjectProvider.getCardPayment(true, finalAmount, finalCurrency));
                }


            } else {

                Toast.makeText(PaymentActivity.this, "Choose Payment Method and agree in Terms and conditions", Toast.LENGTH_SHORT).show();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


            }

             private void openbankRegisrat(String mSgbody, String kd) {

        try {
//
            BigDecimal amount = new BigDecimal(mSgbody);
            PaymentObjectProvider mPaymentObjectProvider = new PaymentObjectProvider();
            BigDecimal finalAmount = amount;
            String finalCurrency = kd;

            if (paymentChekd && checkBoxAgerr2.isChecked()) {

                if (knet){

                    sendamount(mSgbody);
                    relative_radio_btn.setVisibility(View.GONE);
                    button.setVisibility(View.GONE);
                    webviewKnet.setVisibility(View.VISIBLE);
                    String url = "http://www.egyptgoogle.com/k";
                    webviewKnet.getSettings().setJavaScriptEnabled(true);
                    webviewKnet.loadUrl(url); // load a web page in a web vie

                    webviewKnet.setWebViewClient(new MyWebViewClient());

                    sendDataToServer();


//                    startActivity(new Intent(PaymentActivity.this,KnetActivity.class));
                }else {

                    Client client = new Client(PaymentActivity.this, "https://api-test.wirecard.com");
                    client.startPayment(mPaymentObjectProvider.getCardPayment(true, finalAmount, finalCurrency));

                }




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



                 if (knet){


                     sendamount(roomPrice);
                     relative_radio_btn.setVisibility(View.GONE);
                     button.setVisibility(View.GONE);
                     webviewKnet.setVisibility(View.VISIBLE);
                     String url = "http://egyptgoogle.com/k";
                     webviewKnet.getSettings().setJavaScriptEnabled(true);
                     webviewKnet.loadUrl(url); // load a web page in a web vie
                     webviewKnet.setWebViewClient(new MyWebViewClient());




                 }else {

                     Client client = new Client(PaymentActivity.this, "https://api-test.wirecard.com");
                     client.startPayment(mPaymentObjectProvider.getCardPayment(true, finalAmount, finalCurrency));
                 }



            } else {

                Toast.makeText(PaymentActivity.this, "Choose Payment Method and agree in Terms and conditions", Toast.LENGTH_SHORT).show();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
            }

         private void sendamount(String roomPrice_) {


        StringRequest request = new StringRequest(Request.Method.POST, LinksUrl.URL_AMOUNT, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

//                Toast.makeText(PaymentActivity.this, ""+response, Toast.LENGTH_SHORT).show();

//               Intent intent =new Intent(PaymentActivity.this,KnetActivity.class);
//               startActivity(intent);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

//                Toast.makeText(PaymentActivity.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();

            }

        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("roomprice",roomPrice_);
                parameters.put("token",uid);


                return parameters;
            }
        };



        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(request);

            }


         @Override
         protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Serializable paymentSdkResponse = data.getSerializableExtra(Client.EXTRA_PAYMENT_SDK_RESPONSE);
        if (paymentSdkResponse instanceof PaymentResponse) {
            String formattedResponse = ResponseHelper.getFormattedResponse((PaymentResponse) paymentSdkResponse);


        }
            Toast.makeText(this, "your payment is successful", Toast.LENGTH_SHORT).show();


            if (mId == BOOKING_ROOM) {
                startActivity(new Intent(PaymentActivity.this, RoomBooked.class));
            } else if (mId==1){

                sendDataToServer();
                Toast.makeText(this, "Welcome", Toast.LENGTH_LONG).show();





            }else if (mId==3){

                Toast.makeText(this, "your payment is successful", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(PaymentActivity.this,FlightDetails.class));
            }else if (mId==6){



                Toast.makeText(this, "your payment is successful", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(PaymentActivity.this,HotelBooking.class));

            }


    }

    private void sendDataToServer() {

        countDownStart();
        StringRequest request = new StringRequest(Request.Method.POST, LinksUrl.URL_REGISTER, new Response.Listener<String>() {

            @Override

            public void onResponse(String response) {
                SharedPreferencesManger.SaveData(PaymentActivity.this, "user_name", username);

                try {
                    JSONObject jObj = new JSONObject(response);
                    int status = jObj.getInt("status");
                    if (status == 1) {
                        // User successfully stored in MySQL
                        // Now store the user in sqlite

                        String uid = jObj.getString("uid");

                        JSONObject user = jObj.getJSONObject("user");
                        username = user.getString("username");
                        first_name1 = user.getString("firstname");
                        last_name1 = user.getString("lastname");
                        country = user.getString("country");
                        city = user.getString("city");
                        phone = user.getString("phone");
                        isfree = user.getInt("isfree");
                        ocupation = user.getString("occupation");
                        email = user.getString("email");


                        // Inserting row in users table
//                        db.addUser(name, email, uid, created_at);

//                        Intent intent =new Intent(PaymentActivity.this,MemberCongratsActivity.class);
                        SharedPreferencesManger.remove(PaymentActivity.this,"gustMode");

//                        startActivity(intent);
                        // Launch login activity


                    } else {

                        // Error occurred in registration. Get the error
                        // message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(PaymentActivity.this,
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


//                    Toast.makeText(getContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(getContext(), FreeCongratsActivity.class);
//                        SharedPreferencesManger.SaveData(getContext(),"user_name",userName);
//                    startActivity(intent);



            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                int statusCode = error.networkResponse.statusCode;
                Toast.makeText(PaymentActivity.this, ""+statusCode, Toast.LENGTH_SHORT).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("username", username);
                parameters.put("firstname",first_name1 );
                parameters.put("lastname", last_name1);
                parameters.put("country", country);
                parameters.put("city", city);
                parameters.put("phone",phone );
                parameters.put("isfree",String.valueOf(isfree));
                parameters.put("occupation",ocupation);
                parameters.put("email", email);
                parameters.put("password", pass);
                parameters.put("birthdate"," " + day+ " - " + month+ " - " + year + " ");

                parameters.put("subscriptiondate", bookedOn);





                //  parameters.put("tokenid",tokenId );


                return parameters;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(PaymentActivity.this);
        requestQueue.add(request);

    }


    private void getmemberfees() {


        StringRequest stringRequest = new StringRequest(Request.Method.GET, LinksUrl.URL_MEMBER_FEES, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("memberfees");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject ob = array.getJSONObject(i);


                        msgbody = ob.getString("Text");
                        tvKd.setText("USD " + msgbody);


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

        int paymentActivityId = 5;
        SharedPreferencesManger.SaveData(this,"paymentActivityId",paymentActivityId);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.payment_terms_container, new TermsFragment())
                .addToBackStack("RegisterationActivity").commit();


//        Intent intent = new Intent(PaymentActivity.this, TermsFragment.class);
//        startActivity(intent);


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if (mId==BOOKING_ROOM){

            startActivity(new Intent(PaymentActivity.this, ConfirmBookingRoom.class));


        }else if (mId==3){

            startActivity(new Intent(PaymentActivity.this, Proceedbeybey.class));


        }else if (mId==1){



        }
    }
    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {

                    // Please here set your event date//YYYY-MM-DD
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.YEAR,1);
                    Date futureDate = calendar.getTime();
                    String dateFormat = new SimpleDateFormat("yyyy-MM-dd").format(futureDate);




                    currentDate = new Date();
                    new SimpleDateFormat("yyyy-MM-dd").format(currentDate);

                    if (!currentDate.after(futureDate)) {
                        long diff = futureDate.getTime() - currentDate.getTime();
                         days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;

//                        txtmonth.setText("" + String.format("%02d", months));
//                        txtDay.setText("" + String.format("%02d", days));
//                        txtHour.setText("" + String.format("%02d", hours));
//                        txtMinute.setText("" + String.format("%02d", minutes));
//                        txtSecond.setText("" + String.format("%02d", seconds));

                        SharedPreferencesManger.SaveData(PaymentActivity.this,"validTill",days);
                    } else {

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 1 * 1000);
    }
    ViewGroup progressView;
    protected boolean isProgressShowing = false;
    public void showProgressingView() {

        if (!isProgressShowing) {
            isProgressShowing = true;
            progressView = (ViewGroup) getLayoutInflater().inflate(R.layout.progressbar_layout, null);
            View v = this.findViewById(android.R.id.content).getRootView();
            ViewGroup viewGroup = (ViewGroup) v;
            viewGroup.addView(progressView);
        }
    }

    public void hideProgressingView() {
        View v = this.findViewById(android.R.id.content).getRootView();
        ViewGroup viewGroup = (ViewGroup) v;
        viewGroup.removeView(progressView);
        isProgressShowing = false;
    }
}
