package com.java;

public class CashAccount extends BankAccount {
	private double balance = 0;
	public double getBalance() {
		return balance;
	}
	public void deposit(double balance) {
		//存钱
		this.balance += balance;
		String op = "账户：" + getName() + "存入金额：" + balance + ", 现金账户卡中余额为：" + getBalance();
		stack.push(op);
	}
	public void consume(double balance) {
		//取款
		if(this.balance >= balance){
			this.balance -= balance;
			System.out.println("扣取成功！您的现金账户" + "中余额为：" + this.getBalance());
			String op = "账户：" + getName() + "取出金额：" + balance + ", 现金账户卡中余额为：" + getBalance();
			stack.push(op);
		}
		else
			System.out.println("您的余额不足！");
			return;
	}
}
