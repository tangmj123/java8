package com.madhosue.java8.lambda;

import java.util.stream.IntStream;

import org.junit.Test;

public class Lambda3 {
	@Test
	public void test3(){
		/**
		 * ��������(::)
		 * 	1.��̬��������
		 * 	2.���췽������
		 * 	3.��ͨ��������
		 */
		SayHello say = Person::sayHello;
		say.say("tom");
		
		PersonFactory<Person> factory = Person::new;
		Person person = factory.create(10, "xiaoming");
		System.out.println(person);
		
		SayHello  setName = person::setName;
		setName.say("xiaohong");
		System.out.println(person);
	}
	
	@Test
	public void test2(){
		IntStream.range(0, 100)
			.forEach(System.out::println);
	}
}
@FunctionalInterface
interface SayHello{
	void say(String name);
}
@FunctionalInterface
interface PersonFactory<P extends Person>{
	P create(int age,String name);
}

