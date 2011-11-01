package net.ivanvega.Archivos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private EditText txtTexto;
	private Button btnGuardar;
	private Button btnAbrir;
	private static final int READ_BLOCK_SIZE=100;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        txtTexto = (EditText)findViewById(R.id.txtTexto);
        btnGuardar = (Button)findViewById(R.id.btnGuardar);
        btnAbrir = (Button)findViewById(R.id.btnAbrir);
        btnGuardar.setOnClickListener(this);
        btnAbrir.setOnClickListener(this);
    }

	@Override
	public void onClick(View arg0) {	
		// TODO Auto-generated method stub
		
		if (arg0.equals(btnGuardar)){
			String str = txtTexto.getText().toString();
			
			//Clase que permite grabar texto en un archivo
			FileOutputStream fout=null;
			try {
				
				fout =
					//Metodo que escribe y abre un archivo con un nombre especifica
					//La constante MODE_WORLD_READABLE indica que este arvhivo lo puede
					//leer cualquier apllicacion
					openFileOutput("archivoTexto.txt", MODE_WORLD_READABLE);
				
				//Convierte un stream de caracteres en un stream de bytes
				OutputStreamWriter ows = new OutputStreamWriter(fout);
				ows.write(str); //Escribe en el buffer la cadena de texto
				ows.flush(); //Volca lo que hay en el buffer al archivo
				ows.close(); //Cierra el archivo de texto
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Toast.makeText(getBaseContext(), "El archivo se ha almacenado!!!", Toast.LENGTH_SHORT).show();
			
			txtTexto.setText("");
		}
		
		
		if (arg0.equals(btnAbrir)){
			try {
				
				//Se lee el archivo de texto indicado
				FileInputStream fin = 
					openFileInput("archivoTexto.txt");
				InputStreamReader isr = new InputStreamReader(fin);
				
				char[] inputBuffer = new char[READ_BLOCK_SIZE	];
				String str= "";
				
				//Se lee el archivo de texto mientras no se llegue al final de él
				int charRead;
				while ((charRead=isr.read(inputBuffer))>0) {
					//Se lee por bloques de 100 caracteres 
					//ya que se desconoce el tamaño del texto
					//Y se va copiando a una cadena de texto
					String strRead =
						String.copyValueOf(inputBuffer, 0, charRead);
					str += strRead;
					
					inputBuffer = new char [READ_BLOCK_SIZE];
				}
				
				//Se muestra el texto leido en la caje de texto
				txtTexto.setText(str);
				
				isr.close();
			
				Toast.makeText(getBaseContext(),
						"El archivo ha sido cargado", Toast.LENGTH_SHORT).show();
				
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		}
	}
}