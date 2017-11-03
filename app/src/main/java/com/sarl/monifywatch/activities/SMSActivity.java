package com.sarl.monifywatch.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

import com.sarl.monifywatch.R;
import com.sarl.monifywatch.linechart.LineCardOne;

public class SMSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        CardView cardView = (CardView) findViewById(R.id.chart_card);
        LineCardOne lineCardOne = new LineCardOne(cardView,getApplicationContext());
        lineCardOne.init();
    }
}
