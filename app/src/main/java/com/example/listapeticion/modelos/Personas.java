package com.example.listapeticion.modelos;

public class Personas
{
    private Integer id;
    private String Nombre;
    private String Apellido;
    private Integer Edad;

    public Personas(Integer ID, String nombre, String apellido, Integer edad)
    {
        this.id = ID;
        Nombre = nombre;
        Apellido = apellido;
        Edad = edad;
    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer ID) {
        this.id = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setEdad(Integer edad) {
        Edad = edad;
    }
}
