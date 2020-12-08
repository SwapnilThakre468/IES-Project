<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IES</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	 $("#hiddeninput").hide();
	 $("#email").blur(function(){
	 	  $("#errMsg").text("");
	 	  
	 	  $.ajax({
				type : "GET",
				url : "uniqueMailCheck?email="+$("#email").val() ,
				success : function(data) {
					if (data == "duplicate") {
						$("#errMsg").text("Duplicate Email");
						$("#registerBtn").prop("disabled", true);
					    } else {
						$("#registerBtn").prop("disabled", false);
					    }
				}
		});
	    });
});
</script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript">
$( function() {
   
    $('#datepicker').datepicker({ dateFormat: 'dd/mm/yy' });
  } );
  </script>
  <script type="text/javascript">
 function mydate() {
	 var str=$( "#datepicker").val();
	 if(str!==""){
		 if(str.includes("/")){
			
			 
		 }else{
			 
			 var d =new Date( str);
			 document.getElementById("datepicker").value =d.getDate()+"/"+(d.getMonth()+1)+"/"+d.getFullYear();	 
			 
		 }
		 
       }
	 
	  } 
  </script>
<!--   <script>
  function dropdownval(){
	 var str= $("#role option:selected").val();
	 
	 document.getElementById("dropdown").value=str;
	  alert(document.getElementById("dropdown").value+"swap");
	  
  }
  </script>
  <script>
  function loaddropdown(){
	 
	  var dropvalue=document.getElementById("dropdown").value;
	  var str= $("#role option:selected").text();
	  alert( dropvalue);
	  $('select[name^="role"] option[value="-select-"]').attr("selected",null); 
			  $('select[name^="role"] option[value=dropvalue]').attr("selected","selected");	  
  }
  
  </script> -->
  <script type="text/javascript">
  function loadformdata(){
	  mydate()
	 
	  
  }
  </script>
</head>
<body  onload="loadformdata()">
<div align="center">
		<h3>Account Creation</h3>
		<font color='red'>${failMsg}</font> <font color='green'>${succMsg}</font>
		<form:form action="saveAccount"  id="f1" method="post" modelAttribute="account">
			<table>
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName" /></td>
				</tr>

				<tr>
					<td>Email:</td>
					<td><form:input path="email" id="email"/>
					<font color='red'><span id="errMsg"></span></font></td>
				</tr>
				<tr>
					<td>Phone Number:</td>
					<td><form:input path="phoneNo" /></td>
				</tr>
				<tr>
					<td>Date of Birth:</td>
					<td><form:input   path="dob" id="datepicker" /></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><form:radiobutton path="gender" value="male" />Male <form:radiobutton
							path="gender" value="female" />Female</td>
				</tr>
				<tr>
					<td>SSN:</td>
					<td><form:input path="ssn"  onfocus="mydate()"/>
				</tr>
				<tr>
					<td>Role:</td>
					<td><form:select path="role" id="role"  name="role">
							<form:option  path="role" value="-1">-select-</form:option>
							<form:options items="${roleList}"/>
							
						</form:select></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input path="password" />
				</tr>
				
				
				
				<tr>
					<td><a href="/admin/">Home</a></td>
					<td><input type="submit" value="Register" id="registerBtn"  ></td>
				</tr>
			</table>
		</form:form>
		
	</div>

</body>
</html>