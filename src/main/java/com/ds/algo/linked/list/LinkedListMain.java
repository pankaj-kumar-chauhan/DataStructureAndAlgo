package com.ds.algo.linked.list;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedListMain {

	private static final Logger LOGGER = LoggerFactory.getLogger(LinkedListMain.class);

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList(0);
		linkedList.removeLast();
		linkedList.print();
		linkedList.removeFirst();
		linkedList.append(0);
		linkedList.append(2);
		linkedList.append(3);
		Node deleteNode = linkedList.removeFirst();
		LOGGER.debug("Deleted {}", deleteNode.getValue() + "");
		linkedList.print();

	}
}
