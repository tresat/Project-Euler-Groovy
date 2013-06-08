package com.tomtresansky.projecteuler.problem0014

import com.tomtresansky.projecteuler.AbstractProblemSolver
import com.tomtresansky.projecteuler.util.CollatzGenerator

class Problem14SolverMark1 extends AbstractProblemSolver implements Problem14Solver {
  @Override
  public Integer getProblemNumber() {
    return 14
  }

  @Override
  BigInteger solve() {
    CollatzGenerator cg = new CollatzGenerator()
    [*1..1000000].each { cg.generateCollatz(it) }

    def maxKey = cg.collatz.collectEntries([:]) { k, v -> [k, v.flatten().size] }.max { e -> e.value }.key
    //println "$maxKey -> ${cg.collatz[maxKey]} with size: ${cg.collatz[maxKey].size}"
    return new BigInteger(maxKey)
  }

  static void main(String... args) {
    run(new Problem14SolverMark1())
  }
}
