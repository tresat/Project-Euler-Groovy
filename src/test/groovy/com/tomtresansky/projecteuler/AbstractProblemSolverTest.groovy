package com.tomtresansky.projecteuler

import org.junit.Test

import com.tomtresansky.projecteuler.ProblemSolver

abstract class AbstractProblemSolverTest extends GroovyTestCase {
  abstract BigInteger getSolution()
  abstract ProblemSolver getProblemSolver()

  @Test
  void test() {
    assert getSolution() == getProblemSolver().solve()
  }
}
