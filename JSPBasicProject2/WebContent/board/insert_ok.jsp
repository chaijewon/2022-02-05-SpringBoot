<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.it.model.*"%>
<jsp:useBean id="model" class="com.it.model.BoardModel"/>
<%
     request.setCharacterEncoding("UTF-8");// 한글 디코딩 
%>
<jsp:useBean id="vo" class="com.it.dao.BoardVO"><%--vo메모리 할당  --%>
  <jsp:setProperty name="vo" property="*"/><%-- setter에 사용자가 보내준 값을 채운다 --%>
</jsp:useBean>
<%--
      insert.jsp
      String name=request.getParaemeter("name");
      String subject=request.getParaemeter("subject");
      String content=request.getParaemeter("content");
      String pwd=request.getParaemeter("pwd");
      BoardVO vo=new BoardVO();
      vo.setName(name);
      vo.setSubject(subject);
      vo.setContent(content);
      vo.setPwd(pwd)
      model.boardInsert(vo,response)
 --%>
<%
    model.boardInsert(vo, response);
%>