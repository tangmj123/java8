package com.madhosue.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class Lambda1 {

	/**
	 * Lambda:
	 * 	1.lambda可以由用逗号分隔的参数列表、–>符号与函数体三部分表示 
	 * 	2.lambda允许把函数作为一个方法的参数（函数作为参数传递进方法中），或者把代码看成数据
	 */
	@Test
	public void test1(){
		/**
		 * 排序对比
		 */
		
		List<String> cities = Arrays.asList("hanzhong","xian","shanxi","qinpu","shanghai");
		//使用匿名类
		Collections.sort(cities, new Comparator<String>() {

			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println(cities);
		
		//使用lambda
		Collections.sort(cities, (a,b)->a.compareTo(b));
		System.out.println(cities);
		
//		Collections.sort(cities, (String a,String b)->a.compareTo(b));
		
//		Collections.sort(cities, (String a,String b)->{return a.compareTo(b);});
	}
	@Test
	public void test2(){
		List<String> cities = Arrays.asList("hanzhong","xian","shanxi","qinpu","shanghai");
		cities.sort(Collections.reverseOrder());
		System.out.println(cities);
	}
}
