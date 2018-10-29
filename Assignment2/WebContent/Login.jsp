<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<html>
<head>
<title>Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sb:head />
<body>

	<!--action connect to struts.xml -->
	<s:form method="POST" action="login" theme="bootstrap" cssClass="well form-vertical" label="LoginForm"
		style="width:600px;height:300px;position:relative;top:25%;left:35%">
		<s:textfield name="name" label="Username" placeholder="Please enter your username" />
		<s:password name="password" label="Password" placeholder="Please enter your password" />
		<s:submit name="submit" id="submit" label="Submit" cssClass="btn btn-primary" />
		<strong><s:text name="%{errorMsg}" /></strong>
	</s:form>

</body>

</html>