package ru.mirea.lukyanchuk.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Calendar calendar = Calendar.getInstance();
    TextView currentDateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentDateTime = findViewById(R.id.textView);
        setInitialDateTime();
    }
    private void setInitialDateTime() {
        Calendar dateAndTime=Calendar.getInstance();
        currentDateTime.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                        | DateUtils.FORMAT_SHOW_TIME));
    }

    public void onClickShowDialog(View view){
        MyDialogFragment dialogFragment = new MyDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "mirea");
    }

    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Ты выбрал \"Идти вперед\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Ты выбрал \"НЕТ\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Ты выбрал \"Паузу\"!",
                Toast.LENGTH_LONG).show();
    }

    public void onClickDate(View view){
        MyDateDialogFragment fragment = new MyDateDialogFragment();
        new DatePickerDialog(MainActivity.this, fragment.d,
                fragment.calendar.get(Calendar.YEAR),
                fragment.calendar.get(Calendar.MONTH),
                fragment.calendar.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    public void onClickTime(View view) {
        MyTimeDialogFragment fragment = new MyTimeDialogFragment();
        new TimePickerDialog(this, fragment.t,
                fragment.calendar.get(Calendar.HOUR_OF_DAY),
                fragment.calendar.get(Calendar.MINUTE), true)
                .show();
    }

    public void onClickProgress(View view){
        MyProgressDialogFragment fragment = new MyProgressDialogFragment(this);
        fragment.onProgress();
    }
}