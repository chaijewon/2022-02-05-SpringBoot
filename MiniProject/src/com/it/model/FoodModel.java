package com.it.model;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.controller.RequestMapping;
import com.it.dao.*;
public class FoodModel {
  @RequestMapping("food/category_list.do")
  public String food_catgory_list(HttpServletRequest request,HttpServletResponse response)
  {
	  String cno=request.getParameter("cno");
	  List<FoodVO> list=FoodDAO.categoryFoodListData(Integer.parseInt(cno));
	  for(FoodVO vo:list)
	  {
		  String poster=vo.getPoster();
		  poster=poster.substring(0,poster.indexOf("^"));
		  vo.setPoster(poster);
		  
		  String address=vo.getAddress();
		  address=address.substring(0,address.lastIndexOf("지"));
		  vo.setAddress(address);
	  }
	  CategoryVO vo=FoodDAO.categoryInfoData(Integer.parseInt(cno));
	  request.setAttribute("list", list);
	  request.setAttribute("vo", vo);
	  request.setAttribute("main_jsp", "../food/category_list.jsp");
	  return "../main/main.jsp";
  }
  @RequestMapping("food/food_detail_before.do")
  public String food_detail_before(HttpServletRequest request,HttpServletResponse response)
  {
	  String no=request.getParameter("no");
	  Cookie cookie=new Cookie("m"+no, no);
	  //                        key    값
	  cookie.setMaxAge(60*60*24); // 하루 => 초단위 (기간)
	  // path 지정 
	  cookie.setPath("/");
	  // 클라이언트로 전송 
	  response.addCookie(cookie);
	  return "redirect:../food/food_detail.do?no="+no;
  }
  @RequestMapping("food/food_detail.do")
  public String food_detail(HttpServletRequest request,HttpServletResponse response)
  {
	  String no=request.getParameter("no");
	  FoodVO vo=FoodDAO.foodDetailData(Integer.parseInt(no));
	  String address=vo.getAddress();
	  String addr1=address.substring(0,address.lastIndexOf("지"));
	  String addr2=address.substring(address.lastIndexOf("지"));
	  vo.setAddr1(addr1);
	  vo.setAddr2(addr2);
	  request.setAttribute("vo", vo);
	  request.setAttribute("main_jsp", "../food/food_detail.jsp");
	  return "../main/main.jsp";
  }
}





