package gs.com.learnUscala.higherOrder

object Sum {
  
  
  /**
   * function application associates to the left. That is,
   * if args1 and args2 are argument lists, then
   * f (args1)(args2) is equivalent to (f (args1))(args2)
   * 
   * function types associate to the right. I.e.
   * T1 => T2 => T3 is equivalent to T1 => (T2 => T3)
   * 
   * @param f
   * @param a
   * @param b
   * @return
   *   def sum(f: Int => Int)(a:Int, b:Int): Int = {
   *     if (a > b) 0 else f(a) + sum(f)(a + 1, b)
   *   }
   */
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
  import scala.annotation.tailrec
    @tailrec
    def _sum(a: Int, result: Int): Int = {
      if (a > b) result
      else _sum(a + 1, result + f(a))
    }
    _sum(a, 0)
  }
  def sumSquares = sum(x => x * x) _               //> sumSquares: => (Int, Int) => Int

  def sumInts = sum(x => x) _                      //> sumInts: => (Int, Int) => Int

  def powersOfTwo(x: Int): Int =
    if (x == 0) 1 else 2 * powersOfTwo(x - 1)     //> powersOfTwo: (x: Int)Int
  def sumPowersOfTwo = sum(powersOfTwo) _          //> sumPowersOfTwo: => (Int, Int) => Int
}