package com.madhosue.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.madhosue.java8.lambda.Person;

public class Stream2 {
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
	public void testFlatMap(){
		//统计list中用了哪些字母
		list.stream()
			.flatMap(s->s.chars().mapToObj(i->(char)i))//将每一个元素扁平化成新的stream
			.distinct()
			.forEach(System.out::println);
			
	}
	@Test
	public void testFlatMap2(){
		//扁平化处理
		Stream<List<Integer>> stream = Stream.of(
				 	Arrays.asList(1),
				 	Arrays.asList(2, 3),
				 	Arrays.asList(4, 5, 6)
				 );
		stream.flatMap((childList) -> childList.stream())
			  .forEach(System.out::println);
		
	}
	@Test
	public void testCollect1(){
		//将stream变成字符串
		String collect = Stream.of("a","b","c","d")
			.collect(Collectors.joining());
		System.out.println(collect);	
	}
	@Test
	public void testCollect2(){
		//用“#”把元素连接起来
		String collect = list.stream()
			.collect(Collectors.joining("#"));
		System.out.println(collect);
	}
	@Test
	public void testCollect3(){
		//用“#”把元素连接起来，带前后缀
		String collect = list.stream()
			.collect(Collectors.joining("#","prefix","subfix"));
		System.out.println(collect);
	}
	@Test
	public void testCollect4(){
		//按年龄分组
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(18,"tom"));
		persons.add(new Person(10,"jin"));
		persons.add(new Person(25,"lucy"));
		persons.add(new Person(60,"green"));
		
		Map<Boolean, List<Person>> collect = persons.stream()
			.collect(Collectors.groupingBy(p->p.getAge()>=18));
		System.out.println(collect);
	}
	@Test
	public void testCollect5(){
		//计算平均年龄
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(18,"tom"));
		persons.add(new Person(10,"jin"));
		persons.add(new Person(25,"lucy"));
		persons.add(new Person(60,"green"));
		
		
		Double collect = persons.stream()
			.collect(Collectors.averagingInt(p->p.getAge()));
		System.out.println(collect);
		
	}
	@Test
	public void testCollect6(){
		//用&将人名字联接起来
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(18,"tom"));
		persons.add(new Person(10,"jin"));
		persons.add(new Person(25,"lucy"));
		persons.add(new Person(60,"green"));
		
		StringJoiner collect = persons.stream()
			.collect(()->new StringJoiner("&"), 
					(sj,p)->sj.add(p.getName()), 
					(a,b)->{//在串行流中这里并不执行													
						System.out.println("========");
						a.merge(b);
						}
					);
//		StringJoiner collect = persons.parallelStream()
//				.collect(()->new StringJoiner("&"), 
//						(sj,p)->sj.add(p.getName()), 
//						(a,b)->{													
//							System.out.println("========");
//							a.merge(b);
//							}
//						);
		System.out.println(collect);
	}
	
	@Test
	public void test6(){
		//Collectors.collectingAndThen
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(18,"tom"));
		persons.add(new Person(10,"jin"));
		persons.add(new Person(25,"lucy"));
		persons.add(new Person(60,"green"));
		
		String result = persons.stream()
			.collect(Collectors.collectingAndThen(Collectors.averagingInt(p->((Person) p).getAge()),d->"平均年龄是："+d));
		System.out.println(result);//平均年龄是：28.25
	}
	
	@Test
	public void test7(){
		//Collectors.mapping
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(18,"tom"));
		persons.add(new Person(10,"jin"));
		persons.add(new Person(25,"lucy"));
		persons.add(new Person(60,"green"));
		
		persons = persons.stream()
			.collect(Collectors.mapping(p->new Person(p.getAge()-5,p.getName()), Collectors.toList()));
		System.out.println(persons);
		//[Person [age=13, name=tom], Person [age=5, name=jin], Person [age=20, name=lucy], Person [age=55, name=green]]
	}
	
	@Test
	public void test8(){
		List<Person> persons = new ArrayList<Person>();
		persons.stream().forEach(p->{
			if("tom".equals(p.getName()))
//				break;//不能使用
//				continue;//不能使用
				;
		});
	}
	
}
