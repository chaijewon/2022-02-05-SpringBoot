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
  <h2>서울 명소</h2>
  <div class="row">
    <c:forEach var="vo" items="${list }">
	    <div class="col-md-3">
	      <div class="thumbnail">
	        <a href="detail.do?no=${vo.no }"><!-- @Controller -->
	          <img src="${vo.poster }" alt="Lights" style="width:100%">
	          <div class="caption">
	            <p>${vo.name }</p>
	          </div>
	        </a>
	      </div>
	     </div>
      </c:forEach>
  </div>
  <div class="row">
    <div class="text-center">
      <a href="list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-danger">이전</a>
      ${curpage } page / ${totalpage } pages
      <a href="list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-primary">다음</a>
    </div>
  </div>
</div>
</body>
</html>