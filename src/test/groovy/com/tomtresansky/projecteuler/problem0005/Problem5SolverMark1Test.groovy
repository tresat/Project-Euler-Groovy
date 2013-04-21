package com.tomtresansky.projecteuler.problem0005

import com.tomtresansky.projecteuler.AbstractProblemSolverTest
import com.tomtresansky.projecteuler.ProblemSolver

class Problem5SolverMark1Test extends AbstractProblemSolverTest {
  @Override
  BigInteger getSolution() {
    return 232792560
  }

  @Override
  Problem5Solver getProblemSolver() {
    return new Problem5SolverMark1()
  }
}