package tsatow

import org.scalatest._
import FibLog._

class FibLogSpec extends FlatSpec with Matchers with FibTest {
  "FibLog.fib" should "calculate fibonacci number." in {
    testFib(fib)
  }
}
