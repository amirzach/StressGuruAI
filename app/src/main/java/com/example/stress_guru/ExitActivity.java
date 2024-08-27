package com.example.stress_guru;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class ExitActivity extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Exit StressGuru");
        builder.setMessage("Are you sure you would like to quit?");
        builder.setCancelable(false);

        builder.setPositiveButton("OK",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                Toast.makeText(getActivity(), "Exiting Application", Toast.LENGTH_SHORT);
                getActivity().finish();
            }
        });
        builder.setNegativeButton("CANCEL",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                Toast.makeText(getActivity(),"Cancelling", Toast.LENGTH_SHORT);
                getActivity().finish();
            }
        });
        AlertDialog alertDialog=builder.create();
        return alertDialog;
    }
}
