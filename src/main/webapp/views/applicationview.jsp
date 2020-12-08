<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apllication Registration</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$(".status").hide();
	
	 
		});


</script>


<script>function buttonReplace(){
	if($(".status").val()==="Active"){
		
		
		$(".activatebtn").hide();
		$(".deletebtn").show();
	}else{
		$(".deletebtn").hide();
		$(".activatebtn").show();
	}
	
 $(".wrapper").on('click', '.activatebtn', function(){
         
         var el = $(this);
        el.('.activatebtn').hide();
         el.('.deletebtn').show();
   });
   
   $(".wrapper").on('click', '.deletebtn', function(){
   
         var el = $(this);
         el.('.deletebtn').hide();
         el.('.activatebtn').show();
     
   });
}</script>
<script type="text/javascript">
function changeDiv(){
	  /*  if($(".status").val()==="Inactive"){
		   return deleteConfirm()
	  
		   $("#activatebutton").hide();
	       $("#deletebutton").show();
	      
	   }else{
		  
			   return activateConfirm()
		   
			   $("#deletebutton").hide();
			   $("#activatebutton").show();
		
	   } */
	   }
function activateConfirm(){
	return confirm("Are you sure,do you want to Activate?");
}
function deleteConfirm(){
	return confirm("Are you sure,do you want to Delete?");
}

</script>
</head>
<body onload="changeDiv()">
<h1 align="center"> View Application</h1>
	<div align="center">
	<font color="green">${delsucc}</font>

	
    <a href="/ar/">Home</a>
	<div  align="center">
	<table border="1"  id="Application_table">
		<tr>
			<th>Application No</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Date of Birth</th>
			<th>SSN</th>
			<th>Action</th>
		</tr>
		
		<c:forEach var="application" items="${applicationList}" > 
		<tr>
				<td>${application.appId }</td>
				<td>${application.firstName }</td>
				<td>${application.lastName }</td>
				<td >${application.dob }</td>
				<td>${application.ssn }</td>
				<td colspan="2" oninput="buttonReplace()">
				<div class="status" >"${application.status}"</div>
				<div class="wrapper"><div class="form-group inputFields">
				
				<a href="editApplication?appId=${application.appId }" ><input type="image"  src="/images/edit.gif"  width="48" height="48" ></a>
<a href="deleteApplication?appId=${application.appId}" class="deletebtn"  onclick="return deleteConfirm()"><input type="image" src="/images/delete.gif"   width="48" height="48" class="fa fa-plus-circle fa-2x" aria-hidden="true"></a>
<a href="deleteApplication?appId=${application.appId }" class="activatebtn"  onclick="return activateConfirm()"><input type="image" src="/images/activate.gif"  width="48" height="48" class="fa fa-plus-circle fa-2x" aria-hidden="true"></a>
			</div>	</div>
			
	<%-- 		
			<div id="deletebutton"><a href="editApplication?appId=${application.appId }" ><input type="image"  src="/images/edit.gif"  width="48" height="48" ></a>
<a href="deleteApplication?appId=${application.appId}" class="deletebtn"  onclick="changeDiv(1)"><input type="image" src="/images/delete.gif"   width="48" height="48"  >
</a></div>
			
	<div id="activatebutton"><a href="editApplication?appId=${application.appId }" ><input type="image"  src="/images/edit.gif"  width="48" height="48" ></a>
<a href="deleteApplication?appId=${application.appId }" class="activatebtn"  onclick="changeDiv(2)"><input type="image" src="/images/activate.gif"  width="48" height="48"  >
</a></div>		 --%>
			
</td>
			</tr>
			</c:forEach>
			
	</table>
	</div>
	
</div>
</body>
</html>