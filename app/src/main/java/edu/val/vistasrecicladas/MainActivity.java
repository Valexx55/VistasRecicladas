package edu.val.vistasrecicladas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerView;//es el padre de la lista de datos - el contendor
    private static final int TAMANIO_LISTA_LIBROS = 100;
    private SearchView searchView;
    private List<Libro> libroList;
    private AdapterListaLibros adapterListaLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.searchView = findViewById(R.id.searchView);
        this.recyclerView = findViewById(R.id.recicler_view);
        libroList = generarListaLibros();

        Log.d("ETIQUETA_LOG", "lista sin ordenar = " + this.libroList);
        //Collections.sort(libroList);
        //Log.d("ETIQUETA_LOG", "lista ordenada por id orden natural = " + this.libroList);
        //Collections.sort(libroList, new ComparadorLibros());
        //Log.d("ETIQUETA_LOG", "lista ordenada por titulo orden total = " + this.libroList);


        adapterListaLibros = new AdapterListaLibros(libroList);

        this.recyclerView.setAdapter(adapterListaLibros);//oye, lista (recycler), tu proveedor, es éste (adapter)

        //ahora definimos el estilo
        RecyclerView.LayoutManager layoutManager =  new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        this.recyclerView.setLayoutManager(layoutManager);
        //this.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

         //echad un vistazo al  StaggeredGridLayoutManager para distrbucion en celdas
        this.searchView.setOnQueryTextListener(this);


    }


    private List<Libro> generarListaLibros ()
    {
        List<Libro> lista_libros = null;
        Libro libro_aux = null;

            lista_libros = new ArrayList<Libro>(TAMANIO_LISTA_LIBROS);

            for (int i = 0; i < TAMANIO_LISTA_LIBROS; i++)
            {
                libro_aux = new Libro(i, R.mipmap.ic_launcher, "TITULO "+i);
                lista_libros.add(libro_aux);
            }


        return lista_libros;
    }

    //lista_filtrada filtrarLista (lista, busqueda_usuario)
    private List<Libro> filtrarLista (List<Libro> lista_libros, String busqueda_usuario)
    {
        List<Libro> lista_libros_filtrada = null;
            //TODO: implementar esta función para que cumpla con la funcionalidad prevista
        //tiempo: 15 minutos
            //recorrer con un for
        lista_libros_filtrada = new ArrayList<Libro>();
        for(int i = 0; i<lista_libros.size(); i++){
            //if (busqueda_usuario.equals(lista_libros.get(i).getTitulo()))
            if (lista_libros.get(i).getTitulo().contains(busqueda_usuario))
            {
                lista_libros_filtrada.add(lista_libros.get(i));
            }
        }

                //si la busqueda de usuario, coincide con el elemento de la lista
                    //a la buchaca, lo meto en la nueva lista
               //si no --> no hago nada

        return lista_libros_filtrada;
    }

    //ALERNATIVA A FILTRADO CON PROGRAMACIÓN FUNCIONAL (STREAMS Y LAMBDAS, FUNCIONES ANÓNIMAS)
    private List<Libro> filtrarLista2 (List<Libro> lista_libros, String busqueda_usuario)
    {
        List<Libro> lista_libros_filtrada = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            lista_libros_filtrada = lista_libros.stream().filter(libro -> {return libro.getTitulo().contains(busqueda_usuario);}).collect(Collectors.toList());
        }

        return lista_libros_filtrada;
    }

    @Override
    public boolean onQueryTextSubmit(String termino_busqueda) {
        //método invocado al realizar la búsqueda
        Log.d("ETIQUETA_LOG", "onQueryTextSubmit = " + termino_busqueda);
        //FILTRAR POR LA CADENA DE BÚSQUEDA S
        Log.d("ETIQUETA_LOG", "lista sin filtrar = " + this.libroList);
        List<Libro> lista_filtrada = filtrarLista(this.libroList, termino_busqueda);
        List<Libro> lista_filtrada2 = filtrarLista2(this.libroList, termino_busqueda);
        Log.d("ETIQUETA_LOG", "lista_filtrada = " + lista_filtrada);
        Log.d("ETIQUETA_LOG", "lista_filtrada2 = " + lista_filtrada2);
        //TODO Actualizar el Recycler --> CREANDO UN NUEVO ADAPTER CON LOS DATOS NUEVOS
        this.adapterListaLibros = new AdapterListaLibros(lista_filtrada);
        this.recyclerView.setAdapter(this.adapterListaLibros);//al asginarle al recycler un nuevo adapter, fuerzo su actualización

        return true;
    }



    @Override
    public boolean onQueryTextChange(String termino_busqueda) {
        //método invocado al modficar el contenido de la caja de búsqueda
        Log.d("ETIQUETA_LOG", "onQueryTextChange = " + termino_busqueda);
        if (termino_busqueda.equals(""))
        {
            //TODO recuperar la lista original
           // this.libroList = this.generarListaLibros();
            this.adapterListaLibros = new AdapterListaLibros(libroList);
            this.recyclerView.setAdapter(adapterListaLibros);
        } else {
            List<Libro> lista_filtrada = filtrarLista(this.libroList, termino_busqueda);
            this.adapterListaLibros = new AdapterListaLibros(lista_filtrada);
            this.recyclerView.setAdapter(this.adapterListaLibros);
        }
        return true;
    }

    public void ordenarPorTitulo(View view) {

        Log.d("ETIQUETA_LOG", "ORDEN ordenarPorTitulo");
        Collections.sort(this.libroList, new ComparadorLibros());
        this.adapterListaLibros = new AdapterListaLibros(this.libroList);
        this.recyclerView.setAdapter(this.adapterListaLibros);
    }

    public void ordenarPorId(View view) {
        Log.d("ETIQUETA_LOG", "ORDEN ordenarPorId");
        Collections.sort(this.libroList);
        this.adapterListaLibros = new AdapterListaLibros(this.libroList);
        this.recyclerView.setAdapter(this.adapterListaLibros);
    }
}