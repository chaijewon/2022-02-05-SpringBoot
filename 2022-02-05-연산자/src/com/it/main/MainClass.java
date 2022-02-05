package com.it.main;

public class MainClass {
   // 프로그램에 필요한 변수 설정 위치 (멤버변수) => 프로그램 종료시까지 메모리에 유지 
   /*
    *   멤버변수 : 객체마다 따라 사용하는 변수 => 인스턴스 변수 
    *           한개를 가지고 공유하는 변수  => static (메모리 공간 1개)
    *       => 자동 초기화 
    *           int => 0
    *           double => 0.0
    *           boolean => false
    *           클래스 => null
    *           
    *   지역변수 : 메소드안에서만 사용 
    *            지역변수 / 매개변수
    *            => 사용시에는 반드시 초기화후 사용  
    *   변수 : 한개의 데이터를 저장하는 메모리 공간 
    *        변수 선언방식 
    *        1) 선언 
    *        2) 값 주입 
    *        ---------
    *         int a;
    *         a=100;
    *         
    *        선언과 동시에 값 주입 (*****)
    *        int a=100;
    *        
    *        여러개 동시 선언 
    *        int a;
    *        int b;
    *        int c; 
    *        
    *        => int a,b,c;
    *        
    *        int a=10;
    *        int b=20;
    *        int c=30;
    *        
    *        => int a=10,b=20,c=30;
    *        
    *        int a=10;
    *        int b=10;
    *        int c=10;
    *        => int a,b,c;
    *        a=b=c=10;
    *        
    */
   public static void main(String[] args) {
	  // 데이터 저장 => 정수, 10을 저장 
	   int a=10;//지역변수 
	   System.out.println("a="+a);
	   double d=100;// int , float , char
	   /*
	    *  double d='A';
	    *           ---
	    *           double 변경 => 65.0
	    *  double d=100;
	    *           ---
	    *           100.0
	    */
	   System.out.println("d="+d);
	   int c='A';
	   System.out.println("c="+c);
	   
	   int aa=(int)10.5;// 강제형변환 => 소수점 제거 
	   System.out.println("aa="+aa);
	   byte bb=(byte)300; //127
	   System.out.println("bb="+bb);
	   long ccc=21400000000L; // 숫자 => 자동으로 int 
	   float f=10.7f;
	   //      double
	   // => 웹 (정수,실수(X)) => 문자열 
   }// a는 사라진다 
   // 멤버변수 
}








