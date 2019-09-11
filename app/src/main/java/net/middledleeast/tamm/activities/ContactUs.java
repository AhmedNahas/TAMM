package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
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

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;
import net.middledleeast.tamm.model.AllLinks.LinksUrl;

import java.util.HashMap;
import java.util.Map;


public class ContactUs extends AppCompatActivity {

    RelativeLayout toolbar_back_contact;
    TextView et_subject,message_contact;
    Button btn_send_contact;
    RequestQueue requestQueue;
    private String user;
    private String subject;
    private String message;
//    private String contact_url_message="http://egyptgoogle.com/backend/sendtouser/insertsendtouser.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);


        btn_send_contact=findViewById(R.id.btn_send_contact);
        et_subject=findViewById(R.id.et_subject);
        message_contact=findViewById(R.id.message_contact);
        toolbar_back_contact=findViewById(R.id.toolbar_back_contact);
        user = SharedPreferencesManger.LoadStringData(ContactUs.this, "user");


         requestQueue = Volley.newRequestQueue(this);
        toolbar_back_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(ContactUs.this,RenewAccount.class);
                startActivity(intent);

            }

        });



        btn_send_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subject = et_subject.getText().toString();
                message = message_contact.getText().toString();

                setContent();
                Toast.makeText(ContactUs.this, "Message Sent", Toast.LENGTH_SHORT).show();


            }
        });





    }

    private void setContent() {


        StringRequest request = new StringRequest(Request.Method.POST, LinksUrl.URL_CONTACTUS, new Response.Listener<String>() {

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
                parameters.put("subject",subject);
                parameters.put("message",message );
                parameters.put("username", user);

                return parameters;
            }
        };

        requestQueue.add(request);


    }
}
