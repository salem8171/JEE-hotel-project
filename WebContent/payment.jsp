<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="hotel.BeanHotel" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% BeanHotel B= (BeanHotel)session.getAttribute("nomHotel");%>
<h1>Résérvation</h1><br>

Hotel : <%= B.getNom() %> <br> <br>
Date d'entrée : <%= session.getAttribute("de") %><br>
Date de sortie : <%= session.getAttribute("ds") %><br>
Type de chambre : <%= session.getAttribute("room") %><br>
Nombre de nuit :<%= session.getAttribute("nbn") %><br>
Nombre de personne :<%= session.getAttribute("nbp") %><br><br>

<% String nbn=(String)session.getAttribute("nbn");
String nbp=(String)session.getAttribute("nbp");
double prix;
if(request.getParameter("room").equals("single"))
	{
		 prix = B.getPrix_single()* Integer.parseInt(nbn)*Integer.parseInt(nbp);
	}
else
	 prix = B.getPrix_double()* Integer.parseInt(nbn)*Integer.parseInt(nbp);
	%>

Total a payer :<%= prix %> D<br><br>
<button>Payer</button>

</body>
</html>