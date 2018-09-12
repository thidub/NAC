package com.app.thidu.nacapirestedados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GETActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
    }

    public void executaConsultaGET(View view){

        String response;
        String url = "https://jsonplaceholder.typicode.com/todos/";

        EditText txtConsulta = findViewById(R.id.edt_pesquisa);
        url += txtConsulta.getText().toString();
        Toast.makeText(this, url, Toast.LENGTH_SHORT).show();

        TextView txtTitulo = findViewById(R.id.txt_titulo);
        TextView txtCompleted = findViewById(R.id.txt_completed);
        TextView txtStatus = findViewById(R.id.txt_statusget);

        //NetworkToolkit.getJSONFromAPI(url);

        new DataGetter(txtTitulo,txtCompleted,txtStatus).execute(url);

    }
}
