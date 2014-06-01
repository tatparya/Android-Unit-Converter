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

public class mlToOz extends ActionBarActivity {

    EditText valInput;
    TextView answerText;
    double finalTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ml_to_oz);

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
        valInput = (EditText) findViewById(R.id.inputVal);
        double inputVal = 0;
        int invalid = 1;

        if ( valInput.getText().toString().length() == 0 )
        {
            Toast.makeText(mlToOz.this, "Enter a valid Value", Toast.LENGTH_LONG ).show();
        }
        else
        {
            invalid = 0;
            inputVal = Double.parseDouble(valInput.getText().toString());

            //  Getting "from" selection from the radio group
            RadioGroup toRadio = (RadioGroup) findViewById(R.id.toGroup);
            int toID = toRadio.getCheckedRadioButtonId();
            RadioButton to = (RadioButton) findViewById(toID);

            //  Getting "to" selection from the radio group
            RadioGroup fromRadio = (RadioGroup) findViewById(R.id.fromGroup);
            int fromID = fromRadio.getCheckedRadioButtonId();
            RadioButton from = (RadioButton) findViewById(fromID);

            // Calculation
            if ( to.getText().toString().equals("Litre") && ( from.getText().toString().equals("Millilitre") ) )
            {
                finalTemp = litreToMilliLitre(inputVal);
            }
            else if ( to.getText().toString().equals("Litre") && ( from.getText().toString().equals("Ounce") ) )
            {
                finalTemp = litreToOunce(inputVal);
            }

            else if ( to.getText().toString().equals("Millilitre") && ( from.getText().toString().equals("Ounce") ) )
            {
                finalTemp = millilitreToOunce(inputVal);
            }

            else if ( to.getText().toString().equals("Millilitre") && ( from.getText().toString().equals("Litre") ) )
            {
                finalTemp = millilitreToLitre(inputVal);
            }

            else if ( to.getText().toString().equals("Ounce") && ( from.getText().toString().equals("Litre") ) )
            {
                finalTemp = ounceToLitre(inputVal);
            }

            else if ( to.getText().toString().equals("Ounce") && ( from.getText().toString().equals("Millilitre") ) )
            {
                finalTemp = ounceToMillilitre(inputVal);
            }
            else
            {
                finalTemp = inputVal;
            }
            //  Display answer!
            answerText = (TextView) findViewById(R.id.answer);
            answerText.setText(String.valueOf(finalTemp));
        }

    }
    // Meathod LITRE to MILLILITRE
    public double litreToMilliLitre ( double litre ){
        double millilitre;
        millilitre = litre * 1000;
        return millilitre;
    }

    // Meathod LITRE to OUNCE
    public double litreToOunce ( double litre ){
        double ounce;
        ounce = litre * 33.814;
        return ounce;
    }

    // Meathod MILLILITRE to LITRE
    public double millilitreToLitre ( double millilitre ){
        double litre;
        litre = millilitre / 1000;
        return litre;
    }

    // Meathod MILLILITRE to OUNCE
    public double millilitreToOunce ( double millilitre ){
        double fahrenheit;
        fahrenheit =  millilitre / 29.573;
        return fahrenheit;
    }

    // Meathod OUNCE to LITRE
    public double ounceToLitre ( double ounce ){
        double litre;
        litre = ounce / 33.814;
        return litre;
    }

    // Meathod OUNCE to MILLILITRE
    public double ounceToMillilitre ( double ounce ){
        double millilitre;
        millilitre = ounce * 29.573 ;
        return millilitre;
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
