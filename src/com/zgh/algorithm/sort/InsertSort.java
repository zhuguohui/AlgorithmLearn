package com.zgh.algorithm.sort;

import java.util.concurrent.atomic.AtomicBoolean;

import com.zgh.algorithm.SortTestHelper.SortFunction;

public class InsertSort implements SortFunction {

	@Override
	public void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				} else {
					break;
				}
			}
		}

	}

	@Override
	public String sortName() {
		// TODO Auto-generated method stub
		return "²åÈëÅÅÐò·¨";
	}

}
