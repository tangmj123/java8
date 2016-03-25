package com.madhosue.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class Stream1 {
	/**
	 * stream
	 *  Intermediate、Terminal、Short-circuiting
	 *  Intermediate -> map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、 sequential、 unordered
	 *  Terminal ->orEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator
	 *  Short-circuiting -> anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit
	 */
	List<String> list = new ArrayList<String>();
	@Before
	public void initData(){
		list.add("abc");
		list.add("ddgds");
		list.add("dshj");
		list.add("Yjg");
		list.add("Dan");
		list.add("uDd");
		list.add("qlO");
		list.add("dfF");
		list.add("gaDgD");
		list.add("dgagaef");
		
	}
	
	@Test
	public void testFilter(){
		//filter 过滤出以大写字母开头的
		list.add(null);
		list.stream()
			.filter(Objects::nonNull)
			.filter(s->{
				if(Character.isLowerCase(s.charAt(0)))
					return true;
				else
					return false;
			})
			.forEach(System.out::println);
	}
	@Test
	public void testFilter2(){
		//filter 过滤出偶数
		Integer[] nums = {1, 2, 3, 4, 5, 6};
		Integer[] evens = Stream.of(nums)
					.filter(n -> n%2 == 0)
					.toArray(Integer[]::new);
		System.out.println(Arrays.toString(evens));
	}
	@Test
	public void testSort(){
		list.stream()
			.sorted()
//			.sorted((a,b)->a.compareTo(b))指定比较器
			.forEach(System.out::println);
	}
	
	@Test
	public void testMap(){
		//映射
		list.stream()
			.map(s->s.toUpperCase())
			.forEach(System.out::println);
	}
	
	@Test
	public void testMatch(){
		Stream<String> stream = list.stream();
		boolean anyMatch = stream
			.anyMatch(s->s.startsWith("a"));
//		 list.stream()
//		 	.allMatch(s->s.startsWith("a"));
//		list.stream()
//			.findAny();
//		list.stream()
//			.noneMatch(s->s.startsWith("a"))
	}
	@Test
	public void testCount(){
		//统计
		long count = list.stream()
				.filter(s->s.startsWith("a"))
				.count();
		System.out.println(count);
	}
	@Test
	public void testReduce(){
		//合并
		//计算list中所有字符串的总长度
		int size = list.stream()
			.map(s->s.length())
			.reduce((a,b)->a+b)
			.get();
		System.out.println(size);
		
		size = list.stream()
			.map(s->s.length())
			.reduce(1,(a,b)->a+b);
		System.out.println(size);
		
		size = list.stream()
				.parallel()
				.map(s->s.length())
				.reduce(1,
						(a,b)->a+b,
						(a,b)->a+b
				);
		System.out.println(size);
	}
	
	@Test
	public void testForEachOrdered(){
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		list.parallelStream()//并行流
		.forEach(System.out::println);//顺序不确定
		System.out.println("---------------------");
		list.parallelStream()//并行流
			.forEachOrdered(System.out::println);//顺序确定
		
	}
	@Test
	public void testOptational(){
		Optional<String> findFirst = list.stream()
			.filter(p->p.length()>3)
			.findFirst();
		if(findFirst.isPresent())
			System.out.println(findFirst.get());
		findFirst.ifPresent(System.out::println);
	}
}
