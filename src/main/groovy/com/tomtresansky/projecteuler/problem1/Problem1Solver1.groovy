package com.tomtresansky.projecteuler.problem1

class Problem1Solver1 {
  static void main(String... args) {
    println ("\nProblem 1: " + solve())
  }

  static solve() {
    def sum = 0

    for (i in (0..<1000).step(3)) {
      sum += i
    }

    for (i in (0..<1000).step(5)) {
      sum += i
    }

    for (i in (0..<1000).step(15)) {
      sum -= i
    }

    sum
  }
}
