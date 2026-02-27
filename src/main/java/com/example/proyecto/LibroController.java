package com.example.proyecto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibroController {

    @GetMapping("/libros")
    public List<Libro> obtenerLibros() {

        return List.of(
                new Libro("El Principito", 10.99),
                new Libro("Cien Años de Soledad", 15.50),
                new Libro("Clean Code", 40.00)
        );
    }
}