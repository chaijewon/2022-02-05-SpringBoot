package com.it.controller;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
/*
 *   Retention : 컴파일된 어노테이션의 저장 기간 
 *              ----------
 *               CLASS
 *               SOURCE 
 *              ---------- 컴파일후에 자동으로 메모리 해제 
 *               RUNTIME
 *              ---------- 프로그램 종료시까지 유지 
 *   Target : 찾는 종류 
 *   => Index 찾아주는 역할 (구분자) 
 *      ----------------
 *      1. class : TYPE
 *      2. method : METHOD
 *      3. 생성자  : CONSTRUCTOR
 *      4. 멤버변수 : FIELD
 *      5. 매개변수  : PARAMETER 
 */
public @interface RequestMapping {
  public String value();
}
