package com.zgh.algorithm.graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ShortestPath {
	Graph graph;
	int s = 0;
	int[] from;
	boolean[] visitied;
	int[] order;
	Queue<Integer> queue = new LinkedList<>();

	public ShortestPath(Graph graph, int s) {
		this.graph = graph;
		int size = graph.getPointSize();
		from = new int[size];
		visitied = new boolean[size];
		order = new int[size];
		for (int i = 0; i < size; i++) {
			from[i] = -1;
			order[i] = -1;
			visitied[i] = false;
		}
		this.s = s;
		queue.offer(s);
		visitied[s] = true;
		order[s] = 0;
		search();
	}

	private void search() {
		while (!queue.isEmpty()) {
			int p = queue.poll();
			int o = order[p];
			Iterator<Integer> iterator = graph.getPostionIterator(p);
			while (iterator.hasNext()) {
				Integer next = (Integer) iterator.next();
				if (next != -1) {
					if (visitied[next]) {
						continue;
					} else {
						visitied[next] = true;
						from[next] = p;
						order[next] = o + 1;
						queue.offer(next);
					}
				}
			}
		}

	}

	public int pathLength(int w){
		return order[w];
	}
	
	public boolean hasPath(int w) {
		return visitied[w];
	}

	public int[] findPath(int w) {
		if (!hasPath(w)) {
			return null;
		}
		int[] path = null;
		Stack<Integer> stack = new Stack<>();
		int p = w;
		while (p != -1) {
			stack.push(p);
			p = from[p];
		}
		int size = stack.size();
		if (size != 0) {
			path = new int[size];
			for (int i = 0; i < size; i++) {
				path[i] = stack.pop();
			}
		}
		return path;
	}

	public void printFrom() {
		System.out.println(Arrays.toString(from));
	}

	public void printVisited() {
		System.out.println(Arrays.toString(visitied));
	}

	public void printPath(int w) {
		int[] path = findPath(w);
		if (path != null) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("to " + w + " path:");
			int i = 0;
			for (; i < path.length - 1; i++) {
				buffer.append(path[i] + "->");
			}
			buffer.append(path[i]);
			System.out.println(buffer.toString());
		} else {
			System.out.println("没有到" + w + "的路径");
		}
	}
}
