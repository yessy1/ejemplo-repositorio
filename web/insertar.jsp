<%-- 
    Document   : insertar
    Created on : 05/05/2017, 09:38:10 AM
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
          <form method="get" action="./libroaction.do" >
              <input type="hidden" name="metodo" value="insertarLibro"/>
              Número Libro<input type="text" name="id" required=""/><br/>
              Titulo<input type="text" name="titulo" required=""/><br/>
              Año<input type="text" name="año" required=""/><br/>
              Precio<input type="text" name="precio" required=""/><br/>
            <div name="contenedor"></div>
            <select name="categ" >
                <logic:iterate name="editorial" id="ed"> 
                    <option value="<bean:write name="ed" property="nombre"/>">
                    <bean:write name="ed" property="nombre"/>
                    </option>
                </logic:iterate>
            </select>
            <br/>
            <select name="autores" multiple="true">
                <logic:iterate name="autores" id="aut"> 
                    <option value="<bean:write name="aut"/>">
                    <bean:write name="aut"/>
                    </option>
                </logic:iterate>
            </select>
            <br/>
            <input type="submit" value="Insertar">
            
        </form>
    </body>
</html>
