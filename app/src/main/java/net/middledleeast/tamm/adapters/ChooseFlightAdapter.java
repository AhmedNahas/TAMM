package net.middledleeast.tamm.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.FlightsSummary;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.List;

import FlightApi.SearchFlightsResponse;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Retrofit;

public class ChooseFlightAdapter extends RecyclerView.Adapter<ChooseFlightAdapter.ChooseFlightViewHolder> {


    private Context context;
    //    private List<String> airLineName;
//    List<String> Listduration;
//    private List<String> arriveTime;
//    List<String> depuruerTime;
//    List<String> countryNameOriginList;
//    List<String> countryNameDestinationList;
//
//    int size, sizeSegments;
//    List<String> listIncludedBaggage;
//    List<String> listCabinBaggage;
//    List<Double> listTotalFare;
//    List<String> listTypeFare;
//    List<String> ListflightNumber;
//    List<String> ListMealType;
//    List<Long> listnoSetAv;
//    List<String> ListairportCode_Distnation, ListairportCode_Origin;
    List<SearchFlightsResponse.Result> ListResult;
    private String airline;
    private String CityNameOrogin1, CityNameDestination1;
    private String departureTime_, arrivalTime_;
    private String cabinBaggage, groundTime;
    private String additionalBaggage;
    private String cabinBaggageSiz4_4, additionalBaggageSiz4_4;
    private String CityNameDestinationSiz4_4, CityNameOroginSiz4_4;
    private String departureTimeSiz4, arrivalTimeSiz4;
    private String CityNameDestinationSiz4_3, CityNameOroginSiz4_3;
    private String CityNameDestinationSiz4_2, CityNameOroginSiz4_2;
    private String CityNameDestinationSiz4_1, CityNameOroginSiz4_1;
    private String groundTimeSiz4;
    private String additionalBaggageSize3, cabinBaggageSize3;
    private String groundTimeSiz3;
    private String arrivalTimeSize3, departureTimeSize3;
    private String CityNameDestinationSize3_3, CityNameOroginsize3_3;
    private String CityNameDestination3_2, CityNameOroginSiz3_2;
    private String CityNameDestinationSize3_1, CityNameOroginSize3_1;
    private String additionalBaggageSiz2, cabinBaggageSize2;
    private String groundTimeSiz2;
    private String departureTimeSize2_, arrivalTimeSize2_;
    private String departureTimeSize2, arrivalTimeSize2;
    private String CityNameDestinationSize2_2, CityNameOroginSize2_2;
    private String CityNameDestinationSize2_1, CityNameOroginSize2_1;
    private String departureTimeAll4, arrivalTimeAll4;
    private String departureTimeAll3, arrivalTimeAll3;
    private String departureTime, arrivalTime;
    private String countryCodeDestnation1, countryCodeOrigin1;
    private String countryCodeOriginSize2_1, countryCodeDestnationSize2_1;
    private String countryCodeDestnationSize2_2, countryCodeOriginSize2_2, countryCodeOriginSize4_1,
            countryCodeDestnationSize4_1,
            countryCodeOriginSize4_2,
            countryCodeDestnationSize4_2,
            countryCodeOriginSize4_3,
            countryCodeDestnationSize4_3,
            countryCodeOriginSize4_4,
            countryCodeDestnationSize4_4, countryCodeOriginSize3_1,
            countryCodeDestnationSize3_1,
            countryCodeOriginSize3_2,
            countryCodeDestnationSize3_2,
            countryCodeOriginSize3_3, countryCodeDestnationSize3_3;
    private String flightNumberSize2_1;
    private String flightNumberSize2_2;
    private String flightNumberSize1, flightNumberSize3_1,
            flightNumberSize3_2,
            flightNumberSize3_3, flightNumberSize4_1,
            flightNumberSize4_2,
            flightNumberSize4_3,
            flightNumberSize4_4,
            countryNameOrogin1,
            countryNameDestination1,
            countryNameOroginSize2_1,
            countryNameDestinationSize2_1,
            countryNameOroginSize2_2,
            countryNameDestinationSize2_2,
            countryNameOroginSize3_1,
            countryNameDestinationSize3_1,
            countryNameOroginSize3_2,
            countryNameDestinationSize3_2,
            countryNameOroginSize3_3,
            countryNameDestinationSize3_3,
            countryNameOroginSize4_1,
            countryNameDestinationSize4_1,
            countryNameOroginSize4_2,
            countryNameDestinationSize4_2,
            countryNameOroginSize4_3,
            countryNameDestinationSize4_3,
            countryNameOroginSize4_4,
            countryNameDestinationSize4_4;
    private InputStream inputStream;
    private int sizeReturn;
    private String stringResourceByName;
    private String airlineCode   ,    airlineCode_return,
            CityNameOrogin1Return,
            CityNameDestination1Return,
            airlineReturn,
            arrivalTimeReturn,
            departureTimeReturn,
            departureTime_Return,
            arrivalTime_Return,
            groundTimeReturn,
            cabinBaggageReturn,
            additionalBaggageReturn,

    countryCodeOrigin1Return,
            countryCodeDestnation1Return,
            countryNameOrogin1Return,
            countryNameDestination1Return;
    private String flightNumberSize1Return;
    private String stringResourceByNameReturn
            ;
    private String bookingClass
            ;
    private String bookingClassReturn;
    private Retrofit retrofit;



    public ChooseFlightAdapter(Context context, List<SearchFlightsResponse.Result> ListResult
    ) {
        this.context = context;
        this.ListResult = ListResult;

    }


    @NonNull
    @Override
    public ChooseFlightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.choose_flight_row, parent, false);

        return new ChooseFlightViewHolder(view);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull ChooseFlightViewHolder holder, int position) {


//        inputStream = context.getResources().openRawResource(R.raw.airline_);
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//
//        try {
//
//            String data;
//
//            while ((data = reader.readLine()) != null) {
//
//                String[] split = data.split(",");
//
//                try {
//
//                    String airportCode = split[0];
//
//
//                    String airportName = split[1];
//
//
//                } catch (Exception e) {
//
//
//                }
//
//            }
//
//
//        } catch (Exception e) {
//
//
//        }


        SearchFlightsResponse.Result result = ListResult.get(position);


        double baseFare = result.getFare().getBaseFare();
        double tax = result.getFare().getTax();
        long serviceFee = result.getFare().getServiceFee();


        String resultId = result.getResultId();
        double totalFare = result.getFare().getTotalFare();

        String agentPreferredCurrency = result.getFare().getAgentPreferredCurrency();


        DecimalFormat df = new DecimalFormat("###.###");
        String format = df.format(totalFare);

        holder.tvTotalFare.setText(format + " " + agentPreferredCurrency);


        // one way
        List<SearchFlightsResponse.Segment> segments = result.getSegments().get(0);


        int journyTipe = SharedPreferencesManger.LoadIntegerData(context, "journyTipe");


        if (journyTipe == 2) {
            holder.relativeReturn.setVisibility(View.VISIBLE);


            List<SearchFlightsResponse.Segment> segmentsReturn = result.getSegments().get(1);

             sizeReturn = segmentsReturn.size();

            if (sizeReturn == 1) {

                flightNumberSize1Return = segmentsReturn.get(0).getFlightNumber();

                 airlineCode_return = "a" + segmentsReturn.get(0).getAirlineDetails().getAirlineCode().toLowerCase();
                bookingClassReturn = segmentsReturn.get(0).getBookingClass();


                holder.ivIconReturn.setImageResource(context.getResources().getIdentifier(airlineCode_return, "drawable", context.getPackageName()));


                holder.tvTransitReturn.setText("Direct");

                holder.tvTransitReturn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_trending_flat, 0, 0, 0);

                holder.from2Return.setVisibility(View.GONE);
                holder.to2Return.setVisibility(View.GONE);
                holder.from3Return.setVisibility(View.GONE);
                holder.to3Return.setVisibility(View.GONE);

                holder.fromt4Return.setVisibility(View.GONE);
                holder.to4Return.setVisibility(View.GONE);


                CityNameOrogin1Return = segmentsReturn.get(0).getOrigin().getCityName();
                  CityNameDestination1Return = segmentsReturn.get(0).getDestination().getCityName();



                holder.fromReturn.setText(CityNameOrogin1Return);
                holder.toReturn.setText(CityNameDestination1Return);



                airlineReturn = "A"+segmentsReturn.get(0).getAirlineDetails().getAirlineCode();


                 stringResourceByNameReturn = getStringResourceByName(airlineReturn);

                holder.tvAirlineReturn.setText(stringResourceByName);


                  arrivalTimeReturn = segmentsReturn.get(0).getArrivalTime();
                 departureTimeReturn = segmentsReturn.get(0).getDepartureTime();


                String[] ts = departureTimeReturn.split("T");
                 departureTime_Return = ts[1];

                String[] ts1 = arrivalTimeReturn.split("T");
                   arrivalTime_Return = ts1[1];
                holder.tvTimeOneReturn.setText(departureTime_Return + " ");
                holder.tvTimeTwoReturn.setText(" " + arrivalTime_Return);

                groundTimeReturn = segmentsReturn.get(0).getGroundTime();
                holder.tvTimeReturn.setText(groundTimeReturn);

                holder.tvTotalFareReturn.setVisibility(View.GONE);


                cabinBaggageReturn = (String) segmentsReturn.get(0).getCabinBaggage();
                additionalBaggageReturn = (String) segmentsReturn.get(0).getAdditionalBaggage();

                holder.tvKgReturn.setText(additionalBaggageReturn);
                holder.tvKiloG2Return.setText(cabinBaggageReturn);



                countryCodeOrigin1Return = segmentsReturn.get(0).getOrigin().getCountryCode();

                countryCodeDestnation1Return = segmentsReturn.get(0).getDestination().getCountryCode();

                countryNameOrogin1Return = segmentsReturn.get(0).getOrigin().getCountryName();

                countryNameDestination1Return = segmentsReturn.get(0).getDestination().getCountryName();



            }else if (sizeReturn==2){



            }


        }




        int size = segments.size();

        if (size == 1) {



            // flight number
             bookingClass = segments.get(0).getBookingClass();
            flightNumberSize1 = segments.get(0).getFlightNumber();

            countryCodeOrigin1 = segments.get(0).getOrigin().getCountryCode();

            countryCodeDestnation1 = segments.get(0).getDestination().getCountryCode();


            airline ="A"+ segments.get(0).getAirlineDetails().getAirlineCode();


             stringResourceByName = getStringResourceByName(airline);


            CityNameOrogin1 = segments.get(0).getOrigin().getCityName();
            CityNameDestination1 = segments.get(0).getDestination().getCityName();
             airlineCode = "a" + segments.get(0).getAirlineDetails().getAirlineCode().toLowerCase();


            holder.ivIcon.setImageResource(context.getResources().getIdentifier(airlineCode, "drawable", context.getPackageName()));


            holder.tvTransit.setText("Direct");
            holder.tvTransit.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_trending_flat, 0, 0, 0);

//          or

            countryNameOrogin1 = segments.get(0).getOrigin().getCountryName();

            countryNameDestination1 = segments.get(0).getDestination().getCountryName();


            holder.tvBeirut.setText(CityNameOrogin1);
            holder.tvKuwait.setText(CityNameDestination1);
            holder.tvAirline.setText(stringResourceByName);
            holder.from2.setVisibility(View.GONE);
            holder.to2.setVisibility(View.GONE);
            holder.from3.setVisibility(View.GONE);
            holder.to3.setVisibility(View.GONE);

            holder.from4.setVisibility(View.GONE);
            holder.to4.setVisibility(View.GONE);

            arrivalTime = segments.get(0).getArrivalTime();
            departureTime = segments.get(0).getDepartureTime();


            String[] ts = departureTime.split("T");
            departureTime_ = ts[1];

            String[] ts1 = arrivalTime.split("T");
            arrivalTime_ = ts1[1];
            holder.tvTimeOne.setText(departureTime_ + " ");
            holder.tvTimeTwo.setText(" " + arrivalTime_);


            groundTime = segments.get(0).getGroundTime();

            holder.tvTime.setText(groundTime);


            cabinBaggage = (String) segments.get(0).getCabinBaggage();
            additionalBaggage = (String) segments.get(0).getAdditionalBaggage();

            holder.tvKg.setText(additionalBaggage);
            holder.tvKiloG2.setText(cabinBaggage);


        } else if (size == 2) {


            flightNumberSize2_1 = segments.get(0).getFlightNumber();
            flightNumberSize2_2 = segments.get(1).getFlightNumber();


            countryCodeOriginSize2_1 = segments.get(0).getOrigin().getCountryCode();

            countryCodeDestnationSize2_1 = segments.get(0).getDestination().getCountryCode();


            countryCodeOriginSize2_2 = segments.get(1).getOrigin().getCountryCode();

            countryCodeDestnationSize2_2 = segments.get(1).getDestination().getCountryCode();

            CityNameOroginSize2_1 = segments.get(0).getOrigin().getCityName();
            CityNameDestinationSize2_1 = segments.get(0).getDestination().getCityName();


            countryNameOroginSize2_1 = segments.get(0).getOrigin().getCountryName();
            countryNameDestinationSize2_1 = segments.get(0).getDestination().getCountryName();


            countryNameOroginSize2_2 = segments.get(1).getOrigin().getCountryName();
            countryNameDestinationSize2_2 = segments.get(1).getDestination().getCountryName();

            holder.tvTransit.setText("Transit");
            holder.tvBeirut.setText(CityNameOroginSize2_1);
            holder.tvKuwait.setText(CityNameDestinationSize2_1);
            holder.tvAirline.setText(airline);


            CityNameOroginSize2_2 = segments.get(1).getOrigin().getCityName();
            CityNameDestinationSize2_2 = segments.get(1).getDestination().getCityName();


            holder.from2.setText(CityNameOroginSize2_2);
            holder.to2.setText(CityNameDestinationSize2_2);


            holder.from3.setVisibility(View.GONE);
            holder.to3.setVisibility(View.GONE);
            holder.from4.setVisibility(View.GONE);
            holder.to4.setVisibility(View.GONE);

            arrivalTimeSize2 = segments.get(0).getArrivalTime();
            departureTimeSize2 = segments.get(1).getDepartureTime();


            String[] ts = departureTimeSize2.split("T");
            arrivalTimeSize2_ = ts[1];

            String[] ts1 = arrivalTimeSize2.split("T");
            departureTimeSize2_ = ts1[1];
            holder.tvTimeOne.setText(arrivalTimeSize2_ + " ");
            holder.tvTimeTwo.setText(" " + departureTimeSize2_);
            groundTimeSiz2 = segments.get(1).getGroundTime();

            holder.tvTime.setText(groundTimeSiz2);


            cabinBaggageSize2 = (String) segments.get(1).getCabinBaggage();
            additionalBaggageSiz2 = (String) segments.get(1).getAdditionalBaggage();

            holder.tvKg.setText(additionalBaggageSiz2);
            holder.tvKiloG2.setText(cabinBaggageSize2);


        } else if (size == 3) {

            flightNumberSize3_1 = segments.get(0).getFlightNumber();
            flightNumberSize3_2 = segments.get(1).getFlightNumber();
            flightNumberSize3_3 = segments.get(2).getFlightNumber();


            countryCodeOriginSize3_1 = segments.get(0).getOrigin().getCountryCode();

            countryCodeDestnationSize3_1 = segments.get(0).getDestination().getCountryCode();


            countryCodeOriginSize3_2 = segments.get(1).getOrigin().getCountryCode();

            countryCodeDestnationSize3_2 = segments.get(1).getDestination().getCountryCode();


            countryCodeOriginSize3_3 = segments.get(1).getOrigin().getCountryCode();

            countryCodeDestnationSize3_3 = segments.get(1).getDestination().getCountryCode();


            CityNameOroginSize3_1 = segments.get(0).getOrigin().getCityName();
            CityNameDestinationSize3_1 = segments.get(0).getDestination().getCityName();

            holder.tvTransit.setText("Transit");
            holder.tvBeirut.setText(CityNameOroginSize3_1);
            holder.tvKuwait.setText(CityNameDestinationSize3_1);
            holder.tvAirline.setText(airline);


            CityNameOroginSiz3_2 = segments.get(1).getOrigin().getCityName();
            CityNameDestination3_2 = segments.get(1).getDestination().getCityName();


            holder.from2.setText(CityNameOroginSiz3_2);
            holder.to2.setText(CityNameDestination3_2);


            CityNameOroginsize3_3 = segments.get(2).getOrigin().getCityName();
            CityNameDestinationSize3_3 = segments.get(2).getDestination().getCityName();


            countryNameOroginSize3_1 = segments.get(0).getOrigin().getCountryName();
            countryNameDestinationSize3_1 = segments.get(0).getDestination().getCountryName();


            countryNameOroginSize3_2 = segments.get(1).getOrigin().getCountryName();
            countryNameDestinationSize3_2 = segments.get(1).getDestination().getCountryName();


            countryNameOroginSize3_3 = segments.get(2).getOrigin().getCountryName();
            countryNameDestinationSize3_3 = segments.get(2).getDestination().getCountryName();


            holder.from3.setText(CityNameOroginsize3_3 + " - ");
            holder.to3.setText(CityNameDestinationSize3_3);

//
            arrivalTimeAll3 = segments.get(0).getArrivalTime();
            departureTimeAll3 = segments.get(2).getDepartureTime();


            String[] ts = departureTimeAll3.split("T");
            departureTimeSize3 = ts[1];

            String[] ts1 = arrivalTimeAll3.split("T");
            arrivalTimeSize3 = ts1[1];
            holder.tvTimeOne.setText(departureTimeSize3 + " ");
            holder.tvTimeTwo.setText(" " + arrivalTimeSize3);
            holder.from4.setVisibility(View.GONE);
            holder.to4.setVisibility(View.GONE);
            groundTimeSiz3 = segments.get(2).getGroundTime();

            holder.tvTime.setText(groundTimeSiz3);


            cabinBaggageSize3 = (String) segments.get(2).getCabinBaggage();
            additionalBaggageSize3 = (String) segments.get(2).getAdditionalBaggage();

            holder.tvKg.setText(additionalBaggageSize3);
            holder.tvKiloG2.setText(cabinBaggageSize3);


        } else if (size == 4) {

            flightNumberSize4_1 = segments.get(0).getFlightNumber();
            flightNumberSize4_2 = segments.get(1).getFlightNumber();
            flightNumberSize4_3 = segments.get(2).getFlightNumber();
            flightNumberSize4_4 = segments.get(3).getFlightNumber();

            countryCodeOriginSize4_1 = segments.get(0).getOrigin().getCountryCode();

            countryCodeDestnationSize4_1 = segments.get(0).getDestination().getCountryCode();


            countryCodeOriginSize4_2 = segments.get(1).getOrigin().getCountryCode();

            countryCodeDestnationSize4_2 = segments.get(1).getDestination().getCountryCode();


            countryCodeOriginSize4_3 = segments.get(1).getOrigin().getCountryCode();

            countryCodeDestnationSize4_3 = segments.get(1).getDestination().getCountryCode();


            countryCodeOriginSize4_4 = segments.get(1).getOrigin().getCountryCode();

            countryCodeDestnationSize4_4 = segments.get(1).getDestination().getCountryCode();


            groundTimeSiz4 = segments.get(3).getGroundTime();

            holder.tvTime.setText(groundTimeSiz4);


            CityNameOroginSiz4_1 = segments.get(0).getOrigin().getCityName();
            CityNameDestinationSiz4_1 = segments.get(0).getDestination().getCityName();

            holder.tvTransit.setText("Transit");
            holder.tvBeirut.setText(CityNameOroginSiz4_1);
            holder.tvKuwait.setText(CityNameDestinationSiz4_1);
            holder.tvAirline.setText(airline);


            CityNameOroginSiz4_2 = segments.get(1).getOrigin().getCityName();
            CityNameDestinationSiz4_2 = segments.get(1).getDestination().getCityName();


            holder.from2.setText(CityNameOroginSiz4_2);
            holder.to2.setText(CityNameDestinationSiz4_2);


            CityNameOroginSiz4_3 = segments.get(2).getOrigin().getCityName();
            CityNameDestinationSiz4_3 = segments.get(2).getDestination().getCityName();


            holder.from3.setText(CityNameOroginSiz4_3 + " - ");
            holder.to3.setText(CityNameDestinationSiz4_3);


            arrivalTimeAll4 = segments.get(0).getArrivalTime();
            departureTimeAll4 = segments.get(2).getDepartureTime();


            String[] ts = departureTimeAll4.split("T");
            departureTimeSiz4 = ts[1];

            String[] ts1 = arrivalTimeAll4.split("T");
            arrivalTimeSiz4 = ts1[1];
            holder.tvTimeOne.setText(departureTimeSiz4 + " ");
            holder.tvTimeTwo.setText(" " + arrivalTimeSiz4);


            CityNameOroginSiz4_4 = segments.get(3).getOrigin().getCityName();
            CityNameDestinationSiz4_4 = segments.get(3).getDestination().getCityName();


            countryNameOroginSize4_1 = segments.get(0).getOrigin().getCountryName();
            countryNameDestinationSize4_1 = segments.get(0).getDestination().getCountryName();


            countryNameOroginSize4_2 = segments.get(1).getOrigin().getCountryName();
            countryNameDestinationSize4_2 = segments.get(1).getDestination().getCountryName();


            countryNameOroginSize4_3 = segments.get(2).getOrigin().getCountryName();
            countryNameDestinationSize4_3 = segments.get(2).getDestination().getCountryName();


            countryNameOroginSize4_4 = segments.get(3).getOrigin().getCountryName();
            countryNameDestinationSize4_4 = segments.get(3).getDestination().getCountryName();


            holder.from4.setText(CityNameOroginSiz4_4);
            holder.to4.setText(CityNameDestinationSiz4_4);


            cabinBaggageSiz4_4 = (String) segments.get(3).getCabinBaggage();
            additionalBaggageSiz4_4 = (String) segments.get(3).getAdditionalBaggage();

            holder.tvKg.setText(additionalBaggageSiz4_4);
            holder.tvKiloG2.setText(cabinBaggageSiz4_4);

        } else if (size == 5) {
            holder.tvTransit.setText("Transit");


        }

//
//        String arrivalTime = segments.get(0).getArrivalTime();
//        String departureTime = segments.get(0).getDepartureTime();
//
//
//        String[] ts = departureTime.split("T");
//        String t = ts[1];
//
//        String[] ts1 = arrivalTime.split("T");
//        String s = ts1[1];
//        holder.tvTimeOne.setText(t + " ");
//        holder.tvTimeTwo.setText(" " + s);


//        String airlin_name = airLineName.get(position);
//
//
////        if (airLineName.size()==0){
////            holder.tvAirline.setText("Not Available right now");
////        }else {
//
//        holder.tvAirline.setText(airlin_name);
//
////        }
//        String duration = Listduration.get(position);
//        holder.tvTime.setText(duration);
//
//        String CabinBaggage = listCabinBaggage.get(position);
//
//        Double totlalPrice = listTotalFare.get(position);
//
//        String typeFare = listTypeFare.get(position);
//
//        DecimalFormat df = new DecimalFormat("###.###");
//
//
//        holder.tvTotalFare.setText("" + df.format(totlalPrice) + " " + typeFare);
//        String IncludedBaggage = listIncludedBaggage.get(position);
//
//        holder.tvKiloG2.setText(" " + CabinBaggage);
//        holder.tvKg.setText(" " + IncludedBaggage);
//        String deTime = depuruerTime.get(position);
//        String arrTime = arriveTime.get(position);
//
//        String destination = countryNameDestinationList.get(position);
//        String origin = countryNameOriginList.get(position);
//
//
//
//        switch (sizeSegments){
//
//
//            case 1 :
//                holder.tvBeirut.setText(origin);
//
//                holder.tvKuwait.setText(destination);
//                holder.to2.setVisibility(View.GONE);
//                holder.from2.setVisibility(View.GONE);
//                holder.to3.setVisibility(View.GONE);
//                holder.from3.setVisibility(View.GONE);
//                break;
//
//            case 2 :
//
//                holder.tvBeirut.setText(origin);
//                holder.tvKuwait.setText(destination);
//
//                holder.to2.setVisibility(View.VISIBLE);
//                holder.from2.setVisibility(View.VISIBLE);
//                holder.from2.setText(origin);
//                holder.to2.setText(destination);
//            break;
//
//            case 3 :
//
//                holder.tvBeirut.setText(origin);
//                holder.tvKuwait.setText(destination);
//
//                holder.to2.setVisibility(View.VISIBLE);
//                holder.from2.setVisibility(View.VISIBLE);
//                holder.to3.setVisibility(View.VISIBLE);
//                holder.from3.setVisibility(View.VISIBLE);
//                holder.from2.setText(origin);
//                holder.to2.setText(destination);
//                holder.to3.setText(destination);
//                holder.from3.setText(origin);
//                break;
//
//
//        }
//
//        holder.tvBeirut.setText(origin);
//        holder.tvKuwait.setText(destination);
//
//
//        String[] ts = deTime.split("T");
//        String t = ts[1];
//
//        String[] ts1 = arrTime.split("T");
//        String s = ts1[1];
//        holder.tvTimeOne.setText(t + " ");
//        holder.tvTimeTwo.setText(" " + s);
//
//
//        String Distnation = ListairportCode_Distnation.get(position);
//
//        String Origin = ListairportCode_Origin.get(position);
//
//
//        String flightNumber = ListflightNumber.get(position);
//
//
//        String mealType = ListMealType.get(position);
//

        //  long noOfSetAvaliable = listnoSetAv.get(position);
        holder.selectFlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(context, FlightsSummary.class);


                SharedPreferencesManger.SaveData(context, "resultId", resultId);



                SharedPreferencesManger.SaveData(context, "totalFare", format + " " + agentPreferredCurrency);


                SharedPreferencesManger.SaveData(context, "baseFare", String.valueOf(baseFare));
                SharedPreferencesManger.SaveData(context, "tax", String.valueOf(tax));
                SharedPreferencesManger.SaveData(context, "serviceFee", String.valueOf(serviceFee));



                SharedPreferencesManger.SaveData(context, "size", size);
                SharedPreferencesManger.SaveData(context, "sizeReturn", sizeReturn);





                if (size == 1||sizeReturn==1) {

                    SharedPreferencesManger.SaveData(context, "bookingClass", bookingClass);

                    SharedPreferencesManger.SaveData(context, "logoOneWaySize1", airlineCode);

                    SharedPreferencesManger.SaveData(context, "airline", stringResourceByName);

                    SharedPreferencesManger.SaveData(context, "countryNameOrogin1", countryNameOrogin1);

                    SharedPreferencesManger.SaveData(context, "countryNameDestination1", countryNameDestination1);

                    SharedPreferencesManger.SaveData(context, "cabinBaggage", cabinBaggage);

                    SharedPreferencesManger.SaveData(context, "CityNameDestination1", CityNameDestination1);

                    SharedPreferencesManger.SaveData(context, "CityNameOrogin1", CityNameOrogin1);


                    SharedPreferencesManger.SaveData(context, "groundTime", groundTime);

                    SharedPreferencesManger.SaveData(context, "direct", "Direct");

                    SharedPreferencesManger.SaveData(context, "additionalBaggage", additionalBaggage);


                    SharedPreferencesManger.SaveData(context, "flightNumberSize1", flightNumberSize1);

                    SharedPreferencesManger.SaveData(context, "departureTime", departureTime);

                    SharedPreferencesManger.SaveData(context, "arrivalTime", arrivalTime);

                    SharedPreferencesManger.SaveData(context, "countryCodeDestnation1", countryCodeDestnation1);

                    SharedPreferencesManger.SaveData(context, "countryCodeOrigin1", countryCodeOrigin1);


///
                    SharedPreferencesManger.SaveData(context, "countryNameOrogin1Return", countryNameOrogin1Return);

                    SharedPreferencesManger.SaveData(context, "countryNameDestination1Return", countryNameDestination1Return);

                    SharedPreferencesManger.SaveData(context, "cabinBaggageReturn", cabinBaggageReturn);

                    SharedPreferencesManger.SaveData(context, "CityNameDestination1Return", CityNameDestination1Return);

                    SharedPreferencesManger.SaveData(context, "CityNameOrogin1Return", CityNameOrogin1Return);


                    SharedPreferencesManger.SaveData(context, "groundTimeReturn", groundTimeReturn);

                    SharedPreferencesManger.SaveData(context, "directReturn", "Direct");

                    SharedPreferencesManger.SaveData(context, "additionalBaggageReturn", additionalBaggageReturn);


                    SharedPreferencesManger.SaveData(context, "flightNumberSize1Return", flightNumberSize1Return);

                    SharedPreferencesManger.SaveData(context, "departureTimeReturn", departureTimeReturn);

                    SharedPreferencesManger.SaveData(context, "arrivalTimeReturn", arrivalTimeReturn);

                    SharedPreferencesManger.SaveData(context, "countryCodeDestnation1Return", countryCodeDestnation1Return);

                    SharedPreferencesManger.SaveData(context, "countryCodeOrigin1Return", countryCodeOrigin1Return);

                    SharedPreferencesManger.SaveData(context, "airlineReturn", stringResourceByNameReturn);
                    SharedPreferencesManger.SaveData(context, "bookingClassReturn", bookingClassReturn);
                    SharedPreferencesManger.SaveData(context, "airlineCode_return", airlineCode_return);





                } else if (size == 2||sizeReturn==2) {


                    SharedPreferencesManger.SaveData(context, "countryNameOroginSize2_1", countryNameOroginSize2_1);

                    SharedPreferencesManger.SaveData(context, "countryNameDestinationSize2_1", countryNameDestinationSize2_1);


                    SharedPreferencesManger.SaveData(context, "countryNameOroginSize2_2", countryNameOroginSize2_2);

                    SharedPreferencesManger.SaveData(context, "countryNameDestinationSize2_2", countryNameDestinationSize2_2);


                    SharedPreferencesManger.SaveData(context, "CityNameDestinationSize2_1", CityNameDestinationSize2_1);

                    SharedPreferencesManger.SaveData(context, "CityNameOroginSize2_1", CityNameOroginSize2_1);


                    SharedPreferencesManger.SaveData(context, "CityNameDestinationSize2_2", CityNameDestinationSize2_2);

                    SharedPreferencesManger.SaveData(context, "CityNameOroginSize2_2", CityNameOroginSize2_2);


                    SharedPreferencesManger.SaveData(context, "cabinBaggageSize2", cabinBaggageSize2);

                    SharedPreferencesManger.SaveData(context, "direct", "Transit");


                    SharedPreferencesManger.SaveData(context, "groundTimeSiz2", groundTimeSiz2);

                    SharedPreferencesManger.SaveData(context, "flightNumberSize2_1", flightNumberSize2_1);
                    SharedPreferencesManger.SaveData(context, "flightNumberSize2_1", flightNumberSize2_2);


                    SharedPreferencesManger.SaveData(context, "departureTimeSize2", departureTimeSize2);

                    SharedPreferencesManger.SaveData(context, "arrivalTimeSize2", arrivalTimeSize2);

//                    code country
                    SharedPreferencesManger.SaveData(context, "countryCodeDestnationSize2_1", countryCodeDestnationSize2_1);
                    SharedPreferencesManger.SaveData(context, "countryCodeOriginSize2_1", countryCodeOriginSize2_1);
                    SharedPreferencesManger.SaveData(context, "countryCodeDestnationSize2_2", countryCodeDestnationSize2_2);
                    SharedPreferencesManger.SaveData(context, "countryCodeOriginSize2_2", countryCodeOriginSize2_2);
                    SharedPreferencesManger.SaveData(context, "additionalBaggageSiz2", additionalBaggageSiz2);

                } else if (size == 3) {


                    SharedPreferencesManger.SaveData(context, "countryNameOroginSize3_1", countryNameOroginSize3_1);

                    SharedPreferencesManger.SaveData(context, "countryNameDestinationSize3_1", countryNameDestinationSize3_1);


                    SharedPreferencesManger.SaveData(context, "countryNameOroginSize3_2", countryNameOroginSize3_2);

                    SharedPreferencesManger.SaveData(context, "countryNameDestinationSize3_2", countryNameDestinationSize3_2);


                    SharedPreferencesManger.SaveData(context, "countryNameOroginSize3_3", countryNameOroginSize3_3);

                    SharedPreferencesManger.SaveData(context, "countryNameDestinationSize3_3", countryNameDestinationSize3_3);


                    SharedPreferencesManger.SaveData(context, "CityNameDestinationSize3_1", CityNameDestinationSize3_1);

                    SharedPreferencesManger.SaveData(context, "CityNameOroginSize3_1", CityNameOroginSize3_1);


                    SharedPreferencesManger.SaveData(context, "CityNameDestination3_2", CityNameDestination3_2);

                    SharedPreferencesManger.SaveData(context, "CityNameOroginSiz3_2", CityNameOroginSiz3_2);

                    SharedPreferencesManger.SaveData(context, "CityNameDestinationSize3_3", CityNameDestinationSize3_3);

                    SharedPreferencesManger.SaveData(context, "CityNameOroginsize3_3", CityNameOroginsize3_3);

                    SharedPreferencesManger.SaveData(context, "cabinBaggageSize3", cabinBaggageSize3);

                    SharedPreferencesManger.SaveData(context, "direct", "Transit");
                    SharedPreferencesManger.SaveData(context, "flightNumberSize2_1", flightNumberSize3_1);
                    SharedPreferencesManger.SaveData(context, "flightNumberSize2_1", flightNumberSize3_2);
                    SharedPreferencesManger.SaveData(context, "flightNumberSize2_1", flightNumberSize3_3);
                    SharedPreferencesManger.SaveData(context, "groundTimeSiz3", groundTimeSiz3);


                    SharedPreferencesManger.SaveData(context, "departureTimeAll3", departureTimeAll3);
                    SharedPreferencesManger.SaveData(context, "arrivalTimeAll3", arrivalTimeAll3);


//                    code country
                    SharedPreferencesManger.SaveData(context, "countryCodeDestnationSize3_1", countryCodeDestnationSize3_1);
                    SharedPreferencesManger.SaveData(context, "countryCodeOriginSize3_1", countryCodeOriginSize3_1);
                    SharedPreferencesManger.SaveData(context, "countryCodeDestnationSize3_2", countryCodeDestnationSize3_2);
                    SharedPreferencesManger.SaveData(context, "countryCodeOriginSize3_2", countryCodeOriginSize3_2);

                    SharedPreferencesManger.SaveData(context, "countryCodeDestnationSize3_2", countryCodeDestnationSize3_3);
                    SharedPreferencesManger.SaveData(context, "countryCodeOriginSize3_2", countryCodeOriginSize3_3);
                    SharedPreferencesManger.SaveData(context, "additionalBaggageSize3", additionalBaggageSize3);


                } else if (size == 4) {
                    SharedPreferencesManger.SaveData(context, "groundTimeSiz4", groundTimeSiz4);

                    SharedPreferencesManger.SaveData(context, "flightNumberSize2_1", flightNumberSize4_1);
                    SharedPreferencesManger.SaveData(context, "flightNumberSize2_1", flightNumberSize4_2);
                    SharedPreferencesManger.SaveData(context, "flightNumberSize2_1", flightNumberSize4_3);
                    SharedPreferencesManger.SaveData(context, "flightNumberSize2_1", flightNumberSize4_4);

                    SharedPreferencesManger.SaveData(context, "direct", "Transit");

                    SharedPreferencesManger.SaveData(context, "departureTimeAll4", departureTimeAll4);

                    SharedPreferencesManger.SaveData(context, "arrivalTimeAll4", arrivalTimeAll4);
                    SharedPreferencesManger.SaveData(context, "cabinBaggageSiz4_4", cabinBaggageSiz4_4);

                    SharedPreferencesManger.SaveData(context, "additionalBaggageSiz4_4", additionalBaggageSiz4_4);


//                    code country
                    SharedPreferencesManger.SaveData(context, "countryCodeDestnationSize4_1", countryCodeDestnationSize4_1);
                    SharedPreferencesManger.SaveData(context, "countryCodeOriginSize4_1", countryCodeOriginSize4_1);

                    SharedPreferencesManger.SaveData(context, "countryCodeDestnationSize4_2", countryCodeDestnationSize4_2);
                    SharedPreferencesManger.SaveData(context, "countryCodeOriginSize4_2", countryCodeOriginSize4_2);

                    SharedPreferencesManger.SaveData(context, "countryCodeDestnationSize4_3", countryCodeDestnationSize4_3);
                    SharedPreferencesManger.SaveData(context, "countryCodeOriginSize4_3", countryCodeOriginSize4_3);

                    SharedPreferencesManger.SaveData(context, "countryCodeDestnationSize4_3", countryCodeDestnationSize4_4);
                    SharedPreferencesManger.SaveData(context, "countryCodeOriginSize4_3", countryCodeOriginSize4_4);

                    SharedPreferencesManger.SaveData(context, "CityNameDestinationSiz4_1", CityNameDestinationSiz4_1);

                    SharedPreferencesManger.SaveData(context, "CityNameOroginSiz4_1", CityNameOroginSiz4_1);


                    SharedPreferencesManger.SaveData(context, "CityNameDestinationSiz4_2", CityNameDestinationSiz4_2);

                    SharedPreferencesManger.SaveData(context, "CityNameOroginSiz4_2", CityNameOroginSiz4_2);


                    SharedPreferencesManger.SaveData(context, "CityNameDestinationSiz4_3", CityNameDestinationSiz4_3);

                    SharedPreferencesManger.SaveData(context, "CityNameOroginSiz4_3", CityNameOroginSiz4_3);

                    SharedPreferencesManger.SaveData(context, "CityNameDestinationSiz4_4", CityNameDestinationSiz4_4);

                    SharedPreferencesManger.SaveData(context, "CityNameOroginSiz4_4", CityNameOroginSiz4_4);


                    SharedPreferencesManger.SaveData(context, "countryNameOroginSize4_1", countryNameOroginSize4_1);

                    SharedPreferencesManger.SaveData(context, "countryNameDestinationSize4_1", countryNameDestinationSize4_1);


                    SharedPreferencesManger.SaveData(context, "countryNameOroginSize4_2", countryNameOroginSize4_2);

                    SharedPreferencesManger.SaveData(context, "countryNameDestinationSize4_2", countryNameDestinationSize4_2);


                    SharedPreferencesManger.SaveData(context, "countryNameOroginSize4_3", countryNameOroginSize4_3);

                    SharedPreferencesManger.SaveData(context, "countryNameDestinationSize4_3", countryNameDestinationSize4_3);


                    SharedPreferencesManger.SaveData(context, "countryNameOroginSize4_4", countryNameOroginSize4_4);

                    SharedPreferencesManger.SaveData(context, "countryNameDestinationSize4_4", countryNameDestinationSize4_4);


                }


//                SharedPreferencesManger.SaveData(context, "Distnation", Distnation);
//                SharedPreferencesManger.SaveData(context, "Origin", Origin);
//
//                SharedPreferencesManger.SaveData(context, "depuruerTime", t);
//                SharedPreferencesManger.SaveData(context, "arriveTime", s);
//
//
//                SharedPreferencesManger.SaveData(context, "A_TotalFare", df.format(totlalPrice));
//                SharedPreferencesManger.SaveData(context, "A_typeFare", typeFare);
//
//                SharedPreferencesManger.SaveData(context, "A_airlin_name", airlin_name);
//                SharedPreferencesManger.SaveData(context, "A_duration", duration);
//
//                //
//                SharedPreferencesManger.SaveData(context, "A_CabinBaggage", CabinBaggage);
//                SharedPreferencesManger.SaveData(context, "A_IncludedBaggage", IncludedBaggage);
//
//                SharedPreferencesManger.SaveData(context, "A_deTime", deTime);
//                SharedPreferencesManger.SaveData(context, "A_arrTime", arrTime);
//
//                SharedPreferencesManger.SaveData(context, "A_destination", destination);
//                SharedPreferencesManger.SaveData(context, "A_origin", origin);
//
//                SharedPreferencesManger.SaveData(context, "flightNumber", flightNumber);
//                SharedPreferencesManger.SaveData(context, "noOfSetAvaliable", noOfSetAvaliable);
//                SharedPreferencesManger.SaveData(context, "TotalFare", df.format(totlalPrice));
//                SharedPreferencesManger.SaveData(context, "typeFare", typeFare);


                if (size == 1) {

                    context.startActivity(intent);

                } else {


                    Toast.makeText(context, "Flight Available Just For Direct New ", Toast.LENGTH_SHORT).show();
                }


//                 intent to payment use it later
//                Intent intent = new Intent(context, PaymentActivity.class);
//                intent.putExtra("mId", 3);


                // context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return ListResult.size();
    }

    public class ChooseFlightViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.select_flight)
        Button selectFlight;
        @BindView(R.id.tv_TotalFare)
        TextView tvTotalFare;
        @BindView(R.id.tvKiloG2)
        TextView tvKiloG2;
        @BindView(R.id.iv_icon)
        CircleImageView ivIcon;
        @BindView(R.id.tv_airline)
        TextView tvAirline;
        @BindView(R.id.tv_time_one)
        TextView tvTimeOne;
        @BindView(R.id.tv_text)
        TextView tvText;
        @BindView(R.id.tv_time_two)
        TextView tvTimeTwo;
        @BindView(R.id.tv_beirut)
        TextView tvBeirut;

        @BindView(R.id.tv_kuwait)
        TextView tvKuwait;


        @BindView(R.id.iv_bag)
        ImageView ivBag;
        @BindView(R.id.tv_kg)
        TextView tvKg;
        @BindView(R.id.relative_bag)
        RelativeLayout relativeBag;
        @BindView(R.id.iv_bag2)
        ImageView ivBag2;
        @BindView(R.id.iv_star)
        ImageView ivStar;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_transit)
        TextView tvTransit;
        //        @BindView(R.id.spinner_dollar)
//        Spinner spinnerDollar;
        @BindView(R.id.relative_country1)
        RelativeLayout relativeCountry1;

        @BindView(R.id.relative_country1_return)
        RelativeLayout relativeReturn;
        @BindView(R.id.tv_kuwait2)
        TextView from2;
        @BindView(R.id.tv_bubai)
        TextView to2;
        @BindView(R.id.tv_bubai2)
        TextView to3;
        @BindView(R.id.tv_kuwait3)
        TextView from3;


        @BindView(R.id.tv_kuwait4)
        TextView from4;
        @BindView(R.id.tv_bubai3)
        TextView to4;
        @BindView(R.id.tv_airline_return)
        TextView tvAirlineReturn;
        @BindView(R.id.tv_time_one_return)
        TextView tvTimeOneReturn;
        @BindView(R.id.tv_time_two_return)
        TextView tvTimeTwoReturn;
        @BindView(R.id.tv_beirut_return)
        TextView fromReturn;
        @BindView(R.id.tv_kuwait_return)
        TextView toReturn;
        @BindView(R.id.tv_kuwait2_return)
        TextView from2Return;
        @BindView(R.id.tv_bubai_return)
        TextView to2Return;
        @BindView(R.id.tv_bubai2_return)
        TextView to3Return;
        @BindView(R.id.tv_kuwait3_return)
        TextView from3Return;
        @BindView(R.id.tv_kuwait4_return)
        TextView fromt4Return;
        @BindView(R.id.tv_bubai3_return)
        TextView to4Return;
        @BindView(R.id.tv_kg_return)
        TextView tvKgReturn;
        @BindView(R.id.tvKiloG2_return)
        TextView tvKiloG2Return;
        @BindView(R.id.iv_star_return)
        ImageView ivStarReturn;
        @BindView(R.id.tv_time_return)
        TextView tvTimeReturn;
        @BindView(R.id.tv_transit_return)
        TextView tvTransitReturn;
        @BindView(R.id.tv_TotalFare_return)
        TextView tvTotalFareReturn;

        @BindView(R.id.iv_icon_return)
        CircleImageView ivIconReturn;
        public ChooseFlightViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

        }
    }


    private String getStringResourceByName(String aString) {
        String packageName = context.getPackageName();
        int resId = context.getResources().getIdentifier(aString, "string", packageName);
        return context.getString(resId);
    }
}
