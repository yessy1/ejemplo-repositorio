/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.lab_3.app.dominio;

import java.util.LinkedList;

/**
 *
 * @author usuario
 */
public class Libro {
    
    int id_libro;
    String titulo;
    int anio;
    int editorial;
    float precio;
    LinkedList<Autor> autores;

    public Libro(int idlibro,String titulo, int anio, int id_editorial, float precio, 
        LinkedList<Autor> autores) {
        this.id_libro = idlibro;
        this.titulo = titulo;
        this.anio = anio;
        this.editorial = id_editorial;
        this.precio = precio;
        this.autores= autores;
    }

    public int getEditorial() {
        return editorial;
    }

    public void setEditorial(int editorial) {
        this.editorial = editorial;
    }

    public LinkedList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(LinkedList<Autor> autores) {
        this.autores = autores;
    }

    
    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

   

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
    
}
