package com.example.clase1.clase1;



        import android.content.Intent;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.RadioButton;
        import android.widget.Toast;

        import com.example.clase1.clase1.Model.Alumno;
        import com.example.clase1.clase1.Model.Person;
        import com.example.clase1.clase1.Model.Profesor;


public class ActividadP extends AppCompatActivity {

    int sexo;
    int tipopersona;
    EditText nombre;
    EditText apellido;
    EditText anio;
    EditText materia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_p);
        nombre = (EditText) findViewById(R.id.nombre);
        apellido = (EditText) findViewById(R.id.apellido);
        anio = (EditText) findViewById(R.id.anio);
        materia = (EditText) findViewById(R.id.materia);
    }

    public void btnImprimir(View v) {

        if (nombre.getText().toString().isEmpty() || apellido.getText().toString().isEmpty() && (anio.getText().toString().isEmpty() || materia.getText().toString().isEmpty())) {
            Toast.makeText(this, "Campos incompletos", Toast.LENGTH_SHORT).show();

        }


            ImageView vv;
            Person p;
            Intent intent = new Intent(this, Actividadsec.class);
            if (tipopersona == 1) {
                p = new Profesor(nombre.getText().toString(), apellido.getText().toString(), sexo, materia.getText().toString());
            } else {
                p = new Alumno(nombre.getText().toString(), apellido.getText().toString(), sexo, anio.getText().toString());
            }

            intent.putExtra("pers1", p);

            startActivity(intent);


    }


    public void eligeSexo(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.masculino:
                if (checked)
                    //Toast.makeText(this,"Masculino", Toast.LENGTH_SHORT).show();
                    sexo = Person.MASCULINO;
                break;
            case R.id.femenino:
                if (checked)
                    //Toast.makeText(this,"Femenino", Toast.LENGTH_SHORT).show();
                    sexo = Person.FEMENINO;
                break;
        }
        switch (view.getId()) {
            case R.id.profesor:
                if (checked)
                    tipopersona = 1;
                View chauanio = findViewById(R.id.anio);
                chauanio.setVisibility(View.INVISIBLE);
                View materia = findViewById(R.id.materia);
                materia.setVisibility(View.VISIBLE);

                break;
            case R.id.alumno:
                if (checked)
                    tipopersona = 2;
                View materiachau = findViewById(R.id.materia);
                materiachau.setVisibility(View.INVISIBLE);
                View anio = findViewById(R.id.anio);
                anio.setVisibility(View.VISIBLE);
                break;
        }


    }
}