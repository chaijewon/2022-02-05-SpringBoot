package com.it.seoul.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *   no int 
	name varchar(100) 
	address varchar(200) 
	poster varchar(200) 
	msg varchar(1000)
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeoulVO {
  
  private int no;
  private String name,address,poster,msg;
}
