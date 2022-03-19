package com.it.main;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

public class Sawon implements InitializingBean,BeanNameAware{
   private String name;
   private String sex;
   public Sawon()
   {
	   System.out.println("1. Sawon() Call..:객체 생성");
   }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("Sawon:name에 값을 주입..:"+name);
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
		System.out.println("Sawon:name에 값을 주입..:"+name);
	}
	public void init()
	{
		System.out.println("init() Call...:객체가 생성된 다음에 호출");
	}
	public void destroy()
	{
		System.out.println("destroy() Call...:객체가 소멸된 다음에 호출");
	}
	public void useCall()
	{
		System.out.println("사용자가 호출하는 메소드:");
		System.out.println("name:"+name);
		System.out.println("sex:"+sex);
	}
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("getBean()");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("setterDI완료시에 호출..");
	}
   
}
