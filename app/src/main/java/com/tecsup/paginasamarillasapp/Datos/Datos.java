package com.tecsup.paginasamarillasapp.Datos;

public class Datos {

    private int id;
    private String titulo;
    private String detalle;
    private String telefono;
    private int imagen;

    public Datos(String titulo, String detalle, String telefono, int imagen) {
        this.titulo = titulo;
        this.detalle = detalle;
        this.telefono = telefono;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
