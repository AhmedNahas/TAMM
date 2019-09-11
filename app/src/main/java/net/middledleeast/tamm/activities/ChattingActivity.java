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

public class ChattingActivity extends AppCompatActivity {

    RelativeLayout toolbar_back1_assistant;
    TextView et_subject,message_contact,tv_agent_assist;
    Button btn_send_contact;
    RequestQueue requestQueue;
    private String user;
//    private String contact_url_message="http://egyptgoogle.com/backend/sendtouser/insertsendtouser.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        et_subject=findViewById(R.id.et_subject);
        message_contact=findViewById(R.id.message_contact);
        tv_agent_assist=findViewById(R.id.tv_agent_assist);

        user = SharedPreferencesManger.LoadStringData(ChattingActivity.this, "user");
        user = SharedPreferencesManger.LoadStringData(ChattingActivity.this, "userNameFromSignIn");

        toolbar_back1_assistant=findViewById(R.id.toolbar_back1_assistant);

        btn_send_contact=findViewById(R.id.btn_send_contact);
        requestQueue = Volley.newRequestQueue(this);

        Integer idAssistant = SharedPreferencesManger.LoadIntegerData(ChattingActivity.this, "idAssistant");

        if (idAssistant==1){

            tv_agent_assist.setText("Flight agent :");

        }else if (idAssistant==2){

            tv_agent_assist.setText("Luxury agent :");

        }else if (idAssistant==3){

            tv_agent_assist.setText("Hotel agent :");

        }


        toolbar_back1_assistant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(ChattingActivity.this,AssistantActivity.class);
                startActivity(intent);

            }
        });



        btn_send_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                setContent();
                Toast.makeText(ChattingActivity.this, "Message Sent", Toast.LENGTH_SHORT).show();


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
                parameters.put("subject",et_subject .getText().toString());
                parameters.put("message", message_contact.getText().toString());
                parameters.put("username", user);

                return parameters;
            }
        };

        requestQueue.add(request);


    }
    }

