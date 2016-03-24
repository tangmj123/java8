package com.madhosue.java8.others;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.stream.Stream;

import org.junit.Test;

public class AnnotationTest {

	@Test
	public void test(){
		Auth annotation = A.class.getAnnotation(Auth.class);
		System.out.println(annotation);
		
		
		Auths annotations = A.class.getAnnotation(Auths.class);
		Stream.of(annotations.value()).forEach(auth->System.out.println(auth.value()));
		
		Auth[] annotationsByType = A.class.getAnnotationsByType(Auth.class);
		Stream.of(annotationsByType).forEach(auth->System.out.println(auth.value()));
	}
}
@Repeatable(value = Auths.class)
@Retention(RetentionPolicy.RUNTIME)
@interface Auth{
	String value();
}
@Retention(RetentionPolicy.RUNTIME)
@interface Auths{
	Auth[] value();
}

@Auth("first")
@Auth("second")
class A{
	
}