package com.unitconverter;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class LengthConverter extends ActionBarActivity {

    EditText lenInput;
    TextView answerText;
    double fianalLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_converter);

        //  To hide keyboard when not in use
        View view = (View) findViewById(R.id.parentView);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm = (InputMethodManager) getSystemService(
                        INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        });
    }

    public void convert ( View view ){

        //  Getting the input from edit text
        lenInput = (EditText) findViewById(R.id.inputLength);
        double inputLength = 0;
        int invalid = 1;

        if ( lenInput.getText().toString().length() == 0 )
        {
            Toast.makeText(LengthConverter.this, "Enter a valid Length", Toast.LENGTH_LONG ).show();
        }
        else
        {
            invalid = 0;
            inputLength = Double.parseDouble(lenInput.getText().toString());

            //  Getting "from" selection from the radio group
            RadioGroup toRadio = (RadioGroup) findViewById(R.id.toGroup);
            int toID = toRadio.getCheckedRadioButtonId();
            RadioButton to = (RadioButton) findViewById(toID);

            //  Getting "to" selection from the radio group
            RadioGroup fromRadio = (RadioGroup) findViewById(R.id.fromGroup);
            int fromID = fromRadio.getCheckedRadioButtonId();
            RadioButton from = (RadioButton) findViewById(fromID);

            // Calculation
            if ( to.getText().toString().equals("Centimeter") && ( from.getText().toString().equals("Inches") ) )
            {
                fianalLength = centimeterToInches(inputLength);
            }
            else if ( to.getText().toString().equals("Centimeter") && ( from.getText().toString().equals("Foot") ) )
            {
                fianalLength = centimeterToFoot(inputLength);
            }

            else if ( to.getText().toString().equals("Inches") && ( from.getText().toString().equals("Centimeter") ) )
            {
                fianalLength = inchesToCentimeter(inputLength);
            }

            else if ( to.getText().toString().equals("Inches") && ( from.getText().toString().equals("Foot") ) )
            {
                fianalLength = inchesToFoot(inputLength);
            }

            else if ( to.getText().toString().equals("Foot") && ( from.getText().toString().equals("Centimeter") ) )
            {
                fianalLength = footToCentimeter(inputLength);
            }

            else if ( to.getText().toString().equals("Foot") && ( from.getText().toString().equals("Inches") ) )
            {
                fianalLength = footToinches(inputLength);
            }
            else
            {
                fianalLength = inputLength;
            }
            //  Display answer!
            answerText = (TextView) findViewById(R.id.answer);
            answerText.setText(String.valueOf(fianalLength));
        }


    }
    // Meathod CENTIMETER to INCHES
    public double centimeterToInches ( double centimeter ){
        double inches;
        inches = centimeter * 0.393;
        return inches;
    }

    // Meathod CENTIMETER to FOOT
    public double centimeterToFoot ( double centimeter ){
        double foot;
        foot = centimeter * 0.0328;
        return foot;
    }

    // Meathod INCHES to FOOT
    public double inchesToFoot ( double inches ){
        double foot;
        foot = inches / 12;
        return foot;
    }

    // Meathod INCHES to CENTIMETER
    public double inchesToCentimeter ( double inches ){
        double centimeter;
        centimeter = inches * 2.54;
        return centimeter;
    }

    // Meathod FOOT to CENTIMETER
    public double footToCentimeter ( double foot ){
        double centimeter;
        centimeter = foot * 30.48;
        return centimeter;
    }

    // Meathod FOOT to INCHES
    public double footToinches ( double foot ){
        double inches;
        inches = foot * 12;
        return inches;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.temp_converter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_temp_converter, container, false);
            return rootView;
        }
    }

}
