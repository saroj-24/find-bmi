package com.example.findbmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button mbmicalculate;

    TextView mcurrentheight;
    TextView mcurrentage,mcurrentweight;
    ImageView mincrementweight,mincrementage, mdecrementage, mdecrementweight;
    SeekBar mseekabrforheight;

    RelativeLayout mmale,mfemale;

     int intweight = 50;
     int intage = 20;
     int currentprogress;

     String mintprogress= "150";
     String typeofuser = "0";
     String age2 = "20";
     String weight2 = "50";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbmicalculate = findViewById(R.id.calculatebmi);
        mcurrentheight = findViewById(R.id.currentheight);
        mcurrentage = findViewById(R.id.currentage);
        mcurrentweight = findViewById(R.id.currentweight);
        mincrementage = findViewById(R.id.incrementage);
        mincrementweight = findViewById(R.id.incrementweight);
        mdecrementage = findViewById(R.id.decrementage);
        mdecrementweight = findViewById(R.id.decrementweight);

        mseekabrforheight = findViewById(R.id.seekbarforheight);

        mmale = findViewById(R.id.male);
        mfemale = findViewById(R.id.female);

        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser = "MALE";

            }
        });

        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.femalefocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser = "FEMALE";

            }
        });

        mseekabrforheight.setMax(1000);
        mseekabrforheight.setProgress(150);
        mseekabrforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress = progress;
                mintprogress = String.valueOf(currentprogress);
                mcurrentheight.setText(mintprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mincrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage = intage+1;
                age2 = String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });

        mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage = intage-1;
                age2 = String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });

        mincrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight = intweight+1;
                weight2 = String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });

        mdecrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight = intweight-1;
                weight2 = String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        mbmicalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(typeofuser.equals("0"))
                {
                    Toast.makeText(MainActivity.this, "select your gender", Toast.LENGTH_SHORT).show();
                }
                else if(mintprogress.equals("0"))
                {
                    Toast.makeText(MainActivity.this, "select your height", Toast.LENGTH_SHORT).show();
                }
               else if(intage==0 || intage<0)
                {
                    Toast.makeText(MainActivity.this, "Age is incorrect", Toast.LENGTH_SHORT).show();
                }
               else if(intweight==0 || intweight<0)
                {
                    Toast.makeText(MainActivity.this, "weight is incorrect", Toast.LENGTH_SHORT).show();
                }
               else
                {
                    Intent intent = new Intent(MainActivity.this,bmi.class);
                    intent.putExtra("gender",typeofuser);
                    intent.putExtra("height",mintprogress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);
                    startActivity(intent);
                }
            }
        });

    }
}