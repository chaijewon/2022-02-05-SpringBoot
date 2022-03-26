package com.it.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.it.student.dao.*;
import com.it.student.entity.*;
@RestController
public class StudentRestController {
  @Autowired
  private StudentDAO dao;
  @GetMapping(value = "/list_vue")
  public List<StudentEntity> studentListData()
  {
	  List<StudentEntity> list=dao.findAll();
		/*
		 * for(StudentEntity s:list) {
		 * System.out.println(s.getHakbun()+" "+s.getName()); }
		 */
	  return list;
  }
  @GetMapping("/find_vue")
  public List<StudentEntity> studentFindData(String fd)
  {
	  System.out.println("fd="+fd);
	  List<StudentEntity> list=dao.findByNameContains(fd);
	  for(StudentEntity s:list)
	  {
		  System.out.println(s.getHakbun()+" "+s.getName());
	  }
	  return list;
  }
}
