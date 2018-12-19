package tsatow

object FibRec extends Memo {

  def fib(n: Long): Long = n match {
    case 0 => 0
    case 1 => 1
    case n     => fib(n - 1) + fib(n - 2)
  }

  def memoizedFibNG(n: Int): Int = {
    // 再帰関数のメモ化ってむずかしいな...
    val memo = scala.collection.mutable.Map.empty[Int, Int]

    def fib(n: Int): Int = n match {
      case 0 => 0
      case 1 => 1
      case n     => memo.getOrElseUpdate(n, fib(n - 1) + fib(n - 2))
    }

    fib(n)
  }

  def memoizedFib(n: Long): Long = {
    lazy val memoized = memoize(fib)
    lazy val fib: Long => Long = {
      case 0 => 0
      case 1 => 1
      case n     => memoized(n - 1) + memoized(n - 2)
    }

    memoized(n)
  }

}
