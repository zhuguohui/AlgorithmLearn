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
		System.out.println("ʹ��" + function.functionName() + "������" + arrayInfo + "����Ԫ��" + target);
		System.out.println("�ڵ�" + function.search(array, target) + "��λ���ҵ�");
	}
}
