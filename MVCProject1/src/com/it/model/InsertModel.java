package com.it.model;

import javax.servlet.http.HttpServletRequest;

public class InsertModel implements Model{
	 public String handlerRequest(HttpServletRequest request)
	  {
		  request.setAttribute("msg", "게시판 추가");
		  return "view/insert.jsp";
	  }
}
