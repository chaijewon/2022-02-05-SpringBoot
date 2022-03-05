<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
      1. JSP 기초  : model1  JSP <===> JSP (자바+HTML) => 재사용 , 확장성(X)
                           자바 / HTML 분리 => MVC (model2) => 라이브러리화 (Spring Framework)
               => XML , Annotation 
               => JDBC => MyBatis
          JSP(View) : 화면 출력 => 자바파일을 제거 
               => 처리(자바) , 화면 출력(JSP)
                  Model       View 
                  ----------------------- 연결  (Controller)  => MVC
               => MV => MVC 
               => Spring Framework(설정파일) => 4버전 , 5버전 (자바)
                  Spring Boot (설정파일 => 자동처리) => 서버역할 , 클라이언트(Front-End)
               => JDBC => DBCP => ORM(MyBatis , Hibernate , JPA)
                                     ---------              ----
       2. JSP 화면 출력  => <% %> , <%= %> , <%! %> 제거 => 자바가 없는 프로그램 
                         조건문 , 반복문  => 태그형으로 만들다 (Front-End)
              <%
                  for()
                  {
              %>
                      HTML
              <%
                  }
              %> 
              
              <c:forEach> => JSTL 
                 HTML
              </c:forEach>
              <%= %> =======> ${} (EL)
              
          2-1. 내장객체 (미리 선언된 객체) => 
               ***request 
               HttpServletRequest
                  = 역할 
                    = 서버정보 , 브라우저 정보 
                    http://localhost:8080 /JSPBasicProject2/jsp/basic1.jsp
                    --------------------- ---------------------------------
                                                  서버 정보                        사용자 요청 정보 
                     1) 서버정보 + 사용자 요청정보 => URL
                        getRequestURL()
                     2) 사용자 요청정보 => URI
                        *****getRequestURI()
                     3) 서버 IP 
                        getServerInfo()
                                            서버 PORT
                        getServerPort()
                        /JSPBasicProject2 => *****getContextPath()
                        getMethod() => 데이터전송방식 => GET/POST
                        
                        *** getRemoteAddr() : 클라이언트의 IP
                    = 요청 정보 
                                         사용자가 전송한 데이터 받기
                       => ****String getParameter() => URL?키=값
                            <input type=text,password,radio>
                            <textarea> , <select>
                          basic.jsp?id=admin&pwd=1234
                                    --       ---
                          String id=request.getParameter("id")
                                                          ---
                          String pwd=request.getParameter("pwd")
                                                           ----
                          basic.jsp?hobby=운동&hobby=낚시&hobby=등산
                       => **String[] getParameterValues() => checkbox,select
                          String[] hobby=request.getParamterValues("hobby")
                       => setCharacterEncoding("UTF-8") => 한글 
                          https://www.google.com/search?q=%EC%9E%90%EB%B0%94&oq=%EC%9E%90%EB%B0%94&aqs=chrome..69i57j0i433i512l2j0i512l3j0i433i512j0i512l3.860j0j15&sourceid=chrome&ie=UTF-8
                           자바  =>   %EC%9E%90%EB%B0%94 => byte[] 변환 (Encoding)
               %EC%9E%90%EB%B0%94 => 자바 (Decoding)  
                           한글(2byte) => 브라우저 (네트워크 전송) => 1byte(ASC)
                           POST방식 처리   setCharacterEncoding("UTF-8")
                           GET방식 처리   server.xml(등록) => window10
                                      요청(request)
               USER  =============== Server 
                                     request에 결과값을 담아서 재전송 
                        request
                        setAttribute() , getAttribute() 
                
               ***response : 응답 (HTML,Cookie) => 한개의 JSP에서 한번만 전송이 가능
                    addCookie() , sendRedirect() , setHeader()
                                      쿠키 전송             화면 이동                   결과값 전송전 보내는 데이터가 있는 경우
                                                    => 다운로드  
               ***session VC Cookie 
                                서버에 저장      클라이언트 브라우저에 저장 
                  session메소드 (공유)
                    저장 : setAttribute()
                    읽기 : getAttribute()
                    일부 삭제 : removeAttribute() => 장바구니 , 찜 ...
                    기간(저장) : setMaxInactiveInterval() => 30분 (초단위) 60*60*24
                    전체 삭제 : invalidate() => 로그아웃 
                  cookie메소드 : 최신방문 
                     저장 : new Cookie(키 , 값)
                     읽기 : getCookies()
                     삭제 : setMaxAge(0)
                     기간 : setMaxAge(60*60*24)
                     전체 삭제  : setMaxAge(0)
               ***application: ServletContext
                                서버 정보,로그정보,자원정보 
                         log()   getRealPath() 
               out : 출력정보 => <%= %> , ${} , out.println()
               JspWriter
               
               exception:예외처리 (X) => Exception
               config:환경 설정 => web.xml (ServletConfig)
               pageContext :PageContext => 내장객체를 얻어온다 (X)
                            include() , forward()
                                                      조립식          화면이동 => request를 전송 => MVC
               page:this(Object)
          2-2. JSTL(태그라이브러)
               <%@ taglib prefix="c" uri=""> => <c:~>
                   ------
                   core : 변수설정 , 제어문 , 화면 이동 
                          <c:set> 변수 설정 
                          <c:if> : 조건문 (else가 없다)
                          <c:choose> : 다중 조건문 
                          <c:forEach> : 반복문 
                          <c:forTokens> : StringTokenizer
                   fmt : 변환 (숫자,날짜) 
                          <fmt:formatDate> , <fmt:formatNumber>
                   fn : String메소드 사용 
                          fn:substring() , fn:trim()....
                   -----
                   xml : 자바
                   sql : MyBatis
                   -----
          2-3. EL : 화면에 데이터 출력  <%= %>
               ${데이터출력}
                 --------
                 1) 연산자 
                      => 산술연산자 (+ , - , * , / , %)
                              + : 순수하게 산술만 사용   "10"+"a" ==> 10a => 에러 
                                                      문자열 결합(+=) ${"10"+= "a"}
                              ${"10"+"20"} => 30 
                              ${null+10} = 10
                                ---- 0값으로 취급 
                              / => 정수/정수=실수 => 5/2(2) , ${5/2} => 2.5
                              % => ${ 5%2} , ${5 mod 2} 
                              / => ${5/2} , ${5 div 2}
                      => 비교연산자 (== , != , < , > ,<= ,>=) ==> true/false
                                   eq   ne  lt  gt  le ge
                                   ${10 eq 10} ${10==10}
                                   ${"hello"=="hello"} ${"hello" eq "hello"}
                                   = (데이터베이스), == (프로그램), ===(자바스크립트)
                      => 논리연산자 ( && , || )
                                   and  or
                      => 삼항연산자 : (조건)?값1:값2
                      --------------------- 자바 , 자바스크립트 => 화면 출력 , 조건문 
                 2) 데이터출력 
                    => ${변수} => 일반 변수가 아니다 
                         --- request변수 , session변수 , application변수 
                       ${requestScope.id(키)} => <%= request.getAttribute("id")%>
                         ------------보통 생략이 가능 
                       ${sessionScope.id} => <%= session.getAttribute("id")%>
                       ${applicationScope.id} => <%= application.getAttribute("id")%>
          2-4. XML사용법 
          2-5. MyBatis연결 
          ---------------- MVC 처리 
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>