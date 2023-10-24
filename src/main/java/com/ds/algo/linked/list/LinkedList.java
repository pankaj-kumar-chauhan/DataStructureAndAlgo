package com.ds.algo.linked.list;

import java.util.HashSet;
import java.util.Set;

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

	public Node removeFirst() {
		if (length == 0) {
			return null;
		}
		Node temp = head;
		head = temp.getNext();
		temp.setNext(null);
		length--;
		return temp;
	}

	public Node get(int index) {
		if (index < 0 || index > length) {
			return null;
		}
		Node temp = head;
		for (int i = 0; i < length; i++) {
			if (i == index) {
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
	}

	public boolean set(int index, int value) {
		Node node = get(index);
		if (node != null) {
			node.setValue(value);
			return true;
		}
		return false;
	}

	public boolean insert(int index, int value) {
		Node newNode = new Node(value);
		if (index < 0 || index > length) {
			return false;
		}
		if (index == 0) {
			prepend(value);
			return true;
		}
		if (index == length - 1) {
			append(value);
			return true;
		}
		Node node = get(index - 1);
		newNode.setNext(node.getNext());
		node.setNext(newNode);
		length++;
		return true;
	}

	public Node remove(int index) {
		if (index < 0 || index > length) {
			return null;
		}
		if (index == 0) {
			return removeFirst();
		}
		if (index == length - 1) {
			return removeLast();
		}
		Node node = get(index - 1);
		Node tempNode = node.getNext();
		node.setNext(tempNode.getNext());
		length--;
		return tempNode;
	}

	public void reverse() {
		Node previous = null;
		Node middle = head;
		Node next = middle.getNext();
		head = tail;
		tail = middle;
		while (next != null) {
			Node node = next.getNext();
			next.setNext(middle);
			middle.setNext(previous);
			previous = middle;
			middle = next;
			next = node;
		}
	}

	public Node findMiddleNode() {
		Node node = head;
		Node fastNode = head;
		while (fastNode != null && fastNode.getNext() != null) {
			node = node.getNext();
			fastNode = fastNode.getNext().getNext();
		}

		return node;
	}

	public boolean hasLoop() {
		Node node = head;
		Node fastNode = head;
		while (fastNode != null && fastNode.getNext() != null) {
			node = node.getNext();
			fastNode = fastNode.getNext().getNext();
			if (fastNode != null && node.getValue() == fastNode.getValue()) {
				return true;
			}
		}
		return false;
	}

	public Node findKthFromEnd(int k) {
		Node slow = head;
		Node fast = head;

		for (int i = 0; i < k; i++) {
			if (fast == null) {
				return null;
			}
			fast = fast.getNext();
		}
		while (fast != null) {
			slow = slow.getNext();
			fast = fast.getNext();
		}
		return slow;
	}

	public void partitionList(int x) {
		if (head == null) {
			return;
		}
		Node first = null;
		Node second = null;
		Node secondHead = null;
		Node firstHead = null;
		Node temp = head;
		while (temp != null) {
			if (temp.getValue() < x) {
				if (first == null) {
					first = temp;
					firstHead = temp;
				} else {
					first.setNext(temp);
					first = temp;
				}

			} else {
				if (second == null) {
					second = temp;
					secondHead = temp;
				} else {
					second.setNext(temp);
					second = temp;
				}
			}
			temp = temp.getNext();
		}
		if (second != null) {
			second.setNext(null);
		}
		if (first != null) {
			first.setNext(secondHead);
			head = firstHead;
		} else {
			head = secondHead;
		}

	}

	public void removeDuplicates() {
		Set<Integer> intSet = new HashSet<>();
		Node node = head;
		Node prev = head;
		while (node != null) {
			if (intSet.contains(node.getValue())) {
				prev.setNext(node.getNext());

			} else {
				intSet.add(node.getValue());
				prev = node;
			}

			
			node = node.getNext();
		}
	}
}
