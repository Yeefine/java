package com.java;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BankSys {
	Scanner console = new Scanner(System.in);
	public static Set<User> Users = new HashSet();
	
	public void createUser() {
		User user = new User();
		System.out.println("请输入用户姓名：");
		String st = console.next();
		user.setName(st);
		Users.add(user);
		System.out.println("创建用户成功！");
	}
	
	public User entry() {
		System.out.println("请输入用户姓名：");
		String st = console.next();
		int k = 0;
		for (User user : Users) {
			if(user.getName().equals(st)) {
				k = 1;
				break;
			}
		}
		if(k == 0) {
			System.out.println("没有该用户信息，请创建！");
			createUser();
		}
		User name = new User();
		for (User user : Users) {
			if(user.getName().equals(st)) {
				name = user;
			}
		}
		return name;
	}
	
	public int interFace0() {
		
		int k;
		System.out.println("*******Welcome To The BankSystem*******");
		System.out.println("* 1.Enter User   2.Total Cards Number *");
		System.out.println("* 3.Quit                              *");
		System.out.println("***************************************");
		System.out.println("请输入您需要的服务：");
		k = console.nextInt();
		return k;
	}
	
	public int interFace1() {
		int k;
		System.out.println("*******************Welcome To The BankSystem********************");
		System.out.println("* 1.Create Card                      2.Cancel Card             *");
		System.out.println("* 3.Deposit                          4.Withdraw Money          *");
		System.out.println("* 5.Modify Account Name              6.Show All Accounts       *");
		System.out.println("* 7.Show Operate                     0.Quit                    *");
		System.out.println("****************************************************************");
		System.out.println("请输入您需要的服务：");
		k = console.nextInt();
		return k;
	}
	
	public void totalNum() {
		//总卡数
		int num = 0;
		for (User user : Users) {
			num += user.getCardNum();
		}
		System.out.println("The BankSystem Has " + num + " BankAccount:");
		for (User user : Users) {
			for (CashAccount cash : user.cashAccounts) {
				System.out.println("User: " + user.getName() + ", Account: " + cash.getName() + "    Card's Type: CashAccount");
			}
			for (CreditAccount credit : user.creditAccounts){
				System.out.println("User: " + user.getName() + ", Account: " + credit.getName() + "    Card's Type: CreditAccount");
			}
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankSys sys = new BankSys();
		User user = new User();
		int k = 0;
		while(k != 3) {
			k = sys.interFace0();
			switch(k) {
			case 1: {
				user = sys.entry();
				int i = 1;
				while(i != 0) {
					i = sys.interFace1();
					switch(i) {
						case 1: {
							user.CreateAccount();
							break;
						}
			
						case 2: {
							user.DeleteAccount();
							break;
						}
			
						case 3: {
							user.store();
							break;
						}
			
						case 4: {
							user.remove();
							break;
						}
			
						case 5: {
							user.modifyAccountName();
							break;
						}
						
						case 6: {
							user.showAccounts();
							break;
						}
						
						case 7: {
							user.showOperate();
							break;
						}
						
						case 0: {
							break;
						}
					}
				}
				break;
			}
			case 2: {
				sys.totalNum();
				break;
			}
			case 3: {
				break;
			}
		}
	}

	}
}
