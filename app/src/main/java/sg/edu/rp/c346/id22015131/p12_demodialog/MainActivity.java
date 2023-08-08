package sg.edu.rp.c346.id22015131.p12_demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnDemo1, btnDemo2, btnDemo3, btnEx3, btnDemo4, btnDemo5;
    TextView tvDemo2, tvDemo3, tvEx3, tvDemo4 ,tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = (Button) findViewById(R.id.buttonDemo1);
        btnDemo2 = (Button) findViewById(R.id.buttonDemo2);
        btnDemo3 = (Button) findViewById(R.id.buttonDemo3);
        btnEx3 = (Button) findViewById(R.id.buttonEx3);
        btnDemo4 = (Button) findViewById(R.id.buttonDemo4);
        btnDemo5 = (Button) findViewById(R.id.buttonDemo5);
        tvDemo2 = (TextView) findViewById(R.id.textViewDemo2);
        tvDemo3 = (TextView) findViewById(R.id.textViewDemo3);
        tvEx3 = (TextView) findViewById(R.id.textViewEx3);
        tvDemo4 = (TextView) findViewById(R.id.textViewDemo4);
        tvDemo5 = (TextView) findViewById(R.id.textViewDemo5);

        btnDemo1.setOnClickListener(v -> {
            AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

            // Set the dialog details
            /*
            myBuilder.setTitle("Demo 1-Simple Dialog");
            myBuilder.setMessage("I can develop Android App.");
            myBuilder.setCancelable(false);
            myBuilder.setPositiveButton("Close", null);
            */

            myBuilder.setTitle("Congratulations");
            myBuilder.setMessage("You have completed a simple Dialog Box");
            myBuilder.setCancelable(true);
            myBuilder.setPositiveButton("DISMISS", null);

            AlertDialog myDialog = myBuilder.create();
            myDialog.show();
        });

        btnDemo2.setOnClickListener(v -> {
            AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
            myBuilder.setTitle("Demo 2 Buttons Dialog");
            myBuilder.setMessage("Select one of the Buttons below.");
            myBuilder.setCancelable(false);

            // Configure the 'positive' button
            myBuilder.setPositiveButton("Yes", (dialog, which) -> {
                tvDemo2.setText("You have selected Positive");
            });

            //Configure the 'negative' button
            myBuilder.setNegativeButton("No", (dialog, which) -> {
               tvDemo2.setText("You have selected Negative");
            });

            // Configure the 'neutral' button
            myBuilder.setNeutralButton("Cancel", null);
            AlertDialog myDialog = myBuilder.create();
            myDialog.show();
        });

        btnDemo3.setOnClickListener(v -> {
            LayoutInflater inflater =  (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View viewDialog = inflater.inflate(R.layout.input, null);

            final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

            AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
            myBuilder.setView(viewDialog);
            myBuilder.setTitle("Demo 3-Text Input Dialog");
            myBuilder.setPositiveButton("OK", (dialog, which) -> {
                String message = etInput.getText().toString();
                tvDemo3.setText(message);
            });
            myBuilder.setNegativeButton("CANCEL", null);
            AlertDialog myDialog = myBuilder.create();
            myDialog.show();
        });

        btnEx3.setOnClickListener(v -> {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View viewDialog = inflater.inflate(R.layout.input2, null);

            final EditText etInputNum1 = viewDialog.findViewById(R.id.editTextNum1);
            final EditText etInputNum2 = viewDialog.findViewById(R.id.editTextNum2);

            AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
            myBuilder.setView(viewDialog);
            myBuilder.setTitle("Exercise 3");
            myBuilder.setPositiveButton("OK", (dialog, which) -> {
                int num1 = Integer.parseInt(etInputNum1.getText().toString());
                int num2 = Integer.parseInt(etInputNum2.getText().toString());
                int sum = num1 + num2;
                tvEx3.setText("The sum is " + sum);
            });
            myBuilder.setNegativeButton("CANCEL", null);
            AlertDialog myDialog = myBuilder.create();
            myDialog.show();
        });

        btnDemo4.setOnClickListener(v -> {
            DatePickerDialog.OnDateSetListener  myDateListener = (view, year, month, dayOfMonth) -> {
                tvDemo4.setText("Date: " + dayOfMonth + "/" + (month+1) + "/" + year);
            };
            Calendar currentDate = Calendar.getInstance();
            DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH));
            myDateDialog.show();
        });

        btnDemo5.setOnClickListener(v -> {
            TimePickerDialog.OnTimeSetListener myTimeListener = (view, hourOfDay, minute) -> {
                tvDemo5.setText("Time: " + hourOfDay + ":" + minute);
            };
            Calendar currentTime = Calendar.getInstance();
            TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, currentTime.get(Calendar.HOUR), currentTime.get(Calendar.MINUTE), false);
            myTimeDialog.show();
        });

    }
}