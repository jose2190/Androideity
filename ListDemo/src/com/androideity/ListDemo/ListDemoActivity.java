package com.androideity.ListDemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;

public class ListDemoActivity extends Activity {
	ListView lv;
	TextView seleccionado;
	String[] datos = {"Cupcake v1.5", "Donut v1.6", "Éclair v2.0/2.1", "Froyo v2.2",
			"Gingerbread v2.2", "Honeycomb v3.0/3.1"};
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lv = (ListView)findViewById(R.id.list);
        seleccionado = (TextView)findViewById(R.id.seleccionado);
        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos));
        
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
            	seleccionado.setText("Has seleccionado: " + datos[position]);
            }
          });
    }
}