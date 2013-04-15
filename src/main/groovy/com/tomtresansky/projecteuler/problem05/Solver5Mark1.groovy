package com.tomtresansky.projecteuler.problem05

import com.tomtresansky.projecteuler.util.PrimeFactorizer

class Solver5Mark1 implements Problem5Solver {
  private PrimeFactorizer f = new PrimeFactorizer()

  BigInteger minNumDivisibleByAllNumsUnder(int x) {
    def compositeFactors = [:].withDefault {1}

    for (i in 1..x) {
        f.primeFactorize(i).each { k, v ->
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

  BigInteger solve() {
    minNumDivisibleByAllNumsUnder(21)
  }

  static void main(String... args) {
    println ("Problem 5: " + new Solver5Mark1().solve())
  }
}
