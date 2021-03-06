package tsatow

trait Memo {
  def memoize[A, R](f: A => R): A => R = {
    // memoizeWithKey(identity[A](_))(f)
    val memo = scala.collection.mutable.Map.empty[A, R]
    arg => memo.getOrElseUpdate(arg, f(arg))
  }

  def memoizeWithKey[K, A, R](f: A => R)(key: A => K): A => R = {
    val memo = scala.collection.mutable.Map.empty[K, R]
    arg => memo.getOrElseUpdate(key(arg), f(arg))
  }
}
