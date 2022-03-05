<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.it.model.*"%>
<%
    BoardModel model=new BoardModel();
    // <jsp:useBean id="model" class="BoardModel">
    model.boardDetailData(request); // vo가 담겨 있다
    //  request.setAttribute("vo", vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row{
   margin: 0px auto;
   width:700px;
}
</style>
</head>
<body>
  <h1>내용보기</h1>
  <div class="row">
    <table class="table">
      <tr>
        <th class="text-center" width=20%>번호</th>
        <td class="text-center" width=30%>${vo.getNo() }</td>
        <th class="text-center" width=20%>작성일</th>
        <td class="text-center" width=30%>${vo.dbday }</td>
      </tr>
      <tr>
        <th class="text-center" width=20%>이름</th>
        <td class="text-center" width=30%>${vo.name }</td>
        <th class="text-center" width=20%>조회수</th>
        <td class="text-center" width=30%>${vo.hit }</td>
      </tr>
      <tr>
        <th class="text-center" width=20%>제목</th>
        <td colspan="3">${vo.subject }</td>
      </tr>
      <tr>
        <td colspan="4" class="text-left" valign="top" height="200">
         <pre style="white-space: pre-wrap;background-color:white;border:none">${vo.content }</pre>
        </td>
      </tr>
      <tr>
        <td colspan="4" class="text-right">
          <a href="#" class="btn btn-xs btn-danger">수정</a>
          <a href="#" class="btn btn-xs btn-success">삭제</a>
          <a href="../main/main.jsp?mode=5" class="btn btn-xs btn-info">목록</a>
        </td>
      </tr>
    </table>
  </div>
</body>
</html>