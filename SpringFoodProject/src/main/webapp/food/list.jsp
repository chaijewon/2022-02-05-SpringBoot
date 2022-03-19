<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="container">
    <div class="jumbotron">
      <h3 class="text-center">${vo.title }</h3>
      <h4 class="text-center">${vo.subject }</h4>
    </div>
    <div class="row">
     <c:forEach var="fvo" items="${list }">
       <table class="table">
         <tr>
           <td class="text-center" width=30% rowspan="4">
            <a href="detail.do?no=${fvo.no }"><img src="${fvo.poster }" style="width:320px;height: 200px"></a>
           </td>
           <td width=70%>
             <h3><a href="detail.do?no=${fvo.no }">${fvo.name }</a>&nbsp;<span style="color:orange">${fvo.score }</span></h3>
           </td>
         </tr>
         <tr>
           <td width=70%>${fvo.address }</td>
         </tr>
         <tr>
           <td width=70%>전화)${fvo.tel }</td>
         </tr>
         <tr>
           <td width=70%>음식종류)${fvo.type }</td>
         </tr>
       </table>
     </c:forEach>
    </div>
  </div>
</body>
</html>