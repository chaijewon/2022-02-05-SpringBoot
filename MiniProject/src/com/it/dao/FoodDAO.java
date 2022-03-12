package com.it.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
public class FoodDAO {
   //1. 마이바티스에 정보를 전송 => MySQL연결해서 => SQL실행문장을 넘겨준다 
   private static SqlSessionFactory ssf;
   static
   {
	   // XML을 파싱한 결과를 ssf에 전송 
	   try
	   {
		   //XML을 읽기
		   Reader reader=Resources.getResourceAsReader("Config.xml");
		   ssf=new SqlSessionFactoryBuilder().build(reader);
	   }catch(Exception ex) 
	   {
		   ex.printStackTrace();
	   }
   }
   // 카테고리 데이터 읽기 
   /*
    *   <select id="categoryListData" resultType="CategoryVO">
		    SELECT cno,title,subject,poster 
		    FROM food_category 
		    ORDER BY cno ASC
		 </select>
    */
   public static List<CategoryVO> categoryListData()
   {
	   List<CategoryVO> list=new ArrayList<CategoryVO>();
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   list=session.selectList("categoryListData");
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return list;
   }
   /*
    *  <select id="categoryInfoData" resultType="CategoryVO" parameterType="int">
	    SELECT title,subject 
	    FROM food_category
	    WHERE cno=#{cno}
	   </select>
	   <select id="categoryFoodListData" resultType="FoodVO" parameterType="int">
	     SELECT no,name,poster,address,tel,type,score
	     FROM food_house
	     WHERE cno=#{cno}
	   </select>
    */
   public static CategoryVO categoryInfoData(int cno)
   {
	   CategoryVO vo=new CategoryVO();
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   vo=session.selectOne("categoryInfoData",cno);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return vo;
   }
   public static List<FoodVO> categoryFoodListData(int cno)
   {
	   List<FoodVO> list=new ArrayList<FoodVO>();
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   list=session.selectList("categoryFoodListData",cno);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return list;
   }
   /*
    *  <select id="foodDetailData" resultType="FoodVO" parameterType="int">
     SELECT * FROM food_house
     WHERE no=#{no}
   </select>
    */
   public static FoodVO foodDetailData(int no)
   {
	   FoodVO vo=new FoodVO();
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   vo=session.selectOne("foodDetailData",no);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return vo;
   }
}








