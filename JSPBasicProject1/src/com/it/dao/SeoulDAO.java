package com.it.dao;
import java.util.*;
import java.sql.*;
public class SeoulDAO {
   // MySQL 연결 객체
   private Connection conn;
   // MySQL로 SQL문장을 송수신 
   private PreparedStatement ps;
   // MySQL 주소  => com.mysql.cj.jdbc.Driver
   private final String URL="jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
   private static SeoulDAO dao;
   // 1. 드라이버 등록 => MySql연결 => 1번만 수행 
   public SeoulDAO()
   {
	   try
	   {
		   Class.forName("com.mysql.cj.jdbc.Driver");
	   }catch(Exception ex){}
   }
   // 2. 싱글턴 : 메모리에 한개만 저장후 => 재사용 => static 
   public static SeoulDAO newInstance()
   {
	   if(dao==null)
		   dao=new SeoulDAO();
	   return dao;
   }
   // 3. MySQL연결 
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"root","happy");
		   // conn  root/happy
	   }catch(Exception ex) {}
   }
   // 4. MySql연결 해제 
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
		   // /quit
	   }catch(Exception ex) {}
   }
   ////////////////////////// ~DAO의 필수 과정 
   // 기능 설정 => 명소 출력 
   public ArrayList<SeoulLocationVO> seoulLocationData(int page)
   {
	   ArrayList<SeoulLocationVO> list=new ArrayList<SeoulLocationVO>();
	   try
	   {
		   // 정상적으로 수행시에 소스 
		   // 1. 연결 
		   getConnection();
		   // 2. SQL문장 제작 => MYSQL에 보내는 문장 
		   String sql="SELECT no,poster,name "
				     +"FROM seoul_location "
				     +"limit ?,?";
		   // limit 시작위치 , 갯수  => 0,10 ==> 11,10
		   // 3. MYSQL로 전송 
		   ps=conn.prepareStatement(sql);
		   // 4. ?에 값을 채운다 
		   int rowSize=12;
		   int start=(rowSize*page)-rowSize;
		   // 1page = 0
		   // 2page = 12
		   ps.setInt(1, start);
		   ps.setInt(2, rowSize);
		   // 5. 실행후에 결과값을 가지고 온다 
		   ResultSet rs=ps.executeQuery();
		   while(rs.next()) // 커서의 위치를 첫번째 출력 위치 ==> previous()
		   {
			   // 한줄씩 읽어온다 
			   SeoulLocationVO vo=new SeoulLocationVO();
			   vo.setNo(rs.getInt(1));
			   vo.setPoster(rs.getString(2));
			   vo.setTitle(rs.getString(3));
			   
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   // 에러 확인 
		   ex.printStackTrace(); // 에러 위치 출력  => getMessage() : 에러 내용만 출력 
	   }
	   finally
	   {
		   // MySQL 닫기
		   disConnection();
	   }
	   return list;
   }
   // 총페이지 구하기 
   public int locationTotalPage()
   {
	   int total=0;
	   try
	   {
		   //1. 연결
		   getConnection();
		   //2. SQL문장 
		   String sql="SELECT CEIL(COUNT(*)/12.0) FROM seoul_location";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   total=rs.getInt(1);
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
	   return total;
   }
}




