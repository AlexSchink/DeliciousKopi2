package com.example.alexanderschink.deliciouskopi;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class newPrices extends AppCompatActivity {

    private SharedPreferences preferences;
    private EditText price0;
    private EditText price1;
    private EditText price2;
    private EditText price3;
    private EditText price4;
    private EditText price5;
    private String aux;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_prices);
    }

    @Override
    protected void onStart() {
        super.onStart();
        price0 = (EditText) findViewById(R.id.price0);
        price1 = (EditText) findViewById(R.id.price1);
        price2 = (EditText) findViewById(R.id.price2);
        price3 = (EditText) findViewById(R.id.price3);
        price4 = (EditText) findViewById(R.id.price4);
        price5 = (EditText) findViewById(R.id.price5);

        preferences = getSharedPreferences("values", MODE_PRIVATE);

        for(int i = 0; i<6; i++){



            String price = "price" + i ;
            String currentprice = preferences.getString(price, "1.60");
            System.out.println(currentprice);


            switch(i){
                case 0:
                    price0.setText(currentprice);
                case 1:
                    price1.setText(currentprice);
                case 2:
                    price2.setText(currentprice);
                case 3:
                    price3.setText(currentprice);
                case 4:
                    price4.setText(currentprice);
                case 5:
                    price5.setText(currentprice);
            }

        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        preferences = getSharedPreferences("values", MODE_PRIVATE);

        for(int i = 0; i<6; i++){

            switch(i) {
                case 0:
                    preferences.edit().putString("price0", String.valueOf(price0.getText())).apply();
                case 1:
                    preferences.edit().putString("price1", String.valueOf(price1.getText())).apply();
                case 2:
                    preferences.edit().putString("price2", String.valueOf(price2.getText())).apply();
                case 3:
                    preferences.edit().putString("price3", String.valueOf(price3.getText())).apply();
                case 4:
                    preferences.edit().putString("price4", String.valueOf(price4.getText())).apply();
                case 5:
                    preferences.edit().putString("price5", String.valueOf(price5.getText())).apply();

            }
        }
    }

    //emptying text for easier editing
    public void pressed0(View v) {
        price0.setText("");
    }
    public void pressed1(View v) {
        price1.setText("");
    }
    public void pressed2(View v) {
        price2.setText("");
    }
    public void pressed3(View v) {
        price3.setText("");
    }
    public void pressed4(View v) {
        price4.setText("");
    }
    public void pressed5(View v) {
        price5.setText("");
    }

    @Override
    protected void onStop() {
        super.onStop();

        preferences = getSharedPreferences("values", MODE_PRIVATE);

        onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

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
