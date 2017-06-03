/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.lab_3.app.data;


import cr.ac.ucr.lab_3.app.dominio.Editorial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Yessica Zuñiga
 */
public class DataEditorial extends DataBase{
    
    
     Connection con;
    public DataEditorial(String user, String pass){
        super(user,pass);
    }
    
    public boolean insertar(Editorial editorial){
        boolean inserto = true;    
        String sql= "INSERT INTO tb_editorial VALUES (?,?,?,?)";
       
        
        try {
            con = this.getConection();
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setInt(1, editorial.getId_editorial());
                statement.setString(2, editorial.getNombre());
                statement.setString(3, editorial.getDireccion());
                statement.setString(4, editorial.getTelefono());
                statement.executeUpdate();
            }
            con.close();
        } catch (SQLException ex) {
            inserto = false;
            Logger.getLogger(DataEditorial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return inserto;
    }
    
    public boolean eliminarEditorial(int codigo){
    
        boolean borrar = true;    
        String sql= "DELETE FROM tb_editorial where id = '"+ codigo+"'";
       
        System.out.println("Borra");
        try {
            con = this.getConection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.executeUpdate();
            statement.close();
            con.close();
        } catch (SQLException ex) {
            borrar = false;
            Logger.getLogger(DataEditorial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return borrar;
    }
    
    public LinkedList<Editorial> getEditoriales(){
    
        LinkedList<Editorial> cursos = new LinkedList();
        String sql = "SELECT * FROM tb_editorial";
        Connection con;
        
        try {
            con = this.getConection();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Editorial edit;
        while(result.next()){
        
            edit = new Editorial(0,"","","");
            edit.setId_editorial(result.getInt("id_editorial"));
            edit.setNombre(result.getString("nombre"));
            edit.setDireccion(result.getString("direccion"));
            edit.setTelefono(result.getString("telefono"));
           
            cursos.add(edit);
        }
            statement.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No se pudo leer la base de datos");
            Logger.getLogger(DataEditorial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return cursos;
    }
    
    public int consultar(String nombre){
    
        
        int idEditorial=0;
        
         try {
             String consulta = "SELECT id_editorial from tb_editorial "
                + "where nombre = ?";
             
             con = this.getConection();
             
             PreparedStatement statement = con.prepareStatement(consulta);
             statement.setString(1,nombre);
             
             ResultSet res = statement.executeQuery();
             
             
             while(res.next()){
                idEditorial= res.getInt("id_editorial");
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(DataEditorial.class.getName()).log(Level.SEVERE, null, ex);
         }
         return idEditorial;       
    }   
    
}
