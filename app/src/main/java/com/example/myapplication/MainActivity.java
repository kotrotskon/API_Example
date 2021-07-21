package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Case> cases = new ArrayList<>();

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

        String url = "https://api.covid19api.com/dayone/country/greece";

        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i=0; i<response.length(); i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        Case aCase = new Case(jsonObject);
                        cases.add(aCase);

                        Log.d("RESPONSE", jsonObject.getString("Date") + ": " + jsonObject.getInt("Active"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Log.d("RESPONSE", cases.size()+"");
                Log.d("RESPONSE", cases.get(265).getDate());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(arrayRequest);
    }
}