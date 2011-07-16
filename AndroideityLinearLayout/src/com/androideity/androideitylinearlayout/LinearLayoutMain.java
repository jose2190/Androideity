package com.androideity.androideitylinearlayout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class LinearLayoutMain extends Activity implements RadioGroup.OnCheckedChangeListener {
	RadioGroup orientation;
	RadioGroup gravity;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        orientation = (RadioGroup)findViewById(R.id.orientation);
        orientation.setOnCheckedChangeListener(this);
        gravity = (RadioGroup)findViewById(R.id.gravity);
        gravity.setOnCheckedChangeListener(this);
    }
    
    public void onCheckedChanged(RadioGroup group, int checkedId){
    	if(group == orientation){
    		if(checkedId == R.id.horizontal){
    			orientation.setOrientation(LinearLayout.HORIZONTAL);
    		}else{
    			orientation.setOrientation(LinearLayout.VERTICAL);
    		}
    	}else if(group == gravity){
    		if(checkedId == R.id.left){
    			gravity.setGravity(0x03); //left
    		}else if(checkedId == R.id.center){
    			gravity.setGravity(0x01); //center
    		}else if(checkedId == R.id.right){
    			gravity.setGravity(0x05); //right
    		}
    	}
    }
}