<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px
}
.row{
  margin: 0px auto;
  width:800px;
}
h1{
  text-align: center;
}
</style>
</head>
<body>
  <div class="container">
   <div class="row">
     <table class="table">
      <tr>
       <c:forTokens items="${vo.poster }" delims="^" var="img">
         <td><img src="${img }" width=100%></td>
       </c:forTokens>
      </tr>
     </table>
     <table class="table">
       <tr>
        <th width=15%>주소</th>
        <td width=85%>${vo.address }</td>
       </tr>
       <tr>
        <th width=15%>전화</th>
        <td width=85%>${vo.tel }</td>
       </tr>
       <tr>
        <th width=15%>음식종류</th>
        <td width=85%>${vo.type }</td>
       </tr>
       <tr>
        <th width=15%>영업시간</th>
        <td width=85%>${vo.time }</td>
       </tr>
       <tr>
        <th width=15%>가격대</th>
        <td width=85%>${vo.price }</td>
       </tr>
       <tr>
        <th width=15%>주차</th>
        <td width=85%>${vo.parking }</td>
       </tr>
       <tr>
        <th width=15%>메뉴</th>
        <td width=85%>${vo.menu }</td>
       </tr>
     </table>
   </div>
  </div>
</body>
</html>


