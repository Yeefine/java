/* @16130110047 王一凡 528378795@qq.com */
package com.IO.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/**
 * 不是所有的对象都可以序列化 java.io.NotSerializableException
 * 不是所有的属性都需要序列化 transient
 *
 *
 */
public class ObjectDemo01 {

	public static void main(String[] args) {
		try {
			seri("e:/IO/test/ser.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			read("e:/IO/test/ser.txt");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//反序列化
	public static void read(String scrPath) throws IOException, ClassNotFoundException {
		//创建源
		File src = new File(scrPath);
		//选择流
		ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(src))
				);
		//操作 读取的顺序和写出一致  必须存在才能读取
		//不一致， 数据存在问题
		Object obj = ois.readObject();
		if(obj instanceof Employee) {
			Employee emp = (Employee)obj;
			System.out.println(emp.getName());
			System.out.println(emp.getSalary());
			
		}
		
		obj = ois.readObject();
		int[] arr = (int[]) obj;
		System.out.println(Arrays.toString(arr));
		
		ois.close();
	}
	

	//序列化
	public static void seri(String destPath) throws IOException {
		Employee emp = new Employee("wyf", 1000000);
		int[] arr = {1, 2, 3, 45};
		
		//创建源
		File dest = new File(destPath);
		//选择流
		ObjectOutputStream dos = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest))
				);
		
		//操作 写出顺序 为读取做准备
		dos.writeObject(emp);
		dos.writeObject(arr);
		dos.flush();
		//释放资源
		dos.close();
		
		
	}
}
