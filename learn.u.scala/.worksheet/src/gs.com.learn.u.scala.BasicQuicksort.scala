package gs.com.learn.u.scala
import scala.collection.mutable.ListBuffer

object BasicQuicksort {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(140); 
  println("Welcome to the Scala worksheet");$skip(50); 
  
  var unsorted = List(8,4,6,9,3,6,8,2,6,8,1,0);System.out.println("""unsorted  : List[Int] = """ + $show(unsorted ));$skip(123); 
  def smallerOrEqual(pivot:Int,xs:List[Int]):List[Int] =  {
    for {
      x <- xs
      if(x <= pivot)
    } yield x
  };System.out.println("""smallerOrEqual: (pivot: Int, xs: List[Int])List[Int]""");$skip(32); val res$0 = 
  
  smallerOrEqual(5,unsorted);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(119); 
  
    def larger(pivot:Int,xs:List[Int]):List[Int] =  {
    for {
      x <- xs
      if(x > pivot)
    } yield x
  };System.out.println("""larger: (pivot: Int, xs: List[Int])List[Int]""");$skip(43); 
  
  val lteq = smallerOrEqual(5,unsorted);System.out.println("""lteq  : List[Int] = """ + $show(lteq ));$skip(30); 
  val gt = larger(5,unsorted);System.out.println("""gt  : List[Int] = """ + $show(gt ));$skip(28); 
  val all = lteq :+ 5 +: gt;System.out.println("""all  : List[Any] = """ + $show(all ));$skip(42); 

  def qsTuple = (ListBuffer, ListBuffer);System.out.println("""qsTuple: => (scala.collection.mutable.ListBuffer.type, scala.collection.mutable.ListBuffer.type)""");$skip(165); 
  def splitLtEqGt(pivot: Int, n:Int)( ltEq:ListBuffer[Int],gt:ListBuffer[Int]) {
      if(n <= pivot) {
        ltEq += n
      } else {
        gt += n
      }
  };System.out.println("""splitLtEqGt: (pivot: Int, n: Int)(ltEq: scala.collection.mutable.ListBuffer[Int], gt: scala.collection.mutable.ListBuffer[Int])Unit""");$skip(153); 
  
  def sort(pivot:Int, xs:List[Int])(ltEq:ListBuffer[Int], gt:ListBuffer[Int]) = {
    for (x <- xs) {
      splitLtEqGt(pivot, x)( ltEq,gt)
    }
  };System.out.println("""sort: (pivot: Int, xs: List[Int])(ltEq: scala.collection.mutable.ListBuffer[Int], gt: scala.collection.mutable.ListBuffer[Int])Unit""");$skip(42); 
  
  val ltEqBuff = new ListBuffer[Int]();System.out.println("""ltEqBuff  : scala.collection.mutable.ListBuffer[Int] = """ + $show(ltEqBuff ));$skip(37); 
  val gtBuff = new ListBuffer[Int]();System.out.println("""gtBuff  : scala.collection.mutable.ListBuffer[Int] = """ + $show(gtBuff ));$skip(43); 
  val unsortedBuff = new ListBuffer[Int]();System.out.println("""unsortedBuff  : scala.collection.mutable.ListBuffer[Int] = """ + $show(unsortedBuff ));$skip(36); 
  sort(5,unsorted)(ltEqBuff,gtBuff);$skip(18); val res$1 = 
  ltEqBuff.toList;System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(16); val res$2 = 
  gtBuff.toList;System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(428); 
  
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
  };System.out.println("""quicksort: (xs: List[Int])List[Int]""");$skip(22); val res$3 = 
  quicksort(unsorted);System.out.println("""res3: List[Int] = """ + $show(res$3))}
                                                  
}
