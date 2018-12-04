/* @16130110047 王一凡 528378795@qq.com */
package com.thread.create;

public class RabbitApp {

	public static void main(String[] args) {
		//创建子类对象
		Rabbit rab = new Rabbit();
		Tortoise tos = new Tortoise();
		
		//调用start() 方法
		rab.start();  //不要调用run方法
		tos.start();
		
		for(int i = 0; i < 1000; i++) {
			System.out.println("main==>" + i);
		}
	}

}
