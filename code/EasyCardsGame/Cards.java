package com.imooc.cards;

public class Cards implements Comparable<Cards> {
	private int number;
	private String type;
	
	public Cards(String type, int number) {
		this.type = type;
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int compareTo(Cards o) {
		// TODO Auto-generated method stub
		if(this.number > o.number)
			return 1;
		else if(this.number == o.number)
			return 0;
		else
			return -1;
	}


	
}
