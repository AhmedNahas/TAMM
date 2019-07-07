package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.wirecard.ecom.Client;
import com.wirecard.ecom.model.out.PaymentResponse;

import net.middledleeast.tamm.R;

import java.io.Serializable;
import java.util.ArrayList;

import payments.PaymentObjectProvider;
import payments.ResponseHelper;

public class ConfirmBookingRoom extends AppCompatActivity {

    private Button confirmRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_booking_room);

        confirmRoom = findViewById(R.id.confirm_room_booking);
        PaymentObjectProvider mPaymentObjectProvider = new PaymentObjectProvider();
        confirmRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(ConfirmBookingRoom.this, PaymentActivity.class ));
                Client client = new Client(ConfirmBookingRoom.this, "https://api-test.wirecard.com");
                client.startPayment(mPaymentObjectProvider.getCardPayment(true));
            }
        });



        Spinner s1 , s2 , s3;
        ArrayAdapter mrOrMissAdapter;
        ArrayList<String> mrOrMissArray;


        mrOrMissArray = new ArrayList<>();
        mrOrMissArray.add("Mr.");
        mrOrMissArray.add("Mrs.");
        mrOrMissAdapter = new ArrayAdapter(this,
                R.layout.mrormissspinnerlist
                , mrOrMissArray);
        s1 = findViewById(R.id.mromiss1);
        s1.setSelection(1);
        s1.setAdapter(mrOrMissAdapter);
        s2 = findViewById(R.id.mromiss2);
        s2.setSelection(1);
        s2.setAdapter(mrOrMissAdapter);
        s3 = findViewById(R.id.mromiss3);
        s3.setSelection(1);
        s3.setAdapter(mrOrMissAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Serializable paymentSdkResponse = data.getSerializableExtra(Client.EXTRA_PAYMENT_SDK_RESPONSE);
        if (paymentSdkResponse instanceof PaymentResponse) {
            String formattedResponse = ResponseHelper.getFormattedResponse((PaymentResponse) paymentSdkResponse);
            Toast.makeText(this, formattedResponse, Toast.LENGTH_SHORT).show();

        }
        if (resultCode == RESULT_OK) {
            startActivity(new Intent(ConfirmBookingRoom.this, RoomBooked.class));
        }
    }
}
