package com.example.jokesito.webservicesandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNumero1, etNumero2;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumero1 = (EditText) findViewById(R.id.etNumero1);
        etNumero2 = (EditText) findViewById(R.id.etNumero2);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnCalcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String NAMESPACE = "";
        String URL = "";
        String METHOD_NAME = "";
        String SOAP_ACTION = "";
    }
}