/* @16130110047 王一凡 528378795@qq.com */
package com.thread.create;
/**
 * 推荐 Runnable 创建线程
 * 	1）、避免单继承的局限性
 * 	2）、便于共享资源
 * @author 52837
 *
 */

public class ProgrammerApp {

	public static void main(String[] args) {
		 //1）、创建真实角色
		Programmer pro = new Programmer();
		 //2）、创建代理角色+ 真实角色引用
		Thread proxy = new Thread(pro);
		 //3）、调用 .start() 启动线程
		proxy.start();
		
		for(int i = 0; i < 1000; i++) {
			System.out.println("一边聊qq......");
		}

	}

}
