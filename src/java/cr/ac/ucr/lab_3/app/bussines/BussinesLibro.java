/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.lab_3.app.bussines;

import cr.ac.ucr.lab_3.app.data.DataLibro;
import cr.ac.ucr.lab_3.app.dominio.Libro;
import java.util.LinkedList;

/**
 *
 * @author usuario
 */
public class BussinesLibro {
    
    private DataLibro dLibro;
    
    
    public BussinesLibro (){
    
    dLibro = new DataLibro("root","");
    }
    
    public void insertar (Libro libro){
    dLibro.insertar(libro);
    }
    
    public LinkedList<String> getAutores(String tabla){
    return dLibro.getAutores(tabla);
    }
    
    
    
}
