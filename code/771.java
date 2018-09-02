package com.imooc;

import java.util.Scanner;

public class Solution {
	public int numJewelsIntStones(String J, String S) {
		return S.replaceAll("[^" + J + "]", "").length();  // [^ 指定字符串 ] 指的是除指定字符串以外的其他字符串
	}
	
	public static void main(String[] arg) {
		Solution st = new Solution();
		Scanner console = new Scanner(System.in);
		System.out.println("请输入珠宝：");
		String J = console.next();
		System.out.println("请输入石头：");
		String S =console.next();
		int x = st.numJewelsIntStones(J, S);
		System.out.println("石头中珠宝数量：" + x);
	}
}
