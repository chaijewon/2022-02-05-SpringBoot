package com.it.model;

import javax.servlet.http.HttpServletRequest;

public class DeleteModel implements Model{
	 public String handlerRequest(HttpServletRequest request)
	  {
		 
		  request.setAttribute("msg", "게시판 삭제");
		  return "view/delete.jsp";
	  }
}
