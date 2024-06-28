package com.app.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.androidproject.database2.timeTrainTable;

import java.util.ArrayList;

public class choice extends AppCompatActivity {
    ArrayList<String> id,type,from,to;
    TextView textView;
    Button button;
    timeTrainTable t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        t=new timeTrainTable(choice.this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.table1(2,"kk","kok","llkl");
                t.table1(1,"normal","11:00:00","1:00:00");
                Cursor cursor=t.readalldata();
                if(cursor.getCount()==0){
                    Toast.makeText(getApplication(),"nodata",Toast.LENGTH_SHORT).show();
                }else{
                    while(cursor.moveToNext()){

                        type.add(cursor.getString(1));
                        from.add(cursor.getString(2));
                        to.add(cursor.getString(3));
                    }
                }
                textView.setText(type.get(0));
            }
        });

    }
}