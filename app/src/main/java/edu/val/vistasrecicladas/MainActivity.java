package edu.val.vistasrecicladas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;//es el padre de la lista de datos - el contendor
    private static final int TAMANIO_LISTA_LIBROS = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recyclerView = findViewById(R.id.recicler_view);
        List<Libro> libroList = generarListaLibros();

        AdapterListaLibros adapterListaLibros = new AdapterListaLibros(libroList);

        this.recyclerView.setAdapter(adapterListaLibros);//oye, lista (recycler), tu proveedor, es éste (adapter)

        //ahora definimos el estilo
        RecyclerView.LayoutManager layoutManager =  new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
         this.recyclerView.setLayoutManager(layoutManager);

         //echad un vistazo al  StaggeredGridLayoutManager para distrbucion en celdas
    }


    private List<Libro> generarListaLibros ()
    {
        List<Libro> lista_libros = null;
        Libro libro_aux = null;

            lista_libros = new ArrayList<Libro>(TAMANIO_LISTA_LIBROS);

            for (int i = 0; i < TAMANIO_LISTA_LIBROS; i++)
            {
                libro_aux = new Libro(R.mipmap.ic_launcher, "TITULO "+i);
                lista_libros.add(libro_aux);
            }


        return lista_libros;
    }
}