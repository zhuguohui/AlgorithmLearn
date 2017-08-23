package com.zgh.algorithm.graph;

import java.util.Iterator;
import java.util.Random;

public class TestGraphHelper {
	private static Random random = new Random();

	public static void testGraph(Graph graph, int size, int edageSize) {
		for (int i = 0; i < edageSize; i++) {
			int a = random.nextInt(size);
			int b = random.nextInt(size);
			graph.addEdge(a, b);
		}
		for (int i = 0; i < size; i++) {
			Iterator<Integer> iterator = graph.getPostionIterator(i);
			StringBuffer buffer = new StringBuffer();
			buffer.append(i + ":");
			while (iterator.hasNext()) {
				Integer integer = (Integer) iterator.next();
				if (integer != -1) {
					buffer.append(integer + " ");
				} else {
					break;
				}
			}
			System.out.println(buffer.toString());
		}
	}
}
