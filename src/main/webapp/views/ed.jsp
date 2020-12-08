<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<form action="determineElig" method="post" class="search"  style="margin:auto;max-width:300px" >
<div align="center">
<h3 >${msg}</h3>
<input type="text" placeholder="Search.." id="search" name="caseId"/>

  <button type="submit"  ><i class="fa fa-search"></i></button><br/><a href="/dc/">Home</a>
</div>
</form>
</body>
</html>