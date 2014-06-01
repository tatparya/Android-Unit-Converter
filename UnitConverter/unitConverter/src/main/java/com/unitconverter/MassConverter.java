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

public class MassConverter extends ActionBarActivity {

    EditText massInput;
    TextView answerText;
    double finalMass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass_converter);

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
        massInput = (EditText) findViewById(R.id.inputMass);
        double inputMass = 0;
        int invalid = 1;

        if ( massInput.getText().toString().length() == 0 )
        {
            Toast.makeText(MassConverter.this, "Enter a valid Mass", Toast.LENGTH_LONG ).show();
        }
        else
        {
            invalid = 0;
            inputMass = Double.parseDouble(massInput.getText().toString());

            //  Getting "from" selection from the radio group
            RadioGroup toRadio = (RadioGroup) findViewById(R.id.toGroup);
            int toID = toRadio.getCheckedRadioButtonId();
            RadioButton to = (RadioButton) findViewById(toID);

            //  Getting "to" selection from the radio group
            RadioGroup fromRadio = (RadioGroup) findViewById(R.id.fromGroup);
            int fromID = fromRadio.getCheckedRadioButtonId();
            RadioButton from = (RadioButton) findViewById(fromID);

            // Calculation
            if ( to.getText().toString().equals("Kilogram") && ( from.getText().toString().equals("Pound") ) )
            {
                finalMass = kilogramToPound(inputMass);
            }
            else if ( to.getText().toString().equals("Pound") && ( from.getText().toString().equals("Kilogram") ) )
            {
                finalMass = poundToKilogram(inputMass);
            }
            else
            {
                finalMass = inputMass;
            }
            //  Display answer!
            answerText = (TextView) findViewById(R.id.answer);
            answerText.setText(String.valueOf(finalMass));
        }


    }
    // Meathod KILOGRAM to POUND
    public double kilogramToPound ( double kilogram ){
        double pound;
        pound = kilogram * 2.204;
        return pound;
    }

    // Meathod POUND to KILOGRAM
    public double poundToKilogram ( double pound ){
        double kilogram;
        kilogram = pound * 0.453;
        return kilogram;
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
