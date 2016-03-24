package com.madhosue.java8.lambda;

import java.util.stream.IntStream;

import org.junit.Test;

public class Lambda3 {
	@Test
	public void test1(){
		/**
		 * 方法引用(::)
		 * 	1.静态方法引用
		 * 	2.构造方法引用
		 * 	3.普通方法引用
		 */
		SayHello say = Person::sayHello;//静态方法引用
		say.say("tom");//Hello,tom
		
		PersonFactory<Person> factory = Person::new;//构造方法引用
		Person person = factory.create(10, "xiaoming");
		System.out.println(person);//Person [age=10, name=xiaoming]
		
		SayHello  setName = person::setName;//普通方法引用
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

