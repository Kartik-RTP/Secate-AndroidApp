package com.google.android.gms.samples.vision.barcodereader;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by kartik on 28/3/16.
 */

public class ConfirmDialogBox extends DialogFragment {
    private String barcodeValue;
    private AlertDialog dialog;
    private String date;
    private String time;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        barcodeValue = getArguments().getString("Entry");
        date = getArguments().getString("date");
        time = getArguments().getString("time");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);

            Context context = getActivity();


            AlertDialog.Builder builder = new AlertDialog.Builder(context)
                    .setTitle(barcodeValue)
                    .setMessage("REGULAR/HOMEIN")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                           BarcodeCaptureActivity.getInstance().insert(barcodeValue, date, time, "null");

                        }
                    });

            dialog = builder.create();


        return dialog;
    }

}

