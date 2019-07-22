package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.Tamm.Hotels.wcf.ArrayOfHotel_Result;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.HotelCodesResponse;
import com.Tamm.Hotels.wcf.HotelInfo;
import com.Tamm.Hotels.wcf.HotelSearchResponse;
import com.Tamm.Hotels.wcf.Hotel_Result;
import com.Tamm.Hotels.wcf.ResponseStatus;
import com.Tamm.Hotels.wcf.TopDestinationsResponse;
import com.google.android.material.navigation.NavigationView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;
import net.middledleeast.tamm.model.ReserveRoom;

import java.io.FileNotFoundException;

public class RenewAccount extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView img1 , img2 , addPic;
    TextView user_name_profile;
    private String user;
    private HotelCodesResponse hotelSearchResponse;
    private String hotelCode;
    private BasicHttpBinding_IHotelService1 service;
    private AuthenticationData authenticationData;
    private TopDestinationsResponse topDestinationsResponse;
    private ResponseStatus status;
    private String category;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.renew_account);
        img2 = findViewById(R.id.imageView10);
        img1 = findViewById(R.id.imageView9);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        service = new BasicHttpBinding_IHotelService1();
        authenticationData = new AuthenticationData();
        authenticationData.UserName = ("Tammtest");
        authenticationData.Password = ("Tam@18418756");



try{
    service.enableLogging = true;
    TopDestinationsResponse topDestinationsResponse = service.TopDestinations(authenticationData);


//        if (hotelSearchResponse.HotelResultList != null) {
//            for (int i = 0; i < hotelSearchResponse.HotelResultList.size(); i++) {
//
//                Hotel_Result hotel_result = hotelSearchResponse.HotelResultList.get(i);
//                HotelInfo hotelInfo = hotel_result.HotelInfo;
//
//
//
//                 hotelCode = hotelInfo.HotelPromotion;
//
//
//            }
//
//        }

    } catch (Exception e) {
        e.printStackTrace();
    }
        Toast.makeText(this, "fffff"+topDestinationsResponse, Toast.LENGTH_SHORT).show();

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RenewAccount.this, ReserveRoom.class);
                startActivity(intent);
            }
        });
//        img1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(RenewAccount.this,FlightTamm.class));
//            }
//        });

        try {
            user = SharedPreferencesManger.LoadStringData(this, "user");

        }catch (Exception e){


        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

       // NavigationView navigationView = findViewById(R.id.nav_view);

        NavigationView navigationView =  findViewById(R.id.nav_view);

        View hView =  navigationView.getHeaderView(0);

        addPic = hView.findViewById(R.id.imageViewAddPic);
        user_name_profile = hView.findViewById(R.id.user_name_profile);

        try {
            user_name_profile.setText(user);


        addPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);

            }
        });
        }catch (Exception e){


        }
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_offer) {


        } else if (id == R.id.nav_conversation) {

        } else if (id == R.id.nav_favorites) {

        } else if (id == R.id.nav_aboutus) {

        } else if (id == R.id.nav_contuctus) {

        }else if (id == R.id.nav_setting) {

        }else if (id == R.id.nav_terms) {

        }else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            Uri targetUri = data.getData();
            String textTargetUri=(targetUri.toString());


            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                addPic.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
