package com.madhosue.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class Lambda1 {

	/**
	 * Lambda:
	 * 	1.lambda�������ö��ŷָ��Ĳ����б��C>�����뺯���������ֱ�ʾ 
	 * 	2.lambda����Ѻ�����Ϊһ�������Ĳ�����������Ϊ�������ݽ������У������߰Ѵ��뿴������
	 */
	@Test
	public void test1(){
		/**
		 * ����Ա�
		 */
		
		List<String> cities = Arrays.asList("hanzhong","xian","shanxi","qinpu","shanghai");
		//ʹ��������
		Collections.sort(cities, new Comparator<String>() {

			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println(cities);
		
		//ʹ��lambda
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
