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
         <td>
           <c:forEach var="vo" items="${list }">
             <table class="table">
               <tr>
                 <td width=30% rowspan="4">
                   <a href="/food_detail?no=${vo.no }"><img src="${vo.poster }" style="width:240px;height: 200px"></a>
                 </td>
                 <td width=70%><a href="/food_detail?no=${vo.no }">${vo.name }</a></td>
               </tr>
               <tr>
                 <td>${vo.address }</td>
               </tr>
               <tr>
                 <td>${vo.tel }</td>
               </tr>
               <tr>
                 <td>${vo.type }</td>
               </tr>
             </table>
           </c:forEach>
         </td>
       </tr>
     </table>
   </div>
  </div>
</body>
</html>





