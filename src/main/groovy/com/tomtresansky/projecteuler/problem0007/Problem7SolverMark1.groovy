package com.tomtresansky.projecteuler.problem0007

import com.tomtresansky.projecteuler.AbstractProblemSolver
import com.tomtresansky.projecteuler.util.PrimeGenerator

class Problem7SolverMark1 extends AbstractProblemSolver implements Problem7Solver {
  PrimeGenerator pg = new PrimeGenerator()

  @Override
  public Integer getProblemNumber() {
    return 7
  }

  @Override
  BigInteger solve() {
    def n = 10001

    pg.primes[n-1]
  }

  static void main(String... args) {
    run(new Problem7SolverMark1())
  }
}
