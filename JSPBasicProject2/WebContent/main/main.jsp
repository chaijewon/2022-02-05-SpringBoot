<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
     // 화면 변경 
     String mode=request.getParameter("mode");
     if(mode==null)
     {
    	 mode="1";
     }
     int index=Integer.parseInt(mode);
     String jsp="";
     switch(index)
     {
     case 1:
    	 jsp="../main/home.jsp";
    	 break;
     case 2:
    	 jsp="../seoul/location.jsp";
    	 break;
     case 3:
    	 jsp="../seoul/nature.jsp";
    	 break;
     case 4:
    	 jsp="../seoul/hotel.jsp";
    	 break;
     case 5:
    	 jsp="../board/list.jsp";
    	 break;
     case 6:
    	 jsp="../board/insert.jsp";
    	 break;
     }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.row{
   margin: 0px auto;
   width:100%;
}
h1{
    text-align: center
}
</style>
</head>
<body>
  <jsp:include page="../main/header.jsp"></jsp:include>
  <div class="container">
    <jsp:include page="<%=jsp %>"></jsp:include>
  </div>
</body>
</html>



