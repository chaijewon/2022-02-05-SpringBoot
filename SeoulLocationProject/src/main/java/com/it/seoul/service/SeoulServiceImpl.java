package com.it.seoul.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.seoul.vo.SeoulVO;
import com.it.seoul.dao.*;
@Service 
public class SeoulServiceImpl implements SeoulService{
    @Autowired
    private SeoulMapper mapper; // 스프링에 의해 구현 
	@Override
	public List<SeoulVO> seoulListData(Map map) {
		// TODO Auto-generated method stub
		return mapper.seoulListData(map);
	}
	@Override
	public int seoulTotalPage() {
		// TODO Auto-generated method stub
		return mapper.seoulTotalPage();
	}

}
