package com.it.main;
/*
 *   데이터 가공 : 연산자 / 제어문 
 *     연산자 
 *       => 단항연산자
 *          = 증감연산자 (++,--)
 *            a++(다른 연산처리후에 증가) , ++a(증가후에 다른 연산사용)
 *            int a=10;
 *            int b = a++;
 *                 --- --- b=10, a=11
 *            int b = ++a
 *                 -- --
 *                     1
 *                  2      b=11 , a=11
 *                  
 *            int a=10;
 *                 10   +1 11    13 
 *            int b=a++ + a++ + ++a + ++a
 *                  10    11    13    14
 *                  --------------------- => 48
 *          = 부정연산자 (!) => boolean만 사용이 가능  !true=false
 *          = 형변환연산자 (type) => (int)10.5 = 10
 *            byte < char  < int < long < float < double
 *                   short
 *            클래스 크기 : is-a(상속) , has-a(포함)
 *       => 이항연산자
 *          = 산술연산자 ( + , - , * , / , % )
 *                     ---------- 형변환 
 *                     / => 0으로 나눌 수 없다
 *                       => 정수/정수=정수 ==> 5/2 = 2
 *                     % =>앞에부호가 남는다 
 *                     5%2 ==> 1
 *                     -5%2 ==> -1
 *                     -5%-2 ==> -1
 *                     5%-2 ==> 1
 *          = 비교연산자 ( == , != , < , > , <= , >=)
 *                     --- MYSQL , JavaScript(===,==)
 *                        ------ (=)
 *          = 논리연산자 ( && , || )
 *              => 효율적인 연산처리 
 *              int a=10;
 *              int b=9;
 *              (a<b) && (++b==a)
 *              -----    --------   
 *               false      X     => a=10, b=9
 *               
 *              (a>b) || (++b==a)
 *              -----    --------
 *              true        X
 *          = 대입연산자 : = , += , -= , op=  (비트연산자/쉬프트연산자) 
 *       => 삼항연산자 ==> if~else => 게임 , 웹 
 *          (조건) ? 값1:값2
 *          ==== true => 값1
 *          ==== false => 값2
 *          
 *        언어 : 변수 , 연산자 , 제어문 
 *             ------------------ 메소드 => 클래스 => 패키지 => 프로그램완료
 *             ------------------ 오류방지 프로그램 (사용자 입력 , 프로그래머 실수)
 *                                예외처리 
 *                                라이브러리 (필요시에 변경해서 사용)
 *                                ** 오버라이딩 프로그램 
 *       
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10;
		int b=a++ + a++ + ++a + ++a;
		System.out.println("a="+a);
		System.out.println("b="+b);
	}

}
