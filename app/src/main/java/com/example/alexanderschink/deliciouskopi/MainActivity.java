package com.example.alexanderschink.deliciouskopi;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;

    private TextView sumText;

    private double sum;
    private String tag;
    private int aux2;


    private Button buttonSettings;
    private Button newCust;
    private double[] priceArray;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sumText = (TextView) findViewById(R.id.sumText);


    }

    @Override
    protected void onStart() {
        super.onStart();

        priceArray = new double[6];
        priceArray[0] = 1.50;
        priceArray[1] = 2.00;
        priceArray[2] = 0.80;
        priceArray[3] = 3.50;
        priceArray[4] = 1.00;
        priceArray[5] = 1.30;
    }

    @Override
    protected void onResume() {
        super.onResume();


        // get the updated prices from the settings and feed them into the price array
        preferences = getSharedPreferences("values", MODE_PRIVATE);

        for(int i = 0; i<6; i++){

            String price = "price" + i ;
            String newPrice = preferences.getString(price, Double.toString(priceArray[i]));
            System.out.println(newPrice);

            priceArray[i] = Float.parseFloat(newPrice);

        }

    }

    public void imagePressed(View view) {

        //get the tag of the pressed imagedButton to find correct price and then call the addition method
        tag = (String) view.getTag();
        Addition();

    }

    public void settingsPressed(View view) {
        Intent goSettings = new Intent(this, newPrices.class);
        preferences = getSharedPreferences("values", MODE_PRIVATE);

        //write all the current prices in the shared preferences to have access to them in the settings activity

        for (int i = 0; i<6; i++) {
            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.HALF_UP);

            String price = "price" + i;
            String value = df.format(priceArray[i]);
            preferences.edit().putString(price, value).apply();

        }

        startActivity(goSettings);
    }


    public void Addition() {

        System.out.println(tag);

        //find the correct price associated with the image and add it to sum and display it in the app
        aux2 = Integer.parseInt(tag);

        switch(aux2) {
            case 0:
                sum += priceArray[0];
                break;
            case 1:
                sum += priceArray[1];
                break;
            case 2:
                sum += priceArray[2];
                break;
            case 3:
                sum += priceArray[3];
                break;
            case 4:
                sum += priceArray[4];
                break;
            case 5:
                sum += priceArray[5];
                break;
        }

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        String sum2 = df.format(sum);

        sumText.setText("Total: " + sum2);
    }

    public void newCustPressed (View view) {

        sum = 0;
        sumText.setText("Total: " + Double.toString(sum));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //delete the shared preferences to start over next time you start the app (e.g. when the price was just changed to sell leftovers of the day)
        preferences = getSharedPreferences("values", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("values");
        editor.remove("price0");
        editor.remove("price1");
        editor.remove("price2");
        editor.remove("price3");
        editor.remove("price4");
        editor.remove("price5");
        editor.commit();
    }
}
