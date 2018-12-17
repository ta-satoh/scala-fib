package tsatow

object Main extends App {
  def exectime(proc: => Unit): Long = {
    val start = System.currentTimeMillis
    proc
    System.currentTimeMillis - start
  }

  def calculate(fib: Int => Int, description: String, step: Int = 100000000, maxN: Int = 1000000000): Unit = {
    Range(0, maxN, step).foreach { n =>
      println(s"""${description}(${n}): ${exectime { fib(n) }}""")
      println
    }
  }

  calculate(FibRec.fib, "FibRec", 5, 50)
  calculate(FibTailRec.fib, "FibTailRec", 5, 50)
  calculate(FibRec.memoizedFib, "FibRecMemoized", 200, 1000)
  //calculate(FibTailRec.memoizedFib, "FibTailRecMemoized", 4000)
  calculate(FibIter.fib, "FibIter")
}
