package com.zgh.algorithm.search;

public interface SearchFunction {
	/**
	 * ����ĳ������
	 * 
	 * @param array
	 *            ��Ҫ���ҵ�����
	 * @param target
	 *            ��Ҫ���ҵ�����
	 * @return ������򷵻���Ӧ��λ�ã����򷵻�-1
	 */
	int search(int[] array, int target);

	/**
	 * ���ҷ���������
	 * 
	 * @return
	 */
	String functionName();
}
