package com.zgh.algorithm.uf;

public class UninFind1 implements UninFindFunction {

	int[] ids;
	int count;

	public UninFind1(int size) {
		count = size;
		ids = new int[size];
		for (int i = 0; i < count; i++) {
			ids[i] = i;
		}
	}

	@Override
	public boolean isConnected(int a, int b) {
		// TODO Auto-generated method stub
		return find(a) == find(b);
	}

	@Override
	public int find(int a) {
		// TODO Auto-generated method stub
		return ids[a];
	}

	@Override
	public void unin(int a, int b) {
		int idA = find(a);
		int idB = find(b);
		if (idA == idB) {
			return;
		}
		for (int i = 0; i < count; i++) {
			if (ids[i] == idB) {
				ids[i] = idA;
			}
		}

	}

	@Override
	public String getFunctionName() {
		// TODO Auto-generated method stub
		return "简单并查集";
	}

}
