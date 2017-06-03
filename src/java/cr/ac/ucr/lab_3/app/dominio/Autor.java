/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.lab_3.app.dominio;

/**
 *
 * @author usuario
 */
public class Autor {
    
    int id_autor;
    String nombre_autor;
    String apellido_autor;

    public Autor(int id_autor, String nombre_autor, String apellido_autor) {
        this.id_autor = id_autor;
        this.nombre_autor = nombre_autor;
        this.apellido_autor = apellido_autor;
    }

    
    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public String getApellido_autor() {
        return apellido_autor;
    }

    public void setApellido_autor(String apellido_autor) {
        this.apellido_autor = apellido_autor;
    }
    
    
    
}

