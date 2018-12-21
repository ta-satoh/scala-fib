package tsatow

import scala.util.control.TailCalls._

object FibTailRecCps extends Memo {
  //StackOverflowが発生する
  def fibNG(n: Long): Long = {
    def go(count: Long)(cb: Long => Long): Long = count match {
      case 0 | 1 => cb(count)
      case _     => go(count - 1)(l => go(count - 2)(r => cb(l + r)))
    }
    go(n)(identity)
  }

  import scala.util.control.TailCalls._
  def fib(n: Long): Long = {
    def go(count: Long)(cb: Long => TailRec[Long]): TailRec[Long] = count match {
      case 0 | 1 => tailcall(cb(count))
      case _     => go(count - 1)(l => tailcall(go(count - 2)(r => cb(l + r))))
    }
    go(n)(l => done(l)).result
  }
}
