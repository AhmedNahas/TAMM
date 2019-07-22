package net.middledleeast.tamm.fragments;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import net.middledleeast.tamm.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForgotPasswordFragment extends Fragment {


    public ForgotPasswordFragment() {
        // Required empty public constructor
    }

    private Button btnSendEmail;
    private EditText edtEmail;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forgot_password, container, false);
        btnSendEmail = view.findViewById(R.id.btn_send_forgort_password_email);

        btnSendEmail.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    btnSendEmail.setBackgroundColor(Color.parseColor("#BE973B"));
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.welcome_container, new SuccessSendEmailFragment())
                            .addToBackStack("ForgotPassword").commit();
                }else if (event.getAction() == MotionEvent.ACTION_UP){
                    btnSendEmail.setBackground(getActivity().getDrawable(R.drawable.border));
                }
                return false;
            }
        });

        return view;
    }

}
