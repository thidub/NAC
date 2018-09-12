package com.app.thidu.nacapirestedados;

import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class DataGetter extends AsyncTask<String,Void,String> {

    private TextView txt_titulo, txt_completed, txt_status;

    public DataGetter(TextView titulo, TextView completed, TextView status) {
        this.txt_titulo = titulo;
        this.txt_completed = completed;
        this.txt_status = status;

        status.setText("Status: Pesquisando...");
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... strings) {

        String url = strings[0];
        String result = NetworkToolkit.doGet(url);


        return result;
    }

    @Override
    protected void onPostExecute(String s) {

        txt_status.setText("Status: Encontrado!");

        try{
            JSONObject jsonResponse = new JSONObject(s);
//            JSONObject dataResponse = jsonResponse.getJSONObject();

            String titulo = jsonResponse.getString("title");
            String completed = jsonResponse.getString("completed");

            txt_titulo.setText(titulo);

            txt_completed.setText("Completed:" + completed);

        }
        catch(JSONException e){
            this.txt_status.setText("erroJSON");
        }
    }
}

