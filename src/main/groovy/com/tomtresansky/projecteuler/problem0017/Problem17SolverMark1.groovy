package com.tomtresansky.projecteuler.problem0017

import com.tomtresansky.projecteuler.AbstractProblemSolver
import com.tomtresansky.projecteuler.util.NumberWriter

class Problem17SolverMark1 extends AbstractProblemSolver implements Problem17Solver {
  @Override
  public Integer getProblemNumber() {
    return 17
  }

  @Override
  BigInteger solve() {
    NumberWriter nw = new NumberWriter()
    [*1..1000].collect{ nw.words[it].replaceAll(/[\s-]/, '') }.collect { it.size() }.sum()
  }

  static void main(String... args) {
    run(new Problem17SolverMark1())
  }
}
