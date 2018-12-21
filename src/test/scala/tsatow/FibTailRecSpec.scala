package tsatow

import org.scalatest._
import FibTailRec._

class FibTailRecSpec extends FlatSpec with Matchers with FibTest {
  "FibTailRec.fib" should "calculate fibonacci number." in {
    testFib(fib)
  }

  "FibTailRec.memoizedFib" should "calculate fibonacci number." in {
    /*testFib(memoizedFib)*/
  }

}
