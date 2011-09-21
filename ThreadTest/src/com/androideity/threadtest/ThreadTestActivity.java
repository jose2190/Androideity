package com.androideity.threadtest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

public class ThreadTestActivity extends Activity {
	ProgressBar bar;
	Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg){
			bar.incrementProgressBy(5);
		}
	};
	boolean isRunning = false;
	
		
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        bar = (ProgressBar)findViewById(R.id.progress);
    }
    
    public void onStart(){
    	super.onStart();
    	bar.setProgress(0);
    	
    	Thread background = new Thread(new Runnable(){
    		public void run(){
    			try{
    				for(int i=0; i<20; i++){
    					Thread.sleep(1000);
    					handler.sendMessage(handler.obtainMessage());
    				}
    			}catch(Throwable t){
    				//Termina el thread en background
    			}
    		}
    	});
    	isRunning = true;
    	background.start();
    }
    
    public void stop(){
    	super.onStop();
    	isRunning = false;
    }
    
}