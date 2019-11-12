package com.example.brijeshvarsani;

import androidx.appcompat.app.AppCompatActivity;

import android.drm.DrmStore;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.function.DoublePredicate;
import java.util.regex.Pattern;

public class activity3 extends AppCompatActivity {


    private Button[] numPad;    //size 10
    private Button[] operatorsButtons; //size 6
    private Button CE;
//    private Button point;
//    private Button add;
//    private Button subtract;
//    private Button multiply;
//    private Button divide;
//    private Button equal;

    final String[] operatorTags = {"point", "plus", "subtract", "multiply", "divide", "equals"};
    final Character[] operatorSymbols = {'.', '+', '-', '*', '/', '='};
    HashMap<String, Character> operatorsAndTags;

    final int POINT = 0, ADD = 1, SUBSTRUCT = 2, MULTIPLY = 3, DIVIDE = 4, EQUAL = 5;
    private TextView textView2;
    private EditText editText;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQL = 0;

    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;


    //reset after each calculation
    private boolean doesOperatorExist = false;
    private char operation;
    private boolean pointPressed = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);
        System.out.println("ASDadasdadasd");
        setupUIView();
    }


    private void setupUIView() {
        GridLayout numPadLayout = findViewById(R.id.numPadLayout);
        numPad = new Button[10];
        for (int i = 0; i < 10; i++) {
            numPad[i] = numPadLayout.findViewWithTag(i + "");
            numPad[i].setText(i + "");
        }

        operatorsButtons = new Button[6];
        for (int i = 0; i < operatorTags.length; i++) {
            operatorsButtons[i] = numPadLayout.findViewWithTag(operatorTags[i] + "");
            operatorsButtons[i].setText(operatorSymbols[i] + "");
        }

        textView2 = findViewById(R.id.textView2);
        editText = findViewById(R.id.editText);
        editText.setEnabled(false);
        for (int i = 0; i < 10; i++) {
            numPad[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editText.setText(editText.getText().toString() + v.getTag());

                }
            });
        }

        for (int i = 0; i < 6; i++) {
            final int op = i;
            operatorsButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.getTag().equals("equals")) {
                        String expr = editText.getText().toString();
                        double result = calculate(expr);
                        textView2.setText(result + "");       // result + ""
                    }
                    if(v.getTag().toString().equals("point") && !pointPressed){
                        pointPressed = true;
                        editText.setText(editText.getText().toString() + operatorSymbols[op]);
                    }
                    else if (!doesOperatorExist) {
                        operation = operatorSymbols[op];
                        editText.setText(editText.getText().toString() + operatorSymbols[op]);

                        pointPressed = false;
                        doesOperatorExist = true;
                    }

                }
            });
        }

    }

    private double calculate(String expr) {
        String ab[] = expr.split(Pattern.quote(Character.toString(operation)));
        double a = Double.parseDouble(ab[0]);
        double b = Double.parseDouble(ab[1]);
        switch(operation){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case'*':
                return a*b;
            case'/':
                return a/b;
        }
        return 0;
    }

    private void compute() {
        if (!Double.isNaN(val1)) {
            val2 = Double.parseDouble(editText.getText().toString());
            switch (ACTION) {
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / (val2);
                    break;
                case EQL:
                    break;

            }
        } else {
            val1 = Double.parseDouble(editText.getText().toString());
        }
    }
}
