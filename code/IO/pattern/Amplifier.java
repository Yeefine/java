/* @16130110047 王一凡 528378795@qq.com */
package com.IO.pattern;
/*
 * 扩音器
 * 类与类之间的关系
 * 1、依赖：形参|局部变量
 * 2、关联：属性
 * 		聚合：属性 整体与部分 不一致的生命周期 人与手
 * 		组合：属性 整体与部分 一致的生命周期 人与大脑
 * 3、继承：父子类关系
 * 4、实现：接口与实现类关系
 */
public class Amplifier {
	private Voice voice;
	
	public Amplifier() {
		
	}

	public Amplifier(Voice voice) {
		super();
		this.voice = voice;
	}
	
	public void say() {
		System.out.println(voice.getVoice() * 1000);
	}
}
