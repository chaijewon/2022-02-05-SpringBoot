<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
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
    <h1>성적 관리</h1>
    <div class="row">
      <table class="table">
       <tr>
        <td>
          <a href="/insert" class="btn btn-sm btn-danger">추가</a>
          <a href="/find" class="btn btn-sm btn-primary">검색</a>
        </td>
       </tr>
      </table>
      <table class="table">
        <tr>
          <th class="text-center">학번</th>
          <th class="text-center">이름</th>
          <th class="text-center">국어</th>
          <th class="text-center">영어</th>
          <th class="text-center">수학</th>
        </tr>
        <tr v-for="vo in std_list">
          <td class="text-center">{{vo.hakbun}}</td>
          <td class="text-center">{{vo.name}}</td>
          <td class="text-center">{{vo.kor}}</td>
          <td class="text-center">{{vo.eng}}</td>
          <td class="text-center">{{vo.math}}</td>
        </tr>
      </table>
    </div>
   </div>
   <script>
     new Vue({
    	 el:'.container', // class: . , id:#
    	 data:{
    		 std_list:[]
    	 },
    	 mounted:function(){
    		 axios.get("http://localhost:8080/list_vue")
    		 .then(res=>{
    			 console.log(res.data)
    			 this.std_list=res.data;
    		 })
    	 }
     })
   </script>
</body>
</html>