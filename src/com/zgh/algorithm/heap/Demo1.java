package com.zgh.algorithm.heap;

public class Demo1 {
	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap(100);
		heap.insert(20);
		heap.insert(15);
		heap.insert(30);
		heap.insert(20);
		heap.insert(23);
		heap.insert(45);
		heap.insert(62);
		System.out.println(heap);
		while (!heap.isEmpty()) {
			System.out.println(heap.getTop());
		}
	}
}
