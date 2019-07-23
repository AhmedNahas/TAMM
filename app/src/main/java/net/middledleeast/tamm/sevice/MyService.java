package net.middledleeast.tamm.sevice;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.CountryList;
import com.Tamm.Hotels.wcf.CountryListResponse;
import com.google.gson.Gson;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.WelcomeActivity;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyService extends Service {


    private BasicHttpBinding_IHotelService1 service;
    private AuthenticationData authenticationData;
    private CountryList<String> countryList;
    private List<String> listID = new ArrayList<>();
    private List<String> list = new ArrayList<>();



    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        Toast.makeText(this, "onBind", Toast.LENGTH_SHORT).show();
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public void onCreate() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        service = new BasicHttpBinding_IHotelService1();
        authenticationData = new AuthenticationData();
        authenticationData.UserName = ("Tammtest");
        authenticationData.Password = ("Tam@18418756");


        try {

            service.enableLogging = true;

            CountryListResponse countryListResponse = service.CountryList(authenticationData);

            for (int i = 0; i < countryListResponse.CountryList.size(); i++) {

                countryList = countryListResponse.CountryList.get(i);
                String cod = countryList.CountryCode;
                listID.add(cod);
                String name = countryList.CountryName;
                list.add(name);

            }
            String listid = listID.toString();
            String str = list.toString();
            str=  str.replace("[", "");
            str=  str.replace("]", "");


            listid=  listid.replace("[", "");
            listid=  listid.replace("]", "");
            Gson gson = new Gson();
            String names = gson.toJson(countryList);
            SharedPreferencesManger.SaveData(this, "name_country", str);
            SharedPreferencesManger.SaveData(this, "code_country", listid);


        }catch (Exception e){

            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    }
