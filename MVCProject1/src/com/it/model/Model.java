package com.it.model;

import javax.servlet.http.HttpServletRequest;

// 일반 데이터 => 묶어서 사용 (배열,클래스)
// 클래스 여러개를 묶어서 사용 => 인터페이스 
public interface Model {
   public String handlerRequest(HttpServletRequest request);
}
