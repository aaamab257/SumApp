package com.aaamab.sumapp.ui.Output;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.aaamab.sumapp.R;

public class OutputScreen extends AppCompatActivity {


    TextView value_txt;
    Button back_btn;
    Intent getValue  ;
    double result  ;
    ImageView imgBack ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_screen);

        //initial views
        initViews();


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // this method to back to the last screen
                onBackPressed();
            }
        });


        // this intent to get the data from other screen
        getValue = getIntent();
        result = getValue.getDoubleExtra("result" , 0);
        value_txt.setText(result+"");

    }

    private void initViews() {
        value_txt = findViewById(R.id.txt_value);
        back_btn = findViewById(R.id.btn_back);
        imgBack = findViewById(R.id.backIcon);
    }
}