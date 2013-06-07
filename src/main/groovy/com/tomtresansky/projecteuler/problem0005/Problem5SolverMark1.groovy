package com.tomtresansky.projecteuler.problem0005

import com.tomtresansky.projecteuler.AbstractProblemSolver
import com.tomtresansky.projecteuler.util.PrimeFactorizer

class Problem5SolverMark1 extends AbstractProblemSolver implements Problem5Solver {
  private PrimeFactorizer pf = new PrimeFactorizer()

  BigInteger minNumDivisibleByAllNumsUnder(int x) {
    def compositeFactors = [1:1].withDefault {1}

    for (i in 2..x) {
      pf.primeFactorize(i).each { k, v ->
        if (v > compositeFactors[k]) {
          compositeFactors[k] = v
        }
      }
    }

    BigInteger divisible = BigInteger.ONE
    compositeFactors.each { k, v -> divisible*=(k**v) }
    //println "Composite Factorization: ${compositeFactors}"

    return divisible
  }

  @Override
  public Integer getProblemNumber() {
    return 5
  }

  @Override
  BigInteger solve() {
    minNumDivisibleByAllNumsUnder(21)
  }

  static void main(String... args) {
    run(new Problem5SolverMark1())
  }
}
