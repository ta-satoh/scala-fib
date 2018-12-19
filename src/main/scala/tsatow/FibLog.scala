package tsatow

object FibLog {
  def fib(n: Long): Long = {
    @annotation.tailrec
    def fibLog(count: Long, a: Long, b: Long, p: Long, q: Long): Long = count match {
      case 0 => b
      case _ =>
        if ((count & 1) == 1) {
          fibLog(count - 1, b * q + a * q + a * p, a * q + b * p, p, q)
        } else {
          fibLog(count >>> 1, a, b, p * p + q * q, q * q + 2 * p * q)
        }
    }

    fibLog(n, 1, 0, 0, 1)
  }

}
