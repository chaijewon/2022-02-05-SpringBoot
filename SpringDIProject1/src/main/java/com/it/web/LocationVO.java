package com.it.web;

import lombok.Getter;
import lombok.Setter;

// 사용자 정의 데이터형 
/*
 *    데이터형 => 읽기 / 쓰기 (setter/getter)
 */
@Setter
@Getter
public class LocationVO {
   private int cno;
   private String title;
   private String subject;
   private String poster;
}
