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
<c:forEach items="${tiendas }" var="tienda_producto">
	<tr>
		<td>${tienda_producto.nombre }</td><!-- $: Esto significa que queremos acceder a una variable que es java -->
		<td>${tienda_producto.precio }</td>
	</tr>
	
	
	
</c:forEach>
</table>
</body>
</html>