package com.tomtresansky.projecteuler.util

class PythagoreanTripler {
  def triples = [].withLazyDefault { c -> findTriples(c) }

  def List findTriples(c) {
    def trips = []

    //println "c: $c"
    def c2 = c**2
    for (a in 1..<c) {
      def a2 = a**2
      for (b in a+1..<c) {
        //println "a: $a, b: $b, c: $c"
        if (a2 + b**2 == c2) {
          trips << [a, b]
        }
      }
    }

    trips
  }

  def findTripleWhichSumsTo(x) {
    for (c in 0..x) {
      for (trip in triples[c]) {
        def a = trip[0]
        def b = trip[1]
        if (x == a + b + c) {
          return [a, b, c]
        }
      }
    }
  }
}
