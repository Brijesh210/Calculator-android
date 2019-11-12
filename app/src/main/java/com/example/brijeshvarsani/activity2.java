package com.example.brijeshvarsani;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity2 extends AppCompatActivity {
    private EditText height, weight;
    private TextView result;
    private Button calculate;
    double height_num, weight_num;
    double bmiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        result = findViewById(R.id.BMI_result);
        calculate = findViewById(R.id.buttonCal);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMS(v);
            }
        });
    }



    private void calculateBMS(View view){
        height_num = Double.parseDouble(height.getText().toString());
        weight_num = Double.parseDouble(weight.getText().toString());

        bmiResult = weight_num / (height_num*height_num);
        result.setText(String.valueOf(bmiResult));
    }
}
