package com.zgh.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

import com.zgh.algorithm.SortTestHelper.SortFunction;

public class QuickSort2 implements SortFunction {
	private static Random random = new Random();

	@Override
	public void sort(int[] arr) {
		// TODO Auto-generated method stub

		quickSrot(arr, 0, arr.length - 1);
	}

	/**
	 * 对数组[l,r]进行快速排序
	 * 
	 * @param arr
	 * @param i
	 * @param j
	 */
	private void quickSrot(int[] arr, int l, int r) {
		if (l >= r) {
			return;
		}
		int p = partition(arr, l, r);
		// System.out.println("p=" + p);
		quickSrot(arr, l, p - 1);
		quickSrot(arr, p + 1, r);

	}

	/**
	 * 分隔数组，使得arr[p+1...max]>=arr[p]>=arr[0...p-1]
	 * 
	 * @param arr
	 * @param l
	 * @param r
	 * @return
	 */
	private int partition(int[] arr, int l, int r) {
		//System.out.println("l=" + l + " r=" + r);
		// 使用随机的一个元素作为开始元素
		int index = random.nextInt(r - l + 1) + l;
		int t = arr[index];
		arr[index] = arr[l];
		arr[l] = t;
		// 取第一个元素作为比较对象
		int temp = arr[l];
		int i = l + 1, j = r;
		while (true) {
			while (i <= r && arr[i] < temp) {
				i++;
			}
			while (j >=l + 1 && arr[j] > temp) {
				j--;
			}
			if (i > j) {
				break;
			}
			// 交换元素
			t = arr[j];
			arr[j] = arr[i];
			arr[i] = t;
			i++;
			j--;
			
		}

		t = arr[j];
		arr[j] = temp;
		arr[l] = t;

		return j;
	}

	@Override
	public String sortName() {
		// TODO Auto-generated method stub
		return "双路快速排序";
	}

}
