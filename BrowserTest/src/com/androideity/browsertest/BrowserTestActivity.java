package com.androideity.browsertest;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class BrowserTestActivity extends Activity {
	
	WebView browser;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        browser = (WebView) findViewById(R.id.webkit);
        browser.loadUrl("http://androideity.com");
    }
}