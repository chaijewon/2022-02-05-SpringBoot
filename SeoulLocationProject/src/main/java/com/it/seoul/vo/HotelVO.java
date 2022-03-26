package com.it.seoul.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *  no int 
name varchar(100) 
score double 
address varchar(200) 
poster varchar(200) 
images varchar(1000)
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HotelVO {
  private int no;
  private double score;
  private String name,address,poster,images;
}
