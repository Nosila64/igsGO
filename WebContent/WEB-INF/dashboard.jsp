<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<button><a href="<%=request.getContextPath()+"/Trajet"%>">J'enregistre mon trajet</a></button>
OU
<button><a href="<%=request.getContextPath()+"/Arret"%>">Je cherche un point d'arr�t proche de moi !</a></button>
</body>
</html>