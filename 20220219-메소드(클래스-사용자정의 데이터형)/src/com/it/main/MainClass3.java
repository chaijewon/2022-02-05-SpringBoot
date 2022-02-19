package com.it.main;
import java.sql.*;
/*
 *   1. 드라이버 등록  => Class.forName("com.mysql.cj.jdbc.Driver")
 *   2. SQL문장 제작 => SELECT /INSERT/UPDATE /DELETE
 *   2-2. MySQL연결 => Connection 
 *   3. MySQL로 전송 => PreparedStatement 
 *   4. 실행을 요청  => ResultSet 
 *   5. 실행된 데이터 읽기 
 *   ==========================================================
 *      자바 
 *            컴퓨터가 인식 (컴파일) => 0,1    실행
 *      A.java  ====> 컴파일 ====> A.class ======> 화면에 출력 
 *      ------        javac                  java(인터프리터)
 *      원시소스 (프로그래머만 알고 있는 파일)
 *   java.net / java.io / java.sql ==> 예외처리 
 *   예외처리  => 예외 / 에러 : 처리할 수 없는 에러(메모리가 부족)
 *            -----
 *            소스상에서 처리할 수 있는 에러(가벼눈 에러)  => MySql 주소 문제 , ip , 파일명 
 *            나누기 / 0 
 *            예외처리 => 사전에 비정상 종료의 프로그램을 방지 => 정상적인 프로그램 유지
 *                      프로그램 제작 (1. 오류방지)
 *                       => 유효성 검사 (사용자 입력 , 프로그래머 실수)
 *                       => 1. CheckException : 컴파일시에 (javac) ==> 반드시 예외처리 필수 
 *                       => 2. UnCheckException  : 실행시 (java)  ==> 생략이 가능 
 *                             ----------------- 
 *   ------
 *    예외복구 (*****)
 *      try
 *      {
 *          정성적으로 처리문장 => 에러시에 catch절을 찾는다 
 *      }catch(예외처리 종류)
 *      {
 *          예외 발생시에 복구 ,예외메세지 확인 
 *      }  
 *    예외회피
 *      method() throws 예외처리클래스 .... : 시스템에 에러가 발생할 수 있다 알려준다 
 *     
 *           1. 예외처리 => 클래스의 계층구조 
 *                  자바 => 모든 클래스 (Object 상속) 
 *                           Object
 *                             |
 *                           Throwable
 *                             |
 *                     -----------------------
 *                     |                     |
 *                   Error (에러)        Exception (예외)
 *                                          |
 *                                 -----------------------------
 *                                 | (CheckException)          |(UnCheckExeption)
 *                              IOException (파일입출력)       RuntimeException
 *                              SQLException(DB연동)            |
  *                              ClassNotFoundException      ArrayIndexOutOfBoundException     | 위로 올라갈 수록 에러처리 범위가 크다 
 *                              MalFormedURLException        NUllPointerException...
 *                              
 */
public class MainClass3 {
    //MySql연결 => 메소드 
	//결과값이 없는 경우(메소드안에서 자체처리) => void
	public static void mySqlConnect()
	{
		try
		{
			//1. 드라이버 등록 
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. MYSQL연결 
			String url="jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
			Connection conn=DriverManager.getConnection(url,"root","happy");
			//3.SQL문장 
			String sql="SELECT * FROM member";
			//4.SQL문장을 MySql로 전송 
			PreparedStatement ps=conn.prepareStatement(sql); 
			//5.실행후에 결과값을 받는다 
			ResultSet rs=ps.executeQuery();//rs가 결과값을 가지고 있다 
			/*
			 *    1   aaa  2022-02-19 4.5
			 *    getInt(1) 1
			 *    getString(2)  aaa
			 *    getDate(3) 2022-02-19
			 *    getDouble(4) 4.5
			 */
			while(rs.next())
			{
				// 한줄씩 => 데이터 while문 한번에 => 데이터를 5개 읽는다 
				System.out.println(rs.getInt(1)+" "
						+rs.getString(2)+" "
						+rs.getString(3)+" "
						+rs.getString(4)+" "
						+rs.getString(5));
			}
			rs.close();
			ps.close();
			conn.close();
		}catch(Exception ex)
		{
			// 에러 메세지 
			/*
			 *   getMessage() ===> 에러메세지만 출력 
			 *   printStackTrace() ==> 실행하는 과정 => 에러위치를 확인 할 수 있다 
			 */
			ex.printStackTrace();
			//System.out.println(ex.getMessage());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 메소드 호출 
		mySqlConnect();
	}

}
