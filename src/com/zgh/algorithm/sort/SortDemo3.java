package com.zgh.algorithm.sort;

import com.zgh.algorithm.SortTestHelper;

public class SortDemo3 {
	public static void main(String[] args) {
		int size =100000;
		int[] array1 = SortTestHelper.generateRandomArray(size, 0, size);
		SortTestHelper.testSort(new MergeSortDU(), array1, true);
	}
}
