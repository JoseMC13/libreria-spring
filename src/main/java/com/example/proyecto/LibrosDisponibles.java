package com.example.proyecto;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio en memoria para la gestion de libros.
 */
public class LibrosDisponibles {
    private final List<Libro> libros;

    public LibrosDisponibles() {
        libros = new ArrayList<>();
        cargarLibrosIniciales();
    }

    private void cargarLibrosIniciales() {
        libros.add(crearLibro("Primer Java", "Kathy Sierra", 300, 5, "primer-java.jpg"));
        libros.add(crearLibro("Comenzando a programar con Java para Dummies", "Barry Burd", 450, 3, "comenzando-java-dummies.jpg"));
        libros.add(crearLibro("Java: conceptos basicos de programacion para principiantes", "Nathan Clark", 600, 4, "java-conceptos-basicos.jpg"));
        libros.add(crearLibro("Java: una guia para principiantes", "Herbert Schildt", 200, 10, "java-guia-principiantes.jpg"));
        libros.add(crearLibro("Core Java Volumen I", "Cay S. Horstman", 200, 3, "core-java-vol-1.jpg"));
        libros.add(crearLibro("Think Java: Como pensar como un cientifico informatico", "Allen B. Downey", 550, 8, "think-java.jpg"));
        libros.add(crearLibro("Java efectivo", "Joshua Bloch", 250, 7, "java-efectivo.jpg"));
        libros.add(crearLibro("Java: la referencia completa", "Herbert Schildt", 700, 13, "java-referencia-completa.jpg"));
        libros.add(crearLibro("Java 8 en accion", "Alan Mycroft", 400, 5, "java-8-en-accion.jpg"));
        libros.add(crearLibro("Pensando en Java", "Bruce Eckel", 300, 4, "pensando-en-java.jpg"));
        libros.add(crearLibro("Aprender Java mediante la creacion de juegos para Android", "Jonh Horton", 800, 4, "java-juegos-android.jpg"));
        libros.add(crearLibro("Java en pocas palabras", "Ben Evans", 200, 2, "java-en-pocas-palabras.jpg"));
        libros.add(crearLibro("Core Java para los impacientes", "Cay S. Horstmann", 450, 11, "core-java-impacientes.jpg"));
        libros.add(crearLibro("Java: una introduccion a la programacion del mundo real", "Marc Loy", 250, 8, "java-introduccion-mundo-real.jpg"));
        libros.add(crearLibro("Asimilando la entrevista de Java", "Javin Paul", 500, 6, "asimilando-entrevista-java.jpg"));
        libros.add(crearLibro("El sistema de modulos de Java", "Nikolai Parlog", 300, 14, "sistema-modulos-java.jpg"));
        libros.add(crearLibro("Java moderno en accion", "Mario Fusco", 400, 7, "java-moderno-en-accion.jpg"));
        libros.add(crearLibro("Problemas clasicos de informatica en Java", "David Kopec", 500, 4, "problemas-clasicos-java.jpg"));
        libros.add(crearLibro("Aprende a hacer codigo", "Eric Freeman", 400, 5, "aprende-a-hacer-codigo.jpg"));
        libros.add(crearLibro("Manual de artesania de software agil", "Robert C. Martin", 200, 7, "manual-software-agil.jpg"));
        libros.add(crearLibro("El lenguaje oculto del hardware y el software informatico", "Charles Petzold", 700, 10, "lenguaje-oculto-hardware-software.jpg"));
        libros.add(crearLibro("Entrevista de Cracking the Coding", "Gayle Laakmann McDowell", 350, 4, "cracking-the-coding.jpg"));
        libros.add(crearLibro("Algoritmos de Grokking: una guia ilustrada para programadores", "Aditya Y. Bhargava", 600, 2, "grokking-algoritmos.jpg"));
        libros.add(crearLibro("Introduccion a los algoritmos", "Thomas H. Cormen", 450, 7, "introduccion-algoritmos.jpg"));
        libros.add(crearLibro("Piense en estructuras de datos", "Allen B. Downey", 550, 17, "piense-estructuras-datos.jpg"));
    }

    private Libro crearLibro(String titulo, String autor, int paginas, int stock, String imagen) {
        return new Libro(titulo, autor, paginas, stock, imagen);
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }
}
