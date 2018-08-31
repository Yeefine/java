package com.imooc.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Operate {
	static List<Cards> cardsList = new ArrayList<Cards>();  //用来存放一副扑克牌
	static Scanner console = new Scanner(System.in);
	static List<Player> playerList = new ArrayList<Player>(); //用来存放玩家信息
	
	public void createCards() {
		//按照顺序创建一副扑克牌
		Cards[] cards = {
				new Cards("方片", 2), new Cards("方片", 3), new Cards("方片", 4), new Cards("方片", 5), new Cards("方片", 6), new Cards("方片", 7), new Cards("方片", 8), new Cards("方片", 9), new Cards("方片", 10), new Cards("方片", 11), new Cards("方片", 12), new Cards("方片", 13), new Cards("方片", 14),
				new Cards("梅花", 2), new Cards("梅花", 3), new Cards("梅花", 4), new Cards("梅花", 5), new Cards("梅花", 6), new Cards("梅花", 7), new Cards("梅花", 8), new Cards("梅花", 9), new Cards("梅花", 10), new Cards("梅花", 11), new Cards("梅花", 12), new Cards("梅花", 13), new Cards("梅花", 14),
				new Cards("红桃", 2), new Cards("红桃", 3), new Cards("红桃", 4), new Cards("红桃", 5), new Cards("红桃", 6), new Cards("红桃", 7), new Cards("红桃", 8), new Cards("红桃", 9), new Cards("红桃", 10), new Cards("红桃", 11), new Cards("红桃", 12), new Cards("红桃", 13), new Cards("红桃", 14),
				new Cards("黑桃", 2), new Cards("黑桃", 3), new Cards("黑桃", 4), new Cards("黑桃", 5), new Cards("黑桃", 6), new Cards("黑桃", 7), new Cards("黑桃", 8), new Cards("黑桃", 9), new Cards("黑桃", 10), new Cards("黑桃", 11), new Cards("黑桃", 12), new Cards("黑桃", 13), new Cards("黑桃", 14)
		};
		cardsList.addAll(Arrays.asList(cards));
		System.out.println("---------------创建扑克牌成功--------------");
		for (Cards cards2 : cards) {
			if(cards2.getNumber() <= 10)
			{
				System.out.print(cards2.getType()+cards2.getNumber()+" ");
			}
			else {
				System.out.print(cards2.getType());
				if(cards2.getNumber() == 11)
					System.out.print("J ");
				if(cards2.getNumber() == 12)
					System.out.print("Q ");
				if(cards2.getNumber() == 13)
					System.out.print("K ");
				if(cards2.getNumber() == 14)
					System.out.print("A ");
			}
		}
		System.out.println();
//		System.out.println(cardsList.size());
	}
	
	public void shuffleCards() {
		//洗牌操作
		System.out.println("---------------开始洗牌-----------------");
		Collections.shuffle(cardsList);  //利用collections工具类随机打乱
		System.out.println("---------------洗牌结束-----------------");
	}
	
	public void CreatePlayer() {
		//创建两个玩家
		System.out.println("---------------创建玩家-----------------");
		for(int i = 0; i <2; i++) {
			System.out.println("请输入第" + (i+1) + "位玩家的ID和姓名");
			while(true) {
				try {
						System.out.println("请输入ID:");
						int id = console.nextInt();
						System.out.println("请输入姓名：");
						String name = console.next();
						Player player = new Player(id, name);
						playerList.add(player);
						break;
				}catch(InputMismatchException e) {
					String token = console.next();
					System.out.println("请输入整数类型的ID！");
					continue;
				}
			}
		}
		for (Player player : playerList) {
			System.out.println("------欢迎玩家：" + player.getName());
		}
	}
	
	public void dealCards() {
		//发牌操作
		System.out.println("---------------开始发牌-----------------");
		for(int i = 0; i < 4;) {
			for (Player player : playerList) {
				player.hand.add((Cards)cardsList.get(i));
				System.out.println("------玩家：" + player.getName() + "-拿牌"); 
				i++;
			}
		}
			
		System.out.println("---------------发牌结束-----------------");
	}
	
	public void startGame() {
		System.out.println("---------------开始游戏------------------");
		List<Cards> maxCards = new ArrayList<Cards>();
//		List<Cards> winCards = new ArrayList<Cards>();
		for(Player player : playerList) {
			Collections.sort(player.hand);
			for(int i = 0; i <player.hand.size(); i++) {
				if(player.hand.get(i).getNumber() <= 10)
					System.out.println(player.hand.get(i).getType()+player.hand.get(i).getNumber());
				else {
					System.out.print(player.hand.get(i).getType());
					if(player.hand.get(i).getNumber() == 11)
						System.out.println('J');
					if(player.hand.get(i).getNumber() == 12)
						System.out.println('Q');
					if(player.hand.get(i).getNumber() == 13)
						System.out.println('K');
					if(player.hand.get(i).getNumber() == 14)
						System.out.println('A');
				}
			}
			if(player.hand.get(player.hand.size()-1).getNumber() == (player.hand.get(player.hand.size()-2).getNumber())){
				Cards[] cards0 = {
						(Cards)player.hand.get(player.hand.size()-1), (Cards)player.hand.get(player.hand.size()-2)
				};
				List<Cards> Max= new ArrayList<Cards>();
				Max.addAll(Arrays.asList(cards0));
				Collections.sort(Max, new CardsComparator());
				Cards card1 = (Cards)Max.get(0);
				Cards card2 = (Cards)Max.get(1);
				Cards[] cards3 = {
						card1,card2
				};
				player.hand.remove(player.hand.size()-1);
				player.hand.remove(player.hand.size()-1);
				player.hand.addAll(Arrays.asList(cards3));
			}
			System.out.print("玩家：" + player.getName() + "最大的手牌为：" + player.hand.get(player.hand.size()-1).getType());
			if(player.hand.get(player.hand.size()-1).getNumber() <= 10)
				System.out.println(player.hand.get(player.hand.size()-1).getNumber());
			if(player.hand.get(player.hand.size()-1).getNumber() == 11)
				System.out.println('J');
			if(player.hand.get(player.hand.size()-1).getNumber() == 12)
				System.out.println('Q');
			if(player.hand.get(player.hand.size()-1).getNumber() == 13)
				System.out.println('K');
			if(player.hand.get(player.hand.size()-1).getNumber() == 14)
				System.out.println('A');
			maxCards.add(player.hand.get(player.hand.size()-1));
		}
		
		Collections.sort(maxCards);
		if(maxCards.get(1).getNumber() == (maxCards.get(0).getNumber())) {
			Collections.sort(maxCards, new CardsComparator());
		}
		String winner;
		for (Player player : playerList) {
			if(player.hand.get(player.hand.size()-1).getType().equals(maxCards.get(1).getType()) && (player.hand.get(player.hand.size()-1).getNumber() == maxCards.get(1).getNumber())) {
				winner = player.getName();
				System.out.println("----------------玩家：" + winner + "获胜！---------------------");
				break;
			}
		}
		System.out.println("玩家各自的手牌为：");
		for (Player player : playerList) {
			System.out.print(player.getName() + ":[ " );
			for(int i = 0; i < player.hand.size(); i++) {
				if(player.hand.get(i).getNumber() <= 10)
					System.out.print(player.hand.get(i).getType() + player.hand.get(i).getNumber() + " ");
				else {
					System.out.print(player.hand.get(i).getType());
					if(player.hand.get(i).getNumber() == 11)
						System.out.print("J ");
					if(player.hand.get(i).getNumber() == 12)
						System.out.print("Q ");
					if(player.hand.get(i).getNumber() == 13)
						System.out.print("K ");
					if(player.hand.get(i).getNumber() == 14)
						System.out.print("A ");
				}
				
			}
			System.out.println("]");
		}
		
	}
}
