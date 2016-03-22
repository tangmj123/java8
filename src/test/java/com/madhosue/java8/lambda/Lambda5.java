package com.madhosue.java8.lambda;

import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

public class Lambda5 {

	/**
	 * lambda
	 */
	static int staticOuter;
	int outer;
	@Test
	public void test(){
		int inner;
		
		Function<String, Integer> function = s->{
													staticOuter = 100;
													outer = 100;
//													inner = 100;//±¨´í
													return Integer.parseInt(s);
												};
	   function.apply("1265");
	}
}
