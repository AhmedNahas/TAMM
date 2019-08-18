package net.middledleeast.tamm.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.ChooseHotelActivity;
import net.middledleeast.tamm.adapters.AdapterAirportCuntry;
import net.middledleeast.tamm.adapters.AdapterHotelInfo;
import net.middledleeast.tamm.model.modelflightSearsh;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFlightByCity extends Fragment {

    SearchView search_flight_city ;
    RecyclerView rv_country;
    AdapterAirportCuntry adapterAirportCuntry;
    String[] ids;
    InputStream inputStream;
    List<String> airportCode = new ArrayList<>();
    List<String> airportName = new ArrayList<>();
    List<String> cityCode = new ArrayList<>();
    ArrayList<String> nameTemp;
    private int id_t;
    private List<modelflightSearsh> list_searsh = new ArrayList<>();

    public SearchFlightByCity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_flight_by_city, container, false);


        try {
            Bundle arguments = getArguments();
            id_t = arguments.getInt("id_t");
        }catch (Exception e){}

        rv_country = view.findViewById(R.id.rv_airport_country);

        search_flight_city = view.findViewById(R.id.search_flight_city);

        inputStream = getResources().openRawResource(R.raw.airports);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {

            String data;

            while ((data = reader.readLine()) != null) {

                ids = data.split(",");

                try {

                    String airportCode = ids[0];
                    this.airportCode.add(airportCode);

                    String airportName = ids[1];
                    this.airportName.add(airportName);

                    String cityCode = ids[2];
                    this.cityCode.add(cityCode);

                } catch (Exception e) {


                }

            }


        } catch (Exception e) {


        }

        modelflightSearsh searsh = null;
        for (int i = 0; i < airportName.size(); i++) {


            searsh = new modelflightSearsh(airportName.get(i),airportCode.get(i),cityCode.get(i));
            list_searsh.add(searsh);

        }



        rv_country.setLayoutManager(new LinearLayoutManager(getContext()));

        adapterAirportCuntry = new AdapterAirportCuntry(list_searsh  ,id_t , getContext());
        rv_country.setAdapter(adapterAirportCuntry);
        adapterAirportCuntry.notifyDataSetChanged();
        search_flight_city.setImeOptions(EditorInfo.IME_ACTION_DONE);
        search_flight_city.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterAirportCuntry.getFilter().filter(newText);
                return false;
            }
        });




//        search_flight_city.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//
//
//                if (charSequence.toString().contains("")){
//                    adapterAirportCuntry.notifyDataSetChanged();
//                }else{
//                    searchItem(charSequence.toString());
//                }
//
//
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//                nameTemp = new ArrayList<>();
//                ArrayList<String> codecityTemp = new ArrayList<>();
//                ArrayList<String> codeAirportTemp = new ArrayList<>();
//
//
//                for (int y = 0; y < airportName.size(); y++) {
//                    if (airportName.get(y).contains(search_flight_city.getText().toString())) {
//
//                        nameTemp.add(airportName.get(y));
//                        codeAirportTemp.add(airportCode.get(y));
//                        codecityTemp.add(cityCode.get(y));
//
//                        //  rv_country.setLayoutManager(new LinearLayoutManager(getContext()));
//
//                        adapterAirportCuntry = new AdapterAirportCuntry(codecityTemp, nameTemp, codeAirportTemp,getActivity(),getContext(),id_t);
//                        rv_country.setAdapter(adapterAirportCuntry);
//                        adapterAirportCuntry.notifyDataSetChanged();
//
//                    }else {
//
//
//                    }
//
//
//                }
//
//            }
//        });

        return view;
    }

    private void searchItem(String toString) {


        for (String item : airportName){
            if (!item.contains(toString)){
                nameTemp.remove(item);

            }
        }

        adapterAirportCuntry.notifyDataSetChanged();
    }

}