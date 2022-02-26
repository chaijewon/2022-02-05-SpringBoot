<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*,com.it.dao.*"%>
<%--
      JSP = Java+HTML
            Java : 데이터 읽기 (MySQL,Web크롤링(날씨))  
            HTML : 읽어온 데이터를 브라우저에 출력 
                                  브라우저에서 인식(HTML,XML)
                                  자바와 HTML의 분리 
      1. 지시자 
         page : jsp에 대한 정보 (파일 한개에 대한 정보)
                1) 변환 (응답 타입) => 브라우저로 전송할때 파일 형식 지정 
                   HTML / XML / JSON => {키:값,키:값....} = 자바스크립트의 객체 형식 
                                ------ 파싱 쉽고 호환성이 좋다 
                   contentType="text/html;charset=EUC-KR" => UTF-8
                   contentType="text/xml;charset=EUC-KR"
                   contentType="text/plain;charset=EUC-KR"
                2) 자바라이브러리 추가 
                   <%@ page import="java.util.*,java.io.*"%>
                   <%@ page import="java.util.*"%>
                   <%@ page import="java.io.*"%>
                3) 에러페이지 출력 
                   <%@ page errorPage="이동할 페이지"%>
                4) 출력버퍼 => 8kb => 16kb buffer
         taglib : 태그로 자바 라이브러리를 제작 
                  <%
                      if(조건문)
                      {
                  %>
                          HTML
                  <%    }
                      else
                      {
                  %>
                          HTML
                  <%    }
                  %>
                  
                  <c:if test="">
                    HTML
                  </c:if>
                  <c:if test="">
                    HTML
                  </c:if>
         include : JSP안에 다른 JSP를 추가 => 조립식 
      2. 스크립트 
                 자바 코딩
            = 스크립트릿 : 일반 자바 소스 => 변수선언 , 메소드 호출 , 제어문 , 연산처리
                        <%
                            int a=10.... 
                                                  문법 자바와 동일   ; 
                            //
                            /* */ 
                        %> 
            = 선언식 : 메소드 , 멤버변수  
                        <%!
                        
                        %> ====> 사용빈도가 없다 
            = 표현식 : System.out.println()
                     <%= %>
                     
             a.jsp 
             ------
             public class a_jsp extends HttpServlet
             {
                <%! %>
                public void _jspInit()
                {
                    web.xml에 설정된 내용을 읽어 온다 
                }
                public void _jspDestory()
                {
                    System.gc() ==> 새로고침 , 화면이동 
                }
                public void _jspService()
                {
                    ==> JSP 
                    <% %>
                    <%= %>
                }
             }
      3. 내장객체
      4. 액션태그 
      5. EL (표현식)
      6. JSTL (태그라이브러리) 
      7. MVC 
 --%>
<%
    String strPage=request.getParameter("page");
    // 첫페이지는 사용자가 선택할 수 없다 
    // 디폴트 페이지 만들기 
    if(strPage==null)
    	strPage="1";
    
    // 현재 페이지 설정 
    int curpage=Integer.parseInt(strPage); // 정수형으로 변환 
    // 현재 페이지에 해당되는 데이터를 받는다 
    SeoulDAO dao=SeoulDAO.newInstance();
    ArrayList<SeoulLocationVO> list=dao.seoulLocationData(curpage);
    // 총페이지 받기 
    int totalpage=dao.locationTotalPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top: 50px;
  /* 
     height: 1000px;
     border:1px solid red; 
     ctrl+shift+/ ctrl+shift+\
  */
}
.row{
   margin: 0px auto;
   width:1024px;
}
h1 {
   text-align: center
}
</style>
</head>
<body>
   <div class="container">
     <h1>서울 명소</h1>
     <hr>
     <div class="row">
       <%
           for(SeoulLocationVO vo:list)
           {
        %>
               <div class="col-md-4">
			    <div class="thumbnail">
			      <a href="#">
			        <img src="<%=vo.getPoster() %>" alt="Lights" style="width:310px;height:250px">
			        <div class="caption">
			          <p><%=vo.getTitle() %></p>
			        </div>
			      </a>
			    </div>
			  </div>
        <%
           }
        %>
     </div>
     <div class="row">
       <div class="text-center">
         <a href="basic1.jsp?page=<%=curpage>1?curpage-1:curpage %>" class="btn btn-sm btn-danger">이전</a>
         <%=curpage %> page / <%=totalpage %> pages
         <a href="basic1.jsp?page=<%=curpage<totalpage?curpage+1:curpage %>" class="btn btn-sm btn-danger">다음</a>
       </div>
     </div>
   </div>
</body>
</html>









