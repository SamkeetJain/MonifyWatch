package com.sarl.monifywatch.activities;

import android.net.Uri;
import android.os.AsyncTask;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

import com.sarl.monifywatch.R;
import com.sarl.monifywatch.barchart.BarCardTwo;
import com.sarl.monifywatch.linechart.LineCardOne;
import com.sarl.monifywatch.stackedchart.StackedCardOne;

import org.json.JSONArray;

import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class SMSActivity extends AppCompatActivity {

    private String smsEndpoint = "http://13.127.4.103/hacakaton/smsget.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        CardView cardView = (CardView) findViewById(R.id.chart_card);
        StackedCardOne stackedCardOne = new StackedCardOne(cardView);
        stackedCardOne.init();

        CardView cardView1 = (CardView) findViewById(R.id.chart_card1);
        BarCardTwo barCardTwo = new BarCardTwo(cardView1, getApplicationContext());
        barCardTwo.init();
    }

    private class CallsPut extends AsyncTask<Void, Void, Integer> {

        protected void onPreExecute() {
        }

        protected Integer doInBackground(Void... params) {
            try {

                URL url = new URL(smsEndpoint);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.setRequestMethod("GET");


                Uri.Builder _data = new Uri.Builder().appendQueryParameter("s", "s");
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
                writer.write(_data.build().getEncodedQuery());
                writer.flush();
                writer.close();

                InputStreamReader in = new InputStreamReader(connection.getInputStream());
                StringBuilder jsonResults = new StringBuilder();
                // Load the results into a StringBuilder
                int read;
                char[] buff = new char[1024];
                while ((read = in.read(buff)) != -1) {
                    jsonResults.append(buff, 0, read);
                }
                connection.disconnect();
                JSONArray jsonArray = new JSONArray(jsonResults.toString());

                return 1;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return 1;
        }

        protected void onPostExecute(Integer result) {

        }
    }
}
