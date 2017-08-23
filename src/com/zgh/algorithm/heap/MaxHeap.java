package com.zgh.algorithm.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zgh.algorithm.sort.ArrayUtil;

/**
 * 最大堆
 * 
 * @author yuelin
 *
 */
public class MaxHeap {
	int[] array;
	private int count = 0;

	public MaxHeap(int size) {
		array = new int[size + 1];
	}

	public MaxHeap(int[] otherArray) {
		array = new int[otherArray.length + 1];
		for (int i = 0; i < otherArray.length; i++) {
			array[i + 1] = otherArray[i];
		}
		count = otherArray.length;
		for (int i = count / 2; i >= 1; i--) {
			shiftDown(i);
		}
	}

	public int size() {
		return this.count;
	}

	public void insert(int item) {
		array[count + 1] = item;
		count++;
		shiftUp(count);
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public int getTop() {
		int result = -1;
		if (count > 0) {
			result = array[1];
			ArrayUtil.swap(array, 1, count);
			count--;
			shiftDown(1);

		} else {
			throw new RuntimeException("getTop 越界");
		}
		return result;
	}

	private void shiftDown(int index) { // 将第一个元素，放置到正常的位置
		int left = 2 * index;
		int right = left + 1;
		int maxIndex;
		StringBuffer buffer = new StringBuffer();
		while (left <= count) { // 比作左右两个子元素，和最大的那个交换
			maxIndex = right <= count && array[right] > array[left] ? right : left;
			if (array[maxIndex] <= array[index]) {
				break;
			}
			ArrayUtil.swap(array, maxIndex, index);
			index = maxIndex;
			left = 2 * index;
			right = left + 1;
		}
	}

	private void shiftUp(int size2) {
		int i = size2;
		while (i >= 2 && array[i] > array[i / 2]) {
			ArrayUtil.swap(array, i, i / 2);
			i = i / 2;
		}
	}

	@Override
	public String toString() {
		int[] printArray = new int[count];
		for (int i = 0; i < count; i++) {
			printArray[i] = array[i + 1];
		}
		return Arrays.toString(printArray);
	}

}
