package com.it.controller;

import java.io.File;
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
import javax.xml.parsers.*;
import org.w3c.dom.*;
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private List<String> clsList=new ArrayList<String>();
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try
		{
			String path="D:\\weekDev\\jspStudy\\MVCProject2\\WebContent\\WEB-INF\\app.xml";
			//1. 파서기 생성 (XML의 데이터 읽기)
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();// 파서기
			// 빅데이터 => news => jaxb , jaxp(DOM,SAX)
			// 파싱 => XML , HTML => Jsoup(정적) 
			Document doc=db.parse(new File(path));
			// 최상위 태그 읽기 
			Element beans=doc.getDocumentElement();
			System.out.println("최상위 태그:"+beans.getTagName());
			// 같은 태그를 모아서 처리 
			NodeList list=beans.getElementsByTagName("bean");
			for(int i=0;i<list.getLength();i++)
			{
				Element bean=(Element)list.item(i);
				//System.out.println("id:"+bean.getAttribute("id"));
				//System.out.println("class:"+bean.getAttribute("class"));
				clsList.add(bean.getAttribute("class"));
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. 사용자 요청값 
		String cmd=request.getRequestURI();
		// food/list.do  board/list.do
		cmd=cmd.substring(request.getContextPath().length()+1);
		// 어노테이션 : 찾기 용도 (클래스 , 메소드 , 멤버변수 , 매개변수) => 클래스 등록 
		// @Bean (Spring-Boot) 
		// XML : 클래스 등록  <bean>
		// 스프링 : DI , AOP , MVC , Transaction => MyBatis
		// 스프링부트 : 어노테이션 => JPA 
	    try
	    {
	    	// com.it.model.BoardModel, com.it.model.FoodModel
	    	for(String strCls:clsList)
	    	{
	    		//1. 메모리 할당 
	    		Class clsName=Class.forName(strCls);
	    		Object obj=clsName.getConstructor().newInstance();
	    		//System.out.println(obj);
	    		//2. 정의된 메소드 읽기
	    		Method[] methods=clsName.getDeclaredMethods();
	    		for(Method m:methods)
	    		{
	    			RequestMapping rm=m.getAnnotation(RequestMapping.class);
	    			if(rm.value().equals(cmd))
	    			{
	    				String jsp=(String)m.invoke(obj, request);
	    				/*
	    				 *   화면 이동 
	    				 *   1. sendRedirect() => request를 초기화 
	    				 *   2. forward () => request를 유지 
	    				 */
	    				if(jsp.startsWith("redirect"))
	    				{
	    					String s=jsp.substring(jsp.indexOf(":")+1);
	    					response.sendRedirect(s);
	    				}
	    				else
	    				{
		    				RequestDispatcher rd=
		    						request.getRequestDispatcher(jsp);
		    				rd.forward(request, response);
	    				}
	    				return;
	    			}
	    		}
	    	}
	    }catch(Exception ex){}
	}

}








