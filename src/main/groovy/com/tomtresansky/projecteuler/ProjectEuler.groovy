package com.tomtresansky.projecteuler

import java.text.SimpleDateFormat

import com.tomtresansky.projecteuler.problem0001.Problem1SolverMark1
import com.tomtresansky.projecteuler.problem0002.Problem2SolverMark1
import com.tomtresansky.projecteuler.problem0003.Problem3SolverMark1
import com.tomtresansky.projecteuler.problem0004.Problem4SolverMark1
import com.tomtresansky.projecteuler.problem0005.Problem5SolverMark1
import com.tomtresansky.projecteuler.problem0006.Problem6SolverMark1
import com.tomtresansky.projecteuler.problem0007.Problem7SolverMark1
import com.tomtresansky.projecteuler.problem0008.Problem8SolverMark1
import com.tomtresansky.projecteuler.problem0009.Problem9SolverMark1
import com.tomtresansky.projecteuler.problem0011.Problem11SolverMark1
import com.tomtresansky.projecteuler.problem0012.Problem12SolverMark1
import com.tomtresansky.projecteuler.problem0013.Problem13SolverMark1
import com.tomtresansky.projecteuler.problem0014.Problem14SolverMark1
import com.tomtresansky.projecteuler.problem0015.Problem15SolverMark2
import com.tomtresansky.projecteuler.problem0016.Problem16SolverMark1
import com.tomtresansky.projecteuler.problem0017.Problem17SolverMark1

class ProjectEuler {
  static void main(String... args) {
    List solvers = [
      new Problem1SolverMark1(),
      new Problem2SolverMark1(),
      new Problem3SolverMark1(),
      new Problem4SolverMark1(),
      new Problem5SolverMark1(),
      new Problem6SolverMark1(),
      new Problem7SolverMark1(),
      new Problem8SolverMark1(),
      new Problem9SolverMark1(),
      //new Problem10SolverMark1() // Long-running:
      new Problem11SolverMark1(),
      new Problem12SolverMark1(),
      new Problem13SolverMark1(),
      new Problem14SolverMark1(),
      new Problem15SolverMark2(),
      new Problem16SolverMark1(),
      new Problem17SolverMark1()
    ]

    File timings = new File("doc${File.separator}timings-${new SimpleDateFormat('yyyy-MM-dd-hh_mm_ss').format(new Date())}.txt")
    timings.createNewFile()
    System.setOut(new PrintStream(timings))

    def start = System.currentTimeMillis()
    println "Running solvers: ${ solvers.collect { s -> s.getProblemNumber() } }..."

    solvers.each { s ->
      AbstractProblemSolver.run(s)
    }
    def end = System.currentTimeMillis()
    println "Finished in ${ (end - start) / 1000 } sec"
  }
}
