package com.imooc.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * 将要完成：
 * 1.通过Collections.sort()方法，对Integer泛型的List进行排序；
 * 2.对String泛型的List进行排序；
 * 3.对其他类型泛型的List进行排序，以Student为例。
 * @author 52837
 *
 */
public class CollectionsTest {

	/**
	 * 1.通过Collections.sort()方法，对Integer泛型的List进行排序；
	 * 创建一个Integer泛型的List，插入十个100以内的不重复随机整数，
	 * 调用Collection.sort()方法对其进行排序
	 * @param args
	 */
	public void testSort1() {
		List<Integer> integerList = new ArrayList<Integer>();
		//插入十个100以内的不重复随机整数
		Random random = new Random();
		Integer k;
		for(int i = 0; i < 10; i++) {
			do {
				k = random.nextInt(100);
			}while(integerList.contains(k));
			integerList.add(k);
			System.out.println("成功添加整数：" + k);
		}
		System.out.println("------------排序前-------------");
		for (Integer integer : integerList) {
			System.out.println("元素：" + integer);
		}
		System.out.println("------------排序后-------------");
		Collections.sort(integerList);
		for (Integer integer : integerList) {
			System.out.println("元素：" + integer);
		}
	}
	
	/**
	 *  2.对String泛型的List进行排序；
	 *  创建String泛型的List，添加三个乱序的String元素，
	 *  调用sort方法，再次输入排序后的顺序
	 * @param args
	 */
	public void testSort2() {
		List<String> stringList = new ArrayList<String>();
		stringList.add("microsoft");
		stringList.add("google");
		stringList.add("lenovo");
		System.out.println("-----------排序前-----------");
		for (String string : stringList) {
			System.out.println("元素：" + string);
		}
		Collections.sort(stringList);
		System.out.println("-----------排序后-----------");
		for (String string : stringList) {
			System.out.println("元素：" + string);
		}
	}
	
	/**
	 * 2.2对String泛型的List进行排序；
	 * 1.创建完List<String>之后，往其中添加十条随机字符串
	 * 2.每条字符串的长度为10以内的随机整数
	 * 3.每条字符串的每个字符都为随机生成的字符，字符可以重复
	 * 4.每条随机字符串不可重复
	 * @param args
	 */
	//length用户要求产生字符串的长度
	public static String getRandomString(int length) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < random.nextInt(length); i++) {
			int number = random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
	
	public void testSort2_2() {
		List<String> stringList = new ArrayList<String>();
		Random random = new Random();
		String st;
		for(int i = 0; i < 10; i++) {
			do {
				st = getRandomString(10);
			}while(stringList.contains(st));
			stringList.add(st);
			System.out.println("成功添加字符串：" + st);
		}
		System.out.println("-----------排序前-----------");
		for (String string : stringList) {
			System.out.println("元素：" + string);
		}
		Collections.sort(stringList);
		System.out.println("-----------排序后-----------");
		for (String string : stringList) {
			System.out.println("元素：" + string);
		}
	}	
	
	/**
	 * 3.对其他类型泛型的List进行排序，以Student为例。
	 * @param args
	 */
	public void testSort3() {
		List<Student> studentList = new ArrayList<Student>();
		Random random = new Random();

		for(int i = 0; i < 3; i++) {
			Student k = new Student();
			System.out.println("请输入学生姓名：");
			Scanner console = new Scanner(System.in);
			String name = console.next();
			do {
				k.id = random.nextInt(1000) + "";	
			}while(studentList.contains(k));
			k.name = name;
			studentList.add(k);
			System.out.println("成功添加学生：" + k.id + ":" + k.name);
		}
		System.out.println("-----------排序前----------");
		for (Student student : studentList) {
			System.out.println("学生：" + student.id + ":" + student.name);
		}
		Collections.sort(studentList);
		System.out.println("-----------排序前----------");
		for (Student student : studentList) {
			System.out.println("学生：" + student.id + ":" + student.name);
		}		
		Collections.sort(studentList, new StudentComparator());
		System.out.println("------按照名称排序后--------");
		for (Student student : studentList) {
			System.out.println("学生：" + student.id + ":" + student.name);
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionsTest ct = new CollectionsTest();
//		ct.testSort1();    //对Integer泛型的List进行排序
//		ct.testSort2();	   //对String泛型的List进行排序
//		ct.testSort2_2();  //随机生成指定长度内的字符串，对String泛型的List进行排序
		ct.testSort3();    //对其他类型泛型的List进行排序，以Student为例。 
	}

}
