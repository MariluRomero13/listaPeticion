package com.example.listapeticion.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.Response;
import com.example.listapeticion.R;
import com.example.listapeticion.modelos.Personas;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class adaptadorPersona extends BaseAdapter {

    Context context;
    List<Personas> people;

    public adaptadorPersona(Context context, List<Personas> people) {
        this.context = context;
        this.people = people;
    }

    @Override
    public int getCount() {
        return people.size();
    }

    @Override
    public Object getItem(int position) {
        return people.get(position);
    }

    @Override
    public long getItemId(int position) {
        return people.get(position).getID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listaPersonalizada = convertView;

        if(listaPersonalizada == null){
            listaPersonalizada = LayoutInflater.from(context).inflate(R.layout.items_personas, parent, false);
        }

        Personas personas = (Personas) getItem(position);

        TextView id =  listaPersonalizada.findViewById(R.id.tv_id);
        id.setText(String.valueOf(personas.getID()));

        TextView nombre =  listaPersonalizada.findViewById(R.id.tv_name);
        nombre.setText(personas.getNombre());

        TextView apellido =  listaPersonalizada.findViewById(R.id.tv_apellido);
        apellido.setText(personas.getApellido());

        TextView edad =  listaPersonalizada.findViewById(R.id.tv_edad);
        edad.setText(String.valueOf(personas.getEdad()));

        return listaPersonalizada;


    }
}
