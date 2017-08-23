package com.zgh.algorithm.uf;

public interface UninFindFunction {
	boolean isConnected(int a, int b);

	int find(int a);

	void unin(int a, int b);

	String getFunctionName();
}
