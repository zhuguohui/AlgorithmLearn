package com.zgh.algorithm.graph2;

public class Demo2 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		int[] testArray = new int[] { 10, 7, 6, 3, 4, 2, 1, 0, 8, 9, 2 };
		IndexMinHeap<Integer> heap = new IndexMinHeap<Integer>(100);
		for (int i = 0; i < testArray.length; i++) {
			heap.insert(i, testArray[i]);
		}
		System.out.println("min index=" + heap.getTopIndex());
		for (int i = 0; i < testArray.length; i++) {
			System.out.println(heap.getTop());
		}
	}
}
