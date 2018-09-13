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

    String txtuserID, txtTitle, txtBody;
    public void executaConsultaPost(View view){

        String url = "https://jsonplaceholder.typicode.com/posts/";

        EditText edtUserId = findViewById(R.id.editText);
        txtuserID = edtUserId.getText().toString();
        EditText edtTitle = findViewById(R.id.editText2);
        txtTitle = edtTitle.getText().toString();
        EditText edtBody = findViewById(R.id.editText3);
        txtBody = edtBody.getText().toString();

        String parametro =  "{\n" +
                            "\"userId\": \""+txtuserID+"\",\n" +
                            "\"title\" : \""+txtTitle+"\" ,\n" +
                            "\"body\"  : \""+txtBody+"\"   \n" +
                            "}";

        TextView txtstatus = findViewById(R.id.txt_statuspost);

        new DataGetterPost(txtstatus).execute(url, parametro);

    }
}
