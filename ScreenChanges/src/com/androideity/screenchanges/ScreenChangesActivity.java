package com.androideity.screenchanges;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ViewFlipper;

public class ScreenChangesActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Spinner country = (Spinner)findViewById(R.id.spinner_country);
        ArrayAdapter countryAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                new String[] { "México", "Guatemala", "Colombia", "Perú", "Chile" });
        country.setAdapter(countryAdapter);
        
        Button next = (Button)findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Get the ViewFlipper from the layout
                ViewFlipper vf = (ViewFlipper) findViewById(R.id.details);

                // Set an animation from res/anim: I pick push left in
                vf.setAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.push_left_in));
                vf.showNext();
        }
        });
        
        Button previous = (Button)findViewById(R.id.btn_previous);
        previous.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Get the ViewFlipper from the layout
                ViewFlipper vf = (ViewFlipper) findViewById(R.id.details);
                // Set an animation from res/anim: I pick push left out
                vf.setAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.push_left_out));
                vf.showPrevious();
        }

        });        
    }
}