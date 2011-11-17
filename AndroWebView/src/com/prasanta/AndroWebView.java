package com.prasanta;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Handler.Callback;
import android.util.Log;
import android.webkit.WebView;

/**
 * Demonstrates usage of Android WebView and Javascript-Java
 * interaction process.
 *  
 * @author prasanta
 *
 */
public class AndroWebView extends Activity implements Callback {
	
	WebView mWebView;
	String TAG = "Prasanta";
	Handler mHandler;
	ProgressDialog dialog;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new Handler(this);
        setContentView(initWebView());
    }
    
    /**
     * Initialize WebView
     * @return
     */
    private WebView initWebView() {
		mWebView = new WebView(this);
		
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setPluginsEnabled(true);
		mWebView.getSettings().setSupportZoom(false);
		// Scale
		mWebView.setInitialScale(0);
		
		// Define the JS-Java interaction object
		mWebView.addJavascriptInterface(new JSImp(), "native_java");
		
		// load content
		mWebView.loadUrl("file:///android_asset/web/index.html");
		
		return mWebView;
	}
    
    private class JSImp {
    	
    	public String getDataFromJava(final String name){
    		// Ask handler to show Dialog Box
    		mHandler.sendEmptyMessage(0);
    		
    		/*
    		 * Schedule one Task to Cancel Dialog and Update HTML element
    		 */
    		Timer timer = new Timer();
    		TimerTask task = new TimerTask(){
        		public void run(){
        			if(dialog != null && dialog.isShowing())
        				dialog.cancel();
        			
        			// Call JS method
        			/*
        			 * Make sure you call this once the respective HTML/JavaScript code loading is over
        			 */
        			mWebView.loadUrl("javascript:updateMsg('"+ name +" got 750 messages')");
        		}
        	};
        	
        	timer.schedule(task, 2000);
        	
        	return name +" - you got 750 messages";
    	}
    	
    }

	public boolean handleMessage(Message msg) {
		// Show progress bar
		Log.i(TAG, "Showing progress....");
		dialog = new ProgressDialog(this);
		dialog.setTitle("Please wait...");
		dialog.show();
		return false;
	}
}