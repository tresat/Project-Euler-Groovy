package com.tomtresansky.projecteuler

interface ProblemSolver {
  Integer getProblemNumber()
  BigInteger getSolution()
  BigDecimal getTime()

  BigInteger solve()
  BigDecimal timeSolution()
}
