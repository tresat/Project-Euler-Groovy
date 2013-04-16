package com.tomtresansky.projecteuler.util

class PrimeGenerator {
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
}
