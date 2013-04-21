package com.tomtresansky.projecteuler


abstract class AbstractProblemSolver implements ProblemSolver {
  BigInteger solution
  BigDecimal time

  @Override
  abstract BigInteger solve()

  @Override
  BigDecimal timeSolution() {
    def start = System.currentTimeMillis()
    solution = solve()
    def end = System.currentTimeMillis()
    time = (end - start) / 1000
  }

  static run(ProblemSolver ps) {
    ps.timeSolution()
    println "${ps.class.getSimpleName()} found problem ${ps.getProblemNumber()} solution: ${ps.getSolution()} in ${ps.getTime()} sec"
  }
}
