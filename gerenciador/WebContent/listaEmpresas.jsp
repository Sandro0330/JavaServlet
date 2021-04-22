<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List, br.gerenciador.servlet.Empresa" %><!-- importando a classe empresa -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de empresas cadastradas</title>
</head>
<body>
	
	<ul>
		<%
			List<Empresa> lista = (List<Empresa>)request.getAttribute("empresas");
			for(Empresa empresa : lista) {
				
		 %>
			<li><%= empresa.getNome() %></li>
		<% 		
			}
		%>
	</ul>
</body>
</html>