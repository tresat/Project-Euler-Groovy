package com.tomtresansky.projecteuler.problem0003

import com.tomtresansky.projecteuler.AbstractProblemSolverTest;
import com.tomtresansky.projecteuler.ProblemSolver

class Problem3SolverMark1Test extends AbstractProblemSolverTest {
  @Override
  BigInteger getSolution() {
    return 6857
  }

  @Override
  Problem3Solver getProblemSolver() {
    return new Problem3SolverMark1()
  }
}
