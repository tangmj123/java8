package com.madhosue.java8.lambda;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

import org.junit.Test;

public class Lambda2 {

	/**
	 * 函数式接口
	 * 	1.用@FunctionalInterface表示 
	 * 	2.只能有一个未实现的方法（除了默认方法和静态方法）
	 * 	3.lambda对目标类型的要求
	 *	    T是一个函数式接口
	 *	    lambda表达式的参数和T的方法参数在数量和类型上一一对应
	 *	    lambda表达式的返回值和T的方法返回值相兼容（Compatible）
	 *	    lambda表达式内所抛出的异常和T的方法throws类型相兼容
	 *
	 *
	 *  java8 新增的几个函数式接口
	 *  	Predicate<T> 接收T返回boolean
	 *  	Consumer<T> 接收T不返回
	 *  	Function<T, R> 接收T返回R
	 *  	Supplier<T> 不接受参数返回T
	 *  	UnaryOperator<T> 接收T返回T
	 *  	BinaryOperator<T>接收两个T返回一个T
	 */
	
	@Test
	public void test1(){
		/**
		 * 每一个lambda表达式对一个一个函数式接口
		 * 	string->integer
		 */
		Convert<String,Integer> convert = f->Integer.parseInt(f);
		//convert = Integer::parseInt;
		int result = convert.convert("123");
		System.out.println(result);
		
		//同样的lambda表达式在不同的上下文环境中，目标类型不一致
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
	/**
	 * 为什么要有默认接口？
	 * 	
	 */
}
interface Convert3<F,T>{
	T convert(F from);
	
}