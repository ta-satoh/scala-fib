package tsatow

object FibIter {
  def fib(n: Int): Int = {
    @annotation.tailrec
    def fibIter(count: Int, prev1: Int, prev2: Int): Int = count match {
      case 1 | 0               => fibIter(count + 1, 1, count)
      case count if count <= n => fibIter(count + 1, prev1 + prev2, prev1)
      case count if count >  n => prev1
    }

    fibIter(0, 0, n)
  }
}
