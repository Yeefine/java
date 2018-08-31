package com.imooc.cards;

import java.util.Comparator;

public class CardsComparator implements Comparator<Cards> {

	@Override
	public int compare(Cards o1, Cards o2) {
		// TODO Auto-generated method stub
		return o1.getType().compareTo(o2.getType());
	}

}
