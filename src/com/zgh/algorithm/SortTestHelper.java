package com.zgh.algorithm;

import java.util.Arrays;
import java.util.Random;

import com.zgh.algorithm.heap.HeapSort;

public class SortTestHelper {
	static Random random = new Random();
	static int showNumber = 50;

	/**
	 * ��������
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
			System.out.println("��������" + testArray.name);
			for (int j = 0; j < functions.length; j++) {
				SortFunction function = functions[j];
				SortTestHelper.testSort(function, testArray.array, true);
			}
		}

	}

	public static TestArray[] generateTestArrays(int size, int swatTimes, int rangeR) {
		TestArray[] testArrays = new TestArray[2];
		TestArray testArray1 = new TestArray();
		testArray1.name = "�������";
		testArray1.array = generateRandomArray(size, 0, rangeR);
		testArrays[0] = testArray1;

		TestArray testArray2 = new TestArray();
		testArray2.name = "�������������";
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
	 * ���ɽ������������
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
		// ����λ��
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
			System.out.println("����ǰ����Ϊ��" + Arrays.toString(array));
		}
		long start = System.currentTimeMillis();
		function.sort(array);
		long end = System.currentTimeMillis();
		if (printArray) {
			System.out.println("���������Ϊ��" + Arrays.toString(array));
		}
		long useTime = end - start;
		String info = "ʹ��" + function.sortName() + "�����СΪ" + size + "��������ʱ" + useTime + "����";
		System.out.println(info);
	}

	public static long testSort(SortFunction function, int[] array, boolean printArray) {
		// ����һ�ݣ�������Զ������
		array = Arrays.copyOf(array, array.length);
		int[] showArray = array;
		if (printArray) {
			if (array.length > showNumber) {
				showArray = Arrays.copyOf(array, showNumber);
			}
			System.out.println("����ǰ����Ϊ��" + Arrays.toString(showArray));
		}
		long start = System.currentTimeMillis();
		function.sort(array);
		long end = System.currentTimeMillis();
		if (printArray) {
			if (array.length > showNumber) {
				showArray = Arrays.copyOf(array, showNumber);
			}
			System.out.println("���������Ϊ��" + Arrays.toString(showArray));
		}
		long useTime = end - start;
		String info = "ʹ��" + function.sortName() + "�����СΪ" + array.length + "��������ʱ" + useTime + "����";
		System.out.println(info);
		return useTime;
	}

	public interface SortFunction {
		void sort(int[] arr);

		String sortName();
	}
}
