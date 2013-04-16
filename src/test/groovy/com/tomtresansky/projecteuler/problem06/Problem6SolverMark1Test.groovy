package com.tomtresansky.projecteuler.problem06

import org.junit.Test

class Problem6SolverMark1Test extends GroovyTestCase {
  @Test
  void testSolution() {
    assert 25164150 == new Solver6Mark1().solve()
  }
}
