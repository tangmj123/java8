package com.madhosue.java8.lambda;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

import org.junit.Test;

public class Lambda2 {

	/**
	 * ����ʽ�ӿ�
	 * 	1.��@FunctionalInterface��ʾ 
	 * 	2.ֻ����һ��δʵ�ֵķ���������Ĭ�Ϸ����;�̬������
	 * 	3.lambda��Ŀ�����͵�Ҫ��
	 *	    T��һ������ʽ�ӿ�
	 *	    lambda���ʽ�Ĳ�����T�ķ���������������������һһ��Ӧ
	 *	    lambda���ʽ�ķ���ֵ��T�ķ�������ֵ����ݣ�Compatible��
	 *	    lambda���ʽ�����׳����쳣��T�ķ���throws���������
	 *
	 *
	 *  java8 �����ļ�������ʽ�ӿ�
	 *  	Predicate<T> ����T����boolean
	 *  	Consumer<T> ����T������
	 *  	Function<T, R> ����T����R
	 *  	Supplier<T> �����ܲ�������T
	 *  	UnaryOperator<T> ����T����T
	 *  	BinaryOperator<T>��������T����һ��T
	 */
	
	@Test
	public void test1(){
		/**
		 * ÿһ��lambda���ʽ��һ��һ������ʽ�ӿ�
		 * 	string->integer
		 */
		Convert<String,Integer> convert = f->Integer.parseInt(f);
		//convert = Integer::parseInt;
		int result = convert.convert("123");
		System.out.println(result);
		
		//ͬ����lambda���ʽ�ڲ�ͬ�������Ļ����У�Ŀ�����Ͳ�һ��
		Convert2<String,Integer> convert2 = f->Integer.parseInt(f);
		
		Callable<Person> callable = ()->new Person();
		Supplier<Person> supplier =  ()->new Person();
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
	/**
	 * ΪʲôҪ��Ĭ�Ͻӿڣ�
	 * 	
	 */
}
interface Convert3<F,T>{
	T convert(F from);
	
}