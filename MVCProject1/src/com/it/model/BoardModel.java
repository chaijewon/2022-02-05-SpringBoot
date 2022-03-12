package com.it.model;

import javax.servlet.http.HttpServletRequest;

public class BoardModel {
   public String boardList(HttpServletRequest request)
   {
	   request.setAttribute("msg", "게시판 목록");;
	   return "view/list.jsp";
   }
   public String boardInsert(HttpServletRequest request)
   {
	   request.setAttribute("msg", "게시판 추가");;
	   return "view/insert.jsp";
   }
   public String boardUpdate(HttpServletRequest request)
   {
	   request.setAttribute("msg", "게시판 수정");;
	   return "view/update.jsp";
   }
   public String boardDelete(HttpServletRequest request)
   {
	   request.setAttribute("msg", "게시판 삭제");;
	   return "view/dlete.jsp";
   }
}
