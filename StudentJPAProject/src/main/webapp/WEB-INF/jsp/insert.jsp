<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  width:500px;
}
h1{
  text-align: center;
}
</style>
</head>
<body>
  <div class="container">
    <h1>성적등록</h1>
    <div class="row">
     <form method=post action="/insert_ok">
      <table class="table">
        <tr>
          <td>이름</td>
          <td><input type=text name=name size=15 class="input-sm"></td>
        </tr>
        <tr>
          <td>국어</td>
          <td><input type=text name=kor size=15 class="input-sm"></td>
        </tr>
        <tr>
          <td>영어</td>
          <td><input type=text name=eng size=15 class="input-sm"></td>
        </tr>
        <tr>
          <td>수학</td>
          <td><input type=text name=math size=15 class="input-sm"></td>
        </tr>
        <tr>
          <td>
            <input type=submit value="등록" class="btn btn-sm btn-danger">
            <input type=button value="취소" class="btn btn-sm btn-danger"
             onclick="javascript:history.back()"
            >
          </td>
        </tr>
      </table>
      </form>
    </div>
  </div>
</body>
</html>