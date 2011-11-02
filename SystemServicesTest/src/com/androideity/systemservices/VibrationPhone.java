package com.androideity.systemservices;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

public class VibrationPhone extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "¡Vibration Mode On porque el tiempo se ha terminado!",
				Toast.LENGTH_LONG).show();
		//Define la vibracion del telefono
		Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
		vibrator.vibrate(2000);
	}

}