<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
  <h2>서울 호텔</h2>
  <div class="row">
    <c:forEach var="vo" items="${list }">
	    <div class="col-md-3">
	      <div class="thumbnail">
	        <a href="#"><!-- @Controller -->
	          <img src="${vo.poster }" alt="Lights" style="width:100%">
	          <div class="caption">
	            <p>${vo.name }<span style="color:orange">${vo.score }</span></p>
	          </div>
	        </a>
	      </div>
	     </div>
      </c:forEach>
  </div>
  </div>

</body>
</html>