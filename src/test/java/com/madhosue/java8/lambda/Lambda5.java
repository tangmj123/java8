package com.madhosue.java8.lambda;

import java.util.function.Function;

import org.junit.Test;

public class Lambda5 {

	/**
	 * lambda ����������ں���������һ��
	 */
	static int staticOuter;
	int outer;
	@Test
	public void test(){
		int inner;
		
		Function<String, Integer> function = s->{
													staticOuter = 100;
													outer = 100;
//													inner = 100;//����������final�ģ���Ϊinner���������ں�function���������ڲ�һ�£�
													return Integer.parseInt(s);
												};
	   function.apply("1265");
	   
	   Runnable runaRunnable = new Runnable() {
		
		public void run() {
			staticOuter = 200;
			outer = 200;
//			inner = 200;//����
		}
	  };
	}
}
