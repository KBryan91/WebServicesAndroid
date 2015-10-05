package com.example.jokesito.webservicesandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransport;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNumero1, etNumero2;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            EditText etNumero1 = (EditText) findViewById(R.id.etNumero1);
            EditText etNumero2 = (EditText) findViewById(R.id.etNumero2);
            TextView tvResultado = (TextView) findViewById(R.id.tvResultado);

            String NAMESPACE = "http://demo.android.org/";
            /* String URL = "http://192.168.2.6:8060/DemoWS.asmx"; */
            /* String URL = "http://localhost:8060/DemoWS.asmx"; */
            String URL = "http://192.168.2.6:8060/DemoWS.asmx";
            String METHOD_NAME = "Suma";
            String SOAP_ACTION = "http://demo.android.org/Suma";

            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            request.addProperty("numero1", Integer.parseInt(etNumero1.getText().toString()));
            request.addProperty("numero2", Integer.parseInt(etNumero2.getText().toString()));

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);

            HttpTransportSE transport = new HttpTransportSE(URL);

            SoapObject result = null;

            try {
                transport.call(SOAP_ACTION, envelope);
                SoapPrimitive resultado_xml = (SoapPrimitive) envelope.getResponse();
                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
    }
}