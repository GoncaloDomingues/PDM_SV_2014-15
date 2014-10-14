package com.example.thothapp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.os.AsyncTask;

public class ThothAsynkTask extends AsyncTask<Void, Void,Void>{
	

	HttpURLConnection _connection;
	InputStream _in;
	List <JSONObject> _listUrl;
	
	

	protected Void doInBackground(Void... args) {
			
		try {
			_listUrl = new ArrayList<JSONObject>();
			
			_connection.setRequestMethod("GET");
			
			_in = _connection.getInputStream();
			
			byte[]b=new byte[1024];
			
			ByteArrayOutputStream baos =new ByteArrayOutputStream();
            String JSONResp = new String(baos.toByteArray());
            
			while(_in.read(b)!=-1)
				baos.write(b);
			
			JSONArray arr = new JSONArray(JSONResp);
			
			for(int i=0; i<arr.length();i++){
				_listUrl.add(arr.getJSONObject(i));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	
}
