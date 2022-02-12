package com.it.main;
// 비교연산자 / 논리연산자 / 대입연산자 
// 부정연산자,비교연산자,논리연산자 => 결과값 (boolean) : true/false => 조건문에서 주로 사용 
// if()
// 비교연산자 : ==(같다) , !=(같지 않다) , < (작다) , >(크다) <=(작거나 같다) , >=(크거나 같다)
// 숫자 비교 가능 (문자열은 비교(X)) => id=="admin" => 문자열 자체가 주소 
// 논리연산자 (&&=>기간이나 범위에 포함  , ||=> 범위를 벗어난 경우)
import java.util.*;// 클래스 읽어오기 => Collection,Scanner, Date ...
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        boolean bCheck=10==9;
        System.out.println(bCheck);//false
        bCheck=10!=9; 
        System.out.println(bCheck);//true
        bCheck=10<9;//false
        System.out.println(bCheck);
        bCheck=10>9;//true
        System.out.println(bCheck);
        bCheck=10<=9;//false ==>  10<9 || 10==9
        System.out.println(bCheck);
        bCheck=10>=9;//true  ==> 10>9 || 10==9
        System.out.println(bCheck);
        
        // 논리연산자 
        /*
         *   ========================================
         *         직렬                                   병렬
         *      (조건) && (조건)      (조건) || (조건)
         *      -----               -----
         *                           true면 다음 조건을 수행하지 않는다 => 효율적 연산
         *       false면 다음 조건은 수행하지 않는다
         *   ========================================
         *       true    true        true    true
         *           true                 true
         *   ========================================
         *       true    false       true    false
         *           false                true
         *   ========================================
         *       false   true        false   true 
         *           false                true
         *   ========================================
         *       false   false       false   false 
         *           false              false    
         *   ========================================
         *   
         *   && => 범위 포함 
         *   || => 범위를 벗어 났을때 처리 
         */
        char c='K';
        bCheck = c>='A' && c<='Z'; // char => 연산처리되면 정수으로 변경 된다 
        //       c>='a' && c<'z';  c>='가' && <='힣'
        System.out.println(bCheck);
        /*
         *    score>=90 && score<=100 => A
         *      score>=90 && score<=95   A0
         */
        int score=101;
        bCheck = c<0 || c>100;
        System.out.println(bCheck);
        
        /*Scanner scan=new Scanner(System.in);
        // System.in (키보드 입력값 받기) 
        // BufferedReader => 예외처리 
        System.out.print("ID입력:");
        String id=scan.next();
        System.out.print("Password입력:");
        String pw=scan.next();
        
        if(id.equals("admin") && pw.equals("1234"))
        {
        	System.out.println("로그인되었습니다");
        }
        else
        	System.out.println("ID나 비밀번호가 틀립니다");*/
        // 대입연산자  ( = , += , -=)
        int aaa=10; // 10을 aaa라는 메모리에 대입
        aaa=10+20;
        int bbb=10;
        // bbb를 한개증가 
        bbb++;//++bbb
        bbb=bbb+1;
        bbb+=1;//bbb=bbb+1;
        bbb+=5; // bbb++ bbb++ bbb++ bbb++ bbb++ => 5증가 
        // bbb=bbb+5 => 복합대입연산자 
        bbb-=10; // bbb=bbb-10
	}

}


