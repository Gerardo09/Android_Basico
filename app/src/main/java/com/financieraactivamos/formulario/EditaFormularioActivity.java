package com.financieraactivamos.formulario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EditaFormularioActivity extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFechaNacimiento;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_formulario);

        initComponents();

        Bundle extras = getIntent().getExtras();
        tvNombre.setText(extras.getString("Nombre"));
        tvFechaNacimiento.setText(extras.getString("FechaNacimiento"));
        tvTelefono.setText(extras.getString("Telefono"));
        tvEmail.setText(extras.getString("Email"));
        tvDescripcion.setText(extras.getString("Descripcion"));

    }

    public void initComponents()
    {
        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvFechaNacimiento = (TextView)findViewById(R.id.tvFechaNacimiento);
        tvTelefono = (TextView)findViewById(R.id.tvTelefono);
        tvEmail = (TextView)findViewById(R.id.tvEmail);
        tvDescripcion = (TextView)findViewById(R.id.tvDescripcion);
    }
}
