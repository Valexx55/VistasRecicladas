package edu.val.vistasrecicladas;

import java.util.Comparator;

public class ComparadorLibros implements Comparator<Libro> {

    //vamos a ordenar por titulo
    @Override
    public int compare(Libro libro, Libro libro2) {
        int resultado_comp = 0;

            resultado_comp = libro.getTitulo().compareTo(libro2.getTitulo());

        return resultado_comp;
    }
}
