package com.it.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.food.entity.CategoryEntity;
import java.util.*;
@Repository
public interface CategoryDAO extends JpaRepository<CategoryEntity, Integer>{
     //public List<CategoryEntity> findByCnoOrderByCno(); // order by cno ASC
}
