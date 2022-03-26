package com.it.seoul.dao;
import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.it.seoul.vo.SeoulVO;
@Repository
@Mapper
public interface SeoulMapper {
  public List<SeoulVO> seoulListData(Map map);
  public int seoulTotalPage();
}
