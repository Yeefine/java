package com.java;

import java.util.Stack;

public class BankAccount {
//	private String type;
	private String Name;
	private int binding; //绑定标记
	
	public int getBinding() {
		return binding;
	}
	
	public void setBinding(int binding) {
		this.binding = binding;
	}
	//	private float balance = 0;
	Stack stack = new Stack();
	
//	public String getType() {
//		return type;
//	}
//	public void setType(String type) {
//		this.type = type;
//	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
//	public float getBalance() {
//		return balance;
//	}
//	public void deposit(float balance) {
//		//存钱
//		this.balance += balance;
//		String op = "账户：" + getName() + "存入金额：" + balance + ", " + getType() + "卡中余额为：" + getBalance();
//		stack.push(op);
//	}
//	public void consume(float balance) {
//		if(this.balance >= balance)
//		{
//			this.balance -= balance;
//			System.out.println("取款成功！您的" + type + "卡中余额为：" + this.getBalance());
//			String op = "账户：" + getName() + "取出金额：" + balance + ", " + getType() + "卡中余额为：" + getBalance();
//			stack.push(op);
//		}
//		else
//			System.out.println("您的余额不足！");
//			return;
//	}
	
}
