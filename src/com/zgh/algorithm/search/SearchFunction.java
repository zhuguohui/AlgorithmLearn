package com.zgh.algorithm.search;

public interface SearchFunction {
	/**
	 * 查找某个数据
	 * 
	 * @param array
	 *            需要查找的数组
	 * @param target
	 *            需要查找的数据
	 * @return 如果有则返回相应的位置，否则返回-1
	 */
	int search(int[] array, int target);

	/**
	 * 查找方法的名称
	 * 
	 * @return
	 */
	String functionName();
}
