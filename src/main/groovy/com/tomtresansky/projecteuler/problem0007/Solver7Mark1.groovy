package com.tomtresansky.projecteuler.problem0007

import com.tomtresansky.projecteuler.util.PrimeGenerator

class Solver7Mark1 implements Problem7Solver {
  PrimeGenerator p = new PrimeGenerator()

  BigInteger prime(x) {
    p.primes[x-1]
  }

  BigInteger solve() {
    prime(10001)
  }

  static void main(String... args) {
    println ("Problem 7: " + new Solver7Mark1().solve())
  }
}
