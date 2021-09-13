package com.aaamab.sumapp.ui.Input;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aaamab.sumapp.R;
import com.aaamab.sumapp.ui.Output.OutputScreen;

import static android.service.controls.ControlsProviderService.TAG;

public class InputScreen extends AppCompatActivity {

    EditText first_num , second_num ;
    Button result_btn , clear_btn , add_btn , sub_btn , div_btn;
    Intent goToOutputScreen ;
    TextView addResult_txt ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_screen);
        //initial views
        initViews();
        goToOutputScreen = new Intent(InputScreen.this , OutputScreen.class);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number1 , number2 ;
                number1 = first_num.getText().toString();
                number2 = second_num.getText().toString();
                if (number1.isEmpty() || number2.isEmpty()){
                    Toast.makeText(InputScreen.this ,"Please Enter The values" , Toast.LENGTH_LONG).show();
                }else{
                    int num1 = Integer.parseInt(number1);
                    int num2 = Integer.parseInt(number2);
                    //sum(num1 , num2);
                    addResult_txt.setVisibility(View.VISIBLE);
                    int value = num1 + num2 ;

                    addResult_txt.setText(value+"");
                }

            }
        });

        sub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number1 , number2 ;
                number1 = first_num.getText().toString();
                number2 = second_num.getText().toString();
                if (number1.isEmpty() || number2.isEmpty()){
                    Toast.makeText(InputScreen.this ,"Please Enter The values" , Toast.LENGTH_LONG).show();
                }else{
                    int num1 = Integer.parseInt(number1);
                    int num2 = Integer.parseInt(number2);
                    sub(num1 , num2);

                }
            }
        });

        div_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number1 , number2 ;
                number1 = first_num.getText().toString();
                number2 = second_num.getText().toString();
                if (number1.isEmpty() || number2.isEmpty()){
                    Toast.makeText(InputScreen.this ,"Please Enter The values" , Toast.LENGTH_LONG).show();
                }else{
                    int num1 = Integer.parseInt(number1);
                    int num2 = Integer.parseInt(number2);
                    div(num1 , num2);

                }
            }
        });


        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first_num.setText("");
                second_num.setText("");
                addResult_txt.setText("");
                addResult_txt.setVisibility(View.GONE);
            }
        });



    }

    public void initViews() {
        // initial EditText
        first_num = findViewById(R.id.ed_fNum);
        second_num = findViewById(R.id.ed_sNum);

        //initial Buttons
        result_btn = findViewById(R.id.btn_result);
        clear_btn = findViewById(R.id.btn_clear);
        add_btn = findViewById(R.id.btn_add);
        sub_btn = findViewById(R.id.btn_sub);
        div_btn = findViewById(R.id.btn_div);


        //initial TextView
        addResult_txt = findViewById(R.id.txt_addResult);
    }


    // this function to sum two numbers
    public void sum(int n1 , int n2){
        int value = n1 + n2 ;

        goToOutputScreen.putExtra("result" , value);
        startActivity(goToOutputScreen);

        //Toast.makeText(InputScreen.this , "The Result: "+value , Toast.LENGTH_LONG).show();

        /*Intent goToOutputScreen = new Intent(InputScreen.this , OutputScreen.class);

        goToOutputScreen.putExtra("sum" , value);

        startActivity(goToOutputScreen);*/

    }
    //this function to sub two numbers
    public void sub(int n1 , int n2){
        int value = n1 - n2 ;
        if (value < 0){
            value *= -1 ;
        }



        goToOutputScreen.putExtra("result" , value);
        startActivity(goToOutputScreen);


    }

    // this function to div two numbers
    public void div(int n1 , int n2){

        //int value = n1 % n2 ;

        double value =  Double.valueOf(n1) / Double.valueOf(n2) ;

        Log.e(TAG, "div: "+ value );

        goToOutputScreen.putExtra("result" , value);
        startActivity(goToOutputScreen);

    }



}