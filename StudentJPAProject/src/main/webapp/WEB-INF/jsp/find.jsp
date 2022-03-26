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
   <h1>검색</h1>
   <div class="row">
     <table class="table">
       <tr>
        <td>
          Search:<input type=text size=15 class="input-sm" v-model="std_name">
          <button class="btn btn-sm btn-success" v-on:click="find()">검색</button>
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
    	el:'.container',
    	data:{
    		std_name:'',
    		std_list:[]
    	},
    	methods:{
    		// find_vue?fd=홍
    		find:function(){
    			axios.get('http://localhost:8080/find_vue',{
    				params:{
    					fd:this.std_name
    				}
    			}).then(res=>{
    				console.log(res.data)
    				this.std_list=res.data;
    			})
    		}
    	}
    })
  </script>
</body>
</html>



