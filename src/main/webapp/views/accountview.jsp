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
	$("#role").change(function(){
		alert($("#role").val());
        $(this).find('option').get(0).remove();
			$.ajax({
		type : "GET",
		url : "dropdownAccount?role="+$("#role").val(),
  			dataType: "json",
		success: function(result) {
			alert(result);
			if (result.length > 0) {
			 var accountTableHTML = '<table>';
			$.each(response, function (firstName,lastName,email,role,action) {
				accountTableHTML +=  '<tr><td>' + firstName + '</td><td>' + lastName + '</td><td>' + email + '</td><td>' + role + '</td><td>' +action+ '</td></tr>';     
				 });
				accounntTableHTML += '</table>';
				 $("#accounts_table").html( accountTableHTML );
				 }
			},
        		error: function () { alert("Something went wrong..") },
	      		 });
	 });


	
	
	
	if($(".status").val()==="Active"){
		 $(".deletebtn").hide(); 
	}else{
		 $(".activatebtn").hide();
	}	  
	 
	$(".wrapper").on('click', '.activatebtn', function(){
	              
	       var el = $(this).closest('.inputFields');
	       el.find('.activatebtn').hide();
	       el.find('.deletebtn').show();
	 });
	 
	 $(".wrapper").on('click', '.deletebtn', function(){
	 
	       var el = $(this).closest('.inputFields');
	       el.find('.deletebtn').hide();
	       el.find('.activatebtn').show();
	   
	 });
	 
		 

		});


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
<h1 align="center"> View Account</h1>
	<div align="center">
	<font color="green">${delsucc}</font>

	<table><tr>
					<td>Role:</td>
					
						<td><select name="role" id="role">
   							 	<option value="">-select-</option>
    							<option value="Admin">Admin</option>
    							<option value="CaseWorker">CaseWorker</option>
      							</select></td>
						
						<td><a href="/admin/">Home</a></td>
				</tr></table>
    
	<div  id="account_table">
	<table border="1" >
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Role</th>
			<th>Action</th>
		</tr>
		
		<c:forEach var="account" items="${accountList}" > 
		<tr>
				<td>${account.firstName }</td>
				<td>${account.lastName }</td>
				<td>${account.email }</td>
				<td>${account.role }</td>
				<td colspan="2">
				<div class="status">"${account.status}"</div><div class="wrapper"><div class="form-group inputFields">
				
				<a href="editAccount?employeeId=${account.employeeId }" ><input type="image" alt="" src="/images/edit.gif"  width="48" height="48" ></a>|
<a href="deleteAccount?employeeId=${account.employeeId }" class="deletebtn"  onclick="return deleteConfirm()"><input type="image" src="/images/delete.gif" alt=""  width="48" height="48" class="fa fa-plus-circle fa-2x" aria-hidden="true"></a>
<a href="deleteAccount?employeeId=${account.employeeId }" class="activatebtn"  onclick="return activateConfirm()"><input type="image" src="/images/activate.gif" alt="" width="48" height="48" class="fa fa-plus-circle fa-2x" aria-hidden="true"></a>
				</div></div>
</td>
			</tr>
			</c:forEach>
			
	</table>
	</div>
	
</div>

</body>
</html>