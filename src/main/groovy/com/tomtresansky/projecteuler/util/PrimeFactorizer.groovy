package com.tomtresansky.projecteuler.util

class PrimeFactorizer {
  def primes = [2].withEagerDefault { nextPrime(this.primes) }

  private nextPrime(primes) {
    def potential = ((BigInteger) primes[-1]).nextProbablePrime()

    while (!isPrime(potential, primes)) {
      potential = potential.nextProbablePrime()
    }

    return potential
  }

  private isPrime(potential, primes) {
    for (p in primes) {
      if (potential.remainder(p) == 0) {
        return false
      }
    }

    return true
  }

  public primeFactorize(x) {
    BigInteger remaining = x
    def factors = [:].withDefault{0}

    def i = 0
    while (remaining != 1) {
      def factor = primes[i]
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
