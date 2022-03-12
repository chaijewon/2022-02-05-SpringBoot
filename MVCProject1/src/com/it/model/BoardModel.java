package com.it.model;

import javax.servlet.http.HttpServletRequest;

import com.it.controller.RequestMapping;
/*
 *    ==> 찾는 대상 위에 존재 , 옆에 존재 
 *    @ ===> TYPE(클래스 구분)
 *    class clsName
 *    {
 *        @ ==> FIELD (멤버변수 구분)
 *        private A a;
 *        public void setA(@ => PARAMETERE A a)
 *        {
 *        }
 *        @ ==> METHOD
 *        public void display()
 *        {
 *        }
 *    }
 */
public class BoardModel {
   
   @RequestMapping("list.do") // if추가  => if(cmd.equals("list.do"))
   public String boardList(HttpServletRequest request)
   {
	   request.setAttribute("msg", "게시판 목록");;
	   return "view/list.jsp";
   }
   @RequestMapping("insert.do")
   public String boardInsert(HttpServletRequest request)
   {
	   request.setAttribute("msg", "게시판 추가");;
	   return "view/insert.jsp";
   }
   @RequestMapping("update.do")
   public String boardUpdate(HttpServletRequest request)
   {
	   request.setAttribute("msg", "게시판 수정");;
	   return "view/update.jsp";
   }
   @RequestMapping("delete.do")
   public String boardDelete(HttpServletRequest request)
   {
	   request.setAttribute("msg", "게시판 삭제");;
	   return "view/dlete.jsp";
   }
}
