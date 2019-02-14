package javaspringexamples.LinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * This class represents some operations about linked lists, especially how to
 * get a node at the Nth position from the tail of a linked list, get
 * duplicate-value nodes, cycle detection.
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
public class GetValueCycleDetection {

	public Node insertAtLast(Node head, int _data) {
		if (head == null)
			head = new Node(_data);
		else {
			Node current = head;
			while (current.next != null)
				current = current.next;
			current.next = new Node(_data);
		}
		return head;
	}

	public Node insertAtLast(Node head, Node _node) {
		if (head == null)
			head = _node;
		else {
			Node current = head;
			while (current.next != null)
				current = current.next;
			current.next = _node;
		}
		return head;
	}

	/**
	 * This method gets the Nth value from the tail of a linked list.
	 * 
	 * @param head
	 *            : the head of the linked list.
	 * @param n
	 *            : the Nth position from the tail of the linked list.
	 * @return the linked list reversed.
	 */
	public int getNode(Node head, int n) {
		Stack<Node> s = new Stack<>();
		Node current = head;
		while (current != null) {
			s.add(current);
			current = current.next;
		}
		int i = 0;
		while (i < n) {
			s.pop();
			i++;
		}
		return s.pop().data;
	}

	/**
	 * This method removes duplicates values from a sorted linked list.
	 * 
	 * @param head:
	 *            head of the linked list.
	 * 
	 * @return the linked list without duplicates values.
	 */
	public Node removeDuplicates(Node head) {
		Node previous = head;
		Node current = head.next;

		while (current != null) {
			if (previous.data == current.data) {
				previous.next = null;
				previous.next = current.next;
			} else {
				previous = previous.next;
			}
			current = current.next;
		}
		return head;
	}

	/**
	 * This method detects if the linked list contains a cycle.
	 * 
	 * @param head
	 *            : the head of the linked list.
	 * @return True if there is a cycle in the linked list, false if not.
	 */
	public boolean hasCycle(Node head) {
		Node current = head;
		boolean cycle = false;

		Map<Node, Node> map = new HashMap<>();
		while (current != null) {
			if (!map.containsKey(current)) {
				map.put(current, current);
			} else {
				cycle = true;
				break;
			}
			current = current.next;
		}
		return cycle;
	}

	/**
	 * This method prints the elements of a linked list.
	 * 
	 * @param head:head
	 *            of the linked list
	 */
	public void print(Node head) {
		if (head == null)
			System.out.println(head);
		else {
			Node current = head;
			while (current != null) {
				System.out.print(current.data + "->");
				current = current.next;
				System.out.print((current == null) ? "NULL" : "");
			}
			System.out.println();
		}
	}
}
