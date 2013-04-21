package com.tomtresansky.projecteuler.problem0010

import com.tomtresansky.projecteuler.AbstractProblemSolver
import com.tomtresansky.projecteuler.util.PrimeGenerator

class Problem10SolverMark1 extends AbstractProblemSolver implements Problem10Solver {
  private PrimeGenerator pg = new PrimeGenerator()

  @Override
  public Integer getProblemNumber() {
    return 10
  }

  @Override
  BigInteger solve() {
    def sum = 0
    def i = 0

    while (pg.primes[i] < 2000000) {
      //println pg.primes[i]
      sum += pg.primes[i]
      i++
    }

    sum
  }

  static void main(String... args) {
    run(new Problem10SolverMark1())
  }
}
