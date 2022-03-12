package com.it.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 *   생명주기 (서블릿) => Servlet (Server+let) => let(가벼운 프로그램)
 *                    Applet (사장) , MIDlet (Kotlin)
 *                    = 서버에서 실행되는 가벼운 프로그램 
 *                    2000년 ==> 2003 ~~ JSP 
 *                    최근 : 보안,자바만 코딩(서블릿) , 화면 출력 (JSP)
 *                                                ------------- RestFul 
 *                                                 HTML => VueJS,ReactJS
 *         1. 메모리 할당 : new Controller() => 톰캣에 의해 처리 
 *         2. init() : web.xml(톰캣에 프로그램에 필요한 데이터를 전송)
 *                     멤버변수에 대한 초기화
 *         ---------------------------------------------------
 *         3. Thread 작동 : 사용자가 요청시마다 호출되는 메소드 
 *            while(true) => 프로그램 종료시 (브라우저)
 *            {
 *                service() => GET / POST => 요청을 받아서 해당 JSP로 request를 전송 
 *                ----------
 *                |        |
 *              doGet    doPost   => service = doGet+doPost
 *                GET : 폼 , 단순한 검색어  ==> 데이터 전송 방식 => URL?변수=값....
 *                  HTML : <a href=""> 
 *                  JavaScript: location.href=""
 *                  sndRedirect()
 *                  <form => method="GET/POST"> ajax => 선택 
 *                  $.ajax({
 *                      type:'GET/POST'
 *                  })
 *                POST : 보안 , 데이터가 많다 (URL에 노출이 않된다) => 글쓰기,파일업로드 
 *                       회원가입 , 로그인 
 *                  <form => method="GET/POST"> ajax => 선택 
 *                  $.ajax({
 *                      type:'GET/POST'
 *                  })
 *            } 
 *            
 *           4. destory() : 메모리해제 => 새로고침 , 화면 이동 , 종료 
 *           
 *           a.jsp => a_jsp.java 
 */
import com.it.model.*;
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 사용자 요청을 받는다 
		// /Controller?cmd=list => ListModel  cmd=insert => InsertModel
		String cmd=request.getParameter("cmd");
		String jsp="";
		if(cmd.equals("list"))
		{
			ListModel model=new ListModel();
			jsp=model.handlerRequest(request);
		}
		else if(cmd.equals("insert"))
		{
			InsertModel model=new InsertModel();
			jsp=model.handlerRequest(request);
		}
		else if(cmd.equals("update"))
		{
			UpdateModel model=new UpdateModel();
			jsp=model.handlerRequest(request);
		}
		else if(cmd.equals("delete"))
		{
			DeleteModel model=new DeleteModel();
			jsp=model.handlerRequest(request);
			// Model => request를 받아서 => 결과값을 추가해서 Controller로 전송 
			// request.setAttribute()
		}
		
		// 해당 JSP로 request를 전송 
		RequestDispatcher rd=request.getRequestDispatcher(jsp);
		rd.forward(request, response);
			
	}

}








