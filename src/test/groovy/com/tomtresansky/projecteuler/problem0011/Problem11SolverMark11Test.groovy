package com.tomtresansky.projecteuler.problem0011

import com.tomtresansky.projecteuler.AbstractProblemSolverTest

class Problem11SolverMark11Test extends AbstractProblemSolverTest {
  @Override
  BigInteger getSolution() {
    return 70600674
  }

  @Override
  Problem11Solver getProblemSolver() {
    return new Problem11SolverMark1()
  }
}
