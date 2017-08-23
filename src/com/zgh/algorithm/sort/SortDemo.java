package com.zgh.algorithm.sort;

import java.util.Arrays;

import com.zgh.algorithm.SortTestHelper;

public class SortDemo {
	public static void main(String[] args) {
		// SortTestHelper.testSort(new SelectionSort(), , false);
		int size = 100000;
		// int[] array1 = SortTestHelper.generateRandomArray(size, 0, 3);
		int[] array1 = SortTestHelper.generateNearlyOrderedArray(1000000, 100);
		int[] array2 = Arrays.copyOf(array1, array1.length);
		int[] array3 = Arrays.copyOf(array1, array1.length);
		int[] array4 = Arrays.copyOf(array1, array1.length);
		SortTestHelper.testSort(new SelectionSort(), array3, true);
		System.out.println("改进前");
		SortTestHelper.testSort(new InsertSort(), array1, true);
		System.out.println("改进后");
		SortTestHelper.testSort(new InsertSort2(), array2, true);
		System.out.println("改进后2");
		SortTestHelper.testSort(new InsertSort3(), array4, true);
	}
}
