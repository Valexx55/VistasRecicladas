package edu.val.vistasrecicladas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * ESTA CLASE ACTÚA COMO PROVEEDOR DE DATOS DEL RECYCLER
 * Y CONTIENE LA LISTA/LA INFORMACIÓN A MOSTRAR
 */

public class AdapterListaLibros extends RecyclerView.Adapter<LibroHolder> {

    private List<Libro> lista_libros;

    public AdapterListaLibros (List<Libro> lista_libros)
    {
        this.lista_libros = lista_libros;//guardamos la lista, para luego ir dándosela al Recycler cuando nos la pida
    }

    //este método, se va a invocar cuando el recycler necesite una fila nueva
    @NonNull
    @Override
    public LibroHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LibroHolder libroHolder = null;

            LayoutInflater layoutInflater =  LayoutInflater.from(parent.getContext());
            View fila_libro = layoutInflater.inflate(R.layout.filo_libro, parent, false);
            libroHolder = new LibroHolder(fila_libro);


        return libroHolder;
    }

    //este método, se va a invocar cuando el recycler necesite rellenar una fila
    @Override
    public void onBindViewHolder(@NonNull LibroHolder holder, int position) {
            Libro libro =  lista_libros.get(position);
            holder.cargarLibroEnHolder(libro);
    }

    //este método le dice al Recycler cuántos items tiene que dibujar
    @Override
    public int getItemCount() {
        return this.lista_libros.size();
    }
}
