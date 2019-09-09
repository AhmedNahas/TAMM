package net.middledleeast.tamm.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.PaymentFlights;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSeats extends Fragment {

    Button proceedcheck_out_seat;
    @BindView(R.id.passen_air)
    CheckedTextView passenAir;
    @BindView(R.id.view_blo)
    View viewBlo;
    @BindView(R.id.private_jet)
    CheckedTextView privateJet;
    @BindView(R.id.rel_checked)
    RelativeLayout relChecked;
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_2)
    TextView tv2;
    @BindView(R.id.relative_1_2)
    RelativeLayout relative12;
    @BindView(R.id.tv_3)
    TextView tv3;
    @BindView(R.id.tv_4)
    TextView tv4;
    @BindView(R.id.relative_3_4)
    RelativeLayout relative34;
    @BindView(R.id.tv_5)
    TextView tv5;
    @BindView(R.id.tv_6)
    TextView tv6;
    @BindView(R.id.relative_numbers)
    RelativeLayout relativeNumbers;
    @BindView(R.id.tv_a)
    TextView tvA;
    @BindView(R.id.tv_b)
    TextView tvB;
    @BindView(R.id.tv_c)
    TextView tvC;
    @BindView(R.id.relative_alpha)
    RelativeLayout relativeAlpha;
    @BindView(R.id.iv_1)
    ImageView iv1;
    @BindView(R.id.iv_B1)
    ImageView ivB1;
    @BindView(R.id.iv_C1)
    ImageView ivC1;
    @BindView(R.id.iv_2)
    ImageView iv2;
    @BindView(R.id.iv_B2)
    ImageView ivB2;
    @BindView(R.id.iv_C2)
    ImageView ivC2;
    @BindView(R.id.relative_chair_img1)
    RelativeLayout relativeChairImg1;
    @BindView(R.id.iv_3)
    ImageView iv7;
    @BindView(R.id.iv_B3)
    ImageView ivB3;
    @BindView(R.id.iv_C3)
    ImageView ivC3;
    @BindView(R.id.iv_4)
    ImageView iv4;
    @BindView(R.id.iv_B4)
    ImageView ivB4;
    @BindView(R.id.iv_C4)
    ImageView ivC4;
    @BindView(R.id.relative_chair_img2)
    RelativeLayout relativeChairImg2;
    @BindView(R.id.iv_5)
    ImageView iv5;
    @BindView(R.id.iv_B5)
    ImageView ivB5;
    @BindView(R.id.iv_C5)
    ImageView ivC5;
    @BindView(R.id.iv_6)
    ImageView iv6;
    @BindView(R.id.iv_B6)
    ImageView ivB6;
    @BindView(R.id.iv_C6)
    ImageView ivC6;
    @BindView(R.id.line_seat)
    View lineSeat;
    @BindView(R.id.tv_total_price)
    TextView tvTotalPrice;
    @BindView(R.id.relative_price_seat)
    RelativeLayout relativePriceSeat;
    @BindView(R.id.proceedcheck_out_seat)
    Button proceedcheckOutSeat;
    private String mealType;
    private long noOfSetAvaliable;

    public FragmentSeats() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_seats, container, false);
        ButterKnife.bind(this, view);
        proceedcheck_out_seat = view.findViewById(R.id.proceedcheck_out_seat);

        proceedcheck_out_seat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getContext(), PaymentFlights.class));
            }
        });


//        mealType =      SharedPreferencesManger.LoadStringData(getContext(), "mealType");
//
       noOfSetAvaliable =    SharedPreferencesManger.LoadLongData(getContext(), "noOfSetAvaliable" );
//
//        Toast.makeText(getContext(), "noOfSetAvaliable"+noOfSetAvaliable, Toast.LENGTH_SHORT).show();
//





        return view;
    }

    @OnClick({R.id.iv_1, R.id.iv_B1, R.id.iv_C1, R.id.iv_2, R.id.iv_B2, R.id.iv_C2, R.id.iv_3, R.id.iv_B3, R.id.iv_C3, R.id.iv_4, R.id.iv_B4, R.id.iv_C4, R.id.iv_5, R.id.iv_B5, R.id.iv_C5, R.id.iv_6, R.id.iv_B6, R.id.iv_C6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_1:

                iv1.setImageResource ( R.drawable.chairone);
                break;
            case R.id.iv_B1:
                ivB1.setImageResource ( R.drawable.chairone);

                break;
            case R.id.iv_C1:
                ivC1.setImageResource ( R.drawable.chairone);
                break;
            case R.id.iv_2:
                iv2.setImageResource ( R.drawable.chairone);
                break;
            case R.id.iv_B2:
                ivB2.setImageResource ( R.drawable.chairone);
                break;
            case R.id.iv_C2:
                break;
            case R.id.iv_3:
                break;
            case R.id.iv_B3:
                break;
            case R.id.iv_C3:
                break;
            case R.id.iv_4:
                break;
            case R.id.iv_B4:
                break;
            case R.id.iv_C4:
                break;
            case R.id.iv_5:
                break;
            case R.id.iv_B5:
                break;
            case R.id.iv_C5:
                break;
            case R.id.iv_6:
                break;
            case R.id.iv_B6:
                break;
            case R.id.iv_C6:
                break;
        }
    }
}
