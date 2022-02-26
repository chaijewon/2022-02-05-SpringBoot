package com.it.main;
// 자료구조 (데이터를 모아서 관리) => 컬렉션 (가변형)
/*
 *          Collection 
 *             |
 *     ------------------------
 *     |                      |      Map => HashMap (request,response,session,cookie)
 *                                                 
 *   List                   Set  => 인터페이스 (구현이 안된 메소드) => 여러개의 클래스를 모아서 관리 
 *     |                      |
 *  ----------            HashSet
 *  |    |   |
 *  ArrayList Vector LinkedList 
 *  ----------
 *     1. 데이터 추가 
 *        add() , add(int index)=>원하는 위치에 추가 
 *        ---- 마지막에 추가 
 *     2. 데이터 변경 set()
 *     3. 데이터 삭제 remove()
 *     4. 데이터 읽기 get()
 *     5. 데이터 저장 갯수 size()
 *     6. 전체 삭제  clear()
 */
import java.util.*; //import 생략 => java.lang은 생략이 가능  => #include(C/C++) , using(C#) ....
public class MainClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 데이터 추가 
		ArrayList list=new ArrayList();
		list.add("홍길동");//0
		list.add("심청이");//1
		list.add("박문수");//2
		/* 
		 *   홍길동 
		 *   심청이
		 *   박문수  
		 */
		for(int i=0;i<list.size();i++)
		{
			String name=(String)list.get(i);
			System.out.println(name);
		}
		list.add(1, "이순신");
		/*
		 *   홍길동 //0 
		 *   이순신 //1
		 *   심청이 //2
		 *   박문수 //3
		 */
		System.out.println("===========");
		for(int i=0;i<list.size();i++)
		{
			String name=(String)list.get(i);
			System.out.println(name);
		}
		System.out.println("===========");
		list.remove(2);
		for(int i=0;i<list.size();i++)
		{
			String name=(String)list.get(i);
			System.out.println(name);
		}
		/*
		 *   홍길동 //0 
		 *   이순신 //1
		 *   박문수 //2
		 */
		list.set(1, "강감찬");
		/*
		 *   홍길동 //0 
		 *   강감찬 //1
		 *   박문수 //2
		 */
		System.out.println("==========");
		for(int i=0;i<list.size();i++)
		{
			String name=(String)list.get(i);
			System.out.println(name);
		}
		/*
		 *  형변환 => upcasting , downcasting 
		 *  예)
		 *      double d=10;
		 *      ------   -- int 
		 *      
		 *      double d=10=>10.0
		 *      
		 *      int a='A';
		 *      ---   ---
		 *       4     2   ==> 2->4변경
		 *            --- 65 
		 *       a=65
		 *       
		 *       클래스의 형변환 (크기 설정 ==> is-a, has-a)
		 *                             ------ ------
		 *                              상속        포함 
		 *                              
		 *                 동물
		 *               -------
		 *                  |
		 *          ------------------
		 *          |       |        |
		 *        포유류      양서류           조류 
		 *          |
		 *      ----------
		 *      |    |   |
		 *     개      소      인간
		 *               |
		 *             ------
		 *             |    |
		 *            남자   여자 
		 *            
		 *     인간 = (인간)동물 ==> 동물에 해당되는 자바 클래스 (Object)
		 *     개 = 소(error)
		 */
		
	}

}










