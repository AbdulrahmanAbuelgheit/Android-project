package com.app.androidproject;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.androidproject.database.databaseSQL;
import com.app.androidproject.database2.timeTrainTable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    databaseSQL databaseSQL1=new databaseSQL(this);
//    timeTrainTable tt;
    ArrayList<String>id,type,from,to;
    String[] items={"cairo","fayyoum","qena","beni suef","asyut","Minya","Sohag","Damanhour","Damietta","Suez","Giza","Port Said ","Ismailia","Zagazig","Sidi Gaber","Banha","Tanta","Marsa Matrouh","Aswan","Luxor","Mansoura"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    RecyclerView recyclerView;
    table_timeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.times_activity);
//        databaseSql1 = new databaseSQL(this);
//        databaseSql.table1();
//        tt=new timeTrainTable(MainActivity.this);
//        tt.table1(1,"normal","11:00:00","1:00:00");
        Toast.makeText(getApplication(),databaseSQL1.table1(),Toast.LENGTH_LONG).show();
        autoCompleteTextView=findViewById(R.id.autoCompletetxt1);
//        items[0]=type.get(0);
        adapterItems=new ArrayAdapter<String>(this,R.layout.list_item_train,items);

        autoCompleteTextView.setAdapter(adapterItems);


        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item= String.valueOf(parent.getItemIdAtPosition(position));
                switch (item){
                    case "cairo":

                }
                Toast.makeText(getApplicationContext(),"item "+item,Toast.LENGTH_SHORT).show();
//                Toast.makeText(this,"1323543"+type.get(0),Toast.LENGTH_LONG).show();
            }
        });
        autoCompleteTextView.setThreshold(1);

//        setContentView(R.layout.times_activity);
        recyclerView=findViewById(R.id.recyclerview1);
        setRecyclerView();
//        display();
    }
    private void setRecyclerView(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new table_timeAdapter(this,getList());
        recyclerView.setAdapter(adapter);
    }
    private List<time_table> getList(){

//        List<time_table>time_list=new ArrayList<>();
//        time_list.add(new time_table("1","normal","cairo","alex"));
        return databaseSQL1.show_table();
    }
//    void display(){
//        Cursor cursor=tt.readalldata();
//        if(cursor.getCount()==0){
//            Toast.makeText(this,"nodata",Toast.LENGTH_SHORT).show();
//        }else{
//            while(cursor.moveToNext()){
//                id.add(cursor.getString(0).toString());
//                type.add(cursor.getString(1));
//                from.add(cursor.getString(2));
//                to.add(cursor.getString(3));
//            }
//        }
//    }
    }
