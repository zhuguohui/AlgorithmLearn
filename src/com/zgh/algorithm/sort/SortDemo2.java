package com.zgh.algorithm.sort;

import java.util.Arrays;

import com.zgh.algorithm.SortTestHelper;

public class SortDemo2 {
	public static void main(String[] args) {
		int size = 1000000;
		int[] array1 = SortTestHelper.generateRandomArray(size, 0, size);
		long miniUseTime = Long.MAX_VALUE;
		int miniNumber = 0;
		for (int i = 15; i < 100; i++) {
			int[] array = Arrays.copyOf(array1, array1.length);
			long useTime = SortTestHelper.testSort(new MergeSort2(i), array, true);
			if (useTime < miniUseTime) {
				miniUseTime = useTime;
				miniNumber = i;
			}
		}
		System.out.println("最少用时=" + miniUseTime + "毫秒 ，最优数量为" + miniNumber);
	}
}
