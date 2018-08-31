package com.imooc.cards;

public class demo {

	public static void main(String[] args)   {
		// TODO Auto-generated method stub
		Operate ot = new Operate();
		ot.createCards();  //创建一副扑克牌
		ot.shuffleCards(); //洗牌操作
		ot.CreatePlayer(); //创建两个玩家
		ot.dealCards();    //发牌操作
		ot.startGame();    //开始游戏
	}

}
