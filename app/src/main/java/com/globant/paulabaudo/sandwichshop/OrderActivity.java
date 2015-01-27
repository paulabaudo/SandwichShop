package com.globant.paulabaudo.sandwichshop;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;


public class OrderActivity extends ActionBarActivity {

    Button mPlaceOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        mPlaceOrderButton = (Button) findViewById(R.id.button_place_order);

        mPlaceOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bread = getBread();
                String summary = getSummary();
                Intent confirmationIntent = new Intent(v.getContext(), ConfirmationActivity.class);
                confirmationIntent.putExtra("bread",bread);
                confirmationIntent.putExtra("summary",summary);
                v.getContext().startActivity(confirmationIntent);
            }
        });
    }

    private String getBread(){
        String bread = "";

        RadioButton whiteBread;
        RadioButton wheatBread;

        whiteBread = (RadioButton) findViewById(R.id.radio_button_white);
        wheatBread = (RadioButton) findViewById(R.id.radio_button_wheat);

        if (whiteBread.isChecked()){
            bread = "White";
        } else {
            if (wheatBread.isChecked()){
                bread = "Wheat";
            } else {
                bread = "Rye";
            }
        }

        return bread;
    }

    private String getSummary(){
        String summary = "";

        CheckBox tomatoesCheck;
        CheckBox picklesCheck;
        CheckBox lettuceCheck;
        CheckBox mayonnaiseCheck;
        CheckBox mustardCheck;

        tomatoesCheck = (CheckBox) findViewById(R.id.check_tomatoes);
        picklesCheck = (CheckBox) findViewById(R.id.check_pickles);
        lettuceCheck = (CheckBox) findViewById(R.id.check_lettuce);
        mayonnaiseCheck = (CheckBox) findViewById(R.id.check_mayonnaise);
        mustardCheck = (CheckBox) findViewById(R.id.check_mustard);

        if (tomatoesCheck.isChecked()){
            summary += "tomatoes\n";
        }

        if (picklesCheck.isChecked()){
            summary += "pickles\n";
        }

        if (lettuceCheck.isChecked()){
            summary += "lettuce\n";
        }

        if (mayonnaiseCheck.isChecked()){
            summary += "mayonnaise\n";
        }

        if (mustardCheck.isChecked()){
            summary += "mustard\n";
        }

        return summary;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
