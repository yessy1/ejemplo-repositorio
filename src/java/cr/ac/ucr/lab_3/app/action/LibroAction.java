/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.lab_3.app.action;

import cr.ac.ucr.lab_3.app.bussines.BussinesEditorial;
import cr.ac.ucr.lab_3.app.bussines.BussinesLibro;
import cr.ac.ucr.lab_3.app.data.DataEditorial;
import cr.ac.ucr.lab_3.app.dominio.Autor;
import cr.ac.ucr.lab_3.app.dominio.Editorial;
import cr.ac.ucr.lab_3.app.dominio.Libro;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author usuario
 */
public class LibroAction extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    BussinesLibro bLibro = new BussinesLibro();
    BussinesEditorial bEditorial = new BussinesEditorial();
    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction1, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward iniciar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        LinkedList<String> autores = bLibro.getAutores("autor");
        LinkedList<Editorial> editoriales = bEditorial.getEditoriales();
        request.setAttribute("autores", autores);
        request.setAttribute("editorial", editoriales);
        
        return mapping.findForward("insertar");
    }
    public ActionForward insertarLibro(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LinkedList<Autor> ej = new LinkedList<>();
        ej.add(new Autor(1, "mune", "Orozco"));
        ej.add(new Autor(3, "carmen", "Lyra"));
        DataEditorial dE = new DataEditorial("root","");
        
        Libro libro = new Libro(Integer.parseInt(request.getParameter("id")), request.getParameter("titulo"),
                 Integer.parseInt(request.getParameter("año")), dE.consultar(request.getParameter("categ")),
                 Integer.parseInt(request.getParameter("precio")), ej);
        
        bLibro.insertar(libro);
        LinkedList<String> autores = bLibro.getAutores("autor");
        LinkedList<Editorial> editoriales = bEditorial.getEditoriales();
        request.setAttribute("autores", autores);
        request.setAttribute("editorial", editoriales);
        
       
        
        return mapping.findForward("insertar");
    }

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction2, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward myAction2(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        return mapping.findForward(SUCCESS);
    }
}
