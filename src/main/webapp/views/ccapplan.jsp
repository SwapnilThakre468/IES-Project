<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
$(document).ready(function(){
	$(".caseId").hide();
});
</script>
<script type="text/javascript">
function deleteConfirm(){
	return confirm("Are you sure,do you want to Delete?");
}
</script>
</head>
<body>
<div align="center">
	<h1>CHILD CARE</h1>
		<form:form action="ccap" method="post" modelAttribute="plan">
			<table>
				<tr>
					<td>Case Id:</td>
					<td><form:input path="caseId" /></td>
				</tr>
				<tr>
					<td>Individual's Name:</td>
					<td><form:input path="" /></td>
				</tr>
				<tr>
					<td>Child Name:</td>
					<td><form:input    path=""    /></td>
				</tr>
				<tr>
					<td>Child Gender:</td>
					<td><form:radiobutton path="gender" value="male" />Male <form:radiobutton
							path="gender" value="female" />Female</td>
				</tr>
				<tr>
					<td>Child Date Of Birth:</td>
					<td><form:input    path=""  id="datepicker"  />
					</td>
				</tr>
				<tr>
					<td>SSN:</td>
					<td>
					<form:input path="ssn" id="ssnsplit"   />
					<input type="text" id="1"  onkeyup="Valid1(this,2)" maxlength="3" />
					<input type="text" id="2"   onkeyup="Valid2(this,3)" maxlength="2" />
					<input type="text" id="3"    maxlength="4" onblur="concatSSN()" />
					</td>
					</tr>	
            
					<tr>
					<td><a href="/ar/">Home</a></td>
					<td><input type="submit" value="Add"   ></td>
				</tr>
				

			</table>
			
		</form:form>
	</div>
	<div  align="center">
	<form:form action="ccap" method="get">
	<table border="1" >
		<tr>
			<th>Case Id</th>
			<th>Child Name</th>
			<th>Gender</th>
			<th>DOB</th>
			<th>SSN</th>
			<th>Action</th>
		</tr>
		
		<c:forEach var="plan" items="${planList}" > 
		<tr>
				<td>${plan.caseId }<input type="text" value="${plan.caseId }" class="caseId" name="caseId"></td>
				<td>${plan.childName }</td>
				<td>${plan.gender }</td>
				<td>${plan.dob }</td>
				<td>${plan.ssn}</td>
				<td colspan="2">
				<div >
				
				<a href="editChildRecord?planId=${plan.caseId }" ><input type="image"  src="/images/edit.gif"  width="48" height="48" ></a>|
                <a href="deleteChildRecord?caseId=${plan.caseId }"  onclick="return deleteConfirm()"><input type="image" src="/images/delete.gif"   width="48" height="48"  ></a>

				</div></td>
			</tr>
			</c:forEach>
			
	</table>
	<input type="submit" value="Next" >
	</form:form>
	</div>
		
</body>
</html>
