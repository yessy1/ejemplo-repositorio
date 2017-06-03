/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.lab_3.app.bussines;

import cr.ac.ucr.lab_3.app.data.DataEditorial;
import cr.ac.ucr.lab_3.app.dominio.Editorial;
import java.util.LinkedList;

/**
 *
 * @author usuario
 */
public class BussinesEditorial {
    private DataEditorial dEditorial;
    
    public BussinesEditorial(){
    dEditorial = new DataEditorial("root", "");
    }
    
    public LinkedList<Editorial> getEditoriales(){
    return dEditorial.getEditoriales();
    }
    
}
