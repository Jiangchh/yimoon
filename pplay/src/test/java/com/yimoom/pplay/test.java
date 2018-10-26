
package com.yimoom.pplay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {
	public static void main(String[] args) {
		List<Integer>list=new ArrayList<Integer>();
		for (int i = 0; i < 99999; i++) {
			list.add(99999-list.size());
		}
		Collections.shuffle(list);
		System.err.println(String.format("%05d",list.get(0)));
	}
}
