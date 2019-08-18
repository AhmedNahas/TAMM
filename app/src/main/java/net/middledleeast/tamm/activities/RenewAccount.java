package net.middledleeast.tamm.activities;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.HotelCodesResponse;
import com.Tamm.Hotels.wcf.ResponseStatus;
import com.Tamm.Hotels.wcf.TopDestinationsResponse;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.ViewPagerAdapter;
import net.middledleeast.tamm.fragments.BestDeals;
import net.middledleeast.tamm.fragments.BestFlights;
import net.middledleeast.tamm.fragments.BestHotels;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.io.FileNotFoundException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RenewAccount extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView img1, img2, addPic, right, left;
    TextView user_name_profile;
    @BindView(R.id.assistant_label_voice_renew_hotel)
    TextView assistantLabelVoiceRenewHotel;
    @BindView(R.id.assistant_label_call_renew_hotel)
    TextView assistantLabelCallRenewHotel;
    @BindView(R.id.assistant_label_message_renew_hotel)
    TextView assistantLabelMessageRenewHotel;
    @BindView(R.id.relative_img_renew_hotel_tamm)
    RelativeLayout relativeImgRenewHotelTamm;
    private String user;
    private HotelCodesResponse hotelSearchResponse;
    private String hotelCode;
    private BasicHttpBinding_IHotelService1 service;
    private AuthenticationData authenticationData;
    private TopDestinationsResponse topDestinationsResponse;
    private ResponseStatus status;
    private String category;
    TabLayout tabLayout;
    ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private boolean ClickRenewHotel=false;


//    private AuthenticationData authenticandata;
//    private BasicHttpBinding_IHotelService1 service;
//    private String hotelPromotion;
//    private String sessionId;
//    private String hotelAddress;
//    private String hotelName;
//    private String hotelPicture;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.renew_account);
        ButterKnife.bind(this);
        img2 = findViewById(R.id.imageView10);
        img1 = findViewById(R.id.imageView9);
        tabLayout = findViewById(R.id.tap_layout);
        viewPager = findViewById(R.id.view_pager_renew);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());


        adapter.AddFragment(new BestFlights(), "Best Flights");
        adapter.AddFragment(new BestHotels(), "Best Hotels");
        adapter.AddFragment(new BestDeals(), "Best Deals");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        assistantLabelVoiceRenewHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RenewAccount.this, "Voice", Toast.LENGTH_SHORT).show();
            }
        });
        assistantLabelCallRenewHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RenewAccount.this, "Call", Toast.LENGTH_SHORT).show();
            }
        });

        assistantLabelMessageRenewHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RenewAccount.this, "Message", Toast.LENGTH_SHORT).show();
            }
        });


        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            View tab = ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(i);
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) tab.getLayoutParams();
            p.setMargins(20, 40, 20, 0);
            tab.requestLayout();
        }


//        service = new BasicHttpBinding_IHotelService1();
//        service.enableLogging = true;
//        authenticandata = new AuthenticationData();
//        authenticandata.UserName = ("Tammtest");
//        authenticandata.Password = ("Tam@18418756");


//
//        HotelSearchResponse hotelSearchResponse  =new HotelSearchResponse() ;
//
//        final ArrayOfHotel_Result hotelResultList = hotelSearchResponse.HotelResultList;
//
//        for (int i = 0; i < hotelResultList.size() ; i++) {
//
//            Hotel_Result hotel_result = hotelSearchResponse.HotelResultList.get(i);
//            HotelInfo hotelInfo = hotel_result.HotelInfo;
//            sessionId = hotelSearchResponse.SessionId;
//            hotelAddress = hotelInfo.HotelAddress;
//            hotelName = hotelInfo.HotelName;
//            hotelPicture = hotelInfo.HotelPicture;
//            hotelPromotion = hotelInfo.HotelPromotion;
//            int code = hotelInfo.Rating.getCode();
//
//            Toast.makeText(this, ""+hotelPromotion, Toast.LENGTH_SHORT).show();
//            String hotelCode = hotelInfo.HotelCode;
//
//
//        }


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        service = new BasicHttpBinding_IHotelService1();
        authenticationData = new AuthenticationData();
        authenticationData.UserName = ("Tammtest");
        authenticationData.Password = ("Tam@18418756");


        try {
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

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RenewAccount.this, ReserveRoom.class);
                startActivity(intent);
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RenewAccount.this, FlightTamm.class));
            }
        });

        try {
            user = SharedPreferencesManger.LoadStringData(this, "user");

        } catch (Exception e) {


        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        // NavigationView navigationView = findViewById(R.id.nav_view);

        NavigationView navigationView = findViewById(R.id.nav_view);

        View hView = navigationView.getHeaderView(0);

        addPic = hView.findViewById(R.id.imageViewAddPic);
        user_name_profile = hView.findViewById(R.id.user_name_profile);


        try {


            Uri photo = Uri.parse(SharedPreferencesManger.LoadStringData(this, "img"));

            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(photo));
                addPic.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        } catch (Exception e) {


        }


        try {
            user_name_profile.setText(user);


            addPic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 0);

                }
            });
        } catch (Exception e) {


        }
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Exit Application?");
            alertDialogBuilder
                    .setMessage("Are you sure to exit!")
                    .setCancelable(false)
                    .setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    moveTaskToBack(true);
                                    android.os.Process.killProcess(android.os.Process.myPid());
                                    System.exit(1);
                                }
                            })

                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            dialog.cancel();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

          //  startActivity(new Intent(RenewAccount.this,WelcomeActivity.class));
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

        } else if (id == R.id.nav_setting) {

        } else if (id == R.id.nav_terms) {

            startActivity(new Intent(RenewAccount.this, TermsActivity.class));

        } else if (id == R.id.nav_logout) {


        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Uri targetUri = data.getData();
            String textTargetUri = (targetUri.toString());

            SharedPreferencesManger.SaveData(RenewAccount.this, "img", textTargetUri);

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


    @OnClick(R.id.relative_img_renew_hotel_tamm)
    public void onViewClicked() {

        if (ClickRenewHotel == false) {
            assistantLabelCallRenewHotel.setVisibility(View.VISIBLE);
            assistantLabelMessageRenewHotel.setVisibility(View.VISIBLE);
            assistantLabelVoiceRenewHotel.setVisibility(View.VISIBLE);
            ClickRenewHotel = true;

        } else {
            assistantLabelCallRenewHotel.setVisibility(View.INVISIBLE);
            assistantLabelMessageRenewHotel.setVisibility(View.INVISIBLE);
            assistantLabelVoiceRenewHotel.setVisibility(View.INVISIBLE);
            ClickRenewHotel = false;

        }


    }


}
