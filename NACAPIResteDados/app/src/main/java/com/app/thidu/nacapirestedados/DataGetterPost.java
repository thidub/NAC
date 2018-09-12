package com.app.thidu.nacapirestedados;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class DataGetterPost extends AsyncTask<String,Void,String> {


    private TextView txttitulo, txtbody, txtStatus;

    public DataGetterPost(TextView titulo, TextView body, TextView status) {
        this.txttitulo = titulo;
        this.txtbody = body;
        this.txtStatus = status;
    }

    @Override
    protected String doInBackground(String... strings) {

        return NetworkToolkit.doPost(strings[0],strings[1]);
    }

    @Override
    protected void onPostExecute(String s) {
        try{
            JSONObject jsonResponse = new JSONObject(s);

            String titulo = jsonResponse.getString("title");
            String body = jsonResponse.getString("body");


            txttitulo.setText(titulo);
            txtbody.setText(body);
            txtStatus.setText("Status: Encontrado!");
        }
        catch(JSONException e){
            this.txtStatus.setText("erroJSON");
        }
    }
}
