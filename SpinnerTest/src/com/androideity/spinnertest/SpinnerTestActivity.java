package com.androideity.spinnertest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class SpinnerTestActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Spinner sp = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.versiones, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        
        sp.setOnItemSelectedListener(new OnItemSelectedListener() {
           
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, 
            		int position, long id) {
            	Toast.makeText(parentView.getContext(), "Has seleccionado " +
            	          parentView.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            	    
            }
                                 
            public void onNothingSelected(AdapterView<?> parentView) {
            	
            }
        });        
    }
}