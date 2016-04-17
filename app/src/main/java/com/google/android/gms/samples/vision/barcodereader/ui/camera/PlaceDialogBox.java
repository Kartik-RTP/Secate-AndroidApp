package com.google.android.gms.samples.vision.barcodereader.ui.camera;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.samples.vision.barcodereader.BarcodeCaptureActivity;
import com.google.android.gms.samples.vision.barcodereader.R;

/**
 * Created by kartik on 30/3/16.
 */


public class PlaceDialogBox extends DialogFragment {

    private Button mDestinationButton;
    private EditText mDestinationEditText;
    private String mDestination;
    private String barcodeValue;
    private AlertDialog dialog;
    private String date;
    private String time;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);
        final Context context = getActivity();
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_home_out, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setView(view);

        mDestinationButton= (Button) view.findViewById(R.id.destinationButton);
        mDestinationEditText = (EditText) view.findViewById(R.id.destinationEditText);
        barcodeValue = getArguments().getString("Entry");
        date = getArguments().getString("date");
        time = getArguments().getString("time");

        mDestinationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDestination = mDestinationEditText.getText().toString();
                BarcodeCaptureActivity.getInstance().insert(barcodeValue, date, time, mDestination);

            }
        });
        /*
        builder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //sample text to check if the mDestinationButton is accessible
                mDestination = mDestinationEditText.getText().toString();
                BarcodeCaptureActivity.getInstance().insert(barcodeValue, date, time, mDestination);


            }
        });
        */

        /*mDestinationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });*/




        AlertDialog dialog = builder.create();
        return dialog;
    }
    /*
    @Override
    public void onResume() {
        int width = getResources().getDimensionPixelSize(R.dimen.fragment_width);
        int height = getResources().getDimensionPixelSize(R.dimen.fragment_height);
        getDialog().getWindow().setLayout(width, height);
    }*/

    @Override
    public void onStart() {
        super.onStart();
        // safety check
        if (getDialog() == null) {
            return;
        }
        //getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        int dialogWidth = getResources().getDimensionPixelSize(R.dimen.fragment_place_width); // specify a value here
        int dialogHeight = getResources().getDimensionPixelSize(R.dimen.fragment_place_height); // specify a value here

        getDialog().getWindow().setLayout(dialogWidth, dialogHeight);

        // ... other stuff you want to do in your onStart() method
    }
}