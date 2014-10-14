package com.example.thothapp;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity { 
	
	
	JSONObject _obj;
	JSONArray _jarr;
	ListView _lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        _lv= (ListView) findViewById(R.id.listView1);
        
        try {
			connectionToUrl("http://thoth.cc.e.ipl.pt/api/doc");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
   public void connectionToUrl (String url) throws IOException{
	 
	   
	   URL connect= new URL(url);
	   
	   URLConnection urlConnection= connect.openConnection();
   }
}
