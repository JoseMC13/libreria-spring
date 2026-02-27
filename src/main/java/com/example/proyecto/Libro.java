package com.example.proyecto;

public class Libro {

    private String titulo;
    private double precio;
    private String imagen;
    private String sinopsis;

    public Libro(String titulo, double precio, String imagen, String sinopsis) {
        this.titulo = titulo;
        this.precio = precio;
        this.imagen = imagen;
        this.sinopsis = sinopsis;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getImagen() {
        return imagen;
    }

    public String getSinopsis() {
        return sinopsis;
    }
}