<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Income Details</h1>
<form:form action="snap" method="post" modelAttribute="plan">
			<table>
			    <tr>
					<td>Case Id:</td>
					<td><form:input    path="caseId"   value="${caseId }"  disabled="true" /></td>
				</tr>
				<tr>
					<td>Individual's Name:</td>
					<td><form:input path="individualName" /></td>
				</tr>
				<tr>
					<td>Is Working Employee:</td>
					<td><form:radiobutton path="isEmployeed" value="Yes" />Yes <form:radiobutton
							path="isEmployeed" value="No" />No</td>
				</tr>
				
				<tr>
					<td>Other Income:</td>
					<td><form:input path="otherIncome" /><h5>$</h5></td>
				</tr>
				
				<tr>
					<td><a href="/dc/">Home</a></td>
					<td><input type="submit" value="Next"></td>
				</tr>
				

			</table>
			
		</form:form>
</div>
</body>
</html>