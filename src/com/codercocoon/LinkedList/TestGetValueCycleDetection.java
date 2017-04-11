package com.codercocoon.LinkedList;

import java.util.Scanner;

public class TestGetValueCycleDetection {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node head = null;
		int size = 0;
		GetValueCycleDetection ll = new GetValueCycleDetection();

		System.out.print("Enter the linked list size : ");
		size = sc.nextInt();
		System.out.println("Enter the sorted linked list elements : ");
		while (size > 0) {
			head = ll.insertAtLast(head, sc.nextInt());
			size--;
		}
		System.out.print("Node value at the position : ");
		int position = sc.nextInt();
		System.out.println(ll.getNode(head, position));
		System.out.print("Removing duplicates values : ");
		ll.print(ll.removeDuplicates(head));
		System.out.print("the linked list has a cycle ? " + ll.hasCycle(head));
	}
}
