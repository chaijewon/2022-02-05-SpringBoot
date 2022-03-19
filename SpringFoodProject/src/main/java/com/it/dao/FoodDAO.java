package com.it.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.it.mapper.CategoryMapper;

import om.it.vo.CategoryVO;

import java.util.*;
@Repository
public class FoodDAO {
   @Autowired
   private CategoryMapper cMapper;
   public List<CategoryVO> categoryAllData()
   {
	   return cMapper.categoryAllData();
   }
}
