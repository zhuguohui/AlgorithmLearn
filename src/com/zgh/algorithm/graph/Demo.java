package com.zgh.algorithm.graph;

public class Demo {
	public static void main(String[] args) throws Exception {
		ReadGraph readGraph = new ReadGraph(DenseGraph.class, true, "C:/Users/yuelin/Desktop/G1.txt");
		//readGraph.getGraph().show();
		//ShortestPath path=new ShortestPath(readGraph.getGraph(), 3);
		Path path=new Path(readGraph.getGraph(), 3);
		path.printPath(11);
	//	System.out.println("路径长度为"+path.pathLength(11));
	}
}
