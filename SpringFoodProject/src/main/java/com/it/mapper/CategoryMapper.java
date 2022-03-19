package com.it.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import om.it.vo.CategoryVO;
public interface CategoryMapper {
  @Select("SELECT cno,title,poster,subject "
		 +"FROM food_category "
		 +"ORDER BY 1")
  public List<CategoryVO> categoryAllData();
}
