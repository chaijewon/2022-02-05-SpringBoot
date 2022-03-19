package com.it.web;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface LocationMapper {
  @Select("SELECT cno,title,subject,poster "
		 +"FROM food_category "
		 +"ORDER BY cno ASC")
  public List<LocationVO> foodCategoryData();
}
