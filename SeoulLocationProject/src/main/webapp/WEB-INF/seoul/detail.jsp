<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
   <div class="container">
    <h1>${vo.name } 상세보기</h1>
    <div class="row">
      <table class="table">
       <tr>
        <td>
          <img src="${vo.poster }" width=100%>
        </td>
       </tr>
       <tr>
        <td>
          ${vo.address }
        </td>
       </tr>
       <tr>
        <td>
          ${vo.msg }
        </td>
       </tr>
       <tr>
         <td><a href="javascript:history.back()" class="btn btn-lg btn-primary">목록</a></td>
       </tr>
      </table>
    </div>
   </div>
</body>
</html>