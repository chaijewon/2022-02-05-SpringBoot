package com.it.model;

import javax.servlet.http.HttpServletRequest;

public class ListModel implements Model{
  public String handlerRequest(HttpServletRequest request)
  {
	  request.setAttribute("msg", "게시판 목록");
	  return "view/list.jsp";
  }
}
