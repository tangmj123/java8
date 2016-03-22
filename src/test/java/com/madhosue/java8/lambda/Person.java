package com.madhosue.java8.lambda;

public class Person {

	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Person(){
		
	}
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	static void sayHello(String name){
		System.out.println("Hello,"+name);
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	
}
