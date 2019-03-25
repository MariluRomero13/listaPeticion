package com.example.listapeticion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.listapeticion.adaptadores.adaptadorPersona;
import com.example.listapeticion.modelos.Personas;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    adaptadorPersona adaptador;
    ArrayList<Personas> people = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.lista);


    }

    public void click_boton(View view)
    {
        JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, "http://nuevo.rnrsiilge-org.mx/lista", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try
                        {

                            Gson gson = new Gson();
                            Type type = new TypeToken<List<Personas>>(){}.getType(); //construyendo un tipo de lista // crea un tipo de lista de personas
                            List<Personas> lp  = gson.fromJson(response.toString(), type);
                            adaptador = new adaptadorPersona(MainActivity.this, lp);
                            lista.setAdapter(adaptador);

                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }

                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance(MainActivity.this).getRequestQueue().add(jar);
    }
}
