package com.google.android.gms.samples.vision.barcodereader;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

/**
 * Created by kartik on 28/3/16.
 */

public class ConfirmDialogBox extends DialogFragment {
    private String barcodeValue;
    private AlertDialog dialog;
    private String date;
    private String time;
    private Button mOkButton;
    /*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        barcodeValue = getArguments().getString("Entry");
        date = getArguments().getString("date");
        time = getArguments().getString("time");
    }*/

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);

            final Context context = getActivity();
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View view = inflater.inflate(R.layout.fragment_regular_home_in, null);
            barcodeValue = getArguments().getString("Entry");
            date = getArguments().getString("date");
            time = getArguments().getString("time");

            AlertDialog.Builder builder = new AlertDialog.Builder(context)
                                       // .setTitle(barcodeValue)
                                        //.setMessage("REGULAR/HOMEIN")
                                        .setView(view);

            mOkButton = (Button) view.findViewById(R.id.okButton);
            mOkButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BarcodeCaptureActivity.getInstance().insert(barcodeValue, date, time, "null");

                }
            });

            dialog = builder.create();


        return dialog;
    }
    @Override
    public void onStart() {
        super.onStart();
        // safety check
        if (getDialog() == null) {
            return;
        }
        //getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        int dialogWidth = getResources().getDimensionPixelSize(R.dimen.fragment_ok_width); // specify a value here
        int dialogHeight = getResources().getDimensionPixelSize(R.dimen.fragment_ok_height); // specify a value here

        getDialog().getWindow().setLayout(dialogWidth, dialogHeight);

        // ... other stuff you want to do in your onStart() method
    }

}

