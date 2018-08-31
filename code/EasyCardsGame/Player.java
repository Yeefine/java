package com.imooc.cards;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private int ID;
	
	private String name;
	
	List<Cards> hand = new ArrayList<Cards>();
	
	public Player(int ID, String name) {
		this.ID = ID;
		this.name = name;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
