package com.example.allinoneron;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    TextView tv1;
    ArrayAdapter<String> adap;
    ArrayList<Passenger> passengers;
    ArrayList<String> info;
    EditText etTime;
    Button btn;
    RadioButton rd1,rd2,rd3,rd4;
    RadioGroup radioGroup;
    int tp1=0; //counter type 1
    int tp2=0; //counter type 2
    int tp3=0; //counter type 3
    int tp4=0; //counter type 4
    int[]tim; //counter hours
    String type,time,station;
    String PassInfo=""; //all of the passengers info
    String[] stations={"Be'er Sheva Central","Be'er Sheva North","Lehavim - Rahat",
            "Kiryat Gat","Lod","Tel Aviv Hagana","Tel Aviv haShalom", "Tel Aviv Center"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //=================================
        lv=findViewById(R.id.lv);
        btn=findViewById(R.id.btn);
        etTime=findViewById(R.id.etTime);
        tv1=findViewById(R.id.tv1);
        rd1=findViewById(R.id.rd1);
        rd2=findViewById(R.id.rd2);
        rd3=findViewById(R.id.rd3);
        rd4=findViewById(R.id.rd4);
        radioGroup=findViewById(R.id.rdg);

        tim=new int[24];
        passengers=new ArrayList<>();
        info=new ArrayList<>();
        adap=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, stations);
        lv.setAdapter(adap);
        //=======================================
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                station = stations[position];
                Toast.makeText(MainActivity.this, "YOU CHOSE STATION:\n"+station,
                        Toast.LENGTH_LONG).show();
            }
        });
        /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person person=persons.get(position);
                String temp=person.getPhone();
                Toast.makeText(MainActivity.this, "Phone number="+temp,
                        Toast.LENGTH_LONG).show();
            }
        });*/
    }

    //the button NEXT PASSENGER :
    public void next(View view) {
        time=etTime.getText().toString();
        if (rd1.isChecked()) {
            type = "Standard";
            tp1++;
        }
        if (rd2.isChecked()) {
            type = "Soldier";
            tp2++;
        }
        if (rd3.isChecked()) {
            type = "Pensioner";
            tp3++;
        }
        if (rd4.isChecked()) {
            type = "Child";
            tp4++;
        }
        for(int i=0; i<24; i++)
        {
            if(i == Integer.parseInt(etTime.getText().toString().substring(0,2))) {
                tim[i]++;
            }
        }

        Passenger person=new Passenger(type,time,station);
        passengers.add(person);
        PassInfo = PassInfo+person;
        info.add(""+person);
        etTime.setText("");
        station="";
        this.radioGroup.clearCheck();

    }

    //the button CONTINUE :
    public void continueBT(View view) {

        String size = ""+info.size();
        //info.toArray();
        Intent go=new Intent(this, info.class);

        go.putExtra("tp1",""+tp1);
        go.putExtra("tp2",""+tp2);
        go.putExtra("tp3",""+tp3);
        go.putExtra("tp4",""+tp4);
        go.putExtra("size",""+size);
        go.putExtra("tim",tim);
        go.putStringArrayListExtra("info", info);
        //go.putExtra("info2", info);
        go.putExtra("PassInfo",PassInfo);

        startActivity(go);

        /* String[] st = new String[passengers.size()];
        String[] tp = new String[passengers.size()];
        String[] tm = new String[passengers.size()];
        for(int i=0; i<passengers.size(); i++)
        {
            st[i]=passengers.get(i).getStation();
            tp[i]=passengers.get(i).getType();
            tm[i]=passengers.get(i).getTime();
        }*/

    }
}
