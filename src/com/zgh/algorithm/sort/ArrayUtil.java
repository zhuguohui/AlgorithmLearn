package com.zgh.algorithm.sort;

public class ArrayUtil {
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static void swap(Object[] array, int a, int b) {
		Object temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
