<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" 
src='<c:url value="/resources/js/jquery-1.11.1.min.js" />'></script> <!-- Sin esta linea no funciona ajax porque necesita JQuery -->

<title>Insert title here</title>

</head>
<body>

Buscar:<input type="text" id="txtBuscar" 
				placeholder="Parametro de Busqueda">
	   <input type="button" id="btnBuscar" value="buscar" onclick="buscar()"> 
<table id="tblDatos">

<c:forEach items="${tiendas }" var="producto">
	<tr>
		<td>${producto.nombre }</td><!-- $: Esto significa que queremos acceder a una variable que es java -->
		<td>${producto.descripcion }</td>
		<td>${producto.existencias }</td>
		<td>${producto.precio }</td>
		<td>
			
			<a href="/detalle.html?id=${producto.idProducto}"> 
				Ver detalle
			</a>
			
			<a href="#" id="lnkDetalle" 
					onclick="evento(${producto.idProducto})">
				Detalle Ajax
			</a>
		
			<a href="#" id="lnkBorrar" 
					onclick="borrar(${producto.idProducto})">
				Borrar</a>
		
		</td>
	</tr>
</c:forEach>
</table>
<div id="divDetalle" ></div>
<script type="text/javascript">

function borrar(id){
	var datos={idProducto:id};
	var datosPasar=JSON.stringify(datos);

	$.ajax(
			"producto",{
				data:datosPasar,
				method: "DELETE",
				contentType: "application/json",
				success: function(res){
					alert("Producto borrado satisfactoriamente y sin remedio");
					$("#txtBuscar").text("");
					buscar();
					},
				error: function(res){
					alert(JSON.stringify(res));
					}

				}
			);
	
}

function buscar(){
	var tx=$("#txtBuscar").val();
	var url="producto/buscar/"+tx;	

	$.get(url,function(res){

		var tabla=$("#tblDatos");

		$("#tblDatos tr").each(function(){
				$(this).remove();

			});

		for(var i=0;i<res.length;i++){
			var h="<tr>";
			h+="<td>"+res[i].nombre+"</td>";
			h+="<td>"+res[i].precio+"</td>";
			h+="<td><a href='detalle.html?id="+
					res[i].idProducto+"'>Detalle</a>";
			h+="<a href='#' onclick='evento("+
				res[i].idProducto+")'>Detalle ajax</a></td>";
			h+="<a href='#' onclick='borrar("+
				res[i].idProducto+")'>borrar</a></td>";
			h+="</tr>";	
			tabla.append(h);
			}

	});

}

function detalle(id){
	var url="producto/"+id;
/*Hacemos una llamada ajax usando el metodo get
*Le pasamos la url y la funcion que se ejecuta cuando nos 
*devuelve la informacion
*/
	$.get(url,function(res){

		var resultado="<ul>";
		resultado+="<li>"+res.nombre+"</li>";
		resultado+="<li>"+res.descripcion+"</li>";
		resultado+="<li>"+res.existencias+"</li>";
		resultado+="<li>"+res.precio+"</li></ul>";
		
		$("#divDetalle").html(resultado);

		});

}
</script>
</body>
</html>