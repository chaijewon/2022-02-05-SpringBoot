package com.it.main;
/*
 *   데이터 저장방법 
 *   -----------
 *     => 메모리
 *     단일 데이터 저장 
 *       변수 : 한개의 데이터가 저장된 메모리의 별칭
 *     다중 데이터 저장 
 *       배열 : 고정적 , 같은 데이터만 모아서 관리 
 *       ***클래스 : 다른 데이터를 모아서 관리 (사용자 정의 데이터형) => 구조체 
 *     ------------
 *     => 영구적 저장 장치 
 *     파일 
 *     RDBMS(MySQL)
 *     
 *     데이터 저장=>지정된 데이터형 (자료형,기본형) => 메모리 크기 
 *     ---------------------------------------------
 *     정수형 
 *       ***byte (8bit) => 1byte  (0,1을 8개 저장) ==> -128~127
 *          => 파일업로드 , 네트워크 데이터 전송 
 *       short (16bit) => 2byte -32768~32767 => C언어와 호환성
 *       ***int (32bit) => 4byte => 21억 4천 (default)
 *       ***long (64bit) => 8byte => 금융권 
 *     실수형
 *       float (4byte) => 소수점 6
 *       double (8byte) => 소수점 15 (default)
 *     문자형
 *       char (16bit) => 2byte (멀티바이트 => Unicode)
 *                       => 0~65535 (각 문자마다 번호)
 *                       'A' => 65 , 'a' => 97 , '0' => 48
 *                       ---------------------------------- 
 *                       String : 문자열 
 *     논리형
 *       boolean(8bit) => 1byte (true/false) => true(1) / false(0)
 *         => 메소드 : 경우의 수 (결과값 2)
 *         => 제어문의 대부분 (부정연산자 , 비교연산자 , 논리연산자)   
 *     참조형 : 클래스 ,배열 
 *           ------ String , Date , Number
 *       저장하는 공간 
 *       ----------
 *       --------------------------
 *         Method / static 
 *       --------------------------
 *         Stack ==> 메모리 자체 관리 ===> 지역변수 , 매개변수 => 블록 
 *       --------------------------
 *         Heap  ==> 멤버변수 (클래스안에 설정된 변수)
 *               ==> 프로그래머 (new=>int malloc(A)) , delete=>free(X) => gc
 *                   System.gc() => null , 사용하지 않는 경우 
 *       --------------------------
 *       Stack(메모리 주소)        Heap (실제 데이터 저장)
 *       
 *       A.java 
 *       
 *          A a=new A()    a.메소드   a=null System.gc() 
 *          
 *       변수 => 메모리 구분자 (중복X) => 식별자 
 *       사용법) 
 *             데이터(클래스|배열데이터) 변수명 
 *                                 -----
 *             int ()
 *             A ()
 *             int[] ()
 *             ===========
 *             식별자 (변수,메소드 , 인터페이스 ,배열 , 클래스) 
 *             1. 알파벳 , 한글로 시작한다 
 *                (단 알파벳은 대소문자 구분)  a != A
 *             2. 숫자 사용이 가능 (앞에 사용 금지)
 *                a1 , a2.... a1b
 *             3. 특수문자 ($ , _) => _는 단어가 두개이상일때 
 *                                 _A (임시)
 *             4. 키워드는 사용 금지 
 *             
 *             => 자바개발자의 약속 
 *                클래스는 대문자 시작 
 *                변수,메소드 => 소문자 시작 
 *                상수 => 전체 대문자 
 *             => 변수 => i,j를 사용하지 않는다 
 *                      m,n , a,b 
 *             --------   
 *             변수 
 *             연산자
 *             제어문 
 *             -------- 메소드 
 *             
 *             변수 선언 
 *             -------
 *             데이터형 변수명 
 *             실수 => 데이터 
 *             double d;
 *             정수 => 데이터 
 *             int i;
 *             
 *             *** int / long 
 *                 ----------- L(l)
 *             *** float / double
 *                 -------------- F(f)
 *             *** 형변환
 *                 UPCasting => int => double
 *                 DownCasting => int => char
 *                 --------------------------- 
 *                 10.5+10 => (X) => 연산은 같은 데이터형만
 *                      ==
 *                      10.0
 *                 10.5+10.0 ==> 20.5
 *                 
 *                 int이하는 (byte,short,char) => 연산하면 => 결과값은 int
 */
class A
{
	// 생성자 => 변수의 초기값 
	public A()
	{
		System.out.println("A객체 생성");
	}
	public void display()
	{
		System.out.println("A:display Call...");
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("A객체 메모리에서 삭제");
	}
	
}
public class MainClass {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		a.display();
		a=null;
		System.gc();
	}

}
