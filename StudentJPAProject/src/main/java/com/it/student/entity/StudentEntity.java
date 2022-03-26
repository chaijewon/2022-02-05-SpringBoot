package com.it.student.entity;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity(name="student") // 테이블명 설정 
@Getter
@Setter
public class StudentEntity {
    @Id   // primary key 
	private int hakbun;
    @Column(nullable = false,unique = false,length = 34)
    private String name;
    private int kor;
    private int eng;
    private int math;
   
}
