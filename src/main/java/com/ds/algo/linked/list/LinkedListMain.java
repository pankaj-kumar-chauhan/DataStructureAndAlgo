package com.ds.algo.linked.list;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedListMain {

	private static final Logger LOGGER = LoggerFactory.getLogger(LinkedListMain.class);

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList(0);
		linkedList.removeLast();
		linkedList.print();
		linkedList.prepend(0);
		linkedList.print();
		linkedList.prepend(1);
		linkedList.print();
		linkedList.prepend(2);
		linkedList.print();
	}
}
