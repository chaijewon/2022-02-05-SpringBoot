package com.it.model;

import javax.servlet.http.HttpServletRequest;

import com.it.controller.RequestMapping;

public class FoodModel {
	  @RequestMapping("food/list.do")
	  public String food_list(HttpServletRequest request)
	  {
		  request.setAttribute("msg", "맛집 목록");
		  return "../food/list.jsp";
	  }
	  @RequestMapping("food/detail.do")
	  public String food_detail(HttpServletRequest request)
	  {
		  request.setAttribute("msg", "맛집 상세보기");
		  return "../food/detail.jsp";
	  }
}
