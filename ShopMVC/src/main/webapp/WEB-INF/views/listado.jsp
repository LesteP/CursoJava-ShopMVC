<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<table>
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
		
		</td>
	</tr>
</c:forEach>
</table>


<div id="divDetalle" ></div>
<script type="text/javascript" src='<c:url value="/resources/js/jquery.js" />'></script><!-- Sin esto no funciona ajax -->

<script type="text/javascript">
function detalle(id){

	var url="producto/"+id;
//HAcemos una llamada ajax usando el metodo get
//Le pasamos la url y la funcion que se ejecuta cuando nos 
//devuelve la informacion
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