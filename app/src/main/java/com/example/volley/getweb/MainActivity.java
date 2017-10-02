package com.example.volley.getweb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final  String url="http://192.168.1.141/book_get";
    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWORD="password";
    static List<Library> libraries = new ArrayList<>();


    private EditText Username;
    private EditText Password;
    private Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Username=(EditText) findViewById(R.id.username);
//        Password=(EditText) findViewById(R.id.password);
//        Register=(Button) findViewById(R.id.submit);
//        Register.setOnClickListener(this);
        register_user();
    }

    private void register_user(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final Gson gson= new Gson();

        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                Log.d("1111", "onResponse: "+s);
                //Library[] libraryList= gson.fromJson(s,Library[].class);

               Data libraries = gson.fromJson(s, Data.class);


//                Toast.makeText(MainActivity.this, libraries.libraries.get(1).title.toString(), Toast.LENGTH_SHORT).show();
                Log.d("2222", "onResponse: "+libraries.data.get(1).title);
//                Log.d("2222", "onResponse: "+libraryList[1].author);


//                try {
//                    JSONArray array = new JSONArray(s);   //array of json
//                    JSONObject object = array.getJSONObject(1);
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        requestQueue.add(stringRequest);

    }

    @Override
    public void onClick(View view) {

    }
}
