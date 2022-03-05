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
	   int totalpage=BoardDAO.boardTotalPage();
	   //JSP로 값을 전송 
	   request.setAttribute("curpage", curpage);
	   request.setAttribute("totalpage", totalpage);
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
   // 요청받는다 => DAO에서 데이터를 읽어서 JSP로 전송 => Model
   // DAO는 MySQL만 연결 
   
   public void boardDetailData(HttpServletRequest request)
   {
	   // 요청을 받는다 => 요청값은 request => request에 값을 채워준다 => 재전송
	   String no=request.getParameter("no");
	   BoardVO vo=BoardDAO.boardDetailData(Integer.parseInt(no));
	   request.setAttribute("vo", vo);
   }
}
