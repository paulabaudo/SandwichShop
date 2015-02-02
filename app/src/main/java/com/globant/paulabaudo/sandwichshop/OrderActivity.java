package com.globant.paulabaudo.sandwichshop;

import android.app.Activity;
import android.content.Intent;
import android.os.PersistableBundle;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;


public class OrderActivity extends Activity {

    Button mPlaceOrderButton;
    Button mNextSandwichButton;
    ArrayList<Sandwich> mOrders;
    RadioButton mWhiteBread;
    CheckBox mTomatoesCheck;
    CheckBox mPicklesCheck;
    CheckBox mLettuceCheck;
    CheckBox mMayonnaiseCheck;
    CheckBox mMustardCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        init();

        if (savedInstanceState!=null){
            mOrders = savedInstanceState.getParcelableArrayList("orders");
            if (savedInstanceState.getInt("next")==1){
                mNextSandwichButton.setEnabled(true);
            } else {
                mNextSandwichButton.setEnabled(false);
            }
            if (savedInstanceState.getInt("place")==1){
                mPlaceOrderButton.setEnabled(true);
            } else {
                mPlaceOrderButton.setEnabled(false);
            }
        } else {
            mOrders = new ArrayList<Sandwich>();
        }
    }

    private void init(){
        mPlaceOrderButton = (Button) findViewById(R.id.button_place_order);

        mPlaceOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String bread = getBread();
//                String summary = getSummary();
                Intent confirmationIntent = new Intent(v.getContext(), ConfirmationActivity.class);
//                confirmationIntent.putExtra("bread",bread);
//                confirmationIntent.putExtra("summary",summary);
                Bundle extrasBundle = new Bundle();
                extrasBundle.putParcelableArrayList("orders", mOrders);
                confirmationIntent.putExtras(extrasBundle);
                v.getContext().startActivity(confirmationIntent);
            }
        });

        mNextSandwichButton = (Button) findViewById(R.id.button_next_sandwich);

        mNextSandwichButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sandwich sandwich = new Sandwich();
                sandwich = getSandwichOrder();
                mOrders.add(sandwich);
                if (readyToPlaceOrder()){
                    mNextSandwichButton.setEnabled(false);
                    mPlaceOrderButton.setEnabled(true);
                } else {
                    reset();
                }
                Toast.makeText(getBaseContext(), "The sandwich has been added to the order",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("orders",mOrders);
        outState.putInt("next",mNextSandwichButton.isEnabled()?1:0);
        outState.putInt("place",mPlaceOrderButton.isEnabled()?1:0);
    }

    //    private String getBread(){
//        String bread = "";
//
//        RadioButton whiteBread;
//        RadioButton wheatBread;
//
//        whiteBread = (RadioButton) findViewById(R.id.radio_button_white);
//        wheatBread = (RadioButton) findViewById(R.id.radio_button_wheat);
//
//        if (whiteBread.isChecked()){
//            bread = "White";
//        } else {
//            if (wheatBread.isChecked()){
//                bread = "Wheat";
//            } else {
//                bread = "Rye";
//            }
//        }
//
//        return bread;
//    }

//    private String getSummary(){
//        String summary = "";
//
//        CheckBox mTomatoesCheck;
//        CheckBox mPicklesCheck;
//        CheckBox mLettuceCheck;
//        CheckBox mMayonnaiseCheck;
//        CheckBox mMustardCheck;
//
//        mTomatoesCheck = (CheckBox) findViewById(R.id.check_tomatoes);
//        mPicklesCheck = (CheckBox) findViewById(R.id.check_pickles);
//        mLettuceCheck = (CheckBox) findViewById(R.id.check_lettuce);
//        mMayonnaiseCheck = (CheckBox) findViewById(R.id.check_mayonnaise);
//        mMustardCheck = (CheckBox) findViewById(R.id.check_mustard);
//
//        if (mTomatoesCheck.isChecked()){
//            summary += "tomatoes\n";
//        }
//
//        if (mPicklesCheck.isChecked()){
//            summary += "pickles\n";
//        }
//
//        if (mLettuceCheck.isChecked()){
//            summary += "lettuce\n";
//        }
//
//        if (mMayonnaiseCheck.isChecked()){
//            summary += "mayonnaise\n";
//        }
//
//        if (mMustardCheck.isChecked()){
//            summary += "mustard\n";
//        }
//
//        return summary;
//    }

    private Sandwich getSandwichOrder(){
        Sandwich s = new Sandwich();

        RadioButton mWheatBread;

        mWhiteBread = (RadioButton) findViewById(R.id.radio_button_white);
        mWheatBread = (RadioButton) findViewById(R.id.radio_button_wheat);

        if (mWhiteBread.isChecked()){
            s.setBread("White");
        } else {
            if (mWheatBread.isChecked()){
                s.setBread("Wheat");
            } else {
                s.setBread("Rye");
            }
        }

        mTomatoesCheck = (CheckBox) findViewById(R.id.check_tomatoes);
        mPicklesCheck = (CheckBox) findViewById(R.id.check_pickles);
        mLettuceCheck = (CheckBox) findViewById(R.id.check_lettuce);
        mMayonnaiseCheck = (CheckBox) findViewById(R.id.check_mayonnaise);
        mMustardCheck = (CheckBox) findViewById(R.id.check_mustard);

        if (mTomatoesCheck.isChecked()){
            s.setTomatoes(true);
        }

        if (mPicklesCheck.isChecked()){
            s.setPickles(true);
        }

        if (mLettuceCheck.isChecked()){
            s.setLettuce(true);
        }

        if (mMayonnaiseCheck.isChecked()){
            s.setMayonnaise(true);
        }

        if (mMustardCheck.isChecked()){
            s.setMustard(true);
        }

        return s;
    }

    private Boolean readyToPlaceOrder(){
        int count = Integer.parseInt(getIntent().getExtras().get("count").toString());
        return mOrders.size()==count;
    }

    private void reset(){
        mWhiteBread.setChecked(true);
        mTomatoesCheck.setChecked(false);
        mPicklesCheck.setChecked(false);
        mLettuceCheck.setChecked(false);
        mMayonnaiseCheck.setChecked(false);
        mMustardCheck.setChecked(false);
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
