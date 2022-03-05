package com.it.model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.dao.*;
public class BoardModel {
   public void boardListData(HttpServletRequest request)
   {
	   //1. 페이지 받기 
	   String page=request.getParameter("page"); // 사용자가 전송 
	   // default page
	   if(page==null)
		   page="1";
	   //2. 현재 페이지 지정 
	   int curpage=Integer.parseInt(page);
	   //3. 현재페이지에 해당되는 데이터를 읽어 온다 
	   Map map=new HashMap();
	   int rowSize=10;
	   int start=(rowSize*curpage)-(rowSize); // 1page => 0~9
	   // 2=> 10~19
	   map.put("rowSize",rowSize);
	   map.put("start", start);
	   // 결과값 받기 
	   List<BoardVO> list=BoardDAO.boardListData(map);
	   //JSP로 값을 전송 
	   request.setAttribute("list", list);
   }
   public void boardInsert(BoardVO vo,HttpServletResponse response)
   {
	   BoardDAO.boardInsert(vo);
	   try
	   {
	      response.sendRedirect("../main/main.jsp?mode=5");//list.jsp이동 
	   }catch(Exception ex) {}
   }
}
