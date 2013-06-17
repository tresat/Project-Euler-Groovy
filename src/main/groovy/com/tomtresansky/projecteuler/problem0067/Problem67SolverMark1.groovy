package com.tomtresansky.projecteuler.problem0067

import com.tomtresansky.projecteuler.AbstractProblemSolver
import com.tomtresansky.projecteuler.util.WeightedDirectedGraph

class Problem67SolverMark1 extends AbstractProblemSolver implements Problem67Solver {
  @Override
  public Integer getProblemNumber() {
    return 67
  }

  @Override
  BigInteger solve() {
    def t = Problem67SolverMark1.class.getResource('problem67-triangle.txt').text

    WeightedDirectedGraph graph = WeightedDirectedGraph.buildGraph(t)
    graph.sourceNodes.collectEntries { s -> [s, graph.longestPath(s, graph.sinkNodes[0])] }.values().max()
  }

  static void main(String... args) {
    run(new Problem67SolverMark1())
  }
}
