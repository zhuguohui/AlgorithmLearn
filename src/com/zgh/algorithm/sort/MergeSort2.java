package com.zgh.algorithm.sort;

import java.util.Arrays;

import com.zgh.algorithm.SortTestHelper.SortFunction;

/**
 * �Ż��鲢����
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
	 * ��array[l...r] ��Χ���й鲢����
	 * 
	 * @param array
	 * @param l
	 *            ��߽�
	 * @param r
	 *            �ұ߽�
	 */
	private void mergeChile(int[] array, int l, int r) {
		// �ݹ���������
		if (r - l <= miniNumber) {
			// С�����ò�����������Ż�
			InsertSort3.srot(array, l, r);
			return;
		}
		int m = (l + r) / 2;
		// �ݹ����
		mergeChile(array, l, m);
		// �ݹ��ұ�
		mergeChile(array, m + 1, r);
		// �ϲ�����
		if (array[m] > array[m + 1]) {
			merge(array, l, r, m);
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
		return "�鲢�����Ż�";
	}

}
