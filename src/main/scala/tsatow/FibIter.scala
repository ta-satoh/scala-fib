package tsatow

object FibIter {
  def fib(n: Long): Long = {
    @annotation.tailrec
    def fibIter(count: Long, a: Long, b: Long): Long = count match {
      case 0     => b
      case count => fibIter(count - 1, a + b, a)
    }

    fibIter(n, 1, 0)
  }
}
