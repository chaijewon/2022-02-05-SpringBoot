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
		   // sql 문장을 읽어 온다 
		   /*
		    *     public List selectList(String sql,Object obj)
		    *     {
		    *          1. 데이터베이스 연결 
		    *          conn=DriverManager.getConnection(URL,username,password)
		    *          2. SQL문장 제작 
		    *          SQL----------------------
		    *          String sql=""; <select>SELECT~</select>
		    *          ----------------------
		    *          3. MYSQL로 전송 
		    *          ps=conn.preparedStatement(sql);
		    *          4. ?에 값을 채운다 
		    *          ---------------------- parameterType
		    *          ps.setInt(1,"")
		    *          ps.setInt(2,"")
		    *          ----------------------
		    *          5. 결과값 읽기
		    *          ResultSet rs=ps.executeQuery()
		    *          while(rs.next())
		    *          {
		    *          ----------------------------------- ResultType
		    *              BoardVO vo=new BoardVO();
		    *              vo.setNo(rs.getString("no"));
		    *              ..
		    *              ..
		    *              list.add(vo);
		    *           -----------------------------------
		    *          }
		    *          
		    *     }
		    */
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
   /*
    *  <update id="hitIncrement" parameterType="int">
	     UPDATE board SET
	     hit=hit+1
	     WHERE no=#{no}
	   </update>
	   <select id="boardDetailData" resultType="BoardVO" parameterType="int">
	    SELECT no,name,subject,content,DATE_FORMAT(regdate,'%Y-%m-%d') as dbday,hit
	    FROM board
	    WHERE no=#{no}
	   </select>
    */
   // resultType(리턴형)  parameterType(매개변수)
   public static BoardVO boardDetailData(int no)
   {
	   BoardVO vo=new BoardVO();
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   //1.조회수 증가 
		   session.update("hitIncrement",no);
		   session.commit();
		   //2.내용보기 데이터 읽기
		   vo=session.selectOne("boardDetailData",no);
		   /*
		    *    1. insert() <insert>
		    *    2. update() <update>
		    *    3. delete() <delete>
		    *    4. select=> 데이터검색 
		    *       ROW가 여러개일 경우 : selectList  => List
		    *       ROW가 한개일 경우 : selectOne => ~VO
		    */
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
	   return vo;
   }
   /*
    *  <select id="boardTotalPage" resultType="int">
        SELECT CEIL(COUNT(*)/10.0) FROM board
       </select>
    */
   public static int boardTotalPage()
   {
	   int totalpage=0;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   totalpage=session.selectOne("boardTotalPage");
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
	   return totalpage;
   }
   
}





