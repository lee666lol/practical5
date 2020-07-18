package com.example.practical5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.labels_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if (spinner != null){
            spinner.setAdapter(adapter);
        }
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()){
            case R.id.today:
                if(checked)
                    displayToast(getString(R.string.dely_today));
                break;
            case R.id.nextday:
                if(checked)
                    displayToast(getString(R.string.dely_Nextday));
                break;
            case R.id.pickup:
                if(checked)
                    displayToast(getString(R.string.dely_pickup));
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void showDatePicker(View view){
        DialogFragment newFragment = new DataPicker();
        newFragment.show(getSupportFragmentManager(), "dataPicker");
    }

    public void processDatePickerResult(int year, int month, int day){
        String month_string = Integer.toString(month+1);
        String day_string =  Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string + "/" + day_string + "/" + year_string);
        Toast.makeText(this, "Date: "+ dateMessage, Toast.LENGTH_SHORT).show();
    }
}