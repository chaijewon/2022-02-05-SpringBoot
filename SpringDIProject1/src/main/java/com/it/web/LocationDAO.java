package com.it.web;
/*
 *   액션 클래스 : 기능을 가지고 있는 클래스 => 스프링에서 관리
 *   
 *   => 공통 모듈 => 자동 호출이 가능 (callback) => AOP(Transcation,Security) 
 *       입고 => 재고
 *       출고 => 재고 
 *   => 핵심 모듈 
 */
import java.util.*;

import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.Setter;
@Repository("dao")
public class LocationDAO {
   @Autowired
   @Setter
   private LocationMapper mapper;
   public List<LocationVO> foodCategoryData()
   {
	   return mapper.foodCategoryData();
   }
   
}
