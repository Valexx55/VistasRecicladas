package edu.val.vistasrecicladas;

public class Libro {

    private int imagen;
    private String titulo;

    public Libro(int imagen, String titulo) {
        this.imagen = imagen;
        this.titulo = titulo;
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
                "imagen=" + imagen +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
