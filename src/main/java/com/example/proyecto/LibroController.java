package com.example.proyecto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibroController {
    private final LibrosDisponibles repositorio = new LibrosDisponibles();

    @GetMapping("/libros")
    public List<Libro> obtenerLibros() {
        return repositorio.getLibros();
    }
}
