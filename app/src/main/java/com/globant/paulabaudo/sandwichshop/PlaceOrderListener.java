package com.globant.paulabaudo.sandwichshop;

import android.content.Intent;
import android.view.View;

/**
 * Created by paula.baudo on 26/01/2015.
 */
public class PlaceOrderListener implements View.OnClickListener {

    public PlaceOrderListener(){

    }

    @Override
    public void onClick(View v) {
        Intent confirmationIntent = new Intent(v.getContext(), ConfirmationActivity.class);
        v.getContext().startActivity(confirmationIntent);
    }
}
