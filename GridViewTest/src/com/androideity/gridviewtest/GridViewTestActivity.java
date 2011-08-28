package com.androideity.gridviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class GridViewTestActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        GridView gv = (GridView)findViewById(R.id.gridview);
        gv.setAdapter(new ImageAdapter(this));
        
        gv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(GridViewTestActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}