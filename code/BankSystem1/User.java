package com.java;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class User {
	Scanner console = new Scanner(System.in);
	private String name;
	private int CardNum = 0;
	public Set<CashAccount> cashAccounts = new HashSet();
	public Set<CreditAccount> creditAccounts = new HashSet();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCardNum() {
		return CardNum;
	}
	
	public void increaseCard() {
		CardNum += 1;
	}
	
	public void reduceCashCard(String st, CashAccount cash) {
		if(this.CardNum < 1) {
			System.out.println("您没有可用账户可执行销户！");
			return;
		}else {
//			if(st.equals("CashAccount")) {
				cashAccounts.remove(cash);
				CardNum -= 1;
//			}
//			if(st.equals("CreditAccount")) {
//				creditAccounts.remove(account);
//				CardNum -= 1;
//			}
//			else
//				System.out.println("没有该类型账户，无法销户！");
		}
	}
	
	public void reduceCreditCard(String st, CreditAccount credit) {
		if(this.CardNum < 1) {
			System.out.println("您没有可用账户可执行销户！");
			return;
		}else {
//			if(st.equals("CashAccount")) {
//				cashAccounts.remove(cash);
//				CardNum -= 1;
//			}
//			if(st.equals("CreditAccount")) {
				creditAccounts.remove(credit);
				CardNum -= 1;
//			}
//			else
//				System.out.println("没有该类型账户，无法销户！");
		}
	}
	
	public void CreateAccount() {
		//创建账户
		System.out.println("请输入账户类型(CashAccount or CreditAccount)：");
		String type = console.next();
		System.out.println("请设置账户名称：");
		String st = console.next();

		if(type.equals("CashAccount")) {
			CashAccount cash = new CashAccount();
			cash.setName(st);
			System.out.println("请设置绑定密钥：");
			int ssh = console.nextInt();
			cash.setBinding(ssh);
			System.out.println("创建成功！");
			increaseCard();
			cashAccounts.add(cash);
		}else if(type.equals("CreditAccount")) {
			CreditAccount credit = new CreditAccount();
			credit.setName(st);
			System.out.println("请输入申请信用卡级别(Primary or Intermediate or Senior)：");
			String level = console.next();
			if(credit.setLimit(level) != -1) {
				System.out.println("请输入绑定密钥：");
				int ssh = console.nextInt();
				credit.setBinding(ssh);
				System.out.println("创建成功！");
				for (CashAccount cash : cashAccounts) {
					if(cash.getBinding() == ssh) {
						System.out.println("绑定成功！");
						increaseCard();
						creditAccounts.add(credit);
					}else {
						System.out.println("绑定失败！");
					}
				}
			}
			
		}else {
			System.out.println("请输入正确的账户类型(CashAccount or CreditAccount)");
			return;
		}

	}
	
	public void DeleteAccount() {
		// 销户
		System.out.println("请输入要注销的账户类型(CashAccount or CreditAccount)：");
		String st = console.next();
		System.out.println("请输入要注销的账户名：");
		String name = console.next();
		int k = 0;
		if(st.equals("CashAccount")) {
			for (CashAccount cash : cashAccounts) {
				if(cash.getName().equals(name)) {
					reduceCashCard(name, cash);
					k = 1;
				}
			}
		}
		else if(st.equals("CreditAccount")) {
			for (CreditAccount credit : creditAccounts) {
				if(credit.getName().equals(name)){
					reduceCreditCard(name, credit);
					k = 1;
				}
				
			}
		}
		if(k == 0) 
			System.out.println("您没有该类型的账户，无需注销！");
		if(k == 1)
			System.out.println("注销成功！");
		
	}
	
	public void store() {
		//存款或还款
		System.out.println("请输入要操作的账户类型(CashAccount or CreditAccount)：");
		String st = console.next();
		System.out.println("请输入要操作的账户名：");
		String name = console.next();
		int k = 0;
//		BankAccount account;
		if(st.equals("CashAccount")) {
			k = -1;
			CashAccount account;
			for (CashAccount cash : cashAccounts) {
				if(cash.getName().equals(name)) {
					account = cash;
					System.out.println("请输入您要存储的金额：");
					double balance = console.nextDouble();
					cash.deposit(balance);
					k = 1;
					System.out.println("存储成功！您的账户名为" + account.getName() + "的CashAccount中余额为：" + account.getBalance());
					break;
				}
			}
			if(k == 0) {
				System.out.println("您没有该账户，无法存款！");
			}
		}
		else if(st.equals("CreditAccount")){
			k = -1;
			CreditAccount account;
			for (CreditAccount credit : creditAccounts) {
				if(credit.getName().equals(name)) {
					k = 1;
					account = credit;
					double money = credit.repay();  //所需还钱数
					if(money == credit.getLimit()) {
						System.out.println("您目前无需还款！");
						break;
					}else {
						for (CashAccount cash : cashAccounts) {
							if(cash.getBinding() == credit.getBinding()) {  //从对应绑定的现今用户中扣取
								if(cash.getBalance() >= money)
								{
									cash.consume(money);
									credit.setBalance(money);
									System.out.println("还款成功！");
									credit.repay();
									break;
								}
								else {
									System.out.println("您绑定的现金用户中余额不足，无法还款！");
									break;
								}
							}
						}
					}
				}
			}
		}
		if(k == 0) {
			System.out.println("请输入正确的账户类型(CashAccount or CreditAccount)");
		}
		if(k == -1)
			System.out.println("您目前该类型下没有此账户！");
		
	}
	
	public void remove() {
		//取款或消费
		System.out.println("请输入您要操作的账户类型(CashAccount or CreditAccount)：");
		String st = console.next();
		System.out.println("请输入要操作的账户名：");
		String name = console.next();
		int k = 0;
		if(st.equals("CashAccount")) {
			k = -1;
			for (CashAccount cash : cashAccounts) {
				if(cash.getName().equals(name)) {
					System.out.println("请输入要取款金额：");
					double money =console.nextDouble();
					cash.consume(money);
					k = 1;
					break;
				}
			}
//			if(k == 0) {
//				System.out.println("未找到对应的账户，无法执行操作！");
//			}
		}
		else if(st.equals("CreditAccount")) {
			k = -1;
			for (CreditAccount credit : creditAccounts) {
				if(credit.getName().equals(name)) {
					credit.borrow();
					k = 1;
					break;
				}
			}
//			if(k == 0) {
//				System.out.println("未找到对应的账户，无法执行操作！");
//			}
		}
		if(k == 0) {
			System.out.println("请输入正确的账户类型(CashAccount or CreditAccount)");
		}
		if(k == -1)
			System.out.println("您目前该类型下没有此账户！");
	}
	
	public void modifyAccountName() {
		//修改账户名称
		System.out.println("请输入您要操作的账户类型(CashAccount or CreditAccount)：");
		String st = console.next();
		System.out.println("请输入要操作的账户名：");
		String name = console.next();
		int k = 0;
		if(st.equals("CashAccount")) {
			for (CashAccount cash : cashAccounts) {
				if(cash.getName().equals(name)) {
					System.out.println("请输入修改后的账户名：");
					String Name = console.next();
					cash.setName(Name);
					System.out.println("修改成功！");
					k = 1;
					break;
				}
			}
			if(k == 0) {
				System.out.println("未找到对应的账户，无法执行操作！");
			}
		}
		else if(st.equals("CreditAccount")) {
			for (CreditAccount credit : creditAccounts) {
				if(credit.getName().equals(name)) {
					System.out.println("请输入修改后的账户名：");
					String Name = console.next();
					credit.setName(Name);
					System.out.println("修改成功！");
					k = 1;
					break;
				}
			}
			if(k == 0) {
				System.out.println("未找到对应的账户，无法执行操作！");
			}
		}
	}
	
	public void showAccounts() {
		//打印输出账户信息
		System.out.println("------ CashAccount ------");
		for (CashAccount cash : cashAccounts) {
			System.out.println("账户名: " + cash.getName() + ", 余额: " + cash.getBalance() + ", 绑定密钥: " + cash.getBinding());
		}
		System.out.println("------ CreditAccount ------");
		for (CreditAccount credit : creditAccounts) {
			System.out.println("账户名: " + credit.getName() + ", 最大额度: " + credit.getLimit() + ", 余额: " + credit.getBalance() + ", 绑定密钥: " + credit.getBinding());
		}
	}
	
	public void showOperate() {
		int i = 0;
		System.out.println("------ CashAccount ------");
		for (CashAccount cash : cashAccounts) {
			System.out.println("Account: " + cash.getName());
			i++;
			if(cash.stack.size() > 6) {
				System.out.println(cash.stack.pop());
				System.out.println(cash.stack.pop());
				System.out.println(cash.stack.pop());
				System.out.println(cash.stack.pop());
				System.out.println(cash.stack.pop());
				System.out.println(cash.stack.pop());
			}
			else {
				for(int k = 0; k < cash.stack.size(); k++) {
					System.out.println(cash.stack.pop());
				}
				System.out.println(cash.stack);
			}
		}
		
		System.out.println("------ CreditAccount ------");
		for (CreditAccount credit : creditAccounts) {
			System.out.println("Account: " + credit.getName());
			i++;
			if(credit.stack.size() > 6) {
				System.out.println(credit.stack.pop());
				System.out.println(credit.stack.pop());
				System.out.println(credit.stack.pop());
				System.out.println(credit.stack.pop());
				System.out.println(credit.stack.pop());
				System.out.println(credit.stack.pop());
			}
			else {
				for(int k = 0; k < credit.stack.size(); k++) {
					System.out.println(credit.stack.pop());
				}
				System.out.println(credit.stack);
			}
		}
		
		
		
	}
	
}
