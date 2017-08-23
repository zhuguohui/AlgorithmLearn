package com.zgh.algorithm.uf;

public class Demo {
	public static void main(String[] args) {
		int size = 100000;
		UninFindFunction function1 = new UninFind1(size);
		UninFindFunction function2 = new UninFind2(size);
		UninFindFunction function3 = new UninFind3(size);
		UninFindFunction function4 = new UninFind4(size);
		UninFindFunction function5 = new UninFind5(size);
		UninFindFunction function6 = new UninFind5(size);
		UninFindTestHelper.testUninfind(function1, size);
		UninFindTestHelper.testUninfind(function2, size);
		UninFindTestHelper.testUninfind(function3, size);
		UninFindTestHelper.testUninfind(function4, size);
		UninFindTestHelper.testUninfind(function5, size);
		UninFindTestHelper.testUninfind(function6, size);
	}
}
