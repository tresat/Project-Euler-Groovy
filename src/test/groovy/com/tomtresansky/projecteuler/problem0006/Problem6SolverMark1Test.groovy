package com.tomtresansky.projecteuler.problem0006

import com.tomtresansky.projecteuler.AbstractProblemSolverTest;

class Problem6SolverMark1Test extends AbstractProblemSolverTest {
  @Override
  BigInteger getSolution() {
    return 25164150
  }

  @Override
  Problem6Solver getProblemSolver() {
    return new Problem6SolverMark1()
  }
}
