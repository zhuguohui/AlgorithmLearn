package com.zgh.algorithm.heap;

import java.util.Arrays;

import com.zgh.algorithm.SortTestHelper;

public class Demo3 {
	public static void main(String[] args) {
		int size = 10;
		int[] array = SortTestHelper.generateRandomArray(size, 0, size);
		System.out.println(Arrays.toString(array));
		IndexMaxHeap2 indexMaxHeap = new IndexMaxHeap2(100);
		for (int i = 0; i < size; i++) {
			indexMaxHeap.insert(array[i]);
		}

		System.out.println("raw = " + indexMaxHeap.getRawArrayString());
		System.out.println("sorted =" + indexMaxHeap.getSortedArrayString());
		// change
		indexMaxHeap.change(10, 20);
		System.out.println("sorted =" + indexMaxHeap.getSortedArrayString());
	}
}
