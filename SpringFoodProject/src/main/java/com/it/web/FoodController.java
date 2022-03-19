package com.it.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import om.it.vo.*;
import com.it.dao.*;
@Controller
@RequestMapping("food/")
public class FoodController {
   // 필요한 객체 선언 => 자동주입
   @Autowired
   private FoodDAO dao;
   /*
    *   class Model
    *   {
    *      HttpServletRequest request;
    *      public void addAttribute(String id,Object obj)
    *      {
    *          request.setAttribute(id,obj);
    *      }
    *   }
    */
   @GetMapping("main.do")
   public String food_main(Model model)
   {
	   //Model => 데이터 전송 객체 => request,response (5버전 보안 => request,response IP)
	   // Category데이터 읽기 
	   List<CategoryVO> list=dao.categoryAllData();
	   // 데이터를 전송 
	   model.addAttribute("list", list);
	   model.addAttribute("main_jsp", "home.jsp");
	   return "food/main"; // .jsp를 사용하면 안된다 
   }
   
   @GetMapping("list.do")
   public String food_list(int cno,Model model)
   {
	   CategoryVO vo=dao.categoryInfoData(cno);
	   List<FoodVO> list=dao.categoryFoodListData(cno);
	   for(FoodVO fvo:list)
	   {
		   String poster=fvo.getPoster();
		   poster=poster.substring(0,poster.indexOf("^"));
		   fvo.setPoster(poster);
		   
		   String address=fvo.getAddress();
		   address=address.substring(0,address.lastIndexOf("지"));
		   fvo.setAddress(address);
	   }
	   model.addAttribute("vo", vo);
	   model.addAttribute("list", list);
	   model.addAttribute("main_jsp", "list.jsp");
	   return "food/main";
   }
   
   @GetMapping("detail.do")
   public String food_detail(int no,Model model)
   {
	   FoodVO vo=dao.foodDetailData(no);
	   String addr=vo.getAddress();
	   addr=addr.substring(0,addr.lastIndexOf("지"));
	   model.addAttribute("addr", addr);
	   model.addAttribute("vo", vo);
	   model.addAttribute("main_jsp", "detail.jsp");
	   return "food/main";
   }
   
}
