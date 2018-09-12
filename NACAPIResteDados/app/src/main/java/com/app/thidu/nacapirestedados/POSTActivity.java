package com.app.thidu.nacapirestedados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class POSTActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
    }

    public void executaConsultaPost(View view){

        String url = "https://jsonplaceholder.typicode.com/posts";
        EditText txtConsulta = findViewById(R.id.edt_pesquisa);
        url += txtConsulta.getText().toString();
        Toast.makeText(this, url, Toast.LENGTH_SHORT).show();

//        String parameter =  "{\n" +
//                "    \"name\": \"testando\",\n" +
//                "    \"job\": \"1234\"\n" +
//                "}";

        TextView txttitulo = findViewById(R.id.txt_titulo);
        TextView txtbody = findViewById(R.id.txt_completed);
        TextView txtstatus = findViewById(R.id.txt_statuspost);

        new DataGetterPost(txttitulo, txtbody, txtstatus).execute(url);

    }
}
