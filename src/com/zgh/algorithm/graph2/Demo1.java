package com.zgh.algorithm.graph2;

import com.zgh.algorithm.graph2.ReadGraph.WeightParser;

public class Demo1 {
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
		readGraph.getGraph().show();
	}
}
