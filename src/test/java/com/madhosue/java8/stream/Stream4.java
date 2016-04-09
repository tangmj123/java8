package com.madhosue.java8.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class Stream4 {

	//how to join arrays
	
	//use apache commons lang-arrayUitls
	@Test
	public void test1(){
		String[] s1 = {"1","2","3"};
		String[] s2 = {"4","5","6"};
		
		String[] result = ArrayUtils.addAll(s1, s2);
		System.out.println(ArrayUtils.toString(result));
	}
	//use java api
	@Test
	public void test2(){
		String[] s1 = {"1","2","3"};
		String[] s2 = {"4","5","6"};
		String[] result = joinArray(s1,s2);
		System.out.println(Arrays.toString(result));
	}
	
	public <T> T[] joinArray(T[]...arrays){
		int length = 0;
		for (T[] t : arrays) {
			length += t.length;
		}
		final T[] array = (T[]) Array.newInstance(arrays[0].getClass().getComponentType(), length);
		
		int offset = 0;
		for (T[] t : arrays) {
//			System.arraycopy(array, 0, result, offset, array.length);
			System.arraycopy(t, 0,array , offset, t.length);
			offset += t.length;
		}
		return array;
	} 
	
	//use java8 stream
	@Test
	public void test3(){
		String[] s1 = {"1s","2","3"};
		String[] s2 = {"4","5","6"};
		String[] array = Stream.of(s1,s2)
//			.flatMap(Stream::of)
			.flatMap(arr->Stream.of(arr))
			.toArray(String[]::new);
		System.out.println(Arrays.toString(array));
	}
}
