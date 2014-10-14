package com.example.thothapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;

public class ThothClassesAT extends AsyncTask<Void, Void, Void> {

	private List<ThothClasses> allClasses = new ArrayList<ThothClasses>();

	private final String thothClasses = "http://thoth.cc.e.ipl.pt/api/v1/classes";
	public URL connectionThoth;
	public InputStream streamingThoth;
	public BufferedReader bufferThoth;

	public JSONObject objThoth;
	public JSONArray arrObjThoth;

	public String jsonList;

	@Override
	protected Void doInBackground(Void... params) {

		try {
			connectionThoth = new URL(thothClasses);

			connectionThoth.openConnection().connect();

			streamingThoth = connectionThoth.openStream();

			bufferThoth = new BufferedReader(new InputStreamReader(
					streamingThoth, "utf-8"), 8);

			jsonList = bufferThoth.readLine();

			streamingThoth.close();

			objThoth = new JSONObject(jsonList);

			arrObjThoth = objThoth.getJSONArray("classes");

			for (int i = 0; i < arrObjThoth.length(); i++) {
				JSONObject objInside = arrObjThoth.getJSONObject(i);
				ThothClasses turma = new ThothClasses(objInside.getInt("id"),
						objInside.getString("courseUnitShortName"),
						objInside.getString("mainTeacherShortName"),
						objInside.getString("className"),
						objInside.getString("lectiveSemesterShortName"));
				
				allClasses.add(turma);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
