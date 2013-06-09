package gs.com.learnUscala.recursion

import scala.collection.mutable.ListBuffer

/**
 * @author root
 * 
 * In real life, quicksort is built in. Scala By Example has much nicer examples 
 * @see http://www.scala-lang.org/api/current/index.html#scala.math.Ordering
 *
 */
class FirstQuicksort {
  
  def smallerOrEqual(pivot:Int,xs:List[Int]):List[Int] =  {
    for {
      x <- xs
      if(x <= pivot)
    } yield x
  }
  
  def larger(pivot:Int,xs:List[Int]):List[Int] =  {
    for {
      x <- xs
      if(x > pivot)
    } yield x
  }

  def splitLtEqGt(pivot: Int, n:Int)( ltEq:ListBuffer[Int],gt:ListBuffer[Int]) {
      if(n <= pivot) {
        ltEq += n
      } else {
        gt += n
      }
  }
  
  def sort(pivot:Int, xs:List[Int])(ltEq:ListBuffer[Int], gt:ListBuffer[Int]) = {
    for (x <- xs) {
      splitLtEqGt(pivot, x)( ltEq,gt)
    }
  }
  
  def apply(xs:List[Int]):List[Int] = {
    def _quicksort(xs:List[Int]):List[Int] = xs match {
      case Nil => xs
      case head :: tail =>
      val ltEq = new ListBuffer[Int]()
      val gt = new ListBuffer[Int]()
      sort(head, tail)(ltEq,gt)
      val small = _quicksort(ltEq toList)
      val big = _quicksort(gt toList)
      (((new ListBuffer() ++ small) += head) ++ big).toList
    }
    _quicksort(xs)
  }
}