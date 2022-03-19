package com.it.main;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        GenericXmlApplicationContext app=
        		new GenericXmlApplicationContext("app2.xml");
        Sawon sa=(Sawon)app.getBean("sa");
        // Sawon sa=new Sawon() => name/sex(X)
        System.out.println("sa="+sa);
        sa.useCall();
        
        Sawon sa1=(Sawon)app.getBean("sa");
        System.out.println("sa1="+sa1);
        // Sawon sa=new Sawon() => name/sex(X)
        sa.useCall();
        app.close();
        
        
	}

}
