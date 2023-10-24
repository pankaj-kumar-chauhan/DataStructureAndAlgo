package com.ds.algo.linked.list;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedListMain {

	private static final Logger LOGGER = LoggerFactory.getLogger(LinkedListMain.class);

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList(1);
		linkedList.append(0);
		linkedList.append(1);
		linkedList.append(1);
		linkedList.append(1);
		linkedList.append(1);

		LOGGER.debug("Binary To Decimal {}", linkedList.binaryToDecimal());
	}
}
