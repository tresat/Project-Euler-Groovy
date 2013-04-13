package com.tomtresansky.projecteuler.problem04

class Factorizer {
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

class Palindromer {
  def isPalindrome(x) {
    def str = x.toString()
    def len = str.size()

    for (i in 0..Math.floor(len/2)) {
      //println "first = ${str[i]}, last = ${str[-(i+1)]}"
      if (str[i] != str[-(i+1)]) {
        return false
      }
    }

    return true
  }
}

class Solver4Mark1 {
  def allPairs(Map factors) {
    def pairs = [] as Set
    def flatfactors = factors.collect{ k, v -> [k]*v }.flatten()

    def lim = flatfactors.size()

    def groupings = new boolean[lim]
    Arrays.fill(groupings, false)

    for (i in 0..<lim) {
      // Set flag at 0..i=1
      Arrays.fill(groupings, 0, i+1, true)
      // Unset flags at i+1..<lim
      Arrays.fill(groupings, i+1, lim, false)

      for (j in i..<lim) {
        // Set flag at j
        groupings[j] = true

        def pair = [1, 1]
        for (k in 0..<lim) {
          if (groupings[k]) {
            pair[0] *= flatfactors[k]
          } else {
            pair[1] *= flatfactors[k]
          }
        }

        // Don't add reverses
        if (!pairs.contains([pair[1], pair[0]])) {
          pairs << pair
        }

        // Unset flag at j
        groupings[j] = false
      }
    }

    return pairs
  }

  def solve() {
    Factorizer f = new Factorizer()
    Palindromer p = new Palindromer()

    for (i in 999999..99000) {
      if (p.isPalindrome(i)) {
        def factors = f.primeFactorize(i)
        def pairs = allPairs(factors)
        println "$i -> $factors -> $pairs"

        def threeDigitPair = pairs.find { it[0] >=100 && it[0] <= 999 && it[1] >= 100 && it[1] <= 999 }
        if (threeDigitPair) {
          println "Solution: ${i} (${threeDigitPair})"
          return i
        }
      }
    }

  }

  static void main(String... args) {
    println ("\nProblem 4: " + new Solver4Mark1().solve())
  }
}