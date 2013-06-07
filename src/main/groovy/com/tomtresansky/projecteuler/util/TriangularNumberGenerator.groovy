package com.tomtresansky.projecteuler.util

class TriangularNumberGenerator {
  def triangularNums = [0G].withEagerDefault { i -> i + (triangularNums[-1]) }
}
