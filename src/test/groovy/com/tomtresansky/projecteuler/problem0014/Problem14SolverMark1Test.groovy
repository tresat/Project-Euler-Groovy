package com.tomtresansky.projecteuler.problem0014

import com.tomtresansky.projecteuler.AbstractProblemSolverTest
import com.tomtresansky.projecteuler.ProblemSolver

class Problem14SolverMark1Test extends AbstractProblemSolverTest {
  @Override
  public BigInteger getSolution() {
    return 837799
  }

  @Override
  public Problem14Solver getProblemSolver() {
    return new Problem14SolverMark1()
  }
}
