package com.tomtresansky.projecteuler.problem0010

import com.tomtresansky.projecteuler.AbstractProblemSolverTest

class Problem10SolverMark1Test extends AbstractProblemSolverTest {
  @Override
  BigInteger getSolution() {
    return 142913828922
  }

  @Override
  Problem10Solver getProblemSolver() {
    return new Problem10SolverMark1()
  }
}
