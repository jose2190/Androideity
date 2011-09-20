package com.androideity.runnabletest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;;

public class RunnableTestActivity extends Activity {
	
	final Handler handle = new Handler();
	
	protected void miThread(){
		Thread t = new Thread(){
			public void run(){
				try{
					Thread.sleep(10000);
					
				}catch(InterruptedException e){
					e.printStackTrace();				
				}
				handle.post(proceso);
			}
		};
		t.start();
	}
	
	final Runnable proceso = new Runnable(){
		public void run(){
			Toast.makeText(RunnableTestActivity.this, "Este es un hilo en background", Toast.LENGTH_SHORT).show();
		}
	};
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btn = (Button) findViewById(R.id.btn_thread);
        btn.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		Toast.makeText(RunnableTestActivity.this, "¡Arrancamos!", Toast.LENGTH_SHORT).show();
        	}
        });
        miThread();
        
    }
}