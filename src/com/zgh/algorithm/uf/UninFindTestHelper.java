package com.zgh.algorithm.uf;

import java.util.Random;

public class UninFindTestHelper {
	private static Random random = new Random();

	public static void testUninfind(UninFindFunction function, int size) {
		System.out.println("开始测试" + function.getFunctionName() + " ,数量为" + size);

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			int a = random.nextInt(size);
			int b = random.nextInt(size);
			function.unin(a, b);
		}
		for (int i = 0; i < size; i++) {
			int a = random.nextInt(size);
			int b = random.nextInt(size);
			function.isConnected(a, b);
		}

		long useTime = System.currentTimeMillis() - startTime;
		System.out.println("耗时" + useTime + "毫秒");

	}

}
