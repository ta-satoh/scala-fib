package tsatow

import scala.util.control.TailCalls._

object FibTailRec extends Memo {

  @annotation.tailrec
  def eval(stack: List[Either[Long, Long]]): List[Either[Long, Long]] = stack match {
    case Left(i1) :: Left(i2)    :: rest  => eval(Left(i1 + i2) :: rest)
    case Left(i)  :: (r@Right(_)) :: rest => r :: (Left(i) :: rest) // 呼出元で木を取り出しやすいよう入れ替え
    case _                                => stack
  }

  def fib(n: Long): Long = {
    @annotation.tailrec
    def fibTailRec(n: Long, stack: List[Either[Long, Long]]): Long = n match {
      case 0 | 1 => eval(Left(1L) :: stack) match {
        case Right(n) :: rest => fibTailRec(n, rest)
        case Left(r) :: _     => r // 最後まで評価が終わっているはず
        case Nil              => 1
      }
      case _     => fibTailRec(n - 2, Right(n - 1) :: stack)
    }
    fibTailRec(n, Nil)
  }

  def memoizedFibNG(n: Long): Long = {
    val memo = scala.collection.mutable.Map.empty[Long, Long]

    // 単純にメモ化しても末尾再帰にできないし、
    // 相互再帰にしても末尾再帰最適化がかからない
    def fibTailRec: (Long, List[Either[Long,  Long]]) => Long = {
      case (0 | 1, stack) => eval(Left(1L) :: stack) match {
        case Right(n) :: rest => memoized((n, rest))
        case Left(r) :: _     => r // 最後まで評価が終わっているはず
        case Nil              => 1
      }
      case (n, stack)     => memoized((n - 2, Right(n - 1) :: stack))
    }
    lazy val memoized = memoizeWithKey(fibTailRec.tupled)(_._1)

    fibTailRec(n, Nil)
  }
/*
  def memoizedFib(n: Int): Int = {

    def fibTailRec: (Int, List[Either[Int,  Int]]) => TailRec[Int] = {
      case (0 | 1, stack) => eval(Left(1) :: stack) match {
        case Right(n) :: rest => tailcall { memoized((n, rest)) }
        case Left(r) :: _     => done(r) // 最後まで評価が終わっているはず
        case Nil              => done(1)
      }
      case (n, stack)     => tailcall { memoized((n - 2, Right(n - 1) :: stack)) }
    }
    lazy val memoized: ((Int, List[Either[Int,  Int]])) => TailRec[Int] = memoizeWithKey(fibTailRec.tupled)(_._1)

    fibTailRec(n, Nil).result
  }
 */
}
