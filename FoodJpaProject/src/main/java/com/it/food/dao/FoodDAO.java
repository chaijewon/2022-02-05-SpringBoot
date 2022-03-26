package com.it.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.food.entity.FoodEntity;
import java.util.*;
// 데이터베이스 연결 (JSP로 값을 전송하지 못한다)
// Controller (DAO에 값을 얻어서 JSP로 값을 전송) 
@Repository //메모리 할당 
public interface FoodDAO extends JpaRepository<FoodEntity, Integer>{
   public List<FoodEntity> findByCno(int cno);
   /*
    *  SELECT * FROM food_house 
       WHERE cno=1;
    */
   public FoodEntity findByNo(int no);
   /*
    *  SELECT * FROM food_house 
       WHERE no=1;
    */
}
