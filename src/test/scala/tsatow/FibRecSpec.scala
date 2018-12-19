package tsatow

import org.scalatest._
import FibRec._

class FibRecSpec extends FlatSpec with Matchers with FibTest {
  "FibRec.fib" should "calculate fibonacci number." in {
    testFib(fib)
  }

  "FibRec.memoizedFib" should "calculate fibonacci number." in {
    testFib(memoizedFib)
  }
}
