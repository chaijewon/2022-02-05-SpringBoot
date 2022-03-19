package com.it.dao;

import lombok.Getter;
import lombok.Setter;

/*
 *   vo 
 *   mapper 
 *   dao
 *   -------- xml,java(spring)
 *   main
 *   
 *   =================
 *   vo
 *   mapper
 *   dao
 *   model
 *   --------- xml,java(spring)
 *   jsp
 */
@Getter
@Setter
public class CategoryVO {
   private int cno;
   private String title,subject;
}
