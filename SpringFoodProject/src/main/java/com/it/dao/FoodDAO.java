package com.it.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.it.mapper.CategoryMapper;

import om.it.vo.CategoryVO;
import om.it.vo.FoodVO;

import java.util.*;
@Repository
public class FoodDAO {
   @Autowired
   private CategoryMapper cMapper;
   public List<CategoryVO> categoryAllData()
   {
	   return cMapper.categoryAllData();
   }
   
   public CategoryVO categoryInfoData(int cno)
   {
	   return cMapper.categoryInfoData(cno);
   }
   public List<FoodVO> categoryFoodListData(int cno)
   {
	   return cMapper.categoryFoodListData(cno);
   }
   public FoodVO foodDetailData(int no)
   {
	   return cMapper.foodDetailData(no);
   }
}
