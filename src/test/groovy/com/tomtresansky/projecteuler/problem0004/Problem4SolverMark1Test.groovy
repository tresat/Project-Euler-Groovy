package com.tomtresansky.projecteuler.problem0004

import com.tomtresansky.projecteuler.AbstractProblemSolverTest;

class Problem4SolverMark1Test extends AbstractProblemSolverTest {
  @Override
  BigInteger getSolution() {
    return 906609
  }

  @Override
  Problem4Solver getProblemSolver() {
    return new Problem4SolverMark1()
  }
}
