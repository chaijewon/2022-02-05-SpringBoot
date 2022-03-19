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
   
}
