package com.imooc.project1;

import java.util.Scanner;

public class BookManager {
	private static Scanner console = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] books = {"C语言", "数据结构",  "汇编语言", "高数", "大学语文", "毛概"};
		while(true) {
			System.out.println("输入命令：1-按照名称查找图书； 2-按照序号查找图书");
			String book;
			try {
				int command = inputCommand();
				switch(command) {
				case 1:
					book = getBookByName(books);
					System.out.println("book:" + book);
					break;
				case 2:
					book = getBookByNumber(books);
					System.out.println("book:" + book);
					break;
				case -1:
					System.out.println("命令输入错误！请根据提示输入数字命令！");
					continue;
					default:
						System.out.println("命令输入错误！");
						continue;
				}
				break;
			}catch(Exception bne) {
				System.out.println(bne.getMessage());
				continue;
			}
		}
	}

	private static String getBookByName(String[] books) throws Exception {
		System.out.println("输入图书名称：");
		String name = console.next();
		for(int i = 0; i < books.length; i++) {
			if(name.equals(books[i]))
			{
				return books[i];
			}
		}
		throw new Exception("图书不存在！");
	}
	
	private static String getBookByNumber(String[] books) throws Exception{
		while(true) {
			System.out.println("输入图书序号：");
			try {
				int index = console.nextInt();
				if(index == -1)
				{
					System.out.println("命令输入错误！请根据提示输入数字命令！");
					continue;
				}
				String book = books[index];
				return book;
			}catch(ArrayIndexOutOfBoundsException e) {
				Exception bookNotExists = new Exception("图书不存在！");
				bookNotExists.initCause(e);
				throw bookNotExists;
			}
		}
	}
	
	private static int inputCommand() {
		int command;
		try {
			command = console.nextInt();
			return command;
		}catch(Exception e) {
			console = new Scanner(System.in);
			return -1;
		}
	}
}
