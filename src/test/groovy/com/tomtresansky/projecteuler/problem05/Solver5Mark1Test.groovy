package com.tomtresansky.projecteuler.problem05

import org.junit.Test

class Problem5SolverMark1Test extends GroovyTestCase {
  @Test
  void testSolution() {
    assert 232792560 == new Solver5Mark1().solve()
  }
}