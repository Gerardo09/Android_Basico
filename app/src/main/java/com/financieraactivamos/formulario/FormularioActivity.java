package com.financieraactivamos.formulario;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class FormularioActivity extends AppCompatActivity
{
    private EditText edtNombreUsuario;
    private DatePicker dpFechaNacimiento;
    private EditText edtTelefono;
    private EditText edtCorreo;
    private EditText edtDescripcion;

    private int year;
    private int month;
    private int day;
    private String fechaNacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fromulario);

        initComponents();
    }

    public void initComponents()
    {
        edtNombreUsuario = (EditText)findViewById(R.id.edtNombreUsuario);
        dpFechaNacimiento = (DatePicker)findViewById(R.id.dpFechaNacimiento);
        edtTelefono = (EditText)findViewById(R.id.edtTelefono);
        edtCorreo = (EditText)findViewById(R.id.edtCorreo);
        edtDescripcion = (EditText)findViewById(R.id.edtDescripcion);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // set current date into datepicker
        dpFechaNacimiento.init(year, month, day,
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        fechaNacimiento = (dayOfMonth + "/" + monthOfYear + "/" + year);
                    }
                }
        );
    }

    public void enviaValores(View v)
    {
        Intent i = new Intent(this, EditaFormularioActivity.class);
        i.putExtra("Nombre", edtNombreUsuario.getText().toString());
        i.putExtra("FechaNacimiento", fechaNacimiento);
        i.putExtra("Telefono", edtTelefono.getText().toString());
        i.putExtra("Email", edtCorreo.getText().toString());
        i.putExtra("Descripcion", edtDescripcion.getText().toString());
        startActivity(i);
    }
}
