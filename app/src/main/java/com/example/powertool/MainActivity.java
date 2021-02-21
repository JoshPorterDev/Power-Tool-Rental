package com.example.powertool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Spinner spinner;
    private RadioGroup radioGroup;
    private RadioButton radioButton, toolOneButton, toolTwoButton;
    private TextView textView;
    double price;
    int noDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Save widgets to variables
        button = findViewById(R.id.button);
        radioGroup = findViewById((R.id.radioGroup));
        spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.textView2);
        toolOneButton = findViewById(R.id.radioButton);
        toolTwoButton = findViewById(R.id.radioButton2);

        // Set click listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get id of selected radio button and save it to the radioButton variable
                int selectedTool = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(selectedTool);

                // Get number of days value from spinner
                noDays = Integer.parseInt(spinner.getSelectedItem().toString());

                // If selected tool is power washer
                if ((radioButton.getId()) == (toolOneButton.getId()))
                {
                    price = (noDays * 55.99);
                }
                // Tiller is selected
                else if ((radioButton.getId()) == (toolTwoButton.getId()))
                {
                    price = (noDays * 68.99);
                }

                // Set text view widget to visible and display price
                textView.setVisibility(View.VISIBLE);
                textView.setText(getString(R.string.totalCostText, price));
            }
        });
    }
}