package com.zgh.algorithm.sort;

import java.util.Arrays;

import com.zgh.algorithm.SortTestHelper.SortFunction;

/**
 * �Ż��鲢����,�Ե�����
 * 
 */
public class MergeSortDU implements SortFunction {

	@Override
	public void sort(int[] arr) {

		for (int size = 2; size <= arr.length; size *= 2) {
			for (int l = 0; l < arr.length; l += size) {
				int r = Math.min(l + size - 1, arr.length - 1);
				int m = l + size / 2 - 1;
				merge(arr, l, r, m);
			}
		}
	}

	private void merge(int[] array, int l, int r, int m) {
		// �������������ڴ�Ž��
		int size = r - l + 1;
		int[] newArray = Arrays.copyOfRange(array, l, r + 1);
		// ��ߵ�ͷԪ��
		int i = l;
		// �ұߵ�ͷԪ��
		int j = m + 1;
		for (int k = 0; k < newArray.length; k++) {

			if (i > m) {
				// ���ȡ�꣬ȡ�ұ�
				newArray[k] = array[j];
				j++;
			} else if (j > r) {
				newArray[k] = array[i];
				i++;
			} else if (array[i] < array[j]) {
				// ��ߵ�С��ȡ��ߵ�
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
		return "�Ե����Ϲ鲢����";
	}

}
