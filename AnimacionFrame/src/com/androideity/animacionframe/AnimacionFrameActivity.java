package com.androideity.animacionframe;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class AnimacionFrameActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btn_start = (Button)findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		animate();
        	}
        });
    }
    
    private void animate(){
    	ImageView imgView = (ImageView)findViewById(R.id.imagen);
    	imgView.setVisibility(ImageView.VISIBLE);
    	imgView.setBackgroundResource(R.drawable.frame_animation);
    	
    	AnimationDrawable frame = (AnimationDrawable) imgView.getBackground();
    	if(frame.isRunning()){
    		frame.stop();
    	}else{
    		frame.stop();
    		frame.start();
    	}
    }
}