package com.tomtresansky.projecteuler.problem02

class Solver2Mark1 {
  private ArrayList<Long> knownFibs = [0G, 1G]

  def fib(i) {
      //println "Calcing ${i}"

      if (knownFibs.size > i) {
        knownFibs[i]

        //println "Remembered fib(${i}) = ${knownFibs[i]}"
      } else {
        knownFibs.ensureCapacity(i)
        knownFibs[i] = fib(i - 1) + fib(i - 2)

        //println "Found fib(${i}) = ${knownFibs[i]}"
      }

      return knownFibs[i]
  }

  def solve() {
    def sum = 0, lastFib = 0, i = 0

    while (true) {
      lastFib = fib(i++)

      if (lastFib > 4000000) break;
      if (lastFib % 2 == 0) sum += lastFib
    }

    sum
  }

  static void main(String... args) {
    println ("\nProblem 2: " + new Solver2Mark1().solve())
  }
}

