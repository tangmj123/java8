package com.madhosue.java8.lambda;

import java.util.stream.IntStream;

import org.junit.Test;

public class Lambda3 {
	@Test
	public void test1(){
		/**
		 * ��������(::)
		 * 	1.��̬��������
		 * 	2.���췽������
		 * 	3.��ͨ��������
		 */
		SayHello say = Person::sayHello;//��̬��������
		say.say("tom");//Hello,tom
		
		PersonFactory<Person> factory = Person::new;//���췽������
		Person person = factory.create(10, "xiaoming");
		System.out.println(person);//Person [age=10, name=xiaoming]
		
		SayHello  setName = person::setName;//��ͨ��������
		setName.say("xiaohong");
		System.out.println(person);//Person [age=10, name=xiaohong]
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

