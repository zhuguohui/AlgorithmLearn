package com.zgh.algorithm.heap;

import com.zgh.algorithm.SortTestHelper.SortFunction;

public class HeapSort2 implements SortFunction {

	@Override
	public void sort(int[] arr) {
		MaxHeap heap = new MaxHeap(arr);
		for (int i = arr.length - 1; i >= 0; i--) {
			arr[i] = heap.getTop();
		}
	}

	@Override
	public String sortName() {
		// TODO Auto-generated method stub
		return "¶ÑÅÅÐò¸Ä½ø2";
	}

}
