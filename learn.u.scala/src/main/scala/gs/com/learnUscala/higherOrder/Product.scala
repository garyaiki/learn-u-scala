package gs.com.learnUscala.higherOrder

object Product {
  
  
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

   */
  def product(f: Int => Int)(a: Int, b: Int): Int = {
  import scala.annotation.tailrec
    @tailrec
    def _product(a: Int, result: Int): Int = {
      if (a > b) result
      else _product(a + 1, result * f(a))
    }
    _product(a, 1)
  }
   
  def factorial(b:Int) = product(x => x)(1,b)
}