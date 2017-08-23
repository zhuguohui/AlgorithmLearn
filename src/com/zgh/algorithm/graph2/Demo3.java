package com.zgh.algorithm.graph2;

import java.util.Iterator;

import com.zgh.algorithm.graph2.ReadGraph.WeightParser;

public class Demo3 {
	public static void main(String[] args) throws Exception {
		ReadGraph<Double> readGraph = new ReadGraph<Double>(DenseGraph.class, new WeightParser<Double>() {
			@Override
			public Double parserWeight(String info) {
				if (info != null) {
					if (info.startsWith(".")) {
						info = "0" + info;
					}
					return Double.parseDouble(info);
				}
				return null;
			}
		}, false, "C:/Users/yuelin/Desktop/testG1.txt");
		// LazyPrimMST<Double> lazyPrimMST=new
		// LazyPrimMST<>(readGraph.getGraph());
		KruskalMST<Double> mst = new KruskalMST<Double>(readGraph.getGraph());
		Iterator<Edge<Double>> iterator = mst.getMSTEdges();
		double total = 0;
		if (iterator != null) {
			while (iterator.hasNext()) {
				Edge<java.lang.Double> edge = (Edge<java.lang.Double>) iterator.next();
				total += edge.w;
				System.out.println(edge);
			}
		}
		System.out.println("total=" + total);
	}
}
