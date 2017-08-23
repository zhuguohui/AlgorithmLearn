package com.zgh.algorithm.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.zgh.algorithm.SortTestHelper.TestArray;
import com.zgh.algorithm.sort.ArrayUtil;

/**
 * 最大堆
 * 
 * @author yuelin
 *
 */
public class IndexMaxHeap2 {
	int[] dataArray;// 保存数据
	int[] indexArray;// 保存索引,安装堆的逻辑
	int[] reverseIndexArray;// 保存dataArray中第i个元素，在indexArray中的位置
	private int count = 0;

	public IndexMaxHeap2(int size) {
		dataArray = new int[size + 1];
		indexArray = new int[size + 1];
		reverseIndexArray = new int[size + 1];
	}

	public int size() {
		return this.count;
	}

	public void insert(int item) {
		dataArray[count + 1] = item;
		count++;
		indexArray[count] = count;
		reverseIndexArray[count] = count;
		shiftUp(count);
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public int getTop() {
		int result = -1;
		if (count > 0) {
			result = dataArray[indexArray[1]];
			ArrayUtil.swap(indexArray, 1, count);
			reverseIndexArray[indexArray[1]] = 1;
			reverseIndexArray[indexArray[count]] = 0;// 0表示该位置不在堆中
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
			reverseIndexArray[indexArray[maxIndex]] = maxIndex;
			reverseIndexArray[indexArray[index]] = index;
			index = maxIndex;
			left = 2 * index;
			right = left + 1;
		}
	}

	private boolean containt(int index) {
		if (index >= 1 && index <= count) {
			if (reverseIndexArray[index] != 0) {
				return true;
			}
		}
		return false;
	}

	public void change(int index, int item) {
		if (!containt(index)) {
			System.out.println("该元素不在堆中，不可改变");
			return;
		}
		dataArray[index] = item;
		int mIndex = reverseIndexArray[index];
		shiftDown(mIndex);
		shiftUp(mIndex);

	}

	private void shiftUp(int size2) {
		int i = size2;
		while (i >= 2 && dataArray[indexArray[i]] > dataArray[indexArray[i / 2]]) {
			ArrayUtil.swap(indexArray, i, i / 2);
			reverseIndexArray[indexArray[i]] = i;
			reverseIndexArray[indexArray[i / 2]] = i / 2;
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
		final int[] backupIndex = Arrays.copyOf(indexArray, count + 1);
		final int[] backupReverseIndex = Arrays.copyOf(reverseIndexArray, count + 1);
		int[] printArray = new int[size];
		for (int i = 0; i < size; i++) {
			printArray[i] = getTop();
		}
		// 还原
		count = size;
		for (int i = 1; i <= count; i++) {
			indexArray[i] = backupIndex[i];
			reverseIndexArray[i] = backupReverseIndex[i];
		}
		return Arrays.toString(printArray);

	}

}
