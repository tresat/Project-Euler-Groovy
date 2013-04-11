package com.tomtresansky.projecteuler.problem03



/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */
class Solver3Mark1 {
  private primes = [2].withEagerDefault({ nextPrime(this.primes) })

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

  Map primeFactorize(BigInteger x) {
    def remaining = x
    def factors = [:].withDefault{0}

    def i = 0
    while (remaining != 1) {
      def factor = primes[i]
      if (remaining.remainder(factor) == 0) {
        remaining = remaining / factor
        factors[factor]+=1
        // println "found ${factor}, remaining ${remaining}"
        i = 0
      } else {
        i++
      }
    }

    factors
  }

  def solve() {
    primeFactorize(600851475143G).keySet().max()
  }

  static void main(String... args) {
    println ("\nProblem 3: " + new Solver3Mark1().solve())
  }
}