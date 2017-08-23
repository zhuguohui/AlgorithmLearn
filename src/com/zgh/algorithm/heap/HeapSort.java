package com.zgh.algorithm.heap;

import com.zgh.algorithm.SortTestHelper.SortFunction;

public class HeapSort implements SortFunction {

	@Override
	public void sort(int[] arr) {
		MaxHeap heap = new MaxHeap(arr.length);
		for (int i = 0; i < arr.length; i++) {
			heap.insert(arr[i]);
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			arr[i] = heap.getTop();
		}
	}

	@Override
	public String sortName() {
		// TODO Auto-generated method stub
		return "∂—≈≈–Ú1";
	}

}
