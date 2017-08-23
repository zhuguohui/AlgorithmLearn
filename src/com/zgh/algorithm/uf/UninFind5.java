package com.zgh.algorithm.uf;

import java.util.Arrays;

import javax.print.attribute.standard.Sides;

public class UninFind5 implements UninFindFunction {

	int[] parent;
	int[] rank;
	int count;

	public UninFind5(int size) {
		count = size;
		parent = new int[size + 1];
		rank = new int[size + 1];
		for (int i = 1; i <= count; i++) {
			parent[i] = i;
			rank[i] = 1;
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
			parent[p] = parent[parent[p]];
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
		if (rank[idB] < rank[idA]) {
			parent[idB] = idA;
			rank[idA] += rank[idB];
		} else if (rank[idB] > rank[idA]) {
			parent[idA] = idB;
		} else {
			parent[idA] = idB;
			rank[idB] += 1;
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
		return "简单并查集5 路径压缩优化";
	}

}
