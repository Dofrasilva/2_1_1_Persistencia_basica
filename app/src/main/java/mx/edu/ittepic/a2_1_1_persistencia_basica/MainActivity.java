package mx.edu.ittepic.a2_1_1_persistencia_basica;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText texto;
    RadioGroup sexo;
    RadioButton hombre,mujer;
    CheckBox correr, dormir, jugar;
    Spinner zodico;
    Button guardar, mostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto=findViewById(R.id.texto1);
        sexo=findViewById(R.id.sexo);
        correr=findViewById(R.id.correr);
        dormir=findViewById(R.id.dormir);
        jugar=findViewById(R.id.jugar);
        zodico=findViewById(R.id.zodiaco);
        guardar=findViewById(R.id.guardar);
        mostrar=findViewById(R.id.mostrar);
        hombre=findViewById(R.id.hombre);
        mujer=findViewById(R.id.mujer);


    }
    public void guardarInf(View view){
        SharedPreferences guardar=getSharedPreferences("general", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= guardar.edit();
        editor.putString("Email",texto.getText().toString());
        if (hombre.isChecked()){
            editor.putString("Sexo", hombre.getText().toString());

        }else{
            editor.putString("Sexo", mujer.getText().toString());
        }

        if(correr.isChecked()){
            editor.putString("Hobbies", correr.getText().toString());
        }
        if (dormir.isChecked()){
            editor.putString("Hobbies", dormir.getText().toString());
        }
        if (jugar.isChecked()){
            editor.putString("Hobbies", jugar.getText().toString());
        }


        editor.putString("Zodiaco",zodico.getSelectedItem().toString());
        editor.apply();
        Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();

    }
    public void mostrar(View view){
        SharedPreferences mostrar= getSharedPreferences("general",Context.MODE_PRIVATE);
        String ema = mostrar.getString("Email","");
        String sex = mostrar.getString("Sexo","");
        String Hobbies = mostrar.getString("Hobbies","");

        String zodico = mostrar.getString("Zodiaco","");

        AlertDialog.Builder mensaje= new AlertDialog.Builder(this);
        mensaje.setTitle("Atencion").
                setMessage("Email: "+ema+"\nSexo:  "+sex+"\n Hobbies: "+Hobbies+"\nZodiaco:  "+zodico).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        mensaje.show();

    }
}
