package com.zgh.algorithm.graph2;

import java.util.Arrays;

import com.zgh.algorithm.sort.ArrayUtil;

/**
 * ��С��
 * 
 * @author yuelin
 *
 */
public class MinHeap<W extends Comparable<W>> {
	Object[] array;
	private int count = 0;

	@SuppressWarnings("unchecked")
	public MinHeap(int size) {
		array = new Object[size + 1];
	}

	@SuppressWarnings("unchecked")
	public MinHeap(W[] otherArray) {
		array = (W[]) new Object[otherArray.length + 1];
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

	public void insert(W item) {
		array[count + 1] = item;
		count++;
		shiftUp(count);
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public W getTop() {
		W result = null;
		if (count > 0) {
			result = (W) array[1];
			ArrayUtil.swap(array, 1, count);
			count--;
			shiftDown(1);

		} else {
			throw new RuntimeException("getTop Խ��");
		}
		return result;
	}

	private void shiftDown(int index) { // ����һ��Ԫ�أ����õ�������λ��
		int left = 2 * index;
		int right = left + 1;
		int minIndex;
		StringBuffer buffer = new StringBuffer();
		while (left <= count) { // ��������������Ԫ�أ�����С���Ǹ�����
			minIndex = right <= count && ((Comparable<W>) array[right]).compareTo((W) array[left]) < 0 ? right : left;
			if (((Comparable<W>) array[minIndex]).compareTo((W) array[index]) > 0) {
				break;
			}
			ArrayUtil.swap(array, minIndex, index);
			index = minIndex;
			left = 2 * index;
			right = left + 1;
		}
	}

	private void shiftUp(int size2) {
		int i = size2;
		while (i >= 2 && ((Comparable<W>) array[i]).compareTo((W) array[i / 2]) < 0) {
			ArrayUtil.swap(array, i, i / 2);
			i = i / 2;
		}
	}

	@Override
	public String toString() {
		Object[] printArray = new Object[count];
		for (int i = 0; i < count; i++) {
			printArray[i] = array[i + 1];
		}
		return Arrays.toString(printArray);
	}

}
