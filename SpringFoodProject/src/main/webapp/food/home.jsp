<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
     tag => 제어문 
            <c:forEach> = for
            <c:if> = if
            <c:choose> = switch 
              <c:when></c:when>
              <c:when></c:when>
            </c:choose>
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="container">
    <h1>믿고보는 맛집 리스트</h1>
    <hr>
    <div class="row">
      <c:forEach var="vo" items="${list }" varStatus="s">
        <c:if test="${s.index>=0 && s.index<12 }">
          <div class="col-md-3">
		    <div class="thumbnail">
		      <a href="#">
		        <img src="${vo.poster }" title="${vo.subject }" style="width:100%">
		        <div class="caption">
		          <p style="font-size:8px">${vo.title }</p>
		        </div>
		      </a>
		    </div>
		  </div>
        </c:if>
      </c:forEach>
    </div>
    
    <h1>지역별 인기 맛집</h1>
    <hr>
    <div class="row">
      <c:forEach var="vo" items="${list }" varStatus="s">
        <c:if test="${s.index>=12 && s.index<18 }">
          <div class="col-md-4">
		    <div class="thumbnail">
		      <a href="#">
		        <img src="${vo.poster }" title="${vo.subject }" style="width:100%">
		        <div class="caption">
		          <p style="font-size:8px">${vo.title }</p>
		        </div>
		      </a>
		    </div>
		  </div>
        </c:if>
      </c:forEach>
    </div>
    
    <h1>메뉴별 인기 맛집</h1>
    <hr>
    <div class="row">
      <c:forEach var="vo" items="${list }" varStatus="s">
        <c:if test="${s.index>=18 && s.index<30 }">
          <div class="col-md-3">
		    <div class="thumbnail">
		      <a href="#">
		        <img src="${vo.poster }" title="${vo.subject }" style="width:100%">
		        <div class="caption">
		          <p style="font-size:8px">${vo.title }</p>
		        </div>
		      </a>
		    </div>
		  </div>
        </c:if>
      </c:forEach>
    </div>
  </div>
</body>
</html>








