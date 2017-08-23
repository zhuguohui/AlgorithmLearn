package com.zgh.algorithm.sort;

import java.util.Arrays;

import com.zgh.algorithm.SortTestHelper.SortFunction;

/**
 * 优化归并排序
 * 
 * @author yuelin
 *
 */
public class MergeSort2 implements SortFunction {

	int miniNumber = 15;

	public MergeSort2(int miniNumber) {
		this.miniNumber = miniNumber;
	}

	@Override
	public void sort(int[] arr) {
		mergeChile(arr, 0, arr.length - 1);
	}

	/**
	 * 对array[l...r] 范围进行归并排序
	 * 
	 * @param array
	 * @param l
	 *            左边界
	 * @param r
	 *            右边界
	 */
	private void mergeChile(int[] array, int l, int r) {
		// 递归跳出条件
		if (r - l <= miniNumber) {
			// 小数据用插入排序进行优化
			InsertSort3.srot(array, l, r);
			return;
		}
		int m = (l + r) / 2;
		// 递归左边
		mergeChile(array, l, m);
		// 递归右边
		mergeChile(array, m + 1, r);
		// 合并排序
		if (array[m] > array[m + 1]) {
			merge(array, l, r, m);
		}

	}

	private void merge(int[] array, int l, int r, int m) {
		// 开辟新数组用于存放结果
		int size = r - l + 1;
		int[] newArray = Arrays.copyOfRange(array, l, r + 1);
		// 左边的头元素
		int i = l;
		// 右边的头元素
		int j = m + 1;
		for (int k = 0; k < newArray.length; k++) {

			if (i > m) {
				// 左边取完，取右边
				newArray[k] = array[j];
				j++;
			} else if (j > r) {
				newArray[k] = array[i];
				i++;
			} else if (array[i] < array[j]) {
				// 左边的小，取左边的
				newArray[k] = array[i];
				i++;
			} else {
				newArray[k] = array[j];
				j++;
			}
		}
		for (i = l; i <= r; i++) {
			array[i] = newArray[i - l];
		}
	}

	@Override
	public String sortName() {
		// TODO Auto-generated method stub
		return "归并排序优化";
	}

}
