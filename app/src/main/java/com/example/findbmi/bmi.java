package com.example.findbmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class bmi extends AppCompatActivity {

    android.widget.Button rebmical;
    Intent intent;
    TextView mbmidisplay,mbmigeneder,mbmicaterogy;
    ImageView mimageview;
    String mbmi;
    float intbmi;
    String height,weight;
    float intheight,intweight;
    ConstraintLayout mbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        rebmical = findViewById(R.id.recalculatebmi);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colordrawble  = new ColorDrawable(Color.parseColor("#937DC2"));
        getSupportActionBar().setBackgroundDrawable(colordrawble);

        intent = getIntent();
        mbmidisplay = findViewById(R.id.bmidisplay);
        mbmigeneder = findViewById(R.id.genderdisplay);
        mbmicaterogy = findViewById(R.id.bmicategroy);
        mimageview =findViewById(R.id.imageview);
        mbackground =findViewById(R.id.contentlayout);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intheight = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);

        intheight = intheight/100;

        intbmi = intweight/(intheight*intheight);
        mbmi = Float.toString(intbmi);

        if(intbmi<16)
        {
            mbmicaterogy.setText("Severe Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.remove);
        }
        else if(intbmi <16.9 && intbmi>16)
        {
            mbmicaterogy.setText("Moderate Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi <18.4 && intbmi>17)
        {
            mbmicaterogy.setText("Mild Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi <25 && intbmi>18.4)
        {
            mbmicaterogy.setText("Normal");
            mbackground.setBackgroundColor(Color.GREEN);
            mimageview.setImageResource(R.drawable.checked);
        }
        else if(intbmi <29.5 && intbmi>25)
        {
            mbmicaterogy.setText("Over Weight");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        else
        {
            mbmicaterogy.setText("Obese class I");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        mbmigeneder.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);
        rebmical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bmi.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}