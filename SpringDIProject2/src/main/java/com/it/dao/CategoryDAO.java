package com.it.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
// id를 등록하지 않는 경우 => default id (categoryDAO)
public class CategoryDAO {
   // 스프링을 통해서 자동 주입 (instanceof)
   @Autowired
   private CategoryMapper mapper;
   public List<CategoryVO> categoryData()
   {
	   return mapper.categoryData();
   }
}
