package com.it.seoul.dao;
import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.it.seoul.vo.*;
@Repository
@Mapper
public interface HotelMapper {
	public List<HotelVO> hotelListData(Map map);
}
