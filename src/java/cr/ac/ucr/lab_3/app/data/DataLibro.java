/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.ucr.lab_3.app.data;
import cr.ac.ucr.lab_3.app.data.DataBase;
import cr.ac.ucr.lab_3.app.dominio.Autor;
import cr.ac.ucr.lab_3.app.dominio.Editorial;
import cr.ac.ucr.lab_3.app.dominio.Libro;
import java.sql.CallableStatement;
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
public class DataLibro extends DataBase {
    
     Connection con;
    public DataLibro(String user, String pass){
        super(user,pass);
    }
    
    public void insertar(Libro libro){
        String sqlLibro= "INSERT INTO tb_libros values(?,?,?,?,?)"   ;
        String sql= "INSERT INTO libro_autor VALUES (?,?)";
       
         try {
             Connection con = super.getConection();
             con.setAutoCommit(true);
             CallableStatement statementLibro = con.prepareCall(sqlLibro);
             CallableStatement statementLibroAutor = con.prepareCall(sql);
             
             statementLibro.setInt(1,libro.getId_libro());
             statementLibro.setString(2, libro.getTitulo());
             statementLibro.setInt(3,libro.getAnio());
             statementLibro.setInt(4,libro.getEditorial());
             statementLibro.setFloat(5,libro.getPrecio());


             statementLibro.execute();
             
             for (Autor autor: libro.getAutores()){
             
                 statementLibroAutor.setInt(1, autor.getId_autor());
                 statementLibroAutor.setInt(2,libro.getId_libro());
                 statementLibroAutor.execute();
             }
             
             statementLibro.close();
             statementLibroAutor.close();
             con.close();
         } catch (SQLException ex) {
             
             if(con != null){
                 try {
                     con.rollback();
                 }catch(SQLException e){
                 
                     Logger.getLogger(sql);
                 }
             }
             Logger.getLogger(DataLibro.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        
        
    }
    
    public boolean eliminarLibro(int codigo){
    
        boolean borrar = true;    
        String sql= "DELETE FROM tb_libro where id_libro = '"+ codigo+"'";
       
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
    
     public LinkedList<String> getAutores(String tabla){
    
        LinkedList<String> autores = new LinkedList();
        String sql = "SELECT * FROM autor";
        Connection con;
        
        try {
            con = this.getConection();
            PreparedStatement statement = con.prepareStatement(sql);
            
            ResultSet result = statement.executeQuery();
            
        while(result.next()){        
            autores.add(result.getString("nombre_autor"));
                    
        }
            statement.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No se pudo leer la base de datos");
            Logger.getLogger(DataEditorial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return autores;
    }
    
    
   
    
//    public static void main (String args[]){
//    
//        DataLibro dl = new DataLibro("root", "");
//        
//        Editorial ed = new Editorial(1,"Universal","","");
//        LinkedList<Autor> autores = new LinkedList<>();
//        Autor a= new Autor(1, "mune", "Orozco");
//        Autor b= new Autor(1, "Rabin", "Laraz");
//        Autor c= new Autor(2, "Rascars", "Frenesi");
//        autores.add (a);
////        autores.add (b);
////        autores.add (c);
//        Libro l = new Libro(8,"Rio verde ",1999,ed,0,autores);
//        
//        dl.insertar(l);
//    }
    
    
}
