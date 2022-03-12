package com.it.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.it.model.*;
@WebServlet("/Controller2")
public class Controller2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map clsMap=new HashMap();
	public void init(ServletConfig config) throws ServletException {
		clsMap.put("list",new ListModel());
		clsMap.put("insert",new InsertModel());
		clsMap.put("update",new UpdateModel());
		clsMap.put("delete",new DeleteModel());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd=request.getParameter("cmd");
		Model model=(Model)clsMap.get(cmd);
		String jsp=model.handlerRequest(request);
		RequestDispatcher rd=request.getRequestDispatcher(jsp);
		rd.forward(request, response);
	}

}
