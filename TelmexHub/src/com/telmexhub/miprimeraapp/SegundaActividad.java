package com.telmexhub.miprimeraapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SegundaActividad extends Activity {
	/*Una vez que agregamos clases a modo de actividades, es decir, pantallas
	 * en nuestras aplicaciones es necesario registrarlas en el archivo AndroidManifest.xml
	 * para que Android "sepa" qué elementos conforman la app*/
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);//Define qué layout es el que desplegará esta actividad como UI
        Bundle extras = getIntent().getExtras();//Este objeto nos sirve para recuperar los datos que se mandaron en la actividad anterior
        if(extras == null){//Comprobamos si existen datos en este objeto
        	return;
        }
        /*Recuperamos los dos valores pasados por la actividad anterior en dos Strings*/
        String valor1 = extras.getString("valor1");
        String valor2 = extras.getString("valor2");
        if(valor1 != null && valor2 != null){//Checamos que ambas cadenas sean diferentes a NULL
        	EditText text1 = (EditText)findViewById(R.id.nombre);//Recuperamos las referencias de los EditText del documentos second.xml
        	EditText text2 = (EditText)findViewById(R.id.edad);
        	text1.setText(valor1);//Les asignamos los valores de la actividad anterior a cada EditText
        	text2.setText(valor2);
        	
        }
    }
    
    public void onClick(View v){//Metodo que controla todo lo que hace el boton cuando los usuarios lo oprimen
    	finish();
    }

    @Override
    public void finish(){
    	Intent data = new Intent();//Creamos un Intent
    	data.putExtra("returnKey1", "Lo logramos!!");//Le asignamos los valores de retorno
    	data.putExtra("returnKey2", "Este es otro valor");
    	/*Se pasa el resultado del procesamiento. El primer parametro puede ser RESULT_OK
    	 * o RESULT_CANCELED, esto es para cuando hacemos un procesamiento de datos más complejo.
    	 * El segundo parametro es el intent con los datos de retorno definimos arriba. Los valores
    	 * tienen una llave y un valor asociado a esa llave.*/
    	setResult(RESULT_OK, data);
    	/*El metodo finish sirve para regresar a la actividad principal que lanzó a la actividad actual.
    	 * Como utilizamos el metodo startActivityForResult() es obvio que la actividad principal está
    	 * esperando un resultado. Esto se detecta automaticamente.*/
    	super.finish();
    	
    }
}
