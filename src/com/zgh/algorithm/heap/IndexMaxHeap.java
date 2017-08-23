package com.zgh.algorithm.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zgh.algorithm.SortTestHelper.TestArray;
import com.zgh.algorithm.sort.ArrayUtil;

/**
 * 最大堆
 * 
 * @author yuelin
 *
 */
public class IndexMaxHeap {
	int[] dataArray;// 保存数据
	int[] indexArray;// 保存索引

	private int count = 0;

	public IndexMaxHeap(int size) {
		dataArray = new int[size + 1];
		indexArray = new int[size + 1];
	}

	public int size() {
		return this.count;
	}

	public void insert(int item) {
		dataArray[count + 1] = item;
		count++;
		indexArray[count] = count;
		shiftUp(count);
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public int getTopIndex() {
		return indexArray[1] - 1;
	}

	public int getTop() {
		int result = -1;
		if (count > 0) {
			result = dataArray[indexArray[1]];
			ArrayUtil.swap(indexArray, 1, count);
			count--;
			shiftDown(1);

		} else {
			throw new RuntimeException("getTop 越界");
		}
		return result;
	}

	private void shiftDown(int start) { // 将第一个元素，放置到正常的位置
		int index = start;
		int left = 2 * index;
		int right = left + 1;
		int maxIndex;
		while (left <= count) { // 比作左右两个子元素，和最大的那个交换
			maxIndex = right <= count && dataArray[indexArray[right]] > dataArray[indexArray[left]] ? right : left;
			if (dataArray[indexArray[maxIndex]] <= dataArray[indexArray[index]]) {
				break;
			}
			ArrayUtil.swap(indexArray, maxIndex, index);
			index = maxIndex;
			left = 2 * index;
			right = left + 1;
		}
	}

	public void change(int index, int item) {
		dataArray[index] = item;
		int mIndex = 0;
		for (int i = 1; i <= count; i++) {
			if (indexArray[i] == index) {
				mIndex = i;
				shiftDown(i);
				shiftUp(i);
				break;
			}
		}
	}

	private void shiftUp(int size2) {
		int i = size2;
		while (i >= 2 && dataArray[indexArray[i]] > dataArray[indexArray[i / 2]]) {
			ArrayUtil.swap(indexArray, i, i / 2);
			i = i / 2;
		}
	}

	@Override
	public String toString() {
		int[] printArray = new int[count];
		for (int i = 0; i < count; i++) {
			printArray[i] = dataArray[indexArray[i + 1]];
		}
		return Arrays.toString(printArray);
	}

	public String getRawArrayString() {
		int[] printArray = new int[count];
		for (int i = 0; i < count; i++) {
			printArray[i] = dataArray[i + 1];
		}
		return Arrays.toString(printArray);
	}

	public String getSortedArrayString() {
		final int size = count;
		final int[] backupIndex = Arrays.copyOf(indexArray, indexArray.length);
		int[] printArray = new int[size];
		for (int i = 0; i < size; i++) {
			printArray[i] = getTop();
		}
		// 还原
		count = size;
		for (int i = 1; i <= count; i++) {
			indexArray[i] = backupIndex[i];
		}
		return Arrays.toString(printArray);

	}

}
