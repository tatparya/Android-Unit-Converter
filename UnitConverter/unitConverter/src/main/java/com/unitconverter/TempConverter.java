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

public class TempConverter extends ActionBarActivity {

    EditText tempInput;
    TextView answerText;
    double finalTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_converter);

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
        tempInput = (EditText) findViewById(R.id.inputTemp);
        double inputTemp = 0;
        int invalid = 1;

        if ( tempInput.getText().toString().length() == 0 )
        {
            Toast.makeText(TempConverter.this, "Enter a valid Temperature", Toast.LENGTH_LONG ).show();
        }
        else
        {
            invalid = 0;
            inputTemp = Double.parseDouble(tempInput.getText().toString());

            //  Getting "from" selection from the radio group
            RadioGroup toRadio = (RadioGroup) findViewById(R.id.toGroup);
            int toID = toRadio.getCheckedRadioButtonId();
            RadioButton to = (RadioButton) findViewById(toID);

            //  Getting "to" selection from the radio group
            RadioGroup fromRadio = (RadioGroup) findViewById(R.id.fromGroup);
            int fromID = fromRadio.getCheckedRadioButtonId();
            RadioButton from = (RadioButton) findViewById(fromID);

            // Calculation
            if ( to.getText().toString().equals("Kelvin") && ( from.getText().toString().equals("Celsius") ) )
            {
                finalTemp = kelvinToCelsius(inputTemp);
            }
            else if ( to.getText().toString().equals("Kelvin") && ( from.getText().toString().equals("Fahrenheit") ) )
            {
                finalTemp = kelvinToFahrenheit(inputTemp);
            }

            else if ( to.getText().toString().equals("Celsius") && ( from.getText().toString().equals("Kelvin") ) )
            {
                finalTemp = celsiusToKelvin(inputTemp);
            }

            else if ( to.getText().toString().equals("Celsius") && ( from.getText().toString().equals("Fahrenheit") ) )
            {
                finalTemp = celsiusToFahrenheit(inputTemp);
            }

            else if ( to.getText().toString().equals("Fahrenheit") && ( from.getText().toString().equals("Celsius") ) )
            {
                finalTemp = fahrenheitToCelsius(inputTemp);
            }

            else if ( to.getText().toString().equals("Fahrenheit") && ( from.getText().toString().equals("Kelvin") ) )
            {
                finalTemp = fahrenheitToKelvin(inputTemp);
            }
            else
            {
                finalTemp = inputTemp;
            }
            //  Display answer!
            answerText = (TextView) findViewById(R.id.answer);
            answerText.setText(String.valueOf(finalTemp));
        }


    }
          // Meathod KELVIN to CELSIUS
        public double kelvinToCelsius ( double kelvin ){
            double celsius;
            celsius = kelvin - 272.15;
            return celsius;
        }

        // Meathod KELVIN to FAHRENHEIT
        public double kelvinToFahrenheit ( double kelvin ){
            double fahrenheit;
            fahrenheit = ( (double) 9 / 5 ) * ( kelvin + 272.15 + 32 );
            return fahrenheit;
        }

        // Meathod CELSIUS to KELVIN
        public double celsiusToKelvin ( double celcius ){
            double kelvin;
            kelvin = celcius + 272.15;
            return kelvin;
        }

        // Meathod CELSIUS to FAHRENHEIT
        public double celsiusToFahrenheit ( double celcius ){
            double fahrenheit;
            fahrenheit = ( (double) 9 / 5 ) * ( celcius + 32 );
            return fahrenheit;
        }

        // Meathod FAHRENHEIT to CELSIUS
        public double fahrenheitToCelsius ( double fahrenheit ){
            double celcius;
            celcius = ( (double) 5 / 9 ) * ( fahrenheit - 32 );
            return celcius;
        }

        // Meathod FAHRENHEIT to KELVIN
        public double fahrenheitToKelvin ( double fahrenheit ){
            double kelvin;
            kelvin = ( (double) 5 / 9 ) * ( fahrenheit - 32 ) - 272.15 ;
            return kelvin;
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
