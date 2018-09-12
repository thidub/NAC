package com.app.thidu.nacapirestedados;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DadosActivity extends AppCompatActivity {

    public final String chave = "chave";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

    }
    public void gravaDadosArquivo(String fileName, String data){
        try{
            FileOutputStream fs = openFileOutput(fileName, Context.MODE_PRIVATE);
            fs.write(data.getBytes());

            fs.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String recuperaDadosArquivo(String fileName){
        try{
            int data;
            StringBuilder output = new StringBuilder();

            FileInputStream fi = openFileInput(fileName);
            data = fi.read();

            while (data != -1){
                output.append((char)data);
                data = fi.read();
            }return output.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void doGravar(View view){
        EditText ed = findViewById(R.id.edt_multi);
        gravaDadosArquivo(chave, ed.getText().toString());

    }

    public void doRecuperar(View view){
        EditText ed = findViewById(R.id.edt_multi);
        ed.setText(recuperaDadosArquivo(chave));

    }

}
