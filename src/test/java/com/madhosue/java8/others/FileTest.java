package com.madhosue.java8.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class FileTest {

	@Test
	public void testWalk(){
		Path path = Paths.get("");
		try {
			Stream<Path> walk = Files.walk(path, 2);
			String collect = walk.map(String::valueOf)
					.filter(s->{
						boolean flag = s.endsWith(".txt");
						System.out.println("path="+s+"     "+flag);
						return flag;
					})
					.collect(Collectors.joining("||"));
			System.out.println("collect:"+collect);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFind(){
		Path path = Paths.get("");
		try {
			Files.find(path, 8, (p,ba)->String.valueOf(p).endsWith(".java"))
				.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testReader(){
		Path path = Paths.get("src\\test\\java\\com\\madhosue\\java8\\others\\FileTest.java");
		BufferedReader br = null;
		try {
			br = Files.newBufferedReader(path);
			br.lines()
				.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br!=null)
				try {br.close();} catch (IOException e) {e.printStackTrace();}
		}
		
//		try {
//			br = new BufferedReader(
//					new InputStreamReader(
//							new FileInputStream("src\\test\\java\\com\\madhosue\\java8\\others\\FileTest.java"),"utf-8"));
//			String line = null;
//			while((line =br.readLine())!=null){
//				System.out.println(line);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			if(br!=null)
//				try {br.close();} catch (IOException e) {e.printStackTrace();}
//		}
	}
}
