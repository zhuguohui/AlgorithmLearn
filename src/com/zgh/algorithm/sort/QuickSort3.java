package com.zgh.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

import com.zgh.algorithm.SortTestHelper.SortFunction;

public class QuickSort3 implements SortFunction {
	private static Random random = new Random();

	@Override
	public void sort(int[] arr) {
		// TODO Auto-generated method stub

		quickSrot(arr, 0, arr.length - 1);
	}

	/**
	 * ������[l,r]���п�������
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
	 * �ָ����飬ʹ��arr[p+1...max]>=arr[p]>=arr[0...p-1]
	 * 
	 * @param arr
	 * @param l
	 * @param r
	 * @return
	 */
	private int partition(int[] arr, int l, int r) {
		// System.out.println("l=" + l + " r=" + r);
		// ʹ�������һ��Ԫ����Ϊ��ʼԪ��
		int index = random.nextInt(r - l + 1) + l;
		int t = arr[index];
		arr[index] = arr[l];
		arr[l] = t;
		// ȡ��һ��Ԫ����Ϊ�Ƚ϶���
		int temp = arr[l];
		int lt = l;
		int gt = r+1;
		int i = l + 1;
		for (; i < gt; i++) {
			if (arr[i] < temp) {
				swap(arr, lt + 1, i);
				lt++;
			} else if (arr[i] > temp) {
				swap(arr, gt - 1, i);
				gt--;
				i--;
			}
		}
		swap(arr, l, lt);
		return lt;
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	@Override
	public String sortName() {
		// TODO Auto-generated method stub
		return "��·��������";
	}

}
