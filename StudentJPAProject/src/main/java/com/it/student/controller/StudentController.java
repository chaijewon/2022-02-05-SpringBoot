package com.it.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// vue,react => router
import org.springframework.web.bind.annotation.PostMapping;

import com.it.student.entity.StudentEntity;
import com.it.student.dao.*;
@Controller
public class StudentController {
  @Autowired
  private StudentDAO dao;
  @GetMapping("/list")
  public String student_list()
  {
	  return "list";
  }
  @GetMapping("/insert")
  public String student_insert()
  {
	  return "insert";
  }
  @PostMapping("/insert_ok")
  public String student_insert_ok(StudentEntity vo)
  {
	  dao.save(vo);
	  return "redirect:list";
  }
  @GetMapping("/find")
  public String student_find()
  {
	  return "find";
  }
}
