package com.tomtresansky.projecteuler.problem0019

import groovy.time.TimeCategory

import com.tomtresansky.projecteuler.AbstractProblemSolver

class Problem19SolverMark1 extends AbstractProblemSolver implements Problem19Solver {
  @Override
  public Integer getProblemNumber() {
    return 19
  }

  @Override
  BigInteger solve() {
    def sol = 0

    use(TimeCategory) {
      def currDate = new GregorianCalendar(1901, Calendar.JANUARY, 1).getTime()
      def endDate = new GregorianCalendar(2000, Calendar.DECEMBER, 31).getTime()
      while (currDate < endDate) {
        currDate = currDate.plus(1.months)
        if (currDate.toCalendar().get(Calendar.DAY_OF_WEEK) == 1) {
          sol++
        }
      }
    }

    return sol
  }

  static void main(String... args) {
    run(new Problem19SolverMark1())
  }
}
