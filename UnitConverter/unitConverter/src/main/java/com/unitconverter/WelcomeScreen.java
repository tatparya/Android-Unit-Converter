package com.unitconverter;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ImageView;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class WelcomeScreen extends ActionBarActivity {

    ImageView temp;
    ImageView dist;
    ImageView mass;
    ImageView mlToOz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        Toast toast = Toast.makeText(WelcomeScreen.this, "Select a unit you want to convert", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        // Opening Tempreature Converter
        temp = (ImageView) findViewById(R.id.temperature);
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp.setColorFilter(0x8CFFFFFF, PorterDuff.Mode.MULTIPLY);
                Intent intent = new Intent( WelcomeScreen.this, TempConverter.class );
                startActivity(intent);
            }
        });

        // Opening Distance Converter
        dist = (ImageView) findViewById(R.id.lenght);
        dist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dist.setColorFilter(0x8CFFFFFF, PorterDuff.Mode.MULTIPLY);
                Intent intent = new Intent( WelcomeScreen.this, LengthConverter.class );
                startActivity(intent);
            }
        });
        // Opening Mass Converter
        mass = (ImageView) findViewById(R.id.mass);
        mass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mass.setColorFilter(0x8CFFFFFF, PorterDuff.Mode.MULTIPLY);
                Intent intent = new Intent( WelcomeScreen.this, MassConverter.class );
                startActivity(intent);
            }
        });
        // Opening mL to Oz Converter
        mlToOz = (ImageView) findViewById(R.id.mlToOz);
        mlToOz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mlToOz.setColorFilter(0x8CFFFFFF, PorterDuff.Mode.MULTIPLY);
                Intent intent = new Intent( WelcomeScreen.this, mlToOz.class );
                startActivity(intent);
            }
        });
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.sliderightin, R.anim.sliderightout);
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.slideleftin, R.anim.slideleftout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome_screen, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_welcome_screen, container, false);
            return rootView;
        }
    }

}
