package com.zgh.algorithm.search;

/**
 * 二分查找法
 * 
 * @author yuelin
 *
 */
public class BinarySearchFunction implements SearchFunction {

	@Override
	public int search(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		int middle = (left + right) / 2;
		while (left <= right) {
			if (target == array[middle]) {
				return middle;
			} else if (target < array[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right) / 2;
		}
		return -1;
	}

	@Override
	public String functionName() {
		// TODO Auto-generated method stub
		return "二分查找法";
	}

}
