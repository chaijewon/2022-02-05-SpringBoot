package com.it.food.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/*
 * cno int PK 
title varchar(2000) 
subject varchar(2000) 
poster varchar(260) 
link varchar(260)
 */
@Entity(name="food_category")
@Setter
@Getter
public class CategoryEntity {
  @Id
  private int cno;
  private String title,subject,poster,link;
}
