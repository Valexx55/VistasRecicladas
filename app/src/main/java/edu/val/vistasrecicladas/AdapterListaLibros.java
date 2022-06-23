package edu.val.vistasrecicladas;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * ESTA CLASE ACTÚA COMO PROVEEDOR DE DATOS DEL RECYCLER
 * Y CONTIENE LA LISTA/LA INFORMACIÓN A MOSTRAR
 */

public class AdapterListaLibros extends RecyclerView.Adapter {

    private List<Libro> lista_libros;

    public AdapterListaLibros (List<Libro> lista_libros)
    {
        this.lista_libros = lista_libros;//guardamos la lista, para luego ir dándosela al Recycler cuando nos la pida
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    //este método le dice al Recycler cuántos items tiene que dibujar
    @Override
    public int getItemCount() {
        return this.lista_libros.size();
    }
}
