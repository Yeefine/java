/* @16130110047 ��һ�� 528378795@qq.com */
package com.IO.pattern;

public class Voice {
	private int voice = 10;
	public Voice() {
		
	}
	
	public Voice(int voice) {
		super();
		this.voice = voice;
	}
	
	public void say() {
		System.out.println(voice);
	}

	public int getVoice() {
		return voice;
	}

	public void setVoice(int voice) {
		this.voice = voice;
	}
	
	
}
