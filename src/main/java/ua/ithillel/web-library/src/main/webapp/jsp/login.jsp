<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	   <title>Login</title>
	</head>
	
	<body>
	   <form action="login" method="post">
    
	       Username <input type="text" name="username"/> 
	       Password <input type="text" name="password" />
	       <input type="text" name="valid" />
	       <input type="submit" />

        </form>
        
        ${loginError}
        
	</body>
</html>