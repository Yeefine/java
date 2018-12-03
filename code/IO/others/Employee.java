/* @16130110047 王一凡 528378795@qq.com */
package com.IO.others;
/**
 * 空接口只是标识
 * @author 52837
 *
 */

public class Employee implements java.io.Serializable{
	//不需要序列化
	private transient String name;  //没有存
	private double salary;	
	
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	public Employee() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
