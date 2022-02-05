package com.it.main;
// 단항연산자 
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 증감 연산자 (++,--) => 한개 증가 , 한개 감소 => 조회수,반복문 
		// 전치연산자 ++변수 , 후치연산자  변수++
		// 증가먼저 나중에 다른 연산 수행  ,  다른 연산자 수행 나중에 증가 
		int a=10;
		int b=++a; // a=11 , b=11
		System.out.println("a="+a+",b="+b);
		
		//초기화 
		a=10;
		b=a++;
		System.out.println("a="+a+",b="+b);
		
		char c='A';
		//System.out.println(c++);//c를 먼저 출력 => 나중에 증가 
		System.out.println(++c);
		System.out.println(--c);
		
		// 부정연산자 (!) => 반드시 boolean 사용 => 턴 
	    boolean bCheck=false;
	    // 예약일때  !예약일이 아니면 ==> 비활성화 
		/*
		 * while(true) { bCheck=!bCheck; if(bCheck==true) {
		 * System.out.println("사용자 차례"); } else { System.out.println("컴퓨터 차례"); } }
		 */
	    // 형변환 연산자 
	    int aa=(int)10.5;// 강제 형변환 
	    System.out.println(aa);
	    char cc='홍';
	    System.out.println((int)cc);
	    int aaa='A';
	    System.out.println(aaa);
		// int <==> double => boolean은 형변환이 없다 
	    aaa=97;
	    System.out.println((char)aaa);
	    System.out.println((int)'0');
	    /*
	     *  자바에서 숫자 표현 
	     *  문자 => '문자한개'
	     *  문자열 => "여러문자"
	     *  숫자 표현 :
	     *           10진법 
	     *           16진법 0xFF
	     *           8진법 012  ==> 08
	     *           2진법 0b0111111
	     */
	    System.out.println(012);
	    System.out.println(0xFF);
	    System.out.println(0b111111);// 0000000000000111111
	}

}
