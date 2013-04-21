package com.tomtresansky.projecteuler.problem0003

import com.tomtresansky.projecteuler.AbstractProblemSolver
import com.tomtresansky.projecteuler.util.PrimeFactorizer

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */
class Problem3SolverMark1 extends AbstractProblemSolver implements Problem3Solver {
  private PrimeFactorizer pf = new PrimeFactorizer()

  @Override
  public Integer getProblemNumber() {
    return 3
  }

  @Override
  BigInteger solve() {
    pf.primeFactorize(600851475143G).keySet().max()
  }

  static void main(String... args) {
    run(new Problem3SolverMark1())
  }
}