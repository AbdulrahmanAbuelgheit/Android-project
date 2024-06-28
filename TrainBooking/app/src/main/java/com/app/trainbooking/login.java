package com.app.trainbooking;

import androidx.appcompat.app.AppCompatActivity;

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
import com.app.trainbooking.databinding.ActivityLoginBinding;
import com.app.trainbooking.register;
import com.app.trainbooking.database.user;

public class login extends AppCompatActivity {
    EditText nam,pass;
    Button btn;
    ImageView img;
    ActivityLoginBinding binding;
    databaseSQL databaseSql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());

        btn =  findViewById(R.id.login);
        setContentView(binding.getRoot());
        databaseSql = new databaseSQL(this);
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name =binding.username.getText().toString();
                String password = binding.password.getText().toString();

                if (name.equals("") ){

                    binding.username.setError("!Required");

                }
                else if(password.equals(" ")){
                    binding.password.setError("!Required");
                }



                else {
                    Boolean checkdata = databaseSql.checkdatasaved(name, password);
                    if (checkdata == true) {
                        Toast.makeText(login.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), mainnn.class);
                        startActivity(intent);
                    } else  {
                        Toast.makeText(login.this, "Invalid ", Toast.LENGTH_SHORT).show();
//                        binding.username.setError("Not valid!");
//                        binding.password.setError("Not valid!");
                    }
                }
            }
        });
//        img=findViewById(R.id.imageView2);
//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), SplashScreenActivity.class);
//                startActivity(intent);
//            }
//
//        });
    }
}