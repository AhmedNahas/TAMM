package net.middledleeast.tamm.adapters;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.FlightsSummary;
import net.middledleeast.tamm.activities.Passenger_inform;
import net.middledleeast.tamm.helper.SharedPreferencesManger;
import net.middledleeast.tamm.model.CountPassengerAndType;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import FlightApi.City;
import FlightApi.Country;
import FlightApi.Nationality;
import FlightApi.Passenger;
import FlightApi.SearchFlightsResponse;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterPassengerInfo extends RecyclerView.Adapter<AdapterPassengerInfo.ViewHolder> {


    private DatePickerDialog.OnDateSetListener mDateSetListener6;
    private boolean rightAge = false;
    private InputStream inputStream;
    private List<String> list_nationalites = new ArrayList<>();
    private DatePickerDialog.OnDateSetListener mDateSetListener4;
    private DatePickerDialog.OnDateSetListener mDateSetListener5;
    private String titlePassenger;

    public interface onListClickedRowListner {
        void onListSelected(List<Passenger> mposition);
    }

    List<CountPassengerAndType> passengerType;
    int passengerCount;
    Button  button ;

    Context  context;
   List<SearchFlightsResponse.Segment> segments = new ArrayList<>() ;
    public AdapterPassengerInfo(List<CountPassengerAndType> passengerType, int passengerCount, Button button, Context context, List<SearchFlightsResponse.Segment> segments) {
        this.passengerType = passengerType;
        this.passengerCount = passengerCount;
        this.button = button;
        this.context = context;
        this.segments =  segments;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_passenger_inf, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//
       CountPassengerAndType countPassengerAndType = passengerType.get(position);

        holder.adultText1.setText(countPassengerAndType.getType());



            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                    if (holder.edFirstName1.getText().toString().equals("")) {

                        holder.edFirstName1.setError("");

                    }else if (holder.edLastName1.getText().toString().equals("")) {

                        holder.edLastName1.setError("");

                    }else if (holder.nationalityAdult1.getText().toString().equals("")) {
                        holder.nationalityAdult1.setError("");
                    }else if (!rightAge) {


                        Toast.makeText(context, "Your Age Should not be less than 12 ", Toast.LENGTH_SHORT).show();


                    }else if (holder.passportNo1.getText().toString().length()>16&&holder.passportNo1.getText().toString().length()<6){

                        holder.passportNo1.setError("Passport number should be from 6  to 16 characters");


                    }else {
                        String country1 = SharedPreferencesManger.LoadStringData(context, "country");
                        String phone = SharedPreferencesManger.LoadStringData(context, "phone");
                        String email = SharedPreferencesManger.LoadStringData(context, "email");
                        String city1 = SharedPreferencesManger.LoadStringData(context, "city");
                        String cityCode = SharedPreferencesManger.LoadStringData(context, "nationality");
                        Passenger passenger = new Passenger();

                        passenger.setAddressLine1(city1);
                        passenger.setAddressLine2(city1);
                        City city = new City();
                        city.setCityCode(cityCode);
                        city.setCityName(city1);
                        city.setCountryCode(country1);
                        passenger.setCity(city);
                        Country country = new Country();
                        country.setCountryCode("EG");
                        country.setCountryName(country1);
                        passenger.setCountry(country);
                        passenger.setGender(1);
                        passenger.setType(1);
                        passenger.setEmail(email);
                        passenger.setMobile1(phone);
                        if (position==0){
                            passenger.setIsLeadPax(true);

                        }
                        passenger.setDateOfBirth(holder.dateOfBirthAdult1.getText().toString());

                        Nationality nationality = new Nationality();

                        nationality.setCountryCode("EG");
                        nationality.setCountryName(country1);
                        passenger.setNationality(nationality);

                        passenger.setFirstName( holder.edFirstName1.getText().toString());
                        passenger.setLastName(holder.edLastName1.getText().toString());
                        passenger.setPassportIssueDate(holder.tvIssueDate1.getText().toString());
                        passenger.setZipCode("2239");
                        passenger.setMobile1CountryCode("+2");
                        passenger.setPassportExpiry(holder.tvEndDat1.getText().toString());
                        passenger.setPassportNo(holder.passportNo1.getText().toString());

                        passenger.setTitle(titlePassenger);

                        List<Passenger> passengerList  = new ArrayList<>();

                        passengerList.add(passenger);


                        Intent intent = new Intent(context,FlightsSummary.class);

                        intent.putExtra("segments",(Serializable) segments);
                        intent.putExtra("passengerList",(Serializable) passengerList);


                        context.startActivity(intent);



                    }



                }
            });

      List<String>  mrmiss1array = new ArrayList<>();
        mrmiss1array.add(context.getString(R.string.mr));
        mrmiss1array.add(context.getString(R.string.mrs));

        List<String>   mrmiss2array = new ArrayList<>();
        mrmiss2array.add(context.getString(R.string.male));
        mrmiss2array.add(context.getString(R.string.female));



        ArrayAdapter adapterChild = new ArrayAdapter(context, R.layout.item_spener, mrmiss2array);

        adapterChild.setDropDownViewResource(R.layout.drop_dowen);
        holder.mromiss1.setAdapter(adapterChild);
        holder.mromiss1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 titlePassenger = mrmiss2array.get(i);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        inputStream = context.getResources().openRawResource(R.raw.nationality);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {

            String data;

            while ((data = reader.readLine()) != null) {


                try {


                    list_nationalites.add(data);


                } catch (Exception e) {


                }

            }


        } catch (Exception e) {


        }


        AutoCompleteAdapter adapter2 = new AutoCompleteAdapter(context, R.layout.drop_dowen, android.R.id.text1, list_nationalites);


        holder.nationalityAdult1.setAdapter(adapter2);
        holder.nationalityAdult1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {




            }


        });






         holder.dateOfBirthAdult1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openAdultAge(mDateSetListener6);


            }
        });
        mDateSetListener6 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                holder.dateOfBirthAdult1.setText(date);
                String age = getAge(year, month, day);

                int ageInt = Integer.parseInt(age);

                if (ageInt < 18) {
                    rightAge = false;


                } else {
                    rightAge = true;


                }


            }

        };










        holder.tvIssueDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        context,
                        android.R.style.Theme_Holo_Wallpaper_NoTitleBar
                        ,
                        mDateSetListener4,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener4 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                holder.tvIssueDate1.setText(date);
            }
        };


        holder.tvEndDat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        context,
                        android.R.style.Theme_Holo_Wallpaper_NoTitleBar
                        ,
                        mDateSetListener5,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener5 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                holder.tvEndDat1.setText(date);
            }
        };

//    }




    }

    private String getAge(int year, int month, int day) {
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();

        return ageS;
    }


    public void openAdultAge(DatePickerDialog.OnDateSetListener mDateSetListener  ) {

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                context,
                android.R.style.Theme_Holo_Wallpaper_NoTitleBar,
                mDateSetListener,
                year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();



    }


    @Override
    public int getItemCount() {
        return passengerCount;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.adultText1)
        TextView adultText1;
        @BindView(R.id.mromiss1)
        Spinner mromiss1;
        @BindView(R.id.ed_first_name1)
        EditText edFirstName1;
        @BindView(R.id.ed_last_name1)
        EditText edLastName1;
        @BindView(R.id.tv_dob1)
        TextView tvDob1;
        @BindView(R.id.date_of_birth_adult1)
        TextView dateOfBirthAdult1;
        @BindView(R.id.nationality_adult1)
        AutoCompleteTextView nationalityAdult1;
        @BindView(R.id.passport_no1)
        EditText passportNo1;
        @BindView(R.id.issue_1)
        TextView issue1;
        @BindView(R.id.tv_issue_Date1)
        TextView tvIssueDate1;
        @BindView(R.id.end_dat1)
        TextView endDat1;
        @BindView(R.id.tv_end_dat1)
        TextView tvEndDat1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }
    }
}
