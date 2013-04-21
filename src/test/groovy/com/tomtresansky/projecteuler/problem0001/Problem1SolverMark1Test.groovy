package com.tomtresansky.projecteuler.problem0001

import com.tomtresansky.projecteuler.AbstractProblemSolverTest;
import com.tomtresansky.projecteuler.ProblemSolver

class Problem1SolverMark1Test extends AbstractProblemSolverTest {
  @Override
  BigInteger getSolution() {
    return 233168
  }

  @Override
  Problem1Solver getProblemSolver() {
    return new Problem1SolverMark1()
  }
}
