package tsatow

import org.scalatest._
import FibConst._

class FibConstSpec extends FlatSpec with Matchers with FibTest {
  "FibConst.fib" should "calculate fibonacci number." in {
    testFib(fib)
  }
}
