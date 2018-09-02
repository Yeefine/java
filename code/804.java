package com.imooc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	Set<String> MorseSet = new HashSet<String>();
	StringBuilder sb = new StringBuilder();
    public int uniqueMorseRepresentations(String[] words) {
    	String[] Morse = new String[] {
    			".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
    	};
    	for (String word : words) {
			for (Character c : word.toCharArray()) {  // toCharArray()将字符串对象转换成字符串数组
				sb.append(Morse[c - 'a']);  //追加内容到当前StringBuilder对象的末尾
			}
			MorseSet.add(sb.toString());
			sb = new StringBuilder();
		}
    	for (String string : MorseSet) {
			System.out.println(string);
		}
    	return MorseSet.size();
    }
	
	public static void main(String[] arg) {
		Solution st = new Solution();
		Scanner console = new Scanner(System.in);
		String[] str = new String[] { "gin", "zen", "gig", "msg"};
		int S = st.uniqueMorseRepresentations(str);

		System.out.println(S);
	}
}
