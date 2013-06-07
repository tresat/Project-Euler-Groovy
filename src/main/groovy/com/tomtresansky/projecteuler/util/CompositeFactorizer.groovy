package com.tomtresansky.projecteuler.util

class CompositeFactorizer {
  private PrimeFactorizer pf = new PrimeFactorizer()
  private Map knownFactorCounts = [1:1]

  BigInteger countFactors(x) {
    assert x > 0

    if (!knownFactorCounts.containsKey(x)) {
      Map primeFactors = pf.primeFactorize(x)
      //println primeFactors
      BigInteger factorCount = primeFactors.keySet().inject(1) { acc, val -> acc *= (primeFactors[val] + 1) }

      knownFactorCounts[x] = factorCount
    }

    return knownFactorCounts[x]
  }

  Set allFactors(x) {
    allPairs(pf.primeFactorize(x)).flatten()
  }

  Set allPairs(Map factors) {
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
}
