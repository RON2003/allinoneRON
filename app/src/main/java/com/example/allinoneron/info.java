package com.example.allinoneron;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class info extends AppCompatActivity {


    ListView lvp;
    TextView tv10,tv13;
    Button btn1,btn2,btn3;
    ImageView back;
    RadioButton rd1,rd2,rd3,rd4;
    EditText etTime;
    String tpa;
    ArrayList<String> info;
    int[] timee;
    ArrayAdapter<String> adap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tv10=findViewById(R.id.tv10);
        tv13=findViewById(R.id.tv13);
        lvp=findViewById(R.id.lvp);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        back=findViewById(R.id.ok);
        etTime=findViewById(R.id.etTime);
        rd1=findViewById(R.id.rd1);
        rd2=findViewById(R.id.rd2);
        rd3=findViewById(R.id.rd3);
        rd4=findViewById(R.id.rd4);

        timee = new int[24];
        info=new ArrayList<>();

        }

    public void SHOWtp(View view) {
        Intent take=getIntent();
        if (rd1.isChecked()) {
            tpa =take.getStringExtra("tp1");
        }
        if (rd2.isChecked()) {
            tpa =take.getStringExtra("tp2");
        }

        if (rd3.isChecked()) {
            tpa =take.getStringExtra("tp3");
        }

        if(rd4.isChecked()) {
            tpa =take.getStringExtra("tp4");
        }
        tv13.setText(tpa + " Passengers");
    }

    public void SHOWtm(View view) {
        Intent take2=getIntent();
        timee = take2.getIntArrayExtra("tim");
        for(int i=0; i<24; i++)
        {
            if(i == Integer.parseInt(etTime.getText().toString().substring(0,2))) {
                tv13.setText(""+timee[i]+" Passengers");
            }
        }
    }

    public void SHOWall(View view) {
        Intent take3=getIntent();
        info=take3.getStringArrayListExtra("info");
        adap=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, info);
        lvp.setAdapter(adap);
    }

    public void backBT(View view) {
        Intent go=new Intent(this, MainActivity.class);
        startActivity(go);
    }




}
