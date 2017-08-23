package com.zgh.algorithm.sort;

import java.util.Arrays;

import com.zgh.algorithm.SortTestHelper;

public class SortDemo4 {
	public static void main(String[] args) {
		int size = 20000000;
		int[] array1 = SortTestHelper.generateRandomArray(size, 0, size);
		int[] array2 = Arrays.copyOf(array1, array1.length);
		SortTestHelper.testSort(new QuickSort4(), array1, true);
		SortTestHelper.testSort(new QuickSort3(), array2, true);
	}
}
