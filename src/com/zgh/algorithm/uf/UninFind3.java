package com.zgh.algorithm.uf;

import java.util.Arrays;

import javax.print.attribute.standard.Sides;

public class UninFind3 implements UninFindFunction {

	int[] parent;
	int[] sz;
	int count;

	public UninFind3(int size) {
		count = size;
		parent = new int[size + 1];
		sz = new int[size + 1];
		for (int i = 1; i <= count; i++) {
			parent[i] = i;
			sz[i] = 1;
		}
	}

	@Override
	public boolean isConnected(int a, int b) {
		// TODO Auto-generated method stub
		return find(a) == find(b);
	}

	@Override
	public int find(int p) {
		while (p != parent[p]) {
			p = parent[p];
		}
		return p;
	}

	@Override
	public void unin(int a, int b) {
		int idA = find(a);
		int idB = find(b);
		if (idA == idB) {
			return;
		}
		if (sz[idB] < sz[idA]) {
			parent[idB] = idA;
			sz[idA] += sz[idB];
		} else {
			parent[idA] = idB;
			sz[idB] += sz[idA];
		}

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Arrays.toString(parent);
	}

	@Override
	public String getFunctionName() {
		// TODO Auto-generated method stub
		return "简单并查集3 size优化";
	}

}
