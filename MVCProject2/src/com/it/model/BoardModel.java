package com.it.model;

import javax.servlet.http.HttpServletRequest;

import com.it.controller.RequestMapping;

public class BoardModel {
  @RequestMapping("board/list.do")
  public String board_list(HttpServletRequest request)
  {
	  request.setAttribute("msg", "게시판 목록");
	  return "../board/list.jsp";
  }
  @RequestMapping("board/detail.do")
  public String board_detail(HttpServletRequest request)
  {
	  request.setAttribute("msg", "게시판 상세보기");
	  return "../board/detail.jsp";
  }
}
