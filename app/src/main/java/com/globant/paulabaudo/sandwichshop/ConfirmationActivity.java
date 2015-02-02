package com.globant.paulabaudo.sandwichshop;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;


public class ConfirmationActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        init();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_confirmation, menu);
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

//    private void init(){
//        TextView breadText;
//        TextView summaryText;
//
//        breadText = (TextView) findViewById(R.id.text_view_bread_chosen);
//        summaryText =(TextView) findViewById(R.id.text_view_condiments_chosen);
//
//        breadText.setText(getIntent().getExtras().get("bread").toString());
//        summaryText.setText(getIntent().getExtras().get("summary").toString());
//    }

    private void init(){
        TextView summaryText = (TextView) findViewById(R.id.text_view_summary);
        ArrayList<Sandwich> orders = getIntent().getExtras().getParcelableArrayList("orders");
        String summary = "";
        int n = 0;

        for (Sandwich s : orders){
            n++;
            String result = "Sandwich " + Integer.toString(n) + ": ";
            result += s.getBread() + " " + (s.getTomatoes()?"tomatoes ":"") +
                    (s.getPickles()?"pickles ":"") +
                    (s.getLettuce()?"lettuce ":"") +
                    (s.getMayonnaise()?"mayonnaise ":"") +
                    (s.getMustard()?"mustard":"") + "\n";
            summary += result;
        }

        summaryText.setText(summary);
    }
}
