package edu.val.vistasrecicladas;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//ESTO ES COMO CADA FILA "holder" - CONTENEDOR
public class LibroHolder extends RecyclerView.ViewHolder {

    private ImageView imagen_libro;
    private TextView titulo_libro;

    //ESTE CONSTRUCTOR A INICIAR CADA FILA
    //TODO crear un layout para definir el aspecto de las filas
    //que las filas, se van a ir inflando después
    //itemView, es una fila
    public LibroHolder(@NonNull View itemView) {
        super(itemView);
        this.imagen_libro = itemView.findViewById(R.id.imagenLibro);
        this.titulo_libro = itemView.findViewById(R.id.tituloLibro);
    }

    //rellenar una fila, con los datos concretos de un libro
    public  void cargarLibroEnHolder (Libro l)
    {
        this.imagen_libro.setImageResource(l.getImagen());
        this.titulo_libro.setText(l.getTitulo());
    }
}
