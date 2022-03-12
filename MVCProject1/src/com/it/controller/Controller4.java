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
@WebServlet("*.do1")
// list.do , insert.do , update.do
public class Controller4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getRequestURI(); 
		System.out.println("cmd:"+cmd);
		/*
		 *   /MVCProject1/update.do => rquestURI
		 *   ------------
		 *    ContextPath
		 */
		cmd=cmd.substring(request.getContextPath().length()+1);
		System.out.println("cmd:"+cmd);
		BoardModel model=new BoardModel();
		String jsp="";
		if(cmd.equals("list.do"))
		{
			jsp=model.boardList(request);
		}
		else if(cmd.equals("insert.do"))
		{
			jsp=model.boardInsert(request);
		}
		else if(cmd.equals("update.do"))
		{
			jsp=model.boardUpdate(request);
		}
		else if(cmd.equals("delete.do"))
		{
			jsp=model.boardDelete(request);
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(jsp);
		rd.forward(request, response);
	}

}









