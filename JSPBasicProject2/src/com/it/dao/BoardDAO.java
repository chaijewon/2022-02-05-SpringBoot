package com.it.dao;
/*
 *   Model : ~VO, ~Model , ~DAO => 자바 코딩 
 *   View : JSP
 */
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
/*
 *   SqlSessionFactory
	 *   <select id="boardListData" resultType="BoardVO" parameterType="hashmap"><!-- id는 UNIQUE -->
	    SELECT no,subject,name,DATE_FORMAT(regdate,'%Y-%m-%d') as dbday,hit 
	    FROM board 
	    LIMIT #{start},#{rowSize}
	   </select>
	   
	  Map map=new HashMap();
	  map.put("boardListData","SELECT no,subject,name,DATE_FORMAT(regdate,'%Y-%m-%d') as dbday,hit 
	    FROM board 
	    LIMIT #{start},#{rowSize}")
 */
/*
 *    자바에서 초기값  => 명시적 초기화 => 초기화블록 => 생성자 
 *                    class A
 *                    {
 *                        int a=10;
 *                    }
 *    1. 생성자 =>호출
 *    ---------------
 *    2. 초기화 블록  ====> 자동으로 처리 
 *       인스턴스 블록 
 *       class A
 *       {
 *           int a=10;
 *          
 *           {
 *              a++; 구현
 *              a=10; => 파일을 읽어온다 ,드라이버등록 (구현)
 *           }
 *       }
 *       static 블록
 *       class A
 *       {
 *           static int a
 *           static
 *           {
 *              a=10;
 *           }
 *       }
 *       
 *       
 */
public class BoardDAO {
   //1. XML코드 읽기 
   private static SqlSessionFactory ssf;
   //2. 초기화 블록 
   static 
   {
	   try
	   {
		   //2-1. XML파일 읽기 
		   Reader reader=Resources.getResourceAsReader("Config.xml");
		   //2-2. 파싱 (XML데이터 읽기) => DOM/SAX(MyBatis)
		   ssf=new SqlSessionFactoryBuilder().build(reader);
		   /*
		    *   DOM : 메모리에 트리형태로 저장을 한 다음에 제어 (추가,수정,읽기, 삭제) 
		    *         속도가 늦다 
		    *   SAX : 읽기 전용 => 한줄씩 읽어서 데이터를 추출 
		    *   => JAXP , JAXB(빅데이터)
		    */
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
   }
   
   public static List<BoardVO> boardListData(Map map)
   {
	   List<BoardVO> list=new ArrayList<BoardVO>();
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();//연결된 Connection을 얻어 온다 
		   list=session.selectList("boardListData",map);
		   
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   try
		   {
			   if(session!=null)
				   session.close();
		   }catch(Exception ex) {}
	   }
	   //return ssf.openSession().selectList("")
	   return list;
   }
   public static void boardInsert(BoardVO vo)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession(true);//commit() => insert,update,delete
		   session.insert("boardInsert",vo);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   try
		   {
			   if(session!=null)
				   session.close();
		   }catch(Exception ex) {}
	   }
   }
   
}





