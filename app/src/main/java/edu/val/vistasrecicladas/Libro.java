package edu.val.vistasrecicladas;

import java.io.Serializable;

//SI YO DEFINO EL LIBRO COMO COMPARABLE
//E IMPLEMENTO POR TANTO EL MÉTODO COMPARE
//ESTOY DEFINIENDO LO QUE LLAMAN EN JAVA
//EL "ORDEN NATURAL"
public class Libro implements Comparable<Libro> {

    private int id;
    private int imagen;
    private String titulo;

    public Libro(int imagen, String titulo) {
        this.imagen = imagen;
        this.titulo = titulo;
    }

    public Libro(int id, int imagen, String titulo) {
        this.id = id;
        this.imagen = imagen;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", imagen=" + imagen +
                ", titulo='" + titulo + '\'' +
                '}';
    }

    /**
     * LA CONVENCIÓN QUE HAY QUE SEGUIR PARA ORDENAR LOS LIBROS, ES PROGRAMAR ESTE MÉTODO
     * Y HACED QUE DEVUELVA
     *
     * 1) UN NÚMERO POSITIVO, SI THIS es mayor
     * 2) UN NÚMERO NEGATIVO, SI THIS es menor
     * 3) CERO, SI son iguales
     *
     * @param libro
     * @return
     */
    @Override
    public int compareTo(Libro libro) {
        int resultado_compracion = 0;

            resultado_compracion = this.id - libro.id;
       /* if (this.id > libro.id)
            {
            resultado_compracion = 1;
        } else if  (this.id < libro.id)
        {
            resultado_compracion = -1;
        } else
        {
            //son iguales
            resultado_compracion = 0;
        }*/


        return resultado_compracion;
    }
}
