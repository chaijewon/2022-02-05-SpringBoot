package com.it.main;
import java.io.*; // 예외처리  => Exception (사용자 입력 , 프로그래머의 실수) => 에러를 변경해서 수행(X)
/*
 *                     Throwable
 *                        |
 *                -----------------------
 *                |                     |
 *               Error               Exception     Error(수정할 수 없는 에러:메모리 부족, 이클립스문제 발생 ) Exception (가벼운 에러 , 소스상의 에러)
 *                                      |
 *                               ----------------------
 *                              checkException     uncheckexception  => checkexception(컴파일시에 검색) , uncheckexception(생략) 
 *                               |                    |
 *                             IOException(java.io)  RuntimeExcetion 
 *                             SQLException(java.sql)
 *                             MalformedURLException(java.net)
 *                             ClassNotFoundException  
 *                             
 *          예외처리 
 *          1) 예외복구 
 *             try
 *             {
 *                 정성적으로 수행하는 문장 
 *             }catch(예외 종류)
 *             {
 *                  에러 발생시에 복구,에러메세지 확인 
 *             }
 *             finally
 *             {
 *                  무조건 수행문장 => 생략 (데이터베이스 연결=>닫기,서버 닫기 , 파일 닫기)
 *             }
 *          2) 예외회피 (예외선언) => 라이브러브에서 제공 
 *             method() throws 예외처리 
 */
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	int i=0;
        	//String data="";
        	StringBuffer sb=new StringBuffer();
        	FileReader fr=new FileReader("d:\\weekdev\\new.txt");
        	while((i=fr.read())!=-1) // 한글자씩 읽기 (글자=>int) , -1:EOF(문장끝)
        	{
        		//data+=String.valueOf((char)i);
        		sb.append(String.valueOf((char)i));
        	}
        	System.out.println(sb.toString());
        }catch(Exception ex)
        {
        	System.out.println(ex.getMessage());// 에러 확인 
        }
	}

}









