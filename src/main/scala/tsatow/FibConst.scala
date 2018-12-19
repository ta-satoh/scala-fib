package tsatow

import FibConst.Expr._

object FibConst {
  def fib(n: Long): Long = {
    val t1 = Math.pow((1 + Math.sqrt(5)) / 2, n)
    val t2 = Math.pow((1 - Math.sqrt(5)) / 2, n)
    Math.round(
      (t1 - t2) / Math.sqrt(5)
    )
  }

  sealed trait Expr {
    def *(e: Expr): Expr = Expr.*(this, e)
    def /(e: Expr): Expr = Expr./(this, e)
    def +(e: Expr): Expr = Expr.+(this, e)
    def -(e: Expr): Expr = Expr.-(this, e)
  }
  object Expr {
    case class *(t1: Expr, t2: Expr) extends Expr
    case class /(t1: Expr, t2: Expr) extends Expr
    case class +(t1: Expr, t2: Expr) extends Expr
    case class -(t1: Expr, t2: Expr) extends Expr
    case class ^(t1: Expr, t2: Expr) extends Expr
    case class IntVal(value: Int) extends Expr
    case class Sqrt5(coefficient: Int) extends Expr
  }

  def eval(expr: Expr): Expr = expr match {
    case e1 * e2 => (e1, e2) match {
      case (IntVal(i1), IntVal(i2)) => IntVal(i1 * i2)
      case (IntVal(i), Sqrt5(c)) => Sqrt5(i * c)
      case (Sqrt5(c), IntVal(i)) => Sqrt5(i * c)
      case (Sqrt5(c1), Sqrt5(c2)) => IntVal(c1 * c2 * 5)
      case (e11 + e12, e2) => eval((e11 * e2) + (e12 * e2))
      case (e1, e21 + e22) => eval((e1 * e21) + (e1 * e22))
    }
    case e1 / e2 => (e1, e2) match {
      case (m / d, e) => eval(m / (d * e))
      case (IntVal(i), Sqrt5(c)) => Sqrt5(i * c)
      case (Sqrt5(c), IntVal(i)) => Sqrt5(i * c)
      case (Sqrt5(c1), Sqrt5(c2)) => IntVal(c1 * c2 * 5)
    }
  }
}
