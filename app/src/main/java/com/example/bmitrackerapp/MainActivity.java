package com.example.bmitrackerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText editTextWeight = findViewById(R.id.weight);
        EditText editTextHeight = findViewById(R.id.height);
        Button button = findViewById(R.id.btnSubmit);
        TextView textView = findViewById(R.id.result);
        LinearLayout main = findViewById(R.id.main);
        TextView tVForColor = findViewById(R.id.condition);

        button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float height = Float.parseFloat(String.valueOf(editTextHeight.getText())) / 100;
                float weight = Float.parseFloat(String.valueOf(editTextWeight.getText()));
                float bmi = weight / (height * height);
                textView.setText(String.valueOf(bmi));

                if(bmi > 25){
                    tVForColor.setText("You are Overweight");
                    main.setBackgroundColor(getResources().getColor(R.color.ow));
                } else if (bmi < 18) {
                    tVForColor.setText("You are Underweight");
                    main.setBackgroundColor(getResources().getColor(R.color.uw));
                } else {
                    tVForColor.setText("You are Healthy");
                    main.setBackgroundColor(getResources().getColor(R.color.h));
                }
            }
        }));
    }
}