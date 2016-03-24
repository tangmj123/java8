package com.madhosue.java8.stream;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.Test;

public class Stream3 {

	/**
	 * IntStream  LongStream DoubleStream
	 */
	@Test
	public void test(){
		double average = IntStream.of(1,2,3,4,5).average().getAsDouble();
		System.out.println(average);
		average = LongStream.of(1l,2l,3l,4l,5l).average().getAsDouble();
		System.out.println(average);
		average = DoubleStream.of(1.0,2.5,3.5,4,5).average().getAsDouble();
		System.out.println(average);
	}
}
