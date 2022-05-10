package ru.mirea.lukyanchuk.dialog;

import android.app.Activity;
import android.app.ProgressDialog;

import androidx.fragment.app.DialogFragment;

public class MyProgressDialogFragment extends DialogFragment {
    ProgressDialog progress;

    public MyProgressDialogFragment(Activity activity) {
        progress = new ProgressDialog(activity);
    }

    public void onProgress(){
        progress.setMessage("Downloading virus. . .");
        progress.setTitle("Security Service");
        progress.show();
    }
}
