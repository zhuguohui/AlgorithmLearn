package com.zgh.algorithm.heap;

import com.zgh.algorithm.SortTestHelper;
import com.zgh.algorithm.sort.QuickSort;

public class Demo2 {
	public static void main(String[] args) {
		int size = 100000;
		int rangeR = size;
		int swapTimes = 10;
		SortTestHelper.testSortFunctions(size, swapTimes, rangeR, new HeapSort(), new HeapSort2(), new HeapSort3(),
				new QuickSort());
	}


}
