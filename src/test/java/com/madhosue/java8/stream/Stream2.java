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
		//ͳ��list��������Щ��ĸ
		list.stream()
			.flatMap(s->s.chars().mapToObj(i->(char)i))//��ÿһ��Ԫ�ر�ƽ�����µ�stream
			.distinct()
			.forEach(System.out::println);
			
	}
	@Test
	public void testFlatMap2(){
		//��ƽ������
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
		//��stream����ַ���
		String collect = Stream.of("a","b","c","d")
			.collect(Collectors.joining());
		System.out.println(collect);	
	}
	@Test
	public void testCollect2(){
		//�á�#����Ԫ����������
		String collect = list.stream()
			.collect(Collectors.joining("#"));
		System.out.println(collect);
	}
	@Test
	public void testCollect3(){
		//�á�#����Ԫ��������������ǰ��׺
		String collect = list.stream()
			.collect(Collectors.joining("#","prefix","subfix"));
		System.out.println(collect);
	}
	@Test
	public void testCollect4(){
		//���������
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
		//����ƽ������
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
		//��&����������������
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(18,"tom"));
		persons.add(new Person(10,"jin"));
		persons.add(new Person(25,"lucy"));
		persons.add(new Person(60,"green"));
		
		StringJoiner collect = persons.stream()
			.collect(()->new StringJoiner("&"), 
					(sj,p)->sj.add(p.getName()), 
					(a,b)->{//�ڴ����������ﲢ��ִ��													
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
			.collect(Collectors.collectingAndThen(Collectors.averagingInt(p->((Person) p).getAge()),d->"ƽ�������ǣ�"+d));
		System.out.println(result);//ƽ�������ǣ�28.25
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
//				break;//����ʹ��
//				continue;//����ʹ��
				;
		});
	}
	
}
