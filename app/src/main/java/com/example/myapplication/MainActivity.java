package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        ArrayList<Case> cases = new ArrayList<>();

        String url = "https://api.covid19api.com/dayone/country/Greece";

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

        Log.d("RESPONSE", cases.size()+"");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String country = editText.getText().toString();


            }
        });


    }
}