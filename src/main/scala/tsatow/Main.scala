package tsatow

object Main extends App {
  def exectime(proc: => Unit): Long = {
    val start = System.currentTimeMillis
    proc
    System.currentTimeMillis - start
  }

  def calculate(fib: Long => Long, description: String, step: Int = 1000, maxN: Int = 10000): Unit = {
    Range(0, maxN, step).foreach { n =>
      // warmup
      exectime { for (_ <- 1 to 10) { fib(n) } }

      val time = exectime { for (_ <- 1 to 1000) { fib(n) } }
      println(s"""${description}(${n}): ${time}micro seconds""")
      println
    }
  }

  calculate(FibRec.fib, "FibRec", 5, 40)
  calculate(FibTailRec.fib, "FibTailRec", 5, 40)
  calculate(FibTailRecCps.fib, "FibTailRecCps", 5, 40)
  //calculate(FibRec.memoizedFib, "FibRecMemoized", 200, 1000)
  //calculate(FibTailRec.memoizedFib, "FibTailRecMemoized", 4000)
  calculate(FibIter.fib, "FibIter")
  calculate(FibLog.fib, "FibLog")
}
