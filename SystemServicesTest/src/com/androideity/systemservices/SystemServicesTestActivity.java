package com.androideity.systemservices;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SystemServicesTestActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void startAlert(View view) {
		EditText text = (EditText) findViewById(R.id.txt_tiempo);
		int i = Integer.parseInt(text.getText().toString());
		Intent intent = new Intent(this, VibrationPhone.class);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(
				this.getApplicationContext(), 234324243, intent, 0);
		AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
		alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
				+ (i * 1000), pendingIntent);
		Toast.makeText(this, "Has fijado la alarma en " + i + " segundos",
				Toast.LENGTH_LONG).show();
	}
}