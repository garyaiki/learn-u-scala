package gs.com.learn.u.scala
import scala.collection.mutable.ListBuffer

object BasicQuicksort {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  var unsorted = List(8,4,6,9,3,6,8,2,6,8,1,0)    //> unsorted  : List[Int] = List(8, 4, 6, 9, 3, 6, 8, 2, 6, 8, 1, 0)
  def smallerOrEqual(pivot:Int,xs:List[Int]):List[Int] =  {
    for {
      x <- xs
      if(x <= pivot)
    } yield x
  }                                               //> smallerOrEqual: (pivot: Int, xs: List[Int])List[Int]
  
  smallerOrEqual(5,unsorted)                      //> res0: List[Int] = List(4, 3, 2, 1, 0)
  
    def larger(pivot:Int,xs:List[Int]):List[Int] =  {
    for {
      x <- xs
      if(x > pivot)
    } yield x
  }                                               //> larger: (pivot: Int, xs: List[Int])List[Int]
  
  val lteq = smallerOrEqual(5,unsorted)           //> lteq  : List[Int] = List(4, 3, 2, 1, 0)
  val gt = larger(5,unsorted)                     //> gt  : List[Int] = List(8, 6, 9, 6, 8, 6, 8)
  val all = lteq :+ 5 +: gt                       //> all  : List[Any] = List(4, 3, 2, 1, 0, List(5, 8, 6, 9, 6, 8, 6, 8))

  def qsTuple = (ListBuffer, ListBuffer)          //> qsTuple: => (scala.collection.mutable.ListBuffer.type, scala.collection.muta
                                                  //| ble.ListBuffer.type)
  def splitLtEqGt(pivot: Int, n:Int)( ltEq:ListBuffer[Int],gt:ListBuffer[Int]) {
      if(n <= pivot) {
        ltEq += n
      } else {
        gt += n
      }
  }                                               //> splitLtEqGt: (pivot: Int, n: Int)(ltEq: scala.collection.mutable.ListBuffer[
                                                  //| Int], gt: scala.collection.mutable.ListBuffer[Int])Unit
  
  def sort(pivot:Int, xs:List[Int])(ltEq:ListBuffer[Int], gt:ListBuffer[Int]) = {
    for (x <- xs) {
      splitLtEqGt(pivot, x)( ltEq,gt)
    }
  }                                               //> sort: (pivot: Int, xs: List[Int])(ltEq: scala.collection.mutable.ListBuffer[
                                                  //| Int], gt: scala.collection.mutable.ListBuffer[Int])Unit
  
  val ltEqBuff = new ListBuffer[Int]()            //> ltEqBuff  : scala.collection.mutable.ListBuffer[Int] = ListBuffer()
  val gtBuff = new ListBuffer[Int]()              //> gtBuff  : scala.collection.mutable.ListBuffer[Int] = ListBuffer()
  val unsortedBuff = new ListBuffer[Int]()        //> unsortedBuff  : scala.collection.mutable.ListBuffer[Int] = ListBuffer()
  sort(5,unsorted)(ltEqBuff,gtBuff)
  ltEqBuff.toList                                 //> res1: List[Int] = List(4, 3, 2, 1, 0)
  gtBuff.toList                                   //> res2: List[Int] = List(8, 6, 9, 6, 8, 6, 8)
  
  def quicksort(xs:List[Int]):List[Int] = {
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
  }                                               //> quicksort: (xs: List[Int])List[Int]
  quicksort(unsorted)                             //> res3: List[Int] = List(0, 1, 2, 3, 4, 6, 6, 6, 8, 8, 8, 9)
                                                  
}