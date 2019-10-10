package net.apptamm.tamm;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.DestinationCityListResponse;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import net.apptamm.tamm.activities.FreeCongratsActivity;
import net.apptamm.tamm.activities.PaymentActivity;
import net.apptamm.tamm.adapters.AutoCompleteAdapter;
import net.apptamm.tamm.fragments.TermsFragment;
import net.apptamm.tamm.helper.SharedPreferencesManger;
import net.apptamm.tamm.model.AllLinks.LinksUrl;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.OnClick;


public class RegisterationActivity extends Fragment {


    TextView termsConditionsTv;
    private EditText etFirstName;
    private EditText etLastName;
    private EditText etUserName;
    private Button register;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etPassword;
    private TextView etDate;
    private AutoCompleteTextView country, city, ocupation;
    private TextView zip_code;
    private BasicHttpBinding_IHotelService1 service;
    private AuthenticationData authenticationData;
    private static final String TAG = RegisterationActivity.class.getSimpleName();

    int checkUserType;

    RequestQueue requestQueue;
//    private String register_url_free = "http://egyptgoogle.com/paymentusertest/user_control.php";

    private ArrayList<String> mrOrMissArray;
    private ArrayAdapter mrOrMissAdapter;
    private Spinner mrormissSpinner;
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private String day, month, year;


    List<String> list_country = new ArrayList<>();
    private List<String> listID = new ArrayList<>();
    private int nameCity;
    private String idCountry;
    private List<String> list_city = new ArrayList<>();

    Toolbar toolbar;
    LinearLayout imageView;

    CheckBox agree;


    TextView terms_conditions ;
    RadioButton special;
//    private static final String HIVALIDATIONFREE = "http://www.egyptgoogle.com/freeusers/validationfree.php";
//    private List<Validationfree> validationfree = new ArrayList<>();
//    private List<String> listUserNamevalidationfree = new ArrayList<>();
//    private List<String> listUserPhonefree = new ArrayList<>();
//    private List<String> listEmailvalidationfree = new ArrayList<>();


//    private static final String HIVALIDATIONMEMBER = "http://www.egyptgoogle.com/freeusers/validationfree.php";
//
//    private List<Validtionmember> validationmember = new ArrayList<>();
//    private List<String> listUserNamevalidationmember = new ArrayList<>();
//    private List<String> listUserPhonemember = new ArrayList<>();
//    private List<String> listEmailvalidationmember = new ArrayList<>();


//    private String phonevalidation;
//    private String usernamevalidation;
//    private String emailvalidation;
//    private String nameCountry;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String counTry;
    private String occup;
    private String email;
    private String phoneM;
    private String cityUser;
    private String tokenId;
    private int PAYMENT = 2;
    private int FREE = 1;
    private String bookedOn;
    private int isfree = 1;
    private String created_at;
    private String nameCountry;


    @SuppressLint("StaticFieldLeak")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registeration, container, false);

        terms_conditions = view.findViewById(R.id.terms_conditions_tv);

        etFirstName = view.findViewById(R.id.ed_first_name);
        etLastName = view.findViewById(R.id.ed_last_name);
        etUserName = view.findViewById(R.id.ed_user_name);
        etPhone = view.findViewById(R.id.ed_phone);
        etEmail = view.findViewById(R.id.ed_email);
        etPassword = view.findViewById(R.id.ed_password);
        etDate = view.findViewById(R.id.ed_Date);
        country = view.findViewById(R.id.country);
        ocupation = view.findViewById(R.id.ed_occupation);
        city = view.findViewById(R.id.ed_city);
        zip_code = view.findViewById(R.id.zip_code);
        special = view.findViewById(R.id.special);
        agree = view.findViewById(R.id.check_box_agerr);
        toolbar = view.findViewById(R.id.welcome_toolbar);
        imageView = view.findViewById(R.id.back_pressed);


        Calendar calendar = Calendar.getInstance();

        Date futureDate = calendar.getTime();
        bookedOn = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(futureDate);

         checkUserType = SharedPreferencesManger.LoadIntegerData(getContext(), "isMemmber");


        special.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               switch (view.getId()){
                   case R.id.special:
                       if (special.isSelected()){
                           special.setChecked(false);
                           special.setSelected(false);
                       }else{
                           special.setChecked(true);
                           special.setSelected(true);
                       }
               }
           }
       });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();

             

            }
        });


        terms_conditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.terms_container, new TermsFragment())
                        .addToBackStack("RegisterationActivity").commit();

            }
        });
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {

//                getValidationMember();
//                getValidationFree();
                return null;
            }
        }.execute();


        String cod = GetCountryZipCode();

        zip_code.setText("+" + cod);


        register = view.findViewById(R.id.proceedcheck_out);
        Context context = getActivity();

        try {
    requestQueue = Volley.newRequestQueue(context);

    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

    StrictMode.setThreadPolicy(policy);
    auth();
    getCountries();

    getOcupation();
}catch (Exception e){}
//        ArrayAdapter  = new ArrayAdapter<String>(getContext(), R.layout.item_spener_reg, list_country);






        mrOrMissArray = new ArrayList<>();
        mrOrMissArray.add("Mr.");
        mrOrMissArray.add("Mrs.");

//        mDisplayDate = view.findViewById(R.id.tvDate);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // TODO: 9/1/2019  remove it when amir do it
                if (isEmpty(etUserName)) {
                    etUserName.setError("user name is required !");


                } else if (isEmpty(etEmail)) {
                    etEmail.setError("Email is required !");


                } else if (isEmpty(etFirstName)) {
                    etFirstName.setError("First Name is required !");


                } else if (isEmpty(etLastName)) {
                    etLastName.setError("Last Name is required !");


                } else if (isEmpty(etPassword)) {
                    etPassword.setError("Password is required !");


                } else if (etPassword.getText().toString().length() < 8) {
                    etPassword.setError("Password should be 8 characters or more");


                } else if (isEmpty(city)) {

                    city.setError("city is required !");
                } else if (isEmpty(country) || !list_country.contains(country.getText().toString())) {

                    country.setError("Country name is either missing or wrong!");
                } else if (isEmpty(ocupation)) {

                    ocupation.setError("occupation is required !");


                } else if (isEmpty(etPhone)) {
                    etPhone.setError("Phone is required !");

                } else if (isEmpty(etDate)) {
                    etDate.setError("Date is required !");
                } else if (!agree.isChecked()) {

                    Toast.makeText(context, "please agree the terms and conditions", Toast.LENGTH_SHORT).show();

                } else {


                    firstName = etFirstName.getText().toString();
                    lastName = etLastName.getText().toString();
                    userName = etUserName.getText().toString();
                    password = etPassword.getText().toString();
                    counTry = country.getText().toString();
                    occup = ocupation.getText().toString();
                    email = etEmail.getText().toString();
                    phoneM = etPhone.getText().toString();
                    cityUser = city.getText().toString();

                    SharedPreferencesManger.SaveData(getContext(), "first_name", firstName);
                    SharedPreferencesManger.SaveData(getContext(), "last_name", lastName);
                    SharedPreferencesManger.remove(getContext(),"gustMode");


                    if (checkUserType ==FREE ) {



                        Intent intent = new Intent(getContext(), PaymentActivity.class);


                        intent.putExtra("username", userName);
                        intent.putExtra("firstname",firstName );
                        intent.putExtra("lastname", lastName);
                        intent.putExtra("country", counTry);
                        intent.putExtra("city", cityUser);
                        intent.putExtra("phone",phoneM);
                        intent.putExtra("isfree",String.valueOf(isfree));
                        intent.putExtra("occupation",occup);
                        intent.putExtra("email", email);
                        intent.putExtra("password", password);
                        intent.putExtra("birthdate"," " + day+ " - " + month+ " - " + year + " ");
                        intent.putExtra("subscriptiondate", bookedOn);
                        intent.putExtra("nationality", idCountry);

                        SharedPreferencesManger.SaveData(getContext(),"mId",1);


                        startActivity(intent);

                    } else if (checkUserType == PAYMENT) {
                        sendFreeUser();


                    }

                }


            }
        });


        mrOrMissAdapter = new ArrayAdapter(getContext(), R.layout.item_spener, mrOrMissArray);
        mrormissSpinner = view.findViewById(R.id.mromiss);
        mrOrMissAdapter.setDropDownViewResource(R.layout.drop_dowen);
        mrormissSpinner.setSelection(0);
        mrormissSpinner.setAdapter(mrOrMissAdapter);


        mrormissSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i != 0) {

                    String s = mrOrMissArray.get(i);

                    SharedPreferencesManger.SaveData(getContext(), "mr", s);


                } else {


                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        etDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }

        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDateSet(DatePicker datePicker, int yea_, int month_, int day_) {

                String s = String.valueOf(Integer.sum(month_,1));


                etDate.setText(" " + day_ + " - " + s + " - " + yea_ + " ");

                day = String.valueOf(day_);

                month = String.valueOf(month_);
                year = String.valueOf(yea_);


            }
        };
        return view;
    }


    // free users

    // still waiting amir
    private void sendFreeUser() {

            StringRequest request = new StringRequest(Request.Method.POST, LinksUrl.URL_REGISTER, new Response.Listener<String>() {

                @Override

                public void onResponse(String response) {

                    Log.d(TAG, "Register Response: " + response.toString());


                    try {
                        JSONObject jObj = new JSONObject(response);
                        int status = jObj.getInt("status");
                        if (status == 1) {
                            // User successfully stored in MySQL
                            // Now store the user in sqlite

                            String uid = jObj.getString("uid");

                            JSONObject user = jObj.getJSONObject("user");
                            userName = user.getString("username");
                            firstName = user.getString("firstname");
                            lastName = user.getString("lastname");
                            counTry = user.getString("country");
                            cityUser = user.getString("city");
                            phoneM = user.getString("phone");
                            isfree = user.getInt("isfree");
                            occup = user.getString("occupation");
                            email = user.getString("email");
                            created_at = user.getString("created_at");


                            SharedPreferencesManger.SaveData(getContext(),"accountPlan",isfree);

                            // Inserting row in users table
//                        db.addUser(name, email, uid, created_at);

                            getActivity().getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.welcome_container, new SignInFragment())
                                    .commit();
                            // Launch login activity


                        } else {

                            // Error occurred in registration. Get the error
                            // message
                            String errorMsg = jObj.getString("error_msg");
                            Toast.makeText(getContext(),
                                    errorMsg, Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    Toast.makeText(getContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), FreeCongratsActivity.class);
                        SharedPreferencesManger.SaveData(getContext(),"user_name",userName);
                    startActivity(intent);



                }

            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {

                    int statusCode = error.networkResponse.statusCode;
                    Toast.makeText(getContext(), ""+statusCode, Toast.LENGTH_SHORT).show();

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> parameters = new HashMap<String, String>();
                    parameters.put("username", userName);
                    parameters.put("firstname",firstName );
                    parameters.put("lastname", lastName);
                    parameters.put("country", counTry);
                    parameters.put("city", cityUser);
                    parameters.put("phone",phoneM);
                    parameters.put("isfree",String.valueOf(isfree));
                    parameters.put("occupation",occup);
                    parameters.put("email", email);
                    parameters.put("password", password);
                    parameters.put("birthdate"," " + day+ " - " + month+ " - " + year + " ");
                    parameters.put("subscriptiondate", bookedOn);
                    parameters.put("nationality", idCountry);
//

                    //  parameters.put("tokenid",tokenId );


                    return parameters;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getContext());
            requestQueue.add(request);



    }


    private void getCountries() {


        // get all name country in string
        String name_country = SharedPreferencesManger.LoadStringData(getActivity(), "name_country");
        Gson gson = new Gson();
        list_country = gson.fromJson(name_country, ArrayList.class);


        String code_country = SharedPreferencesManger.LoadStringData(getActivity(), "code_country");

        Gson gson2 = new Gson();
        listID = gson2.fromJson(code_country, ArrayList.class);


        AutoCompleteAdapter adapter2 = new AutoCompleteAdapter(getContext(), R.layout.drop_dowen, android.R.id.text1,list_country );


        country.setAdapter(adapter2);
        country.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                nameCountry = list_country.get(adapter2.getPosition(adapter2.getItem(position)));
                idCountry = listID.get(adapter2.getPosition(adapter2.getItem(position)));

                getCities(idCountry);

            }


        });


//
//        for (int i = 0; i < list_country.size(); i++) {
//
//            idCountry = listID.get(i);
//
//
//        }


        // String test = hotelSearchResponse.Status.Description;
//            System.out.println("Hello: " + test);


    }

    private void auth() {

        service = new BasicHttpBinding_IHotelService1();
        authenticationData = new AuthenticationData();
        authenticationData.UserName = ("Tammtest");
        authenticationData.Password = ("Tam@18418756");

    }


    private void getCities(String idCountry) {

        list_city.clear();
        try {
            DestinationCityListResponse cities = service.DestinationCityList(idCountry, "true", authenticationData);
            for (int j = 0; j < cities.CityList.size(); j++) {


                String cityName = cities.CityList.get(j).CityName;
                list_city.add(cityName);

                AutoCompleteAdapter adapter2 = new AutoCompleteAdapter(getActivity(), R.layout.drop_dowen, android.R.id.text1, list_city);
                city.setAdapter(adapter2);



//                city.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//                    @Override
//                    public void onFocusChange(View view, boolean b) {
//
//                        if (b) {
//
//                            city.getOnFocusChangeListener();
//                        } else {
//
//                            city.getOnFocusChangeListener();
//                        }
//
//                    }
//                });
//
//
//                city.setOnTouchListener(new View.OnTouchListener() {
//
//                    @Override
//                    public boolean onTouch(View v, MotionEvent event) {
//                        city.showDropDown();
//                        return false;
//                    }
//                });
//
//                city.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//
//                        String name_city = list_city.get(adapter2.getPosition(adapter2.getItem(position)));
//                        String ctyId = cities.CityList.get(adapter2.getPosition(adapter2.getItem(position))).CityCode;
//
//
//                    }
//
//                });

            }

            city.setText("");


        } catch (Exception e) {
            e.printStackTrace();
        }//

    }

    private void getOcupation() {


        String[] ocupation_list = new String[]{

                "3D animator",
                "Abattoir worker",
                "Aboriginal and Torres Strait Islander health worker",
                "Accountant (general)",
                "Accounts clerk",
                "Actor",
                "Actuary",
                "Acupuncturist",
                "Advertising specialist",
                "Aeronautical engineer",
                "Aeroplane pilot",
                "Aged care worker",
                "Agricultural consultant",
                "Agricultural engineer",
                "Agricultural scientist",
                "Air combat officer",
                "Air force - general entrant",
                "Air force technician/tradesperson",
                "Air traffic controller",
                "Air-conditioning and refrigeration mechanic",
                "Aircraft baggage handler and airline ground crew",
                "Aircraft maintenance engineer (avionics)",
                "Aircraft maintenance engineer (mechanical)",
                "Aircraft maintenance engineer (structural)",
                "Alarm, security or surveillance monitor",
                "Ambulance officer",
                "Anaesthetist",
                "Animal attendants and trainers",
                "Aquaculture farmer",
                "Arborist",
                "Archaeologist",
                "Architect",
                "Architectural draftsperson",
                "Archivist",
                "Army officer",
                "Army Soldier - Technician",
                "Art director (film, television, stage)",
                "Art teacher",
                "Auctioneer",
                "Audiologist",
                "Audiovisual technician",
                "Auditor (external and internal)",
                "Author",
                "Automotive electrician",
                "Baker",
                "Bank worker",
                "Bar attendant",
                "Barista",
                "Barrister",
                "Beauty therapist",
                "Beef cattle farmer",
                "Bicycle mechanic",
                "Binder and finisher",
                "Biomedical engineer",
                "Biosecurity officer",
                "Biotechnologist",
                "Boat builder and repairer",
                "Body artist or tattooist",
                "Boiler or engine operator",
                "Book or script editor",
                "Bookkeeper",
                "Bookmaker",
                "Botanist",
                "Brewer",
                "Bricklayer",
                "Broadcast transmitter operator",
                "Builder's Labourer",
                "Building insulation installer",
                "Building surveyor",
                "Bus driver",
                "Business machine mechanic",
                "Butcher or smallgoods maker",
                "Cabinetmaker",
                "Cafe or restaurant manager",
                "Call or contact centre operator",
                "Call or contact centre team leader",
                "Camera operator (film, television or video)",
                "Canvas goods fabricator",
                "Car park attendant",
                "Cardiologist",
                "Cardiothoracic surgeon",
                "Careers counsellor",
                "Carpenter",
                "Cartographer",
                "Chef",
                "Chemical engineer",
                "Chemist",
                "Chief executive or managing director",
                "Child care centre manager",
                "Child care worker",
                "Child protection worker",
                "Chiropractor",
                "Cinema or theatre manager",
                "Civil celebrant",
                "Civil engineer",
                "Civil engineering draftsperson",
                "Civil engineering technician",
                "Clay, concrete, glass or stone machine operator",
                "Clinical haematologist",
                "Clinical psychologist",
                "Clothing production worker",
                "Coastal engineer",
                "Commercial cleaner",
                "Commercial housekeeper (hotel/motel room attendant)",
                "Commodities trader",
                "Communications operator",
                "Community corrections officer",
                "Community worker",
                "Computer engineer",
                "Computer-aided design (CAD) technician",
                "Concierge",
                "Concreter",
                "Confectionery maker",
                "Conference and event organiser",
                "Conservation Officer",
                "Conservator",
                "Construction estimator",
                "Construction project manager",
                "Construction rigger",
                "Contract Administrator",
                "Cook",
                "Copywriter",
                "Corporate general manager",
                "Counsellor",
                "Court bailiff or sheriff (Aus)",
                "Coxswain",
                "Crane chaser (dogger)",
                "Crane, hoist or lift operator",
                "Customer service manager",
                "Customs officer (Border Force officer)",
                "Dairy cattle farmer",
                "Dancer or choreographer",
                "Debt collector",
                "Deck hand",
                "Delivery driver",
                "Dental assistant",
                "Dental hygienist",
                "Dental specialist",
                "Dental technician",
                "Dental therapist",
                "Dentist",
                "Dermatologist",
                "Developer programmer",
                "Diesel motor mechanic",
                "Dietitian",
                "Director (film, television, radio or stage)",
                "Disability services officer",
                "Disability worker",
                "Diver",
                "Diversional therapist",
                "Dog handler or trainer",
                "Domestic cleaner",
                "Doorperson or luggage porter",
                "Driller",
                "Drilling engineer",
                "Driving instructor",
                "Drug and alcohol counsellor",
                "Drycleaner",
                "Early childhood (pre-primary school) teacher",
                "Earth science technician",
                "Earthmoving plant operator",
                "Economist",
                "Electorate officer",
                "Electrical engineer",
                "Electrical engineering draftsperson",
                "Electrical engineering technician",
                "Electrical linesworker (Aus)",
                "Electrician (general)",
                "Electronic engineering technician",
                "Electronic equipment trades worker",
                "Electronic instrument trades worker (general)",
                "Electronics engineer",
                "Electroplater",
                "Embalmer",
                "Emergency medicine specialist",
                "Endocrinologist",
                "Engineering manager",
                "Engineering patternmaker",
                "Engraver",
                "Enrolled nurse",
                "Entertainer or variety artist",
                "Entrepreneur",
                "Environmental consultant",
                "Environmental engineer",
                "Environmental health officer",
                "Environmental manager",
                "Environmental research scientist",
                "Exercise scientist",
                "Facilities manager",
                "Farm manager",
                "Fashion designer",
                "Fast food cook",
                "Fibrous plasterer",
                "Film and video producer",
                "Finance broker",
                "Financial institution branch manager",
                "Financial investment adviser",
                "Financial investment manager",
                "Fire fighter",
                "Fisheries officer",
                "Fishing hand",
                "Fitness instructor",
                "Fleet manager",
                "Flight attendant",
                "Floor finisher",
                "Florist",
                "Flying instructor",
                "Food processing worker",
                "Food technologist",
                "Forensic scientist",
                "Forester (Aus)",
                "Forklift driver",
                "Fruit and vegetable picker",
                "Funeral director",
                "Furniture finisher",
                "Furniture removalist",
                "Gallery or museum curator",
                "Gallery or museum guide",
                "Gallery or museum technician",
                "Game developer",
                "Gaming worker",
                "Gardener (general)",
                "Gasfitter",
                "Gastroenterologist",
                "General clerk",
                "General medical practitioner",
                "Geologist",
                "Geophysicist",
                "Geotechnical engineer",
                "Glazier",
                "Goldsmith",
                "Grain oilseed or pasture grower",
                "Grape grower",
                "Graphic designer",
                "Graphic pre-press trades worker",
                "Greenkeeper",
                "Gunsmith",
                "Gynaecologist",
                "Hair or beauty salon manager",
                "Hairdresser",
                "Handyperson",
                "Health information manager",
                "Health promotion officer",
                "Helicopter pilot",
                "Historian",
                "Horse trainer",
                "Hospital pharmacist",
                "Hotel or motel manager",
                "Human resource adviser",
                "Human resource manager",
                "Hydrologist",
                "ICT business analyst",
                "ICT project manager",
                "ICT security specialist",
                "ICT support technician",
                "ICT systems test engineer",
                "Immigration officer (Border Force officer)",
                "Industrial designer",
                "Industrial engineer",
                "Industrial pharmacist",
                "Information technology administrator",
                "Insurance agent",
                "Insurance broker",
                "Intelligence officer",
                "Intensive care specialist",
                "Interior designer",
                "Interpreter",
                "Jackeroo/Jillaroo",
                "Jewellery designer",
                "Jockey",
                "Joiner",
                "Journalist",
                "Judge",
                "Kitchenhand",
                "Laboratory manager",
                "Laboratory technician",
                "Landscape architect",
                "Landscape gardener",
                "Laundry worker (general)",
                "Law clerk",
                "Legal secretary",
                "Librarian",
                "Library assistant",
                "Library technician",
                "Lifeguard",
                "Lift mechanic",
                "Light technician",
                "Locksmith",
                "Logistics clerk",
                "Machine shorthand reporter",
                "Maintenance planner",
                "Make up artist",
                "Marine biologist",
                "Marine fabricator",
                "Marine surveyor",
                "Market research analyst",
                "Marketing specialist",
                "Massage therapist",
                "Master fisher",
                "Materials engineer",
                "Materials recycler",
                "Materials technician",
                "Mathematician",
                "Meat inspector",
                "Mechanical engineer",
                "Mechanical engineering draftsperson",
                "Mechanical engineering technician",
                "Mechanical fitter",
                "Mechatronic engineer",
                "Medical administrator",
                "Medical diagnostic radiographer",
                "Medical laboratory scientist",
                "Medical oncologist",
                "Medical radiation therapist",
                "Medical receptionist",
                "Member of parliament",
                "Mental health worker",
                "Metal engineering process worker",
                "Metal fabricator",
                "Metal machinist (first class)",
                "Metallurgist",
                "Meteorologist",
                "Meter reader",
                "Microbiologist",
                "Midwife",
                "Migration agent (Aus)",
                "Milliner",
                "Miner",
                "Mining engineer (excluding petroleum)",
                "Mining production manager",
                "Mining support worker",
                "Minister of religion",
                "Mixed crop and livestock farm worker",
                "Model",
                "Mortgage broker",
                "Mothercraft nurse",
                "Motion picture projectionist",
                "Motor mechanic (general)",
                "Motorcycle mechanic",
                "Multimedia specialist",
                "Music teacher (private tuition)",
                "Musician (instrumental)",
                "Nanny",
                "Naturopath",
                "Naval architect",
                "Navy sailor",
                "Navy technician",
                "Network administrator",
                "Network engineer",
                "Neurologist",
                "Neurosurgeon",
                "Nuclear medicine technologist",
                "Nurse educator",
                "Nurse manager",
                "Nurse practitioner",
                "Nurseryperson",
                "Nursing clinical director",
                "Nursing support worker",
                "Nutritionist",
                "Obstetrician",
                "Occupational health and safety adviser",
                "Occupational therapist",
                "Office manager",
                "Offset printer",
                "Ophthalmologist",
                "Optical mechanic",
                "Optometrist",
                "Orthopaedic surgeon",
                "Orthoptist",
                "Orthotist or prosthetist",
                "Osteopath",
                "Otorhinolaryngologist",
                "Outdoor adventure instructor",
                "Paediatric surgeon",
                "Paediatrician",
                "Painting trades worker",
                "Panelbeater",
                "Park ranger",
                "Parking inspector",
                "Pastrycook",
                "Pathologist",
                "Patient care assistant",
                "Payroll clerk",
                "Personal assistant",
                "Pest controller",
                "Pet groomer",
                "Petroleum engineer",
                "Petrophysicist",
                "Pharmacist",
                "Pharmacologist",
                "Pharmacy sales assistant",
                "Pharmacy technician",
                "Photographer",
                "Photographer's assistant",
                "Physical education (PE) teacher",
                "Physicist",
                "Physiotherapist",
                "Picture framer",
                "Plant mechanic",
                "Plastic and reconstructive surgeon",
                "Plastics technician",
                "Plumber (general)",
                "Podiatrist",
                "Police officer",
                "Policy analyst",
                "Political scientist",
                "Polymer factory worker",
                "Postal delivery officer",
                "Powder coater (spray painter)",
                "Power generation plant operator",
                "Precision instrument maker and repairer",
                "Primary school teacher",
                "Printing machinist",
                "Prison officer",
                "Private investigator",
                "Process engineer (Mining Engineer)",
                "Process plant operator",
                "Product examiner",
                "Production manager (manufacturing)",
                "Production or plant engineer",
                "Project builder",
                "Project or program administrator",
                "Prop and scenery maker",
                "Property developer",
                "Property manager",
                "Psychiatrist",
                "Psychologist",
                "Public relations professional",
                "Publisher",
                "Radiation oncologist",
                "Radio presenter",
                "Radio producer",
                "Radiologist",
                "Railway track worker",
                "Real estate representative",
                "Receptionist (general)",
                "Records manager",
                "Recreation officer (Aus)",
                "Recruitment consultant",
                "Recycling or rubbish collector",
                "Registered nurse (community health)",
                "Registered nurse (mental health)",
                "Registered nurse (overview)",
                "Renal medicine specialist",
                "Resident medical officer",
                "Retail buyer",
                "Retail manager (general)",
                "Retirement village manager",
                "Rheumatologist",
                "Road worker",
                "Roof plumber",
                "Roof tiler",
                "Safety inspector",
                "Sales and marketing manager",
                "Sales assistant (general)",
                "Sales representative",
                "Saw maker and repairer",
                "Sawmill or timber yard worker",
                "Scaffolder",
                "School principal",
                "Screen printer",
                "Seafood process worker",
                "Secondary school teacher",
                "Security officer",
                "Security systems installer",
                "Set designer",
                "Settlement agent",
                "Shearer",
                "Sheep farmer",
                "Sheetmetal trades worker",
                "Shelf filler",
                "Ship's engineer",
                "Ship's master",
                "Ship's officer",
                "Shoe repairer",
                "Shotfirer",
                "Signwriter",
                "Silversmith",
                "Social worker",
                "Soil scientist",
                "Soldier",
                "Solicitor",
                "Solid plasterer",
                "Sonographer",
                "Sound technician",
                "Special needs teacher",
                "Speech pathologist (Aus)",
                "Sports administrator",
                "Sports coach or instructor",
                "Sports development officer",
                "Sportsperson",
                "Statistician",
                "Steel fixer",
                "Stockbroking dealer",
                "Stonemason",
                "Storeperson",
                "Streetsweeper operator",
                "Structural engineer",
                "Stunt performer",
                "Supply and distribution manager",
                "Surgeon (general)",
                "Surveyor",
                "Surveyor's assistant",
                "Systems administrator",
                "Systems analyst",
                "Talent agent",
                "Taxi driver",
                "Teacher of the deaf and hard-of hearing",
                "Teacher of the vision impaired",
                "Teachers' aide",
                "Technical cable jointer",
                "Telecommunications engineer",
                "Textile production worker",
                "Textile, clothing and footwear mechanic",
                "Thoracic medicine specialist",
                "Ticket collector or usher",
                "Tool pusher",
                "Tour guide",
                "Tourist information officer",
                "Trade union official",
                "Train controller",
                "Train driver",
                "Training and development professional",
                "Transit officer",
                "Translator",
                "Transport company manager",
                "Transport engineer",
                "Travel consultant",
                "Tree faller",
                "Truck driver (general)",
                "Turf grower",
                "Tyre fitter",
                "University lecturer",
                "Upholsterer",
                "Urban and regional planner",
                "Urologist",
                "Valuer",
                "Vascular surgeon",
                "Vehicle body builder",
                "Veterinarian",
                "Veterinary nurse",
                "Video editor",
                "Vineyard worker",
                "Visual arts and crafts professional",
                "Visual merchandiser",
                "Vocational Education and Training (VET) lecturer",
                "Waiter",
                "Wall and floor tiler",
                "Warehouse administrator",
                "Waste water or water plant operator",
                "Watch and clock maker and repairer",
                "Water inspector",
                "Waterside worker",
                "Web designer",
                "Weight loss consultant",
                "Welder (first class) (Aus)",
                "Welfare centre manager",
                "Welfare worker",
                "Wine maker",
                "Wood machinist",
                "Wood turner",
                "Wool classer",
                "Zoologist",


        };


        ArrayAdapter adapter2 = new ArrayAdapter<String>(getContext(), R.layout.item_spener_reg, ocupation_list);
        ocupation.setAdapter(adapter2);

    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean isEmpty(TextView text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean isEmpty(AutoCompleteTextView text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }


    public String GetCountryZipCode() {
        String CountryID = "";
        String CountryZipCode = "";

        TelephonyManager manager = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
        //getNetworkCountryIso
        CountryID = manager.getSimCountryIso().toUpperCase();
        String[] rl = this.getResources().getStringArray(R.array.CountryCodes);
        for (int i = 0; i < rl.length; i++) {
            String[] g = rl[i].split(",");
            if (g[1].trim().equals(CountryID.trim())) {
                CountryZipCode = g[0];
                break;
            }
        }
        return CountryZipCode;
    }


    // TODO: 9/1/2019 remove it
//    private void getValidationFree() {
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, HIVALIDATIONFREE, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    JSONArray array = jsonObject.getJSONArray("validationfree");
//                    for (int i = 0; i < array.length(); i++) {
//                        JSONObject ob = array.getJSONObject(i);
//
//                        Validationfree listData = new Validationfree(ob.getString("username")
//                                , ob.getString("phone"), ob.getString("email"));
//
//                        validationfree.add(listData);
//
//                        phonevalidation = validationfree.get(i).getPhone();
//                        usernamevalidation = validationfree.get(i).getUsername();
//                        emailvalidation = validationfree.get(i).getEmail();
//
//
//
//
//
//                        SharedPreferencesManger.SaveData(getActivity(), "user", usernamevalidation);
//
//                        listUserNamevalidationfree.add(usernamevalidation);
//                        listEmailvalidationfree.add(emailvalidation);
//                        listUserPhonefree.add(phonevalidation);
//
//
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//
//                }
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//                // dialog.cancel();
//            }
//        });
//        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
//        requestQueue.add(stringRequest);
//    }
//
//    // TODO: 9/1/2019 remove it
//    private void getValidationMember() {
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, HIVALIDATIONMEMBER, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    JSONArray array = jsonObject.getJSONArray("Validtionmember");
//                    for (int i = 0; i < array.length(); i++) {
//                        JSONObject ob = array.getJSONObject(i);
//
//                        Validtionmember listData = new Validtionmember(ob.getString("username")
//                                , ob.getString("phone"), ob.getString("email"));
//
//                        validationmember.add(listData);
//
//                        phonevalidation = validationmember.get(i).getPhone();
//                        usernamevalidation = validationmember.get(i).getUsername();
//                        emailvalidation = validationmember.get(i).getEmail();
//
//                        SharedPreferencesManger.SaveData(getActivity(), "user", usernamevalidation);
//
//                        listUserNamevalidationmember.add(usernamevalidation);
//                        listEmailvalidationmember.add(emailvalidation);
//                        listUserPhonemember.add(phonevalidation);
//
//
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//
//
//                }
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//                //dialog.cancel();
//            }
//        });
//        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
//        requestQueue.add(stringRequest);
//
//
//    }


    @OnClick(R.id.terms_conditions_tv)
    public void onViewClicked() {
    }




}
