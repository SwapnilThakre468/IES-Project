<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IES</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript">
$(document).ready(function(){
    $("#start").datepicker({ dateFormat: 'dd/mm/yy',
        numberOfMonths: 1,
        onSelect: function(selected) {
          $("#end").datepicker("option","minDate", selected)
        }
    });
    $("#end").datepicker({ dateFormat: 'dd/mm/yy',
        numberOfMonths: 1,
        onSelect: function(selected) {
           $("#start").datepicker("option","maxDate", selected)
        }
    });  
});
  </script>
  <script type="text/javascript">
 function mystartdate() {
	 var str=$( "#start").val();
	 if(str!==""){
		 if(str.includes("/")){
			
			 
		 }else{
			 
			 var d =new Date( str);
			 document.getElementById("start").value =d.getDate()+"/"+(d.getMonth()+1)+"/"+d.getFullYear();	 
			 
		 }
		 
       }
	 
	  } 
  </script><script type="text/javascript">
 function myenddate() {
	 var str=$( "#end").val();
	 if(str!==""){
		 if(str.includes("/")){
			
			 
		 }else{
			 
			 var d =new Date( str);
			 document.getElementById("end").value =d.getDate()+"/"+(d.getMonth()+1)+"/"+d.getFullYear();	 
			 
		 }
		 
       }
	 
	  } 
  </script>
  <script>
  function dateload(){
	  mystartdate()
	  myenddate()
  }
  
  </script>
</head>
<body  onload="dateload()">
<div align="center">
		<h3>Plan Creation</h3>
		<font color='red'>${failMsg}</font> <font color='green'>${succMsg}</font>
		<form:form action="savePlan" method="post" modelAttribute="plan">
			<table>
				<tr>
					<td>Plan Name:</td>
					<td><form:input path="planName" /></td>
				</tr>
				<tr>
					<td>Plan Description:</td>
					<td><form:input path="planDescrp" /></td>
				</tr>

				
				<tr>
					<td>Start Date:</td>
					<td><form:input   path="startDate" id="start" /></td>
				</tr>
				<tr>
					<td>End Date:</td>
					<td><form:input   path="endDate" id="end"/></td>
				</tr>
				
				<tr>
					<td><a href="/admin/">Home</a></td>
					<td><input type="submit" value="Register"  onclick="dateload()"></td>
				</tr>


			</table>
		</form:form>
	</div>

</body>
</html>