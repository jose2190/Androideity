package com.telmexhub.miprimeraapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TelmexHubActivity extends Activity {
	
	private static final int REQUEST_CODE = 10;//"ID" que identifica cada una de las peticiones que hace una actividad
	/*Creamos las variables de los widgets que manipularemos dentro de esta clase*/
	EditText txt_nombre;
	EditText txt_edad;
	Button btn_enviar;
	TextView label;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);//Definimos que el archivo main.xml sera la UI de esta actividad
        /*Recuperamos las referencias de los widgets definidos en el archivo main.xml
         * por medio de sus atributos de ID*/
        txt_nombre = (EditText)findViewById(R.id.txt_nombre);
        txt_edad = (EditText)findViewById(R.id.txt_edad);
        btn_enviar = (Button)findViewById(R.id.btn_enviar);
        label = (TextView)findViewById(R.id.label);
        
        /*Se crea el listener para que el boton haga algo cada vez que es presionado*/
        btn_enviar.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		/*String nombre = txt_nombre.getText().toString();
        		String edad = txt_edad.getText().toString();
        		label.setText("Te llamas: " + nombre + "Y tu edad es: " + edad);*/
        		/*Creamos un intent, el cual, de manera burda, es un componente de las 
        		 * apps Android que nos ayudaran a intercambiar datos entre las pantallas*/
        		Intent i = new Intent(TelmexHubActivity.this, SegundaActividad.class);
        		/*Asignamos los valores que deseamos pasar a la segunda actividad.
        		 * Estos valores contienen una llave y un valor asociado a esa llave*/
        		i.putExtra("valor1", txt_nombre.getText().toString());
        		i.putExtra("valor2", txt_edad.getText().toString());
        		/*Para mandar a llamar a otra actividad podemos utilizar el metodo startActivity()
        		 * si solo estamos haciendo un cambio de pantalla o mandamos datos sin esperar un resultado.
        		 * En cambio, si utilizamos startActivityForResult() indica que esperamos un resultado
        		 * del procesamiento de los datos que mandamos.*/
        		startActivityForResult(i, REQUEST_CODE);
        	}
        });
    }
    /*El siguiente metodo se sobreescribe para procesar la respuesta que nos mande la segunda actividad.
     * En este caso la respuesta es estatica. En escenarios reales se trabaja con un resultado que puede ser
     * RESULT_OK o RESULT_CANCELED y dependiendo de eso hacemos "algo" en las actividades.*/
    @Override
    protected void onActivityResult(int requestCode, 
    		int resultCode, Intent data){
    	if(resultCode == RESULT_OK && 
    			requestCode == REQUEST_CODE){
    		if(data.hasExtra("returnKey2")){
    			Toast.makeText(this, 
    					data.getExtras().getString("returnKey2"), 
    					Toast.LENGTH_SHORT).show();
    		}
    			
    	}
    }
}