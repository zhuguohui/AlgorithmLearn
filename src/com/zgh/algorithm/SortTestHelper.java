package com.zgh.algorithm;

import java.util.Arrays;
import java.util.Random;

import com.zgh.algorithm.heap.HeapSort;

public class SortTestHelper {
	static Random random = new Random();
	static int showNumber = 50;

	/**
	 * 测试数组
	 * 
	 * @param size
	 * @param swapTimes
	 * @param rangeR
	 * @param functions
	 */
	public static void testSortFunctions(int size, int swapTimes, int rangeR, SortFunction... functions) {
		TestArray[] testArrays = generateTestArrays(size, swapTimes, rangeR);
		for (int i = 0; i < testArrays.length; i++) {
			TestArray testArray = testArrays[i];
			System.out.println("---------------------------------------------------");
			System.out.println("测试排序" + testArray.name);
			for (int j = 0; j < functions.length; j++) {
				SortFunction function = functions[j];
				SortTestHelper.testSort(function, testArray.array, true);
			}
		}

	}

	public static TestArray[] generateTestArrays(int size, int swatTimes, int rangeR) {
		TestArray[] testArrays = new TestArray[2];
		TestArray testArray1 = new TestArray();
		testArray1.name = "随机数组";
		testArray1.array = generateRandomArray(size, 0, rangeR);
		testArrays[0] = testArray1;

		TestArray testArray2 = new TestArray();
		testArray2.name = "近乎有序的数组";
		testArray2.array = generateNearlyOrderedArray(size, swatTimes);
		testArrays[1] = testArray2;

		return testArrays;
	}

	public static int[] generateRandomArray(int size, int rangeL, int rangeR) {
		int[] array = new int[size];
		int max = rangeR - rangeL + 1;
		for (int i = 0; i < size; i++) {
			array[i] = random.nextInt(max) + rangeL;
		}
		return array;
	}

	/**
	 * 生成近似有序的数组
	 * 
	 * @param size
	 * @param swatTimes
	 * @return
	 */
	public static int[] generateNearlyOrderedArray(int size, int swatTimes) {
		int[] array = new int[size];

		for (int i = 0; i < size; i++) {
			array[i] = i;
		}
		// 交换位置
		for (int i = 0; i < swatTimes; i++) {
			int from = random.nextInt(size);
			int to = random.nextInt(size);
			while (from == to) {
				to = random.nextInt(size);
			}
			int temp = array[to];
			array[to] = array[from];
			array[from] = array[to];
		}

		return array;
	}

	public static class TestArray {
		public String name;
		public int[] array;
	}

	public static void testSort(SortFunction function, int size, boolean printArray) {
		//

		int[] array = generateRandomArray(size, 0, size);
		if (printArray) {
			System.out.println("排序前数组为：" + Arrays.toString(array));
		}
		long start = System.currentTimeMillis();
		function.sort(array);
		long end = System.currentTimeMillis();
		if (printArray) {
			System.out.println("排序后数组为：" + Arrays.toString(array));
		}
		long useTime = end - start;
		String info = "使用" + function.sortName() + "排序大小为" + size + "的数组用时" + useTime + "毫秒";
		System.out.println(info);
	}

	public static long testSort(SortFunction function, int[] array, boolean printArray) {
		// 复制一份，方便测试多个方法
		array = Arrays.copyOf(array, array.length);
		int[] showArray = array;
		if (printArray) {
			if (array.length > showNumber) {
				showArray = Arrays.copyOf(array, showNumber);
			}
			System.out.println("排序前数组为：" + Arrays.toString(showArray));
		}
		long start = System.currentTimeMillis();
		function.sort(array);
		long end = System.currentTimeMillis();
		if (printArray) {
			if (array.length > showNumber) {
				showArray = Arrays.copyOf(array, showNumber);
			}
			System.out.println("排序后数组为：" + Arrays.toString(showArray));
		}
		long useTime = end - start;
		String info = "使用" + function.sortName() + "排序大小为" + array.length + "的数组用时" + useTime + "毫秒";
		System.out.println(info);
		return useTime;
	}

	public interface SortFunction {
		void sort(int[] arr);

		String sortName();
	}
}
