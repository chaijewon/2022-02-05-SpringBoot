package com.it.seoul.controller;
import java.util.*;// List

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.it.seoul.service.*;//데이터베이스 연결 => 요청한 결과값 읽기
import com.it.seoul.vo.*; // 데이터를 모아서 한번에 브라우저로 전송 
@Controller
/*
 *   @Controller : 화면 변경 
 *                 =======
 *                 1) JSP파일을 변경 => request전송 : Model 전송 객체 = forward()
 *                    return "main"
 *                 2) 재전송 (이미 만들어진 파일) => request를 전송하지 않는다 = redirect()
 *                    return "redirect:main.do"
 *   @Restontroller : 데이터만 전송 (일반 데이터 전송,객체단위 : JSON)
 *   
 *   JDBC => DBCP => ORM (MyBatis , Hibernate , JPA)
 *                                 ------------------ SQL없이 사용 (메소드)
 *                                 findAll() , findOne() , save() , delete()
 *                                                        -------- insert,update
 *                                 JPA 
 *                                 ---- findByXxx
 *                                 1. findByNo(int no) => WHERE no=1 
 *                                 2. findByAddressLike  => WHERE address LIKE
 *                                 2. findByNameAndNo => name=? AND no=
 */
/*
 *   클래스 메모리 할당 (어노테이션은 구분자) => 선택적으로 메모리 할당 (스프링에 관리 요청)
 *     @Component : 일반 클래스 , 외부에서 데이터 읽기
 *     @Repository : DAO (저장소)
 *     @Controller : 화면 변경 
 *     @RestController : 다른 프로그램과 연동 => 데이터전송 
 *     @ControllerAdvice : 통합 예외처리 
 *     @Service :BI (DAO여러개 사용)
 *     
 *     Spring => 4.3버전 부터 변경 
 *     @RequestMapping => 프로그래머 요청 (@GetMapping , @PostMapping)
 *     GET => <a> , location.href, sendRedirect => URL?변수=값 
 *     POST => Ajax , axios , <form> ,로그인 , 글쓰기 ,회원가입 
 */
public class SeoulController {
   @Autowired  // 자동 주입 
   private SeoulService service;// 인터페이스 => 구현은 스프링에서 처리 => 이미 스프링에서 구현한 클래스의 주소값 요청
   // 사용자 요청 
   @GetMapping("/list.do")
   // 처리한 결과를 보여주기 위한 메소드를 제작 
   public String seoul_list(String page,Model model)
   {
	   //Model => 데이터를 해당 JSP로 전송 
	   //MySQL 에서 데이터 읽기 
	   /*
	    *  spring.mvc.view.prefix=/WEB-INF/
           spring.mvc.view.suffix=.jsp
           
           /WEB-INF/seoul/list.jsp
           member/join
	    */
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page); // 현재 페이지 
	   Map map=new HashMap();
	   int size=12;
	   int start=(size*curpage)-(size);
	   //int end = size*curpage;
	   map.put("start", start);
	   map.put("end", size);
	   List<SeoulVO> list=service.seoulListData(map);
	   int totalpage=service.seoulTotalPage();
	   //////////////////// 요청처리 
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("list", list);
	   /////////////////// list.jsp로 출력할 데이터 전송 
	   return "list";
   }
   @GetMapping("/detail.do") // 사용자 요청  => if 
   public String seoul_detail(int no,Model model) // no 사용자가 요청값 , model=결과값 전송 
   {
	   SeoulVO vo=service.seoulDetailData(no);
	   model.addAttribute("vo", vo);
	   return "detail";//detail.jsp에서 결과값을 출력 
   }
   // int , String 
   @GetMapping("/hotel.do")
   public String hotel_list(String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page); // 현재 페이지 
	   Map map=new HashMap();
	   int size=12;
	   int start=(size*curpage)-(size);
	   //int end = size*curpage;
	   map.put("start", start);
	   map.put("end", size);
	   List<HotelVO> list=service.hotelListData(map);
	   model.addAttribute("list", list);
	   return "hotel";
   }
   
}








