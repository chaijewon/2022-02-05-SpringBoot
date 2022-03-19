package com.it.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface CategoryMapper {
   @Select("SELECT cno,title,subject "
		  +"FROM food_category "
		  +"ORDER BY 1")
   public List<CategoryVO> categoryData();
}
