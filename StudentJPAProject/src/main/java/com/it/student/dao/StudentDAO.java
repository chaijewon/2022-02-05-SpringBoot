package com.it.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.student.entity.StudentEntity;
import java.util.*;
public interface StudentDAO extends JpaRepository<StudentEntity, Integer>{
    /*
     *   전체 데이터 읽기  findAll()
     *   한개 데이터 읽기  findOne() => 처음 데이터 한개 
     *   수정 , 추가 => save() 
     *   삭제 => delete()
     *   
     *   ------------------ 메소드 만들기 
     *   규칙 : findByXxx()
     *        예) => WHERE 
     *        findByHakbun(int hakbun) => SELECT * FROM student WHERE hakbun=1
     *        findByName(String name)
     *        findByStudentOrderByNoDesc() => ORDER BY no DESC
     *        findByNameLike(String name)  WHERE nale LIKE '%name%'
     *        AND , OR 
     *        findByNameAndKor(String name,int kor) WHERE name='' and kor=100
     *        
     */
	public StudentEntity findByHakbun(int hakbun);
	public List<StudentEntity> findByNameContaining(String name);
}
