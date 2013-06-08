package com.tomtresansky.projecteuler.problem0015

import com.tomtresansky.projecteuler.AbstractProblemSolver

class Problem15SolverMark1 extends AbstractProblemSolver implements Problem15Solver {
  @Override
  public Integer getProblemNumber() {
    return 15
  }

  private findPaths(int n) {
    assert 1 < n

    def x = ['_']*n
    def y = ['|']*n

    def tree = new SolutionTree(x, y)
    tree.print()

    def paths = tree.getPaths()
    println paths
    return paths.size()
  }

  @Override
  BigInteger solve() {
    return findPaths(2)
  }

  static void main(String... args) {
    run(new Problem15SolverMark1())
  }

  private static final class SolutionTree {
    private roots = []

    SolutionTree(List xTotal, List yTotal) {
      Node r1 = new Node(val:xTotal[0])
      buildTreeRec(r1, new ArrayList(xTotal - 1), yTotal)
      roots << r1

      Node r2 = new Node(val:yTotal[0])
      buildTreeRec(r2, xTotal, new ArrayList(yTotal - 1))
      roots << r2
    }

    private buildTreeRec(Node n, List xLeft, List yLeft) {
      println "building tree for $n with $xLeft, $yLeft"

      if (!xLeft.isEmpty()) {
        Node newNode = new Node(val:xLeft[0])
        n.children << newNode

        buildTreeRec(newNode, new ArrayList(xLeft - 1), yLeft)
      }

      if (!yLeft.isEmpty()) {
        Node newNode = new Node(val:yLeft[0])
        n.children << newNode

        buildTreeRec(newNode, xLeft, new ArrayList(yLeft - 1))
      }
    }

    def print() {
      roots.each { r -> printRec(r) }
    }

    private printRec(Node n) {
      println n
      n.children.each { c -> printRec(c) }
    }

    List getPaths() {
      roots.collect { r -> getPathsRec(r, []) }
    }

    private List getPathsRec(Node n, List currPath) {
      println "At: $n, path to here: $currPath"

      def results = currPath.clone()
      results << n.val

      if (!n.children.isEmpty()) {
        println "Recursing with current path: $results"
        results = n.children.collect { c -> getPathsRec(c, results) }
      }

      return results
    }

    private static final class Node {
      static idGen = 1

      private id = idGen++
      private val
      private children = []

      @Override
      public String toString() {
        return "Node ${id}(${val}) has children ${children.collect { it.id + '(' + it.val + ')' } }"
      }
    }
  }
}
