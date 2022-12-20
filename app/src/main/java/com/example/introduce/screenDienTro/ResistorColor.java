package com.example.introduce.screenDienTro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.introduce.R;

public class ResistorColor extends AppCompatActivity {
    private TextView myTextView; // text view in the layout
    private RelativeLayout myBackgroundLayout; // layout background
    private ImageView image;
    private ImageView image2;
    private TextView tvHeading;
    private TextView resistorValue;
    private TextView view1;
    private ImageView bandOne, bandTwo, bandThree, tolerance;
    private int tol = 0;
    private double dig1 = 0;
    private double dig2 = 0;
    private double dig3 = 1;
    private double totalValue;
    private String Multi = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistor_color);
        setTitle("Resistor");
        view1 = (TextView) findViewById(R.id.View);
        RelativeLayout myBackgroundLayout;
        //creating band image views to use images for spinners
        bandOne = findViewById(R.id.colorOne);
        bandTwo = findViewById(R.id.colorTwo);
        bandThree = (ImageView) findViewById(R.id.colorThree);
        tolerance = (ImageView) findViewById(R.id.Tolerance);
        resistorValue = (TextView) findViewById(R.id.resValue);

        //spinners for resistor colors
        NumberPicker pickerOne = (NumberPicker) findViewById(R.id.bandOne);
        NumberPicker pickerTwo = (NumberPicker) findViewById(R.id.bandTwo);
        NumberPicker pickerThree = (NumberPicker) findViewById(R.id.bandThree);
        NumberPicker pickerTolerance = (NumberPicker) findViewById(R.id.bandTolerance);
        pickerOne.setMinValue(0);
        pickerOne.setMaxValue(9);
        pickerTwo.setMinValue(0);
        pickerTwo.setMaxValue(9);
        pickerThree.setMinValue(0);
        pickerThree.setMaxValue(9);
        pickerTolerance.setMinValue(0);
        pickerTolerance.setMaxValue(2);
        calculator();


        // Sets the options for resistor color values
        pickerOne
                .setDisplayedValues(new String[]{"Black", "Brown", "Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Grey", "White"});
        pickerTwo
                .setDisplayedValues(new String[]{"Black", "Brown", "Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Grey", "White"});
        pickerThree
                .setDisplayedValues(new String[]{"Black", "Brown", "Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Grey", "White"});
        pickerTolerance
                .setDisplayedValues(new String[]{"", "Gold", "Silver"});

        //sets the image according to spinner value
        pickerOne
                .setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal,
                                              int newVal) {
                        // TODO Auto-generated method stub
                        // resistorValue.setText(Integer.toString(totalValue));
                        dig1 = newVal;
                        switch (newVal) {
                            case 0:
                                bandOne.setImageResource(R.drawable.black);
                                break;
                            case 1:
                                bandOne.setImageResource(R.drawable.brown);
                                break;
                            case 2:
                                bandOne.setImageResource(R.drawable.red);
                                break;
                            case 3:
                                bandOne.setImageResource(R.drawable.orange);
                                break;
                            case 4:
                                bandOne.setImageResource(R.drawable.yellow);
                                break;
                            case 5:
                                bandOne.setImageResource(R.drawable.green);
                                break;
                            case 6:
                                bandOne.setImageResource(R.drawable.blue);
                                break;
                            case 7:
                                bandOne.setImageResource(R.drawable.violet);
                                break;
                            case 8:
                                bandOne.setImageResource(R.drawable.grey);
                                break;
                            case 9:
                                bandOne.setImageResource(R.drawable.white);
                                break;
                        }
                        calculator();
                    }
                });


        pickerTwo
                .setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal,
                                              int newVal) {
                        // TODO Auto-generated method stub
                        // resistorValue.setText(Integer.toString(totalValue));
                        dig2 = newVal;
                        switch (newVal) {
                            case 0:
                                bandTwo.setImageResource(R.drawable.black);
                                break;
                            case 1:
                                bandTwo.setImageResource(R.drawable.brown);
                                break;
                            case 2:
                                bandTwo.setImageResource(R.drawable.red);
                                break;
                            case 3:
                                bandTwo.setImageResource(R.drawable.orange);
                                break;
                            case 4:
                                bandTwo.setImageResource(R.drawable.yellow);
                                break;
                            case 5:
                                bandTwo.setImageResource(R.drawable.green);
                                break;
                            case 6:
                                bandTwo.setImageResource(R.drawable.blue);
                                break;
                            case 7:
                                bandTwo.setImageResource(R.drawable.violet);
                                break;
                            case 8:
                                bandTwo.setImageResource(R.drawable.grey);
                                break;
                            case 9:
                                bandTwo.setImageResource(R.drawable.white);
                                break;
                        }
                        calculator();
                    }
                });

        pickerThree
                .setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal,
                                              int newVal) {
                        // TODO Auto-generated method stub
                        switch (newVal) {
                            case 0:
                                bandThree.setImageResource(R.drawable.black);
                                Multi = "";
                                dig3 = 1;
                                break;
                            case 1:
                                bandThree.setImageResource(R.drawable.brown);
                                dig3 = 10;
                                Multi = "";
                                break;
                            case 2:
                                bandThree.setImageResource(R.drawable.red);
                                dig3 = 0.1;
                                Multi = "K";
                                break;
                            case 3:
                                bandThree.setImageResource(R.drawable.orange);
                                dig3 = 1;
                                Multi = "K";
                                break;
                            case 4:
                                bandThree.setImageResource(R.drawable.yellow);
                                dig3 = 10;
                                Multi = "K";
                                break;
                            case 5:
                                bandThree.setImageResource(R.drawable.green);
                                dig3 = 0.1;
                                Multi = "M";
                                break;
                            case 6:
                                bandThree.setImageResource(R.drawable.blue);
                                dig3 = 1;
                                Multi = "M";
                                break;
                            case 7:
                                bandThree.setImageResource(R.drawable.violet);
                                dig3 = 10;
                                Multi = "M";
                                break;
                            case 8:
                                bandThree.setImageResource(R.drawable.grey);
                                dig3 = 0.1;
                                Multi = "G";
                                break;
                            case 9:
                                bandThree.setImageResource(R.drawable.white);
                                dig3 = 1;
                                Multi = "G";
                                break;

                        }
                        calculator();
                    }
                });


        pickerTolerance
                .setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal,
                                              int newVal) {
                        switch (newVal) {
                            case 0:
                                tolerance.setImageResource(R.drawable.none);
                                tol = 0;
                                break;
                            case 1:
                                tolerance.setImageResource(R.drawable.gold);
                                tol = 5;
                                break;
                            case 2:
                                tolerance.setImageResource(R.drawable.silver);
                                tol = 10;
                                break;
                        }
                        calculator();
                    }
                });
    }


    //Menu section color options; changes color when selected
    public void changeScheme(int colorValue) {
        myBackgroundLayout = (RelativeLayout) findViewById(R.id.backgroundLayout);
        myTextView = (TextView) findViewById(R.id.View);
        switch (colorValue) {
            case 0:
                myBackgroundLayout.setBackgroundColor(getResources().getColor(
                        R.color.NightBG));
                // night scheme
                myTextView.setTextColor(getResources().getColor(R.color.NightTxt));
                break;
            case 1:
                myBackgroundLayout.setBackgroundColor(getResources().getColor(
                        R.color.NatureBG)); // nature scheme
                myTextView.setTextColor(getResources().getColor(R.color.NatureTxt));
                break;
            case 2:
                myBackgroundLayout.setBackgroundColor(getResources().getColor(
                        R.color.FluroBG)); // fluro scheme
                myTextView.setTextColor(getResources().getColor(R.color.FluroTxt));
                break;
            case 3:
                myBackgroundLayout.setBackgroundColor(getResources().getColor(
                        R.color.ConstructionBG)); // construction scheme
                myTextView.setTextColor(getResources().getColor(
                        R.color.ConstructionTxt));
                break;
            case 4:
                myBackgroundLayout.setBackgroundColor(getResources().getColor(
                        R.color.White)); // standard scheme
                myTextView.setTextColor(getResources().getColor(R.color.Black));
                break;
        }
    }

    // set the text size for the TextView
    public void changeTextSize(int size) {
        myTextView = (TextView) findViewById(R.id.View);
        // text_size = size;
        switch (size) {
            case 0:
                myTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, getResources()
                        .getDimension(R.dimen.text_size_sml));
                break;
            case 1:
                myTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, getResources()
                        .getDimension(R.dimen.text_size_med));

                break;
            case 2:
                myTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, getResources()
                        .getDimension(R.dimen.text_size_lge));
                break;
        }
    } // end of changeTextSize method

    //Creates Menu section
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        Log.d("<<<TAG2>>>", "<<<<MENU INFLATER>>>");
        return true;

    }

    //Sets menu options
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("<<<TAG1>>>", "<<<<After On Select>>>");
        int id = item.getItemId();
        switch (id) {
            case R.id.night:
                changeScheme(0);
                return true;
            case R.id.nature:
                changeScheme(1);
                return true;
            case R.id.fluro:
                changeScheme(2);
                return true;
            case R.id.construction:
                changeScheme(3);
                return true;
            case R.id.standard:
                changeScheme(4);
                return true;
            case R.id.text_sml:
                changeTextSize(0);
                return true;
            case R.id.text_med:
                changeTextSize(1);
                return true;
            case R.id.text_lrg:
                changeTextSize(2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Calculates the resistor value and sets text as its value.
    public void calculator() {
        totalValue = ((dig1 * 10) + dig2) * dig3;
        view1.setText(String.format("%.1f", totalValue) + Multi + " ohms   " + Integer.toString(tol) + " %");
    }
}