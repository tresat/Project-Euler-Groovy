package com.tomtresansky.projecteuler.problem0002

import com.tomtresansky.projecteuler.AbstractProblemSolverTest;
import com.tomtresansky.projecteuler.ProblemSolver

class Problem2SolverMark1Test extends AbstractProblemSolverTest {
  @Override
  BigInteger getSolution() {
    return 4613732
  }

  @Override
  Problem2Solver getProblemSolver() {
    return new Problem2SolverMark1()
  }
}
