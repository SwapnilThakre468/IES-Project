<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IES</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$(".status").hide();
});
</script>
<script type="text/javascript">

if($(".status").val=="Active"){
	
	$(".deletebtn").show();
	 
}else{
	
	
	$(".activatebtn").show();
}	  


</script>
<script type="text/javascript">
function deleteConfirm(){
	return confirm("Are you sure,do you want to Delete?");
}
function activateConfirm(){
	return confirm("Are you sure,do you want to Activate?");
}
</script>
</head>
<body>
<h1 align="center"> View Plans</h1>
	<div align="center">
	<font color="green">${delsucc}</font>

	
    <a href="/admin/">Home</a>
	<div  align="center">
	<table border="1" >
		<tr>
			<th>Plan Name</th>
			<th>Plan Description</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Action</th>
		</tr>
		
		<c:forEach var="plan" items="${planList}" > 
		<tr>
				<td>${plan.planName }</td>
				<td>${plan.planDescrp }</td>
				<td>${plan.startDate }</td>
				<td>${plan.endDate }</td>
				<td colspan="2">
				<div class="status">"${plan.status}"</div><div class="wrapper"><div class="form-group inputFields">
				
				<a href="editPlan?planId=${plan.planId }" ><input type="image"  src="/images/edit.gif"  width="48" height="48" ></a>|
<a href="deletePlan?planId=${plan.planId }" class="deletebtn"  onclick="return deleteConfirm()"><input type="image" src="/images/delete.gif"   width="48" height="48" class="fa fa-plus-circle fa-2x" aria-hidden="true"></a>
<a href="deletePlan?planId=${plan.planId }" class="activatebtn"  onclick="return activateConfirm()"><input type="image" src="/images/activate.gif"  width="48" height="48" class="fa fa-plus-circle fa-2x" aria-hidden="true"></a>
				</div></div>
</td>
			</tr>
			</c:forEach>
			
	</table>
	</div>
	
</div>

</body>
</html>