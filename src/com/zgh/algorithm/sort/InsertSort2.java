package com.zgh.algorithm.sort;

import com.zgh.algorithm.SortTestHelper.SortFunction;

public class InsertSort2 implements SortFunction {

	@Override
	public void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i;
			for (; j > 0 && arr[j - 1] > temp; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = temp;
		}

	}

	@Override
	public String sortName() {
		// TODO Auto-generated method stub
		return "插入排序法改进型2";
	}

}
