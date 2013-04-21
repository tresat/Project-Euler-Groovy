package com.tomtresansky.projecteuler.problem0008

import com.tomtresansky.projecteuler.AbstractProblemSolverTest;

class Problem8SolverMark1Test extends AbstractProblemSolverTest {
  @Override
  BigInteger getSolution() {
    return 40824
  }

  @Override
  Problem8Solver getProblemSolver() {
    return new Problem8SolverMark1()
  }
}
