package com.app.thidu.nacapirestedados;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class DataGetterPost extends AsyncTask<String,Void,String> {


    private TextView txtStatus;

    public DataGetterPost(TextView status) {
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

            String id = jsonResponse.getString("id");

            txtStatus.setText("Sucesso! ID:" + id);

        }
        catch(JSONException e){
            this.txtStatus.setText("erroJSON");
        }
    }
}
