package com.it.main;

import java.util.Arrays;

/*
 *    79 36 51 80 57  ==>  36 51 57 79 80 
 *                         80 79 57 51 36
 *    1. ASC => 선택정렬
 *       79 36 51 80 57
 *       == ==
 *       36 79
 *       ==    ==
 *       36    51
 *       ==       ==
 *       36       80
 *       ==          ==
 *       36          57
 *       36 79 51 80 57
 *       -------------------- 1round 
 *       36 79 51 80 57
 *          == ==
 *          51 79
 *          ==    ==
 *          51    80
 *          ==       ==
 *          51       57
 *       36 51 79 80 57
 *       --------------------- 2round
 *       36 51 79 80 57
 *             == == 
 *             79 80
 *             ==    ==
 *             57    79
 *       36 51 57 80 79
 *       --------------------- 3round
 *       36 51 57 80 79
 *                == ==
 *                79 80
 *       36 51 57 79 80
 *       ---------------------- 4round
 *       
 *    
 *    2. DESC => 버블 정렬 
 *    79 36 51 80 57
 *    == ==
 *    79 36
 *       == ==
 *       51 36
 *          == ==
 *          80 36
 *             == ==
 *             57 36
 *    79 51 80 57 36
 *    ------------------ 1round
 *    79 51 80 57 36
 *    == == 
 *    79 51
 *       == ==
 *       80 51
 *          == ==
 *          57 51
 *    79 80 57 51 36
 *    ------------------ 2round
 *    79 80 57 51 36
 *    == ==
 *    80 79
 *       == ==
 *       79 57
 *    80 79 57 51 36
 *    ------------------ 3round
 *    80 79 57 51 36
 *    == ==
 *    80 79 
 *    80 79 57 51 36
 *    -------------------4round  
 *    0 4
 *    1 3
 *    2 2
 *    3 1
 *    ====   j+i=4 ==> j=4-i
 */
public class MainClass2 {
    static void sort(int[] arr)
    {
    	for(int i=0;i<arr.length-1;i++)
        {
        	for(int j=i+1;j<arr.length;j++)
        	{
        		if(arr[i]>arr[j])
        		{
        			int temp=arr[i];
        			arr[i]=arr[j];
        			arr[j]=temp;
        		}
        	}
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr=new int[5]; // arr[0]~arr[4]
        // arr[0]~arr[4]=> 임의수를 대입 
        for(int i=0;i<arr.length;i++)
        {
        	arr[i]=(int)(Math.random()*100)+1;
        }
        // 저장된 값 출력 
        /*System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        for(int i:arr)
        {
        	System.out.print(i+" ");
        }
        System.out.println();
        for(int i=arr.length-1;i>=0;i--)
        {
        	System.out.print(arr[i]+" ");
        }*/
        System.out.println("정렬 전:");
        for(int i:arr)
        {
        	System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("정렬 후(ASC:선택정렬):");
        /*
         *   int a=10;
         *   int b=20;
         *   a=b;
         *   b=a; ==> 20
         *   
         *   int temp=a;
         *   a=b;
         *   b=temp;
         */
        for(int i=0;i<arr.length-1;i++)
        {
        	for(int j=i+1;j<arr.length;j++)
        	{
        		if(arr[i]>arr[j])
        		{
        			int temp=arr[i];
        			arr[i]=arr[j];
        			arr[j]=temp;
        		}
        	}
        }
        for(int i:arr)
        {
        	System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("정렬 후(DESC:버블정렬):");
        for(int i=0;i<arr.length-1-i;i++)
        {
        	for(int j=i;j<arr.length-1;j++)
        	{
        		if(arr[j]<arr[j+1])
        		{
        			int temp=arr[j];
        			arr[j]=arr[j+1];
        			arr[j+1]=temp;
        		}
        	}
        }
        for(int i:arr)
        {
        	System.out.print(i+" ");
        }
        // Arrays.sort(arr) => ASC
	}

}
