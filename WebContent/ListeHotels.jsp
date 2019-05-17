<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="hotel.BeanHotel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import=java.util.Vector %>
<% String s=request.getParameter("choix"); %>
<% Vector<BeanHotel> vh = (Vector<BeanHotel>) session.getAttribute("hotel");
HttpSession	S = request.getSession(true);%>
	<% if (s==null) { %>
	
	
	<h1>List des hôtels:</h1>
	<form action="http://localhost:8070/HotelProject/ListeHotels.jsp">
	<% int i=0;
	for(BeanHotel p: vh)
		{
		String nom = p.getNom();
		%>
		<input type ="radio" name="choix" value="<%= i %>"><%= nom %>
		
		<%
		i++;
		}
		%>
		<br>
		<input type="submit" value="valider">
		</form>
		<% } else { 
		int n = Integer.parseInt(s);
		BeanHotel b=(BeanHotel)vh.get(n);
		S.setAttribute("nomHotel",b);
		response.sendRedirect("http://localhost:8070/HotelProject/reserve.html"); }%>
</body>
</html>