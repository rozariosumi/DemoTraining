package com.test;

import org.testng.annotations.Test;

public class ExceptionTimeoutTest {


	//How to terminate loop in the TestNg	
		
		/*@Test(invocationTimeOut=2)
		public void infiteloopTest() {
			int i=1;
			while(i==1) {
				System.out.println(i);
			}
		
		

	}*/
	//how to handle excepted exceptions in TestNg
		@Test(invocationTimeOut=2,expectedExceptions =NumberFormatException.class)
		public void Test1() {
			String x="1000A";
			Integer.parseInt(x);
			
		
		

	}
		

}
