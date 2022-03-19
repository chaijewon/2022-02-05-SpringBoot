package com.it.web;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.it.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // Spring 연결 => 컨터이너
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		//CategoryDAO dao=new CategoryDAO();
		CategoryDAO dao=app.getBean("categoryDAO",CategoryDAO.class);
		List<CategoryVO> list=dao.categoryData();
		for(CategoryVO vo:list)
		{
			System.out.println("제목:"+vo.getTitle());
			System.out.println("부제목:"+vo.getSubject());
			System.out.println("=====================");
		}
	}

}
