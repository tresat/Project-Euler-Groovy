package com.tomtresansky.projecteuler.problem0015

import com.tomtresansky.projecteuler.AbstractProblemSolverTest
import com.tomtresansky.projecteuler.ProblemSolver

class Problem15SolverMark2Test extends AbstractProblemSolverTest {
  @Override
  public BigInteger getSolution() {
    return 137846528820
  }

  @Override
  public Problem15Solver getProblemSolver() {
    return new Problem15SolverMark2()
  }
}