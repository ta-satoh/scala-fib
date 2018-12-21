package tsatow

import org.scalatest._
import FibTailRecCps._

class FibTailRecCpsSpec extends FlatSpec with Matchers with FibTest {
  "FibTailRecCps.fib" should "calculate fibonacci number." in {
    testFib(fib)
  }
}
