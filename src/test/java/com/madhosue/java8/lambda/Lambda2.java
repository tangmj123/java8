package com.madhosue.java8.lambda;

import org.junit.Test;

public class Lambda2 {

	/**
	 * 函数式接口
	 * 	1.用@FunctionalInterface表示 
	 * 	2.只能有一个未实现的方法（除了默认方法和静态方法） 
	 */
	
	@Test
	public void test1(){
		/**
		 * 函数式接口与lambda的结合
		 * 	string->integer
		 */
		Convert<String,Integer> convert = f->Integer.parseInt(f);
		//convert = Integer::parseInt;
		int result = convert.convert("123");
		System.out.println(result);
		
	}
	@Test
	public void test2(){
		/**
		 * integer->String
		 */
		Convert<Integer,String> convert = String::valueOf;
		convert.convert(100);
	}
}
@FunctionalInterface
interface Convert<F,T>{
	T convert(F from);//只能有一个
}
@FunctionalInterface
interface Convert2<F,T>{
	T convert(F from);
	
	default void defalultMethod(){
		System.out.println("default method");
	}
	static void staticMethod(){
		System.out.println("static method");
	}
}
interface Convert3<F,T>{
	T convert(F from);
	
}