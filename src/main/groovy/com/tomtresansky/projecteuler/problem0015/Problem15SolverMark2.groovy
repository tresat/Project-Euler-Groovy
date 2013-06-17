package com.tomtresansky.projecteuler.problem0015

import com.tomtresansky.projecteuler.AbstractProblemSolver
import com.tomtresansky.projecteuler.util.PascalsTriangle

class Problem15SolverMark2 extends AbstractProblemSolver implements Problem15Solver {
  @Override
  public Integer getProblemNumber() {
    return 15
  }

  BigInteger solveSquareMaze(int size) {
    PascalsTriangle pt = new PascalsTriangle()
    pt.center(size * 2 + 1)
  }

  @Override
  BigInteger solve() {
    return solveSquareMaze(20)
  }

  static void main(String... args) {
    run(new Problem15SolverMark2())
  }
}
