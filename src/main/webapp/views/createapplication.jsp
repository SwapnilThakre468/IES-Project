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
	$("#ssnsplit").hide();
		});
		

</script>
<script type="text/javascript">
function splitSSN() {
	
	  var ssn = document.getElementById("ssnsplit").value;
	 
	 if(ssn!==""){
	 if(ssn.includes(",")){	
	   
	  var res = ssn.split(",");
	  
	  document.getElementById("1").value = res[0];
	  document.getElementById("2").value= res[1];
	  document.getElementById("3").value = res[2];
	  
	  
	 }else{
		  var charArray=ssn.split("");
		  ssn="";
		  for(var i=0;i<charArray.length;i++){
			  if(i==2 || i==4) {
					ssn=ssn+charArray[i];	
					ssn=ssn+",";
				}else {
				ssn=ssn+charArray[i];	
				}
	     }
		  var res = ssn.split(",");
		  
		  document.getElementById("1").value = res[0];
		  document.getElementById("2").value= res[1];
		  document.getElementById("3").value = res[2];  
	  }
	  
	}
	 
}
	</script>
	
	
	<script>
	function concatSSN() {
	
	  var area=document.getElementById("1").value ;   
	  var group=document.getElementById("2").value ;
	  var sequence=document.getElementById("3").value; 
	  var ssn =( area.concat(",")).concat((group.concat(",")).concat(sequence));
	 
	 document.getElementById("ssnsplit").value=ssn;
	
	}
	</script>
		<script>
	function Valid1(tb,count) {
	  var n=tb.value.length;
	  if(n===3){
	  document.getElementById(count).focus();
	  }
	}
	</script>
	<script>
	function Valid2(tb,count) {
		  var n=tb.value.length;
		  if(n===2){
		  document.getElementById(count).focus();
		  }
		}
	</script>
  
		

		

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

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
  <script>function formload(){
	  splitSSN()
	  mydate()
  }</script>
</head>
<body onload="formload()"  >
<div align="center">
		<h3>Application Registration</h3>
		<font color='red'>${failMsg}</font> <font color='green'>${succMsg}</font>
		<form:form action="saveApplication" method="post" modelAttribute="application">
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
					<td>Date of Birth:</td>
					<td><form:input    path="dob" id="datepicker"   /></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><form:radiobutton path="gender" value="male" />Male <form:radiobutton
							path="gender" value="female" />Female</td>
				</tr>
				<tr>
					<td>SSN:</td>
					<td>
					<form:input path="ssn" id="ssnsplit"   />
					<input type="text" id="1"  onkeyup="Valid1(this,2)" maxlength="3" />
					<input type="text" id="2"   onkeyup="Valid2(this,3)" maxlength="2" />
					<input type="text" id="3"    maxlength="4" onblur="concatSSN()" />
					</td></tr>
				
                <tr>
					<td>Phone Number:</td>
					<td><form:input path="phoneNo"  onfocus="mydate()"/></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" id="email"/>
					<font color='red'><span id="errMsg"></span></font></td>
				</tr>
	
				<tr>
					<td><a href="/ar/">Home</a></td>
					<td><input type="submit" value="Register" id="registerBtn"   ></td>
				</tr>
				

			</table>
			
		</form:form>
	</div>

</body>

</body>
</html>
	
