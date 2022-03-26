package com.it.seoul.service;

import java.util.List;
import java.util.Map;

import com.it.seoul.vo.SeoulVO;

public interface SeoulService {
	public List<SeoulVO> seoulListData(Map map);
	public int seoulTotalPage();
}
