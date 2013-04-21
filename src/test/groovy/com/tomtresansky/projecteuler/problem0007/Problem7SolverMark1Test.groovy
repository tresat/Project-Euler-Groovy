package com.tomtresansky.projecteuler.problem0007

import com.tomtresansky.projecteuler.AbstractProblemSolverTest;

class Problem7SolverMark1Test extends AbstractProblemSolverTest {
  @Override
  BigInteger getSolution() {
    return 104743
  }

  @Override
  Problem7Solver getProblemSolver() {
    return new Problem7SolverMark1()
  }
}