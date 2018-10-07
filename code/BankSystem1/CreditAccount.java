package com.java;

import java.util.Scanner;

public class CreditAccount extends BankAccount {
	Scanner console = new Scanner(System.in);
	private double limit; //额度
	private double balance; //余额

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance += balance;
	}

	public double getLimit() {
		return limit;
	}

	public int setLimit(String st) {
		if(st.equals("Primary")) {
			//初级
			limit = 5000.0;
		}
		else if(st.equals("Intermediate")) {
			//中级
			limit = 10000.0;
		}
		else if(st.equals("Senior")) {
			//高级
			limit = 20000.0;
		}
		else {
			System.out.println("请输入正确的信用卡级别: Primary or Intermediate or Senior)!");
			return -1;
		}
		balance = limit;
		return 0;
	}
	
	public void borrow() {
		//刷卡
		System.out.println("请输入刷卡金额：");
		double st = console.nextDouble();
		if(st > balance) {
			System.out.println("您的余额不足！");
		}
		else {
			balance -= st;
			System.out.println("刷卡成功！");
		}
	}
	
	public double repay() {
		//还贷
		System.out.println("您的信用卡额度为：" + limit + ", 您的余额为：" + balance + ", 所需还款：" + (limit - balance));
		return (limit - balance);
	}
	
}
