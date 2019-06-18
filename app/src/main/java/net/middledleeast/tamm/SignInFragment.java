package net.middledleeast.tamm;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import net.middledleeast.tamm.fragments.ForgotPasswordFragment;
import net.middledleeast.tamm.fragments.PlansFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {

    private TextView txtForgotPassword;
    private Button btnSignIn;
    private EditText userName, pass;
    private FirebaseUser user;
    private FirebaseAuth auth;

    public SignInFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = getView(inflater, container);

        if (user != null) {


        }

        btnSignIn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    btnSignIn.setTextColor(Color.parseColor("#BE973B"));
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.welcome_container, new PlansFragment())
                            .commit();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    btnSignIn.setBackground(getActivity().getDrawable(R.drawable.border));
                }
                return false;



            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user_Name = userName.getText().toString();
                String password = pass.getText().toString();
                if (TextUtils.isEmpty(user_Name)) {
                    userName.setError("Name Is Required");

                } else if (TextUtils.isEmpty(password)) {
                    pass.setError("Conf. Password Is Required");
                } else {
                    signInLogin(user_Name, password);
                }
            }
        });


        txtForgotPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    txtForgotPassword.setTextColor(Color.parseColor("#BE973B"));
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.welcome_container, new ForgotPasswordFragment())
                            .commit();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    txtForgotPassword.setBackground(getActivity().getDrawable(R.drawable.border));
                }
                return false;
            }

        });

        return view;
    }

    private View getView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        txtForgotPassword = view.findViewById(R.id.goto_forgot_pass);
        btnSignIn = view.findViewById(R.id.btn_sign_in_user);
        userName = view.findViewById(R.id.tv_signin_username);
        pass = view.findViewById(R.id.tv_signin_password);
        user = FirebaseAuth.getInstance().getCurrentUser();
        auth = FirebaseAuth.getInstance();
        return view;
    }

    private void signInLogin(String userName2, String passwor) {
        auth.signInWithEmailAndPassword(userName2, passwor).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.welcome_container, new PlansFragment())
                            .commit();
                }else {
                    Toast.makeText(getActivity(), "Wrong Email or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}

