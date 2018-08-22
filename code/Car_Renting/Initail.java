package com.imooc;

import java.util.Scanner;

public class Initail {
	static int  [] arr = new int[100];
	Scanner sc = new Scanner(System.in);
	public void page0() {
		System.out.println("谢谢使用");
	}
	public int page1() {
		int k;
		System.out.println("欢迎使用答答租车系统 ");
		System.out.println("您是否要租车: 1.是 0.否");
		System.out.print("请输入：");
		k = sc.nextInt();
		return k;
	}
	public int page2() {
		int k;
		System.out.println("您可租车的类型及价目表：");
		System.out.println("序号 | 汽车名称 | 租金（/天） | 容量");
		System.out.println("1.  |奥迪A4  | 500元/天     |  载人：4人 ");
		System.out.println("2.  |马自达6 | 400元/天     |  载人：4人");
		System.out.println("3.  |皮卡雪6 | 450元/天     |  载人4人 载货：2吨");
		System.out.println("4.  |金龙       | 800元/天     |  载人：20人");
		System.out.println("5.  |松花江    | 400元/天     |  载货：4吨");
		System.out.println("6.  |依维柯    | 1000元/天   |  载货：20吨");
		System.out.println("请输入您要租汽车的数量：");
		k = sc.nextInt();
		return k;
	}
	public int page3(int n) {
		int i, k;
		//int  [] arr = new int[n];
		for(i = 1; i <= n; i++) {
			System.out.println("请输入第" + i + "辆车的序号：");
			arr[i-1] = sc.nextInt();
		}
		System.out.println("请输入租车天数：");
		k = sc.nextInt();
		return k;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PCar p1 = new PCar();
		p1.setName("奥迪A4");
		p1.setRent(500);
		p1.setManned(4);
		
		PCar p2 = new PCar();
		p2.setName("马自达6");
		p2.setRent(400);
		p2.setManned(4);
		
		P_MCar p3 = new P_MCar();
		p3.setName("皮卡雪6");
		p3.setRent(450);
		p3.setManned(4);
		p3.setCargo(2);
		
		PCar p4 = new PCar();
		p4.setName("金龙");
		p4.setRent(800);
		p4.setManned(20);
		
		MCar p5 = new MCar();
		p5.setName("松花江");
		p5.setRent(400);
		p5.setCargo(4);
		
		MCar p6 = new MCar();
		p6.setName("依维柯");
		p6.setRent(1000);
		p6.setCargo(20);
		
		
		Initail car = new Initail();
		int p = 0, k = 1;
		double q = 0.0, t = 0.0;
		String [] Nam = new String [100];
		String [] nam = new String [100];
		while(k != 0)
		{
			k = car.page1();
			switch(k)
			{
			case 1:
				int i = car.page2();   
				int m = car.page3(i);  //租车天数
				for(int j = 0; j < i; j++)
				{
					switch(arr[j])
					{
					case 1:
						p = p + p1.getManned();
						Nam[j] = p1.getName();
						t = t + p1.getRent();
						break;
					case 2:
						p = p + p2.getManned();
						Nam[j] = p2.getName();
						t = t + p2.getRent();
						break;
					case 3:
						p = p + p3.getManned();
						q = q +p3.getCargo();
						Nam[j] = p3.getName();
						nam[j] = p3.getName();
						t = t + p3.getRent();
						break;
					case 4:
						p = p + p4.getManned();
						Nam[j] = p4.getName();
						t = t + p4.getRent();
						break;
					case 5:
						q = q + p5.getCargo();
						Nam[j] = p5.getName();
						nam[j] = p5.getName();
						t = t + p5.getRent();
						break;
					case 6:
						q = q + p6.getCargo();
						Nam[j] = p6.getName();
						nam[j] = p6.getName();
						t = t + p6.getRent();
						break;
					}
				}
				System.out.println("您的帐单：");
				System.out.println("***可载人的车有：");
				for(int h = 0; h < i; h++)
				{
					if(Nam[h] == null)
					{
						continue;
					}
					System.out.print(Nam[h] + "  ");
				}
				System.out.println("共载人：" + p + "人");
				System.out.println("***载货的车有： ");
				for(int h = 0; h < i; h++)
				{
					if(nam[h] == null)
					{
						continue;
					}
					System.out.print(nam[h] + "  ");
				}
				System.out.println("共载货：" + q + "吨");
				System.out.println("***租车总价格： " +  t * m + "元");
				k = 0;
				break;
			case 0:
				car.page0();
				k = 0;
				break;
			}
		}
		
	}
}
