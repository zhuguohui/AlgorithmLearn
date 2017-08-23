package com.zgh.algorithm.sort;

import com.zgh.algorithm.SortTestHelper.SortFunction;

public class InsertSort3 implements SortFunction {

	@Override
	public void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			for (int j = i - 1; j >= -1; j--) {
				if (j == -1) {
					arr[0] = temp;
					break;
				}
				if (arr[j] > temp) {
					arr[j + 1] = arr[j];
				} else {
					arr[j + 1] = temp;
					break;
				}

			}

		}

	}

	/**
	 * 对[l,r]范围进行排序
	 * 
	 * @param arr
	 * @param l
	 * @param r
	 */
	public static void srot(int[] arr, int l, int r) {
		for (int i = l + 1; i <= r; i++) {
			int temp = arr[i];
			int j = i;
			for (; j > l && arr[j - 1] > temp; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = temp;
		}
	}

	@Override
	public String sortName() {
		// TODO Auto-generated method stub
		return "插入排序法改进型";
	}

}
