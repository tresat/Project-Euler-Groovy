package com.tomtresansky.projecteuler.problem03

// The prime factors of 13195 are 5, 7, 13 and 29.

// What is the largest prime factor of the number 600851475143 ?

class Solver3Mark1 {
  def primes = [2G]

  def isPrime(e) {
    [2..Math.ceil(e/2G)].findAll { true }

    println "${e} is prime"
  }

  def solve() {
    primes = [2..600851475143].each { e -> isPrime(e) }
    primes.each() {
      println it
    }
  }

  static void main(String... args) {
    println ("\nProblem 3: " + new Solver3Mark1().solve())
  }
}