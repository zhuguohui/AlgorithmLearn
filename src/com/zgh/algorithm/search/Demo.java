package com.zgh.algorithm.search;

import java.util.Arrays;

import com.zgh.algorithm.SortTestHelper;

public class Demo {
	public static void main(String[] args) {
		int size = 10;
		int target = 11;
		int[] array = SortTestHelper.generateNearlyOrderedArray(size, 0);
		SearchFunction function = new BinarySearchFunction();
		String arrayInfo = Arrays.toString(array);
		System.out.println("使用" + function.functionName() + "在数组" + arrayInfo + "查找元素" + target);
		System.out.println("在第" + function.search(array, target) + "个位置找到");
	}
}
