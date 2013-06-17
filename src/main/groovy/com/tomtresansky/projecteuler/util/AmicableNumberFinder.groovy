package com.tomtresansky.projecteuler.util

class AmicableNumberFinder {
  private CompositeFactorizer cf = new CompositeFactorizer()
  private factorSums = [1:0].withDefault { n -> (cf.allFactors(n) - n).sum() }
  private amicableNumbers = [:].withDefault { n -> getAmicablePair(n) }

  def getAmicablePair(n) {
    return (factorSums[(n)] != 0 && n == factorSums[factorSums[(n)]]) ? factorSums[(n)] : null
  }
}
