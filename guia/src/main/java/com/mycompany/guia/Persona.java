package com.mycompany.guia;

public class Persona {
    protected String identificacion;
    protected String nombre;
    protected String apellido;
    protected String direccion;
    protected String telefono;

    public Persona(String identificacion, String nombre, String apellido, String direccion, String telefono) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getters
    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}
