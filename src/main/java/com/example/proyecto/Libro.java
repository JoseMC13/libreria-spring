package com.example.proyecto;


public class Libro {

    private String titulo;
    private String autor;
    private int paginas;
    private int stock;
    private double precio;
    private String imagen;
    private String sinopsis;

    public Libro(String titulo, double precio, String imagen, String sinopsis) {
        this.titulo = titulo;
        this.precio = precio;
        this.imagen = imagen;
        this.sinopsis = sinopsis;
    }

    public Libro(String titulo, String autor, int paginas, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.stock = stock;
        this.precio = calcularPrecio(paginas);
        this.imagen = "";
        this.sinopsis = "";
    }

    public Libro(String titulo, String autor, int paginas, int stock, String imagen) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.stock = stock;
        this.precio = calcularPrecio(paginas);
        this.imagen = imagen;
        this.sinopsis = "";
    }

    private double calcularPrecio(int paginas) {
        double valor = paginas * 0.05;
        return Math.round(valor * 100.0) / 100.0;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public int getStock() {
        return stock;
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
