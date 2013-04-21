package com.tomtresansky.projecteuler.problem0009

import com.tomtresansky.projecteuler.AbstractProblemSolver
import com.tomtresansky.projecteuler.util.PythagoreanTripler

class Problem9SolverMark1 extends AbstractProblemSolver implements Problem9Solver {
  private PythagoreanTripler t = new PythagoreanTripler()

  @Override
  public Integer getProblemNumber() {
    return 9
  }

  @Override
  BigInteger solve() {
    def triple = t.findTripleWhichSumsTo(1000)
    solution = triple.inject(1) { val, acc -> acc *= val }
  }

  static void main(String... args) {
    run(new Problem9SolverMark1())
  }
}
