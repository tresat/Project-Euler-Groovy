package com.tomtresansky.projecteuler.problem0012

import com.tomtresansky.projecteuler.AbstractProblemSolver
import com.tomtresansky.projecteuler.util.CompositeFactorizer
import com.tomtresansky.projecteuler.util.TriangularNumberGenerator

class Problem12SolverMark1 extends AbstractProblemSolver implements Problem12Solver {
  private CompositeFactorizer cf = new CompositeFactorizer()
  private TriangularNumberGenerator tng = new TriangularNumberGenerator()

  @Override
  public Integer getProblemNumber() {
    return 12;
  }

  @Override
  BigInteger solve() {

    def i = 2
    while (true) {
      BigInteger t = tng.triangularNums[i]
      def factors = cf.countFactors(t)

      if (factors >= 500) {
        return t
      } else {
        i++
      }
    }
  }

  static void main(String... args) {
    run(new Problem12SolverMark1())
  }
}
