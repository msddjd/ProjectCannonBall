package edu.mercer.projectcannonball;


import android.support.v4.app.DialogFragment;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.content.DialogInterface;
import android.widget.Toast;



/**
 * Created by Mike on 4/30/2015.
 */
public class RateAppAlertDialogFragment extends DialogFragment{
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog myDialog = null;

        myDialog = new AlertDialog.Builder(getActivity())

                .setTitle(R.string.rate_dialogue_title)
                .setMessage(R.string.rate_dialogue_message)
                .setPositiveButton(R.string.rate_dialogue_positive,myAlertDialogListener)
                .setNegativeButton(R.string.rate_dialogue_negative,myAlertDialogListener)
                .create();

        return myDialog;
    }

    private DialogInterface.OnClickListener myAlertDialogListener = new DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface dialog, int whichButton) {
            switch (whichButton) {
                case Dialog.BUTTON_POSITIVE:
                    Toast.makeText(getActivity().getBaseContext(), R.string.rate_dialogue_pos_toast_msg, Toast.LENGTH_SHORT).show();
                    break;
                case Dialog.BUTTON_NEGATIVE:
                    Toast.makeText(getActivity().getBaseContext(), R.string.rate_dialogue_neg_toast_msg, Toast.LENGTH_SHORT).show();
            }
            dialog.dismiss();

        }


    };

}
