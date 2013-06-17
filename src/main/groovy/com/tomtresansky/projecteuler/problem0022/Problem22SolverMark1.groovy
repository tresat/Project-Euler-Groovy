package com.tomtresansky.projecteuler.problem0022

import com.tomtresansky.projecteuler.AbstractProblemSolver

class Problem22SolverMark1 extends AbstractProblemSolver implements Problem22Solver {
  @Override
  public Integer getProblemNumber() {
    return 22
  }

  @Override
  BigInteger solve() {
    def a = ((int) 'A') - 1
    def names = Problem22SolverMark1.class.getResource('problem22-names.txt').text.replace('"', '').split(/,/).sort()
    def values = names.collectEntries { n ->
      [n, n.collect { l ->
          ((int) l) - a
        }]
    }
    BigInteger sol = 0
    names.eachWithIndex() { n, i ->
      //println "$n ${values[(n)]} at ${(i + 1)} with sum ${values[(n)].sum()}"
      sol +=  (i + 1) * (values[(n)].sum())
    }

    return sol
  }

  static void main(String... args) {
    run(new Problem22SolverMark1())
  }
}

