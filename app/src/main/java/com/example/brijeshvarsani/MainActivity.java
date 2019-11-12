package com.example.brijeshvarsani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public void throwError(){
        if(true){
            throw new Error ("Something went wrong");
        }
    }
    private Button button;
    private Button button2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =(Button) findViewById(R.id.button);              //xml id for button
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 openActivity2();
             }
         });
         button2 = findViewById(R.id.button2);
         button2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 openActivity3();
             }
         });

    }
    public void openActivity2(){
        Intent intent = new Intent(this , activity2.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent = new Intent(this , activity3.class);
        startActivity(intent);

    }

    public void buttonClicked (View view){
        TextView text = findViewById(R.id.textView);
        TextView text2 = findViewById(R.id.textViewAnother);
        text2.setText(" Brijesh 2");
        text.setText("BRIJEEESH");

    }

}
