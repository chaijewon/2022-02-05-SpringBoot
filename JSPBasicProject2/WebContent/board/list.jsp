<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.it.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="model" class="com.it.model.BoardModel"/>
<%-- 메모리 할당 
     <jsp:include> : 조립식 프로그램 => JSP안에 특정부분에 다른 JSP를 추가할 수 있게 만든다 
     <jsp:useBean> : 클래스 메모리 할당 
       => BoardModel model=new BoardModel()
       => 자바를 제거 => 제공하는 태그를 사용한다 
 --%>
 <%
     model.boardListData(request);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>자유 게시판</h1>
   <div class="row">
     <%-- 출력 위치 --%>
     <table class="table">
       <tr>
         <td>
          <a href="../main/main.jsp?mode=6" class="btn btn-sm btn-success">새글</a>
         </td>
       </tr>
     </table>
     <table class="table table-striped">
       <tr class="danger">
         <th class="text-center" width=10%>번호</th>
         <th class="text-center" width=45%>제목</th>
         <th class="text-center" width=15%>이름</th>
         <th class="text-center" width=20%>작성일</th>
         <th class="text-center" width=10%>조회수</th>
       </tr>
       <%-- 데이터 출력 --%>
       <%--
           for(BoardVO vo:list)
           {
           }
        --%>
       <c:forEach var="vo" items="${list }">
        <tr>
         <td class="text-center" width=10%>${vo.no }</td>
         <%-- vo.no = vo.getNo() --%>
         <td width=45%>${vo.subject }</td>
         <td class="text-center" width=15%>${vo.name }</td>
         <td class="text-center" width=20%>${vo.dbday }</td>
         <td class="text-center" width=10%>${vo.hit }</td>
        </tr>
       </c:forEach>
     </table>
   </div>
</body>




</html>