package com.tomtresansky.projecteuler.problem0015

import com.tomtresansky.projecteuler.AbstractProblemSolver


/**
 * This is FUNCTIONAL, but extremely long-running and memory intense for grids bigger than 12x12.
 *
 1 -> 2
 2 -> 6
 3 -> 20
 4 -> 70
 5 -> 252
 6 -> 924
 7 -> 3432
 8 -> 12870
 9 -> 48620
 10 -> 184756
 11 -> 705432
 12 -> 2704156
 */
class Problem15SolverMark1 extends AbstractProblemSolver implements Problem15Solver {
  @Override
  public Integer getProblemNumber() {
    return 15
  }

  private findPaths(int n) {
    assert 0 < n

    def tree = new SolutionTree(n, n)
    //tree.print()

    def paths = tree.getPaths()
    //println paths
    return paths.size()
  }

  @Override
  BigInteger solve() {
    return findPaths(20)
  }

  static void main(String... args) {
    run(new Problem15SolverMark1())
  }

  private static final class SolutionTree {
    private roots = []

    SolutionTree(def xTotal, def yTotal) {
      Node r1 = new Node(val:'_')
      buildTreeRec(r1, xTotal - 1, yTotal)
      roots << r1

      Node r2 = new Node(val:'|')
      buildTreeRec(r2, xTotal, yTotal - 1)
      roots << r2
    }

    private buildTreeRec(Node n, def xLeft, def yLeft) {
      //println "building tree for $n with $xLeft, $yLeft"

      if (xLeft > 0) {
        Node newNode = new Node(val:'_')
        n.children << newNode

        buildTreeRec(newNode, xLeft - 1, yLeft)
      }

      if (yLeft > 0) {
        Node newNode = new Node(val:'|')
        n.children << newNode

        buildTreeRec(newNode, xLeft, yLeft - 1)
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
      def result = []
      roots.each { r -> getPathsRec(r, [], result) }
      return result
    }

    private void getPathsRec(Node n, List currPath, List finalPath) {
      //println "At: $n, path to here: $currPath"

      def results = currPath.clone()
      results << n.val

      if (!n.children.isEmpty()) {
        //println "Recursing with current path: $results"
        n.children.each { c -> getPathsRec(c, results, finalPath) }
      } else {
        finalPath << results
      }
    }

    private static final class Node {
      static idGen = 1

      private id = idGen++
      private val
      private children = new ArrayList(2);

      @Override
      public String toString() {
        return "Node ${id}(${val}) has children ${children.collect { it.id + '(' + it.val + ')' } }"
      }
    }
  }
}
