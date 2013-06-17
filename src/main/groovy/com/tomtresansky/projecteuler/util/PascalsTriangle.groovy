package com.tomtresansky.projecteuler.util

class PascalsTriangle {
  private Map rows = [1:[1]].withDefault { x -> generateRow(x) }

  List generateRow(int x) {
    assert x > 1

    def oldRow = rows[x-1]
    def newRow = new ArrayList(x)

    newRow[0] = oldRow[0]
    for (int i = 1; i < x - 1; i++) {
      newRow[i] = (BigInteger) oldRow[i - 1] + oldRow[i]
    }
    newRow[x - 1] = oldRow[-1]

    //println newRow
    return newRow
  }

  def print(int numRows) {
    rows[numRows]
    rows.each { println it }
  }

  BigInteger center(int row) {
    assert row % 2 == 1

    return rows[row][((int)(row-1)/2)]
  }
}