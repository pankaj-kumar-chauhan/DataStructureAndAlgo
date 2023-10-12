package com.ds.algo.linked.list;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedList {

	private static final Logger LOGGER = LoggerFactory.getLogger(LinkedList.class);
	private Node head;
	private Node tail;
	private int length;

	public LinkedList(int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void print() {
		Node temp = head;
		StringBuilder builder = new StringBuilder("");
		while (temp != null) {
			builder.append(temp.getValue() + "-->");
			temp = temp.getNext();
		}
		LOGGER.debug("{}", builder);
	}

	public void append(int value) {
		Node newNode = new Node(value);
		if (length == 0) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = tail.getNext();
		}
		length++;
	}

	public Node removeLast() {
		if (length == 0) {
			return null;
		}
		if (length == 1) {
			Node temp = head;
			head = null;
			tail = null;
			length = 0;
			return temp;
		}
		Node before = head;
		Node after = head;
		while (after.getNext() != null) {
			before = after;
			after = after.getNext();
		}
		before.setNext(null);
		tail = before;
		length--;
		return after;
	}

	public void prepend(int value) {
		Node newNode = new Node(value);
		if (length == 0) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
		length++;
	}

}
