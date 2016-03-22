package com.madhosue.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

public class Lambda4 {

	/**
	 * Predicate¡¢Function¡¢Supplier¡¢Consumer
	 */
	
	@Test
	public void testPredicate(){
		Predicate<String> predicate = s->s.length()>5;
		boolean predicated1 = predicate.test("abcde");
		boolean predicated2 = predicate.test("abcdef");
		System.out.println("predicated1:"+predicated1);
		System.out.println("predicated2:"+predicated2);
		
		Predicate<Object> isNull = Objects::isNull;
		isNull.test(new Object());
		
		Predicate<Object> nonNull = Objects::nonNull;
		
	}
	
	@Test
	public void testFunctions(){
		Function<String, Integer> function = s->Integer.valueOf(s);
		int result = function.apply("10000");
		System.out.println(result);
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
		consumer.accept(new Person(100, "tom"));
	}
	@Test
	public void testComparator(){
		Comparator<Person> personComparator = (p1,p2)->{
			return p1.getAge()-p1.getAge();};
		
		List<Person> persons = Arrays.asList(new Person(25,"KD"),
											 new Person(10,"KB"),
											 new Person(15,"LBJ")
											);
		persons.sort(personComparator);
	}
}
