package com.it.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.it.model.*;

@WebServlet("*.do")
public class Controller5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 사용자 요청 
		String cmd=request.getRequestURI();
		cmd=cmd.substring(request.getContextPath().length()+1);// list.do 
		try
		{
			//1.클래스 정보 읽기 => MVC에서는 Controller를 수정하면 안된다 
			Class clsName=Class.forName("com.it.model.BoardModel");
			//2.클래스 메모리 할당 =>  리플렉션 (솔루션)
			Object obj=clsName.getDeclaredConstructor().newInstance();
			// Object obj=new BoardModel() 
			//3.메소드 찾기 
			Method[] methods=clsName.getDeclaredMethods();
			for(Method m:methods)
			{
				//System.out.println(m.getName());
				RequestMapping rm=m.getAnnotation(RequestMapping.class);
				if(rm.value().equals(cmd)) //rm.value()="update.do"
				{
					// 4.메소드를 호출 
					String jsp=(String)m.invoke(obj, request);
					System.out.println(m.getName()+" Call...");
					System.out.println("리턴값:"+jsp);
					// jsp=model.boardList(request);
					RequestDispatcher rd=request.getRequestDispatcher(jsp);
					rd.forward(request, response);
					return;
				}
			}
		}catch(Exception ex){}
		
	}

}






