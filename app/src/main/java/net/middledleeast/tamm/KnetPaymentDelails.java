package net.middledleeast.tamm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.middledleeast.tamm.activities.ConfirmBookingRoom;
import net.middledleeast.tamm.activities.FlightDetails;
import net.middledleeast.tamm.activities.MemberCongratsActivity;
import net.middledleeast.tamm.activities.PaymentActivity;
import net.middledleeast.tamm.activities.Proceedbeybey;
import net.middledleeast.tamm.activities.RoomBooked;
import net.middledleeast.tamm.helper.SharedPreferencesManger;
import net.middledleeast.tamm.model.AllLinks.LinksUrl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class KnetPaymentDelails extends AppCompatActivity {

    TextView tv_pay_number,tv_result_number,tv_transaction_number,tv_auth_number,tv_track_number,tv_reference_,tv_amount_,tv_udf_one,tv_udf_two,tv_udf_three,tv_udf_four,tv_udf_five,tv_post;

Button btn_confirm;
    private String resultcode;
    private int mId;

    private String fullName;

    private String bookedOn;


    private String name_city_;

    private String email;
    private String transactionid;
    private String amount;
    private String refno;
    private String paymentid;
    private String trackid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knet_payment_delails);

        tv_pay_number=findViewById(R.id.tv_pay_number);
        tv_result_number=findViewById(R.id.tv_result_number);
        tv_transaction_number=findViewById(R.id.tv_transaction_number);
        tv_auth_number=findViewById(R.id.tv_auth_number);
        tv_track_number=findViewById(R.id.tv_track_number);
        tv_reference_=findViewById(R.id.tv_reference_);
        tv_amount_=findViewById(R.id.tv_amount_);
//        tv_udf_one=findViewById(R.id.tv_udf_one);
//        tv_udf_two=findViewById(R.id.tv_udf_two);
//        tv_udf_three=findViewById(R.id.tv_udf_three);
//        tv_udf_four=findViewById(R.id.tv_udf_four);
//        tv_udf_five=findViewById(R.id.tv_udf_five);
        tv_post=findViewById(R.id.tv_post);


        btn_confirm=findViewById(R.id.btn_confirm);

        mId = SharedPreferencesManger.LoadIntegerData(KnetPaymentDelails.this, "mId");





        name_city_ = SharedPreferencesManger.LoadStringData(this, "name_city_");

        bookedOn = SharedPreferencesManger.LoadStringData(this, "bookedOn");

        email = SharedPreferencesManger.LoadStringData(this, "email");
        String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1GustOne");
        String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1GustOne");
        fullName = firstName1GustOne + " "+lastName1GustOne ;





        getpaymentresult();

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                senddataknettoemail();
                if (mId == 1) {




                    if (resultcode.contains("CAPTURED")){

                        startActivity(new Intent(KnetPaymentDelails.this, MemberCongratsActivity.class));


                    }else if(resultcode.contains("NOT CAPTURED")) {

                        Intent intent =new Intent(KnetPaymentDelails.this, PaymentActivity.class);
                        startActivity(intent);

                    }


                } else if (mId==2){


                    if (resultcode.contains("CAPTURED")){

                        Intent intent =new Intent(KnetPaymentDelails.this, RoomBooked.class);
                        startActivity(intent);


                    }else if(resultcode.contains("NOT CAPTURED")) {

                        Intent intent =new Intent(KnetPaymentDelails.this, ConfirmBookingRoom.class);
                        startActivity(intent);

                    }


                }else if(mId==3){


                    if (resultcode.contains("CAPTURED")){

                        Intent intent =new Intent(KnetPaymentDelails.this, FlightDetails.class);
                        startActivity(intent);


                    }else if(resultcode.contains("NOT CAPTURED")) {

                        Intent intent =new Intent(KnetPaymentDelails.this, Proceedbeybey.class);
                        startActivity(intent);

                    }



                }else if(mId==6){

                    if (resultcode.contains("CAPTURED")){

                        Intent intent =new Intent(KnetPaymentDelails.this, RoomBooked.class);
                        startActivity(intent);


                    }else if(resultcode.contains("NOT CAPTURED")) {

                        Intent intent =new Intent(KnetPaymentDelails.this, ConfirmBookingRoom.class);
                        startActivity(intent);

                    }



                }else if(mId==7){

                    if (resultcode.contains("CAPTURED")){

                        Intent intent =new Intent(KnetPaymentDelails.this, FlightDetails.class);
                        startActivity(intent);


                    }else if(resultcode.contains("NOT CAPTURED")) {

                        Intent intent =new Intent(KnetPaymentDelails.this, Proceedbeybey.class);
                        startActivity(intent);

                    }


                }else {


                    Toast.makeText(KnetPaymentDelails.this, "fuck", Toast.LENGTH_SHORT).show();
                }


            }
        });



    }

    private void getpaymentresult() {

        StringRequest stringRequest=new StringRequest(Request.Method.GET, LinksUrl.URL_PAYMENT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray array=jsonObject.getJSONArray("knetinfo");
                    for (int i=0; i<array.length(); i++ ){
                        JSONObject ob=array.getJSONObject(i);
                         String id = ob.getString("id");
                         paymentid = ob.getString("paymentid");
                         resultcode = ob.getString("resultcode");
                         transactionid = ob.getString("transactionid");
                         String auth = ob.getString("auth");
                         trackid = ob.getString("trackid");
                         refno = ob.getString("refno");
                         amount = ob.getString("amount");
                         String udf1 = ob.getString("udf1");
                         String udf2 = ob.getString("udf2");
                         String udf3 = ob.getString("udf3");
                         String udf4 = ob.getString("udf4");
                         String udf5 = ob.getString("udf5");
                         String postcode = ob.getString("postcode");


                        tv_pay_number.setText(paymentid);
                        tv_result_number.setText(resultcode);
                        tv_transaction_number.setText(transactionid);
                        tv_auth_number.setText(auth);
                        tv_track_number.setText(trackid);
                        tv_reference_.setText(refno);
                        tv_amount_.setText(amount);
//                        tv_udf_one.setText(udf1);
//                        tv_udf_two.setText(udf2);
//                        tv_udf_three.setText(udf3);
//                        tv_udf_four.setText(udf4);
//                        tv_udf_five.setText(udf5);
                        tv_post.setText(postcode);


                        SharedPreferencesManger.SaveData(KnetPaymentDelails.this,"amount_",amount);
                        SharedPreferencesManger.SaveData(KnetPaymentDelails.this,"transaction_",transactionid);
                        SharedPreferencesManger.SaveData(KnetPaymentDelails.this,"result_",resultcode);
                        SharedPreferencesManger.SaveData(KnetPaymentDelails.this,"refno_",refno);
                        SharedPreferencesManger.SaveData(KnetPaymentDelails.this,"trackid_",trackid);
                        SharedPreferencesManger.SaveData(KnetPaymentDelails.this,"paymentid_",paymentid);


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
        RequestQueue requestQueue= Volley.newRequestQueue(KnetPaymentDelails.this);
        requestQueue.add(stringRequest);


    }
    public void senddataknettoemail(){

        StringRequest request = new StringRequest(Request.Method.POST, LinksUrl.URL_SENT_KNET_TO_EMAIL, new com.android.volley.Response.Listener<String>() {

            @Override

            public void onResponse(String response) {




                try {
                    JSONObject jObj = new JSONObject(response);
                    int status = jObj.getInt("msg");
                    String msg = jObj.getString("success");

                    Toast.makeText(KnetPaymentDelails.this, ""+msg, Toast.LENGTH_SHORT).show();

                }catch (Exception  e){}

            }


        }, new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                int statusCode = error.networkResponse.statusCode;

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("mail_to", email);
                parameters.put("name", fullName);
                parameters.put("transid", transactionid);
                parameters.put("cityname", name_city_);
                parameters.put("amount", amount);
                parameters.put("refno", refno);
                parameters.put("paymentid", paymentid);
                parameters.put("trackid", trackid);
                parameters.put("time", bookedOn);
                parameters.put("resultcode", resultcode);



                return parameters;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);



    }



}
