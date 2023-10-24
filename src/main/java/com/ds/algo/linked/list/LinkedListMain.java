package com.ds.algo.linked.list;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedListMain {

	private static final Logger LOGGER = LoggerFactory.getLogger(LinkedListMain.class);

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList(1);
		linkedList.append(2);
		linkedList.append(3);
		linkedList.append(4);
		linkedList.append(5);
		linkedList.append(6);
		
		LOGGER.debug("Kth From End {}", linkedList.findKthFromEnd(1));

	}
}
