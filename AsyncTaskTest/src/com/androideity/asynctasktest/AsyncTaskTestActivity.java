package com.androideity.asynctasktest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

public class AsyncTaskTestActivity extends Activity {
	
	Button button;
	ProgressBar progressBar;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        button = (Button)findViewById(R.id.task);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);
        
        button.setOnClickListener(new Button.OnClickListener(){
        	@Override
        	public void onClick(View arg0){
        		button.setClickable(false);
        		new UpdateProgress().execute();
        	}
        });
    }
    
    public class UpdateProgress extends AsyncTask<Void, Integer, Void>{
    	int progress;
    	
    	@Override
    	protected void onPostExecute(Void result){
    		button.setClickable(true);
    	}
    	
    	@Override
    	protected void onPreExecute(){
    		progress = 0;
    	}
    	
    	@Override
    	protected void onProgressUpdate(Integer... values){
    		progressBar.setProgress(values[0]);
    	}
    	
    	@Override
    	protected Void doInBackground(Void... arg0){
    		while(progress<100){
    			progress++;
    			publishProgress(progress);
    			SystemClock.sleep(100);    			
    		}
    		return null;
    	}
    }
}