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
<h1>Education Details</h1>
<form:form action="ktwork" method="post" modelAttribute="plan">
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
					<td>Highest Qualification:</td>
					<td><form:select path="planName" >
							<form:option value="" >-select-</form:option>
							<form:options items="${qualList}"/>
							
						</form:select></td>
				</tr>
				
				<tr>
					<td>Completed Year:</td>
					<td><form:input path="educationComleted" /></td>
				</tr>
				<tr>
					<td>Grade:</td>
					<td><form:select path="planName" >
							<form:option value="" >-select-</form:option>
							<form:options items="${gradeList}"/>
							
						</form:select></td>
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