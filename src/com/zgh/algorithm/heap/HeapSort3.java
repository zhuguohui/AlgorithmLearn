package com.zgh.algorithm.heap;

import com.zgh.algorithm.SortTestHelper.SortFunction;
import com.zgh.algorithm.sort.ArrayUtil;

public class HeapSort3 implements SortFunction {

	@Override
	public void sort(int[] array) {
		for (int i = (array.length - 1) / 2; i >= 0; i--) {
			shiftDown(array, array.length, i);
		}

		for (int i = array.length - 1; i > 0; i--) {
			ArrayUtil.swap(array, i, 0);
			shiftDown(array, i, 0);
		}
	}

	private void shiftDown(int[] array, int count, int index) { // ����һ��Ԫ�أ����õ�������λ��
		int left = 2 * index + 1;
		int right = left + 1;
		int maxIndex;
		StringBuffer buffer = new StringBuffer();
		while (left < count) { // ��������������Ԫ�أ��������Ǹ�����
			maxIndex = right < count && array[right] > array[left] ? right : left;
			if (array[maxIndex] <= array[index]) {
				break;
			}
			ArrayUtil.swap(array, maxIndex, index);
			index = maxIndex;
			left = 2 * index + 1;
			right = left + 1;
		}
	}

	@Override
	public String sortName() {
		// TODO Auto-generated method stub
		return "������Ľ�3";
	}

}
