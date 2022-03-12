package com.it.model;
import com.it.controller.RequestMapping;
import com.it.dao.*;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class MainModel {
   @RequestMapping("main/main.do")
   public String main_main(HttpServletRequest request,HttpServletResponse response)
   {
	   //1. 쿠키 읽기
	   Cookie[] cookies=request.getCookies();
	   List<FoodVO> cList=new ArrayList<FoodVO>();
	   if(cookies!=null)
	   {
		   for(int i=cookies.length-1;i>=0;i--)// 최신에 방문 
		   {
			   if(cookies[i].getName().startsWith("m"))
			   {
				   String no=cookies[i].getValue(); // 단점 :문자열만 저장이 가능 
				   FoodVO vo=FoodDAO.foodDetailData(Integer.parseInt(no));
				   cList.add(vo);
			   }
		   }
	   }
	   request.setAttribute("cList", cList);
	   List<CategoryVO> list=FoodDAO.categoryListData();
	   request.setAttribute("list", list);
	   request.setAttribute("main_jsp", "../main/home.jsp");
	   return "../main/main.jsp";
   }
}
