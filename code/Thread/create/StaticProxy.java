/* @16130110047 王一凡 528378795@qq.com */
package com.thread.create;


/**
 * 静态代理 设计模式
 * 1、真实角色
 * 2、代理角色：持有真实角色的引用
 * 3、二者 实现相同的接口
 * @author 52837
 *
 */
public class StaticProxy {

	public static void main(String[] args) {
		//创建真实角色
		You you = new You();
		//创建代理角色 + 真实角色的引用
		WeddingCompany company = new WeddingCompany(you);
		//执行任务
		company.marry();

	}

}
//接口
interface Marry{
	void marry();
}
//真实角色
class You implements Marry{
	@Override
	public void marry() {
		System.out.println("you and 嫦娥结婚了。。。");
	}	
}
//代理角色
class WeddingCompany implements Marry{
	private Marry you;
	
	public WeddingCompany() {
		super();
	}
	
	public WeddingCompany(Marry you) {
		super();
		this.you = you;
	}
	
	private void Before() {
		System.out.println("布置猪窝。。。");
	}
	
	private void After() {
		System.out.println("闹玉兔...");
	}
	
	@Override
	public void marry() {
		Before();
		you.marry();
		After();
	}
}
