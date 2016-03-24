package com.madhosue.java8.others;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StringTest {

	@Test
	public void testChars(){
		//字符串转变成Intstream
		String result = "abc,bcd,cde".chars()//IntStream
			.mapToObj(c->String.valueOf((char)c))
			.distinct()
			.sorted()
			.collect(Collectors.joining());
		System.out.println(result);//,abcde
	}
	@Test
	public void testSplit(){
		//用逗号风格字符串
		List<String> result = Pattern.compile(",")
			.splitAsStream("abc,bcd,cde")
			.collect(Collectors.toList());
		System.out.println(result);//[abc, bcd, cde]
	}
	
	@Test
	public void testPatternPredicate(){
		//Pattern当做预言
		String regex = "((\\d{11})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$)";
		Stream.of("18752136254","1225","15278956235","021-12345678")
			.filter(Pattern.compile(regex).asPredicate())
			.forEach(System.out::println);
//		18752136254
//		15278956235
//		021-12345678
		
	}
	@Test
	public void testJoin(){
		//字符串联接
		String str = String.join("#", "abc","def","ghi");
		System.out.println(str);//abc#def#ghi
	}
}
