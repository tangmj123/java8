package com.madhosue.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

public class Lambda4 {

	/**
	 * Predicate、Function、Supplier、Consumer、Runnable、Callable
	 */
	
	@Test
	public void testPredicate(){
		//圓冱
		Predicate<String> predicate = s->s.length()>5;
		boolean predicated1 = predicate.test("abcde");
		boolean predicated2 = predicate.test("abcdef");
		System.out.println("predicated1:"+predicated1);//false
		System.out.println("predicated2:"+predicated2);//true
		
		Predicate<Object> isNull = Objects::isNull;
		isNull.test(new Object());
		
		Predicate<Object> nonNull = Objects::nonNull;
		
	}
	
	@Test
	public void testFunctions(){
		Function<String, Integer> function = s->Integer.valueOf(s);
		int result = function.apply("10000");
		System.out.println(result);//10000
	}
	
	@Test
	public void testSupplier(){
		Supplier<Person> supplier = Person::new;
		Person person = supplier.get();
		System.out.println(person);
	}
	@Test
	public void testConsumer(){
		Consumer<Person> consumer = p->System.out.println(p);
		consumer.accept(new Person(100, "tom"));//Person [age=100, name=tom]
	}
	@Test
	public void testComparator(){
		Comparator<Person> personComparator = (p1,p2)->{
			return p1.getAge()-p2.getAge();};
		
		List<Person> persons = Arrays.asList(new Person(25,"KD"),
											 new Person(10,"KB"),
											 new Person(15,"LBJ")
											);
		persons.sort(personComparator);
		System.out.println(persons);
		//[Person [age=10, name=KB], Person [age=15, name=LBJ], Person [age=25, name=KD]]
	}
	@Test
	public void testRunnable(){
		Runnable runnable = ()->System.out.println("run");
		new Thread(runnable).start();//run
	}
	
	@Test
	public void testCallable() throws Exception{
		Callable<UUID> callable = UUID::randomUUID;
		UUID uuid = callable.call();
		System.out.println(uuid);//7ee07e2a-40a7-470d-98c5-99c5eaa556ae
	}
}
