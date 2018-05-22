package com.example.moonnek0.cthulhudice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Button;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private NumberPicker numLeft;
    private NumberPicker numRight;
    private TextView calResult;
    private Button drawresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numLeft = (NumberPicker) findViewById(R.id.numLeft);
        numRight = (NumberPicker) findViewById(R.id.numRight);
        calResult= (TextView) findViewById(R.id.calResult);
        drawresult = (Button)findViewById(R.id.drawresult);
        numLeft.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        numRight.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        String[] displayValue;
        displayValue = new String[]{"3","6","8","10","20","100"};
        numLeft.setMinValue(1);
        numLeft.setMaxValue(12);
        numRight.setMinValue(1);
        numRight.setMaxValue(displayValue.length);
        numRight.setDisplayedValues(displayValue);
    }


    public void onClick(View view) {
        int faceOfDice;
        switch (numRight.getValue()){
            case 1:
                faceOfDice = 3;
                break;
            case 2:
                faceOfDice = 6;
                break;
            case 3:
                faceOfDice = 8;
                break;
            case 4:
                faceOfDice = 10;
                break;
            case 5:
                faceOfDice = 20;
                break;
            case 6:
                faceOfDice = 100;
                break;
                default:
                    faceOfDice =0;
                    break;
        }

        Random rand = new Random();
        int result = numLeft.getValue()*(rand.nextInt(faceOfDice)+1);
        calResult.setText(Integer.toString(result));
    }


}
