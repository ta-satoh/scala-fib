package tsatow

import org.scalatest._
import FibIter._

class FibIterSpec extends FlatSpec with Matchers with FibTest {
  "FibIter.fib" should "calculate fibonacci number." in {
    testFib(fib)
  }
}
