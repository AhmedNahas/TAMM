package net.middledleeast.tamm.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.PassengerInformation;
import net.middledleeast.tamm.activities.Passenger_inform;
import net.middledleeast.tamm.activities.PaymentActivity;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseFlightAdapter extends RecyclerView.Adapter<ChooseFlightAdapter.ChooseFlightViewHolder> {



    private Context context;
    private List<String> airLineName;
    List<String> Listduration;
    private List<String> arriveTime;
    List<String> depuruerTime;
    List<String> countryNameOriginList;
    List<String> countryNameDestinationList;

    List<String> listIncludedBaggage;
    List<String> listCabinBaggage;
    List<Double> listTotalFare;
    List<String> listTypeFare;


    public ChooseFlightAdapter(Context context, List<String> airLineName, List<String> Listduration, List<String> arriveTime, List<String> depuruerTime,
                               List<String> countryNameDestinationList, List<String> countryNameOriginList, List<String> listIncludedBaggage,
                               List<String> listCabinBaggage, List<Double> listTotalFare, List<String> listTypeFare
    ) {
        this.context = context;
        this.airLineName = airLineName;
        this.Listduration = Listduration;
        this.arriveTime = arriveTime;
        this.depuruerTime = depuruerTime;
        this.countryNameOriginList = countryNameOriginList;
        this.countryNameDestinationList = countryNameDestinationList;
        this.listIncludedBaggage = listIncludedBaggage;
        this.listCabinBaggage = listCabinBaggage;
        this.listTotalFare = listTotalFare;
        this.listTypeFare = listTypeFare;
    }


    @NonNull
    @Override
    public ChooseFlightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.choose_flight_row, parent, false);

        return new ChooseFlightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseFlightViewHolder holder, int position) {

        String fees = airLineName.get(position);
        String duration = Listduration.get(position);
        holder.tvTime.setText(duration);

        String CabinBaggage = listCabinBaggage.get(position);

        Double totlalPrice = listTotalFare.get(position);

        String typeFare = listTypeFare.get(position);

        DecimalFormat df = new DecimalFormat("###.###");


        holder.tvTotalFare.setText("" + df.format(totlalPrice) + " " + typeFare);
        String IncludedBaggage = listIncludedBaggage.get(position);

        holder.tvKiloG2.setText(" " + CabinBaggage);
        holder.tvKg.setText(" " + IncludedBaggage);
        String deTime = depuruerTime.get(position);
        String arrTime = arriveTime.get(position);

        String destination = countryNameDestinationList.get(position);
        String origin = countryNameOriginList.get(position);

        holder.tvBeirut.setText(origin);
        holder.tvKuwait2.setText(destination);


        String[] ts = deTime.split("T");
        String t = ts[1];

        String[] ts1 = arrTime.split("T");
        String s = ts1[1];
        holder.tvTimeOne.setText(t + " ");
        holder.tvTimeTwo.setText(" " + s);

        holder.tvAirline.setText(fees);
        holder.selectFlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(context, Passenger_inform.class);


                context.startActivity(intent);

//                Intent intent = new Intent(context, PaymentActivity.class);
//                intent.putExtra("mId", 3);
//
//                SharedPreferencesManger.SaveData(context, "TotalFare", df.format(totlalPrice));
//                SharedPreferencesManger.SaveData(context, "typeFare", typeFare);
//
//                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return listTotalFare.size();
    }

    public class ChooseFlightViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.select_flight)
        Button selectFlight;
        @BindView(R.id.tv_TotalFare)
        TextView tvTotalFare;
        @BindView(R.id.tvKiloG2)
        TextView tvKiloG2;
        @BindView(R.id.iv_icon)
        ImageView ivIcon;
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
        @BindView(R.id.tv_kuwait2)
        TextView tvKuwait2;

        @BindView(R.id.tv_bubai)
        TextView tvBubai;
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

        public ChooseFlightViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

        }
    }
}
