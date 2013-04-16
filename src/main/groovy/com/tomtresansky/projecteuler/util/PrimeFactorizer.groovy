package com.tomtresansky.projecteuler.util

class PrimeFactorizer {
  PrimeGenerator p = new PrimeGenerator()

  public primeFactorize(x) {
    BigInteger remaining = x
    def factors = [:].withDefault{0}

    def i = 0
    while (remaining != 1) {
      def factor = p.primes[i]
      if (remaining.remainder(factor) == 0) {
        remaining = remaining / factor
        factors[factor]+=1
        //println "found ${factor}, remaining ${remaining}"
        i = 0
      } else {
        i++
      }
    }

    return factors
  }
}
