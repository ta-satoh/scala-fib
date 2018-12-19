package tsatow

import org.scalatest.Matchers

trait FibTest { self: Matchers =>
  def testFib(fib: Long => Long) = {
    fib(0)  shouldEqual 0
    fib(1)  shouldEqual 1
    fib(2)  shouldEqual 1
    fib(3)  shouldEqual 2
    fib(4)  shouldEqual 3
    fib(5)  shouldEqual 5
    fib(6)  shouldEqual 8
    fib(7)  shouldEqual 13
    fib(8)  shouldEqual 21
    fib(9)  shouldEqual 34
    fib(10)  shouldEqual 55
    fib(11) shouldEqual 89
    fib(12) shouldEqual 144
    fib(13) shouldEqual 233
    fib(14) shouldEqual 377
    fib(15) shouldEqual 610
    fib(16) shouldEqual 987
  }
}
