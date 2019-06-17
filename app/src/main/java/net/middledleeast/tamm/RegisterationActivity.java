package net.middledleeast.tamm;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterationActivity extends Fragment {
        private ImageView imageView;
        private TextView textView;
        private EditText email,password,confpassword,name,phone;
        private Button button;
        private FirebaseAuth auth;
        private DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registeration, container, false);

        imageView = view.findViewById(R.id.img_view);
        textView = view.findViewById(R.id.register_txt_view);
        email = view.findViewById(R.id.tv_register_email);
        password = view.findViewById(R.id.tv_register_password);
        confpassword = view.findViewById(R.id.tv_register_confpassword);
        name = view.findViewById(R.id.tv_register_name);
        phone = view.findViewById(R.id.tv_register_phone);
        button = view.findViewById(R.id.btn_register_signup);

        auth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strName = name.getText().toString();
                String strEmail = email.getText().toString();
                String strpass = password.getText().toString();
                String strconfpass = confpassword.getText().toString();
                String strphone = phone.getText().toString();


                if (TextUtils.isEmpty(strName)) {
                    name.setError("Name Is Required");

                } else if (TextUtils.isEmpty(strEmail)) {
                    email.setError("Email Is Required");
                } else if (TextUtils.isEmpty(strpass)) {
                    password.setError("Password Is Required");
                } else if (TextUtils.isEmpty(strconfpass)) {
                    confpassword.setError("Conf. Password Is Required");
                } else {
                    doRegister(strName, strEmail, strpass, strconfpass);
                }
            }
        });

        return view;
    }


    private void doRegister(final String strName, String strEmail, String strpass, String strconfpass) {

        auth.createUserWithEmailAndPassword(strEmail,strpass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser firebaseUser=auth.getCurrentUser();
                            Log.d("user_id",firebaseUser.getUid());
                            Toast.makeText(getActivity(), "Register Success", Toast.LENGTH_SHORT).show();
                            getActivity().getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.welcome_container, new SignInFragment())
                                    .commit();

                            reference =FirebaseDatabase.getInstance().getReference()
                                    .child("users").child(auth.getCurrentUser().getUid());

                            HashMap<String,String> hashMap=new HashMap<>();
                            hashMap.put("id",auth.getCurrentUser().getUid());
                            hashMap.put("name",strName);
                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(getActivity(), "Register Success", Toast.LENGTH_SHORT).show();


                                    }
                                }
                            });

                        } else{
                            Toast.makeText(getActivity(), "Something Wrong ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }

    public void sign_in_text(View view) {

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.welcome_container, new SignInFragment())
                .commit();

    }
}
