<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DATA COLLECTION</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: Arial;
  align-content: center;
}

* {
  box-sizing: border-box;
  align-self: center;
}

form.search input[type=text] {
  padding: 10px;
  font-size: 17px;
  border: 1px solid grey;
  float: left;
  width: 80%;
  background: #f1f1f1;
}

form.search button {
  float: left;
  width: 20%;
  padding: 10px;
  background: #2196F3;
  color: white;
  font-size: 17px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
}

form.search button:hover {
  background: #0b7dda;
}

form.search::after {
  content: "";
  clear: both;
  display: table;
}
.test input {
    border: 0;
}
span {
        display: inline-block;
        width: 150px;
        text-align: left;
    }
</style>
</head>
<body>
<form action="search" method="get" class="search"  style="margin:auto;max-width:300px" >
<div align="center">
<h3 >${msg}</h3>
<input type="text" placeholder="Search.." id="search" name="appId"/>

  <button type="submit"  ><i class="fa fa-search"></i></button><br/><a href="/dc/">Home</a>
</div>
</form>

<div>

<c:choose> 
  <c:when test="${not empty caseDetail }">
  
   <div align="center">
   <form:form action="selectplan" method="post" modelAttribute="caseDetail">
        <h2>Create Case</h2>
        <span>Applicant Id:</span><span class="test"><form:input path="appId" value="${caseDetail.appId}"/></span><br/>
        <span>First Name:</span><span class="test"><form:input path="firstName" value="${caseDetail.firstName}"/></span><br/>
         <span>Last Name:</span><span class="test"><form:input path="lastName" value="${caseDetail.lastName}"/></span><br/>
        <span>Date of Birth:</span><span class="test"><form:input path="dob" value="${caseDetail.dob}"/></span><br/>   
        <span>Gender:</span><span class="test"><form:input path="gender" value="${caseDetail.gender}"/></span><br/>
        <span>SSN:</span><span class="test"><form:input path="ssn" value="${caseDetail.ssn}"/></span><br/>
        <span>Phone Number:</span><span class="test"><form:input path="phoneNo" value="${caseDetail.phoneNo}"/></span><br/>
        <span>Email:</span><span class="test"><form:input path="email" value="${caseDetail.email}"/></span><br/>
      
        <input type="submit" value="Create Case">
        </form:form>
    </div>
   
  
  </c:when>
  <c:otherwise>`	
  <div align="center"> <span >${failmsg }</span>
   </div>
  
  </c:otherwise>
</c:choose>
</div>
</body>
</html>