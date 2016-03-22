package com.madhosue.java8.lambda;

import org.junit.Test;

public class Lambda2 {

	/**
	 * ����ʽ�ӿ�
	 * 	1.��@FunctionalInterface��ʾ 
	 * 	2.ֻ����һ��δʵ�ֵķ���������Ĭ�Ϸ����;�̬������ 
	 */
	
	@Test
	public void test1(){
		/**
		 * ����ʽ�ӿ���lambda�Ľ��
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
	T convert(F from);//ֻ����һ��
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