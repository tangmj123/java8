package com.madhosue.java8.lambda;

import java.util.function.Function;

import org.junit.Test;

public class Lambda5 {

	/**
	 * lambda 域的生命周期和匿名函数一致
	 */
	static int staticOuter;
	int outer;
	@Test
	public void test(){
		int inner;
		
		Function<String, Integer> function = s->{
													staticOuter = 100;
													outer = 100;
//													inner = 100;//报错，必须是final的（因为inner的生命周期和function的生命周期不一致）
													return Integer.parseInt(s);
												};
	   function.apply("1265");
	   
	   Runnable runaRunnable = new Runnable() {
		
		public void run() {
			staticOuter = 200;
			outer = 200;
//			inner = 200;//报错
		}
	  };
	}
}
