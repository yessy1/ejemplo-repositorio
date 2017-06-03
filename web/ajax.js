/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validar(){
    
    var xmlhttp = new XMLHttpRequest();
    var capa = document.getElementById("contenedor");
    var texto = documento.getElementByName("texto").value;
    alert("valor del campo "+ texto);
    capa.innerHTML="<div id='contenedor'>Cargando...</div>"
    xmlhttp.open("GET","./verificarUsuario?usuario="+texto,true);
    xmlhttp.setRequestHeader("Content type","aplication/x-www-form-urlencoded");
    xmlhttp.send(null);
    xmlhttp.onreadystatechange= function(){
        
        if(xmlhttp.readyState == 4){
            capa.innerHTML.responseText;
        }
    }
    
}


