package tsatow

import org.scalatest._
import FibIter._

class FibIterSpec extends FlatSpec with Matchers {
  "FibIter.fib" should "calculate fibonacci number." in {
    fib(0)  shouldEqual 1
    fib(1)  shouldEqual 1
    fib(2)  shouldEqual 2
    fib(3)  shouldEqual 3
    fib(4)  shouldEqual 5
    fib(5)  shouldEqual 8
    fib(6)  shouldEqual 13
    fib(7)  shouldEqual 21
    fib(8)  shouldEqual 34
    fib(9)  shouldEqual 55
    fib(10) shouldEqual 89
    fib(11) shouldEqual 144
    fib(12) shouldEqual 233
    fib(13) shouldEqual 377
    fib(14) shouldEqual 610
    fib(15) shouldEqual 987
  }
}
