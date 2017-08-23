package com.zgh.algorithm.sort;

import com.zgh.algorithm.SortTestHelper.SortFunction;

public class SelectionSort implements SortFunction {

	@Override
	public void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int miniIndxe = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[miniIndxe]) {
					miniIndxe = j;
				}
			}
			if (miniIndxe != i) {
				int temp = arr[i];
				arr[i] = arr[miniIndxe];
				arr[miniIndxe] = temp;
			}
		}

	}

	@Override
	public String sortName() {
		// TODO Auto-generated method stub
		return "Ñ¡ÔñÅÅÐò·¨";
	}

}
