package com.app.trainbooking;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.trainbooking.database.databaseSQL;
import com.app.trainbooking.database.user;

import java.util.ArrayList;

public class register extends AppCompatActivity {
    EditText name,password,confirm_password,email,address;
    ImageView img;
    SharedPreferences sp;
    SharedPreferences.Editor edit;
    Button register;
    public final String name_key="username";
    public final String pass_key="password";
    public final String con_pass_key="confirm password";
    public final String email_key="email";
    databaseSQL obj=new databaseSQL(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        name=findViewById(R.id.username);
        password=findViewById(R.id.password);
        confirm_password=findViewById(R.id.conpassword);
        email=findViewById(R.id.email);
//        address=findViewById(R.id.address);
        register = findViewById(R.id.registerbtn);
//        sp= PreferenceManager.getDefaultSharedPreferences(this);
//        edit=sp.edit();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = name.getText().toString();
                String pass = password.getText().toString();
                String conp = confirm_password.getText().toString();
                String em = email.getText().toString();

                if (username.isEmpty()) {
                    name.setError("Name can't be Empty");

                }
                else if (em.isEmpty()) {
                    email.setError("please,Enter your Email");
                }

                else if (pass.isEmpty()) {
                    password.setError("password can't be Empty");
                } else if (conp.isEmpty()) {
                    confirm_password.setError("you mast confirm password");
                }
                else if(!pass.equals(conp)){
                    confirm_password.setError("not match");

                }

                else {
//                    edit.putString(name_key, username);
//                    edit.putString(pass_key, pass);
//                    edit.putString(con_pass_key, conp);
//                    edit.putString(email_key, em);
//                    edit.apply();
                    String n= obj.insertdata(username,pass,em);

                    Intent intent = new Intent(getApplicationContext(), login.class);
                    startActivity(intent);

                }
                ArrayList d=obj.Getdata();

            }

        });

//    img=findViewById(R.id.imageView2);
//    img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), SplashScreenActivity.class);
//                startActivity(intent);
//            }
//
//                });



    }



}