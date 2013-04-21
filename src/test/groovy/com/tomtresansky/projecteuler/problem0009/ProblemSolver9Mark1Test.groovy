package com.tomtresansky.projecteuler.problem0009

import com.tomtresansky.projecteuler.AbstractProblemSolverTest;
import com.tomtresansky.projecteuler.ProblemSolver

class ProblemSolver9Mark1Test extends AbstractProblemSolverTest {
  @Override
  BigInteger getSolution() {
    return 31875000
  }

  @Override
  Problem9Solver getProblemSolver() {
    return new Problem9SolverMark1()
  }
}
