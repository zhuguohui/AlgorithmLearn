package com.zgh.algorithm.graph2;

import java.util.Arrays;

import com.zgh.algorithm.sort.ArrayUtil;

/**
 * 最小索引堆 *
 */
public class IndexMinHeap<W extends Comparable<W>> {
	Object[] dataArray;// 保存数据
	int[] indexArray;// 保存索引

	private int count = 0;

	public IndexMinHeap(int size) {
		dataArray = new Object[size + 1];
		indexArray = new int[size + 1];
	}

	public int size() {
		return this.count;
	}

	public void insert(int i, W item) {
		i += 1;
		dataArray[i] = item;
		count++;
		indexArray[count] = i;
		shiftUp(count);
	}

	public boolean contain(int index) {
		index += 1;
		return dataArray[index] != null;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public int getTopIndex() {
		return indexArray[1] - 1;
	}

	public W getTop() {
		W result = null;
		if (count > 0) {
			result = (W) dataArray[indexArray[1]];
			ArrayUtil.swap(indexArray, 1, count);
			count--;
			shiftDown(1);

		} else {
			throw new RuntimeException("getTop 越界");
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private void shiftDown(int start) { // 将第一个元素，放置到正常的位置
		int index = start;
		int left = 2 * index;
		int right = left + 1;
		int minIndex;
		while (left <= count) { // 比作左右两个子元素，和最大的那个交换
			W rightItem = (W) (right < count ? dataArray[indexArray[right]] : null);
			W leftItem = (W) dataArray[indexArray[left]];
			minIndex = rightItem != null && rightItem.compareTo(leftItem) < 0 ? right : left;
			if (((W) dataArray[indexArray[minIndex]]).compareTo((W) dataArray[indexArray[index]]) > 0) {
				break;
			}
			ArrayUtil.swap(indexArray, minIndex, index);
			index = minIndex;
			left = 2 * index;
			right = left + 1;
		}
	}

	public void change(int index, W item) {
		index += 1;
		dataArray[index] = item;
		for (int i = 1; i <= count; i++) {
			if (indexArray[i] == index) {
				shiftDown(i);
				shiftUp(i);
				break;
			}
		}
	}

	private void shiftUp(int size2) {
		int i = size2;
		while (i >= 2 && ((W) dataArray[indexArray[i]]).compareTo((W) dataArray[indexArray[i / 2]]) < 0) {
			ArrayUtil.swap(indexArray, i, i / 2);
			i = i / 2;
		}
	}

	@Override
	public String toString() {
		Object[] printArray = new Object[count];
		for (int i = 0; i < count; i++) {
			printArray[i] = dataArray[indexArray[i + 1]];
		}
		return Arrays.toString(printArray);
	}

	public String getRawArrayString() {
		Object[] printArray = new Object[count];
		for (int i = 0; i < count; i++) {
			printArray[i] = dataArray[i + 1];
		}
		return Arrays.toString(printArray);
	}

	public String getSortedArrayString() {
		final int size = count;
		final int[] backupIndex = Arrays.copyOf(indexArray, indexArray.length);
		Object[] printArray = new Object[size];
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
