package com.example.proyecto;


public class CompraItem {
    private String titulo;
    private double precioUnitario;
    private int cantidad;

    public CompraItem() {
    }

    public CompraItem(String titulo, double precioUnitario, int cantidad) {
        this.titulo = titulo;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }
}
