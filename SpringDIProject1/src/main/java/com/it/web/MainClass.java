package com.it.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.it.config.LocationConfig;

import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 1. Spring에 XML 코드 전송 => 처리(Container)
		/*
		 *    클래스 관리자 <bean> 
		 *       BeanFactory : core / di
		 *          |
		 *     --------------------
		 *     |                   |
		 *   ApplicationContext AnnotationConfigApplicationContext => AOP
		 *     |     xml  (4)             | java (5)
		 *   WebApplicationContext  AnnotationConfigWebApplicationContext => MVC
		 *   
		 *   1. 동작 순서 (객체생명주기 관리) => 생성 ~ 소멸
		 *   => <bean id="" class="" p:변수명="">
		 *   => class 메모리 할당 
		 *   => setter 값을 주입 
		 *   => map에 저장  ==> 주소값 변경이 없다 (한개 메모리로 사용 => 싱글턴)
		 *   ------------------------
		 *   프로그래머 활용 
		 *   ------------------------
		 *   => 메모리 해제
		 */
		// 1. XML에 있는 등록된 클래스 => 스프링에 전송 
		//ApplicationContext app=
				//new ClassPathXmlApplicationContext("app.xml");
		AnnotationConfigApplicationContext app=
				new AnnotationConfigApplicationContext(LocationConfig.class);
		// classapth => src/main/java
		LocationDAO dao=(LocationDAO)app.getBean("dao");
		/*
		 *  <bean id="dao" class="com.it.web.LocationDAO"
		      p:mapper-ref="mapper"
		    />
		 */
		List<LocationVO> list=dao.foodCategoryData();
		for(LocationVO vo:list)
		{
			System.out.println("제목:"+vo.getTitle());
			System.out.println("부제목:"+vo.getSubject());
			System.out.println("===================================");
		}
		
	}

}
