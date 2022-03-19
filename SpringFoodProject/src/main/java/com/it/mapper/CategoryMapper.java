package com.it.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import om.it.vo.CategoryVO;
import om.it.vo.FoodVO;
public interface CategoryMapper {
  @Select("SELECT cno,title,poster,subject "
		 +"FROM food_category "
		 +"ORDER BY 1")
  public List<CategoryVO> categoryAllData();
  
  @Select("SELECT title,subject "
		 +"FROM food_category "
		 +"WHERE cno=#{cno}")
  public CategoryVO categoryInfoData(int cno);
  
  @Select("SELECT no,name,tel,type,poster,address,score "
		 +"FROM food_house "
		 +"WHERE cno=#{cno}")
  public List<FoodVO> categoryFoodListData(int cno);
  
  @Select("SELECT * FROM food_house "
		 +"WHERE no=#{no}")
  public FoodVO foodDetailData(int no);
}
