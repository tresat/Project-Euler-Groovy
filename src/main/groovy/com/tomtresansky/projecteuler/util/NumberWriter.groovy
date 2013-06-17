package com.tomtresansky.projecteuler.util

class NumberWriter {
  private static ones = [1:'one', 2:'two', 3:'three', 4:'four', 5:'five', 6:'six', 7:'seven', 8:'eight', 9:'nine']
  private static teens = [10: 'ten', 11:'eleven', 12:'twelve', 13:'thirteen', 14:'fourteen', 15:'fifteen', 16:'sixteen', 17:'seventeen', 18:'eighteen', 19:'nineteen']
  private static tens = [2:'twenty', 3:'thirty', 4:'forty', 5:'fifty', 6:'sixty', 7:'seventy', 8:'eighty', 9:'ninety']

  public words = [:].withDefault { n -> write(n) }

  private String write(int n) {
    assert n > 0
    assert n <= 1000

    String result = ''

    int remaining = n
    while (remaining > 0) {
      switch(remaining) {
        case 1..<10:
          result += ones[remaining]
          remaining-=remaining
          break

        case 10..<20:
          result += teens[remaining]
          remaining -= remaining
          break

        case 20..<100:
          def tensValue = Integer.valueOf(remaining.toString()[0])

          result += tens[tensValue]
          remaining -= (tensValue * 10)

          if (remaining > 0) {
            result += '-'
          }
          break

        case 100..<1000:
          def hundredsValue = Integer.valueOf(remaining.toString()[0])

          result += ones[hundredsValue] + ' hundred'
          remaining -= (hundredsValue * 100)

          if (remaining > 0) {
            result += ' and '
          }
          break

        case 1000:
          result = 'one thousand'
          remaining = 0
          break
      }
    }

    return result
  }
}
