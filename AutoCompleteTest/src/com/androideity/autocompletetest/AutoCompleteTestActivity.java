package com.androideity.autocompletetest;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.text.Editable;

public class AutoCompleteTestActivity extends Activity implements TextWatcher {
	
	TextView selection;
	AutoCompleteTextView edit;
	String[] items={"argentina", "albania", "alemania", "argelia", "berlin", "bolivia",
			"méxico", "brasil", "holanda", "italia", "jamaica"};
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        selection = (TextView)findViewById(R.id.txt_texto);
        edit = (AutoCompleteTextView)findViewById(R.id.complete);
        edit.addTextChangedListener(this);
        
        edit.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,items));
    }
    
    public void onTextChanged(CharSequence s, int start, int before,
    		int count){
    	selection.setText(edit.getText());
    }
    
    public void beforeTextChanged(CharSequence s, int start,
    		int count, int after){
    		//
    }
    
    public void afterTextChanged(Editable s){
    	
    }
    
}