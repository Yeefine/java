/* @16130110047 ÍõÒ»·² 528378795@qq.com */
package com.java;

import java.util.ArrayList;
import java.util.List;



public class CSS {
	Course course1 = new Course("Java");
	Course course2 = new Course("WebEngineering");
	Course course3 = new Course("C++");
	Course [] courses = {course1, course2, course3};
	Book book1 = new Book("Java", "Thinking in Java");
	Book book2 = new Book("Java", "Java 8");
	Book book3 = new Book("WebEngineering", "Web Engineering");
	Book book4 = new Book("C++", "Thinking in C++");
	Book book5 = new Book("C++", "C++ Program");
	Book [] Books = {book1, book2, book3, book4, book5};
	
	public CSS() {
		for(Course course : courses) {
			for (Book book : Books) {
				if(course.getName().equals(book.getType())) {
					course.classBooks.add(book);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int l = args.length;
		if(l == 1) {
			Student st = new Student(args[0]);
		}
		else if(l == 2) {
			Student st = new Student(args[0], args[1]);
		}else if(l > 2) {
			Student st = new Student(args);
		}
	}

}

class Book {
	private String type;
	private String name;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Book(String type, String name) {
		super();
		setType(type);
		setName(name);
	}
	
}

class Course {
	private String name;
	List <Book> classBooks = new ArrayList();
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	Course(String name) {
		super();
		this.name = name;
	}
	
	
}

class Student {
	CSS css = new CSS();
	private String stuNum;
	Student(String stuNum){
		this.stuNum = stuNum;
		System.out.println(stuNum + " select nothing with no book");
	}
	
	Student(String stuNum, String className){
		this.stuNum = stuNum;
		for (Course course : css.courses) {
			if(course.getName().equals(className)) {
				System.out.print(stuNum + " select " + course.getName() + " with ");
				for(int i = 0; i < course.classBooks.size(); i++) {
					if(i != course.classBooks.size() - 1) {
						System.out.print(course.classBooks.get(i).getName() + ", ");
					}else {
						System.out.println(course.classBooks.get(i).getName() + "; ");
					}
					
				}
				break;
			}
		}
		
	}
	
	Student(String[] ClassName){
		this.stuNum = ClassName[0];
		for (int j = 1; j < ClassName.length; j++) {
			String st = ClassName[j];
			for (Course course : css.courses) {
				if(course.getName().equals(st)) {
					System.out.print(stuNum + " select " + course.getName() + " with ");
					for(int i = 0; i < course.classBooks.size(); i++) {
						if(i != course.classBooks.size() - 1) {
							System.out.print(course.classBooks.get(i).getName() + ", ");
						}else {
							System.out.println(course.classBooks.get(i).getName() + "; ");
						}
						
					}
					break;
				}
			}
		}
	}
	
}
