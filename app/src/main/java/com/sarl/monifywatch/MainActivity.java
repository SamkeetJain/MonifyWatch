package com.sarl.monifywatch;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

import com.db.chart.tooltip.Tooltip;
import com.db.chart.view.LineChartView;
import com.sarl.monifywatch.linechart.LineCardOne;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView cardView = (CardView) findViewById(R.id.chart_card);
        LineCardOne lineCardOne = new LineCardOne(cardView,getApplicationContext());
        lineCardOne.init();


    }
}
