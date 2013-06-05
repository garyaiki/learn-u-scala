package gs.com.learn.u.scala

object BasicRecursion {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(97); 
  println("Welcome to the Scala worksheet");$skip(294); 
  
  def maxium[A](ss:Seq[A])(implicit ord: Ordering[A]):A = {
	  import scala.annotation.tailrec
	    @tailrec
	  def _maxium(seq:Seq[A], currMax:A):A = seq match {
	    case Nil => currMax
	    case head :: tail => _maxium(tail, ord.max(seq.head,currMax))
	  }
	  _maxium(ss.tail,ss.head)
	};System.out.println("""maxium: [A](ss: Seq[A])(implicit ord: Ordering[A])A""");$skip(24); 
  val l = List(1,3,7,2);System.out.println("""l  : List[Int] = """ + $show(l ));$skip(12); val res$0 = 
  maxium(l)

import scala.collection.mutable.ListBuffer;System.out.println("""res0: Int = """ + $show(res$0));$skip(381); 
  def replicate(n:Int, times:Int):List[Int] = {
    val listBuf = new ListBuffer[Int]()
    import scala.annotation.tailrec
    @tailrec
    def _replicate(n:Int, times:Int):Unit = {
      if(times <= 0) Unit
      else {
        listBuf += n
        _replicate(n, times - 1)
      }
    }
    _replicate(n,times)
    listBuf.toList
  };System.out.println("""replicate: (n: Int, times: Int)List[Int]""");$skip(18); val res$1 = 

  replicate(3,3);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(20); 

  val l1 = List(1);System.out.println("""l1  : List[Int] = """ + $show(l1 ));$skip(368); 
  def take[A](n:Int, xs:List[A]):List[A] = {
    val listBuf = new ListBuffer[A]()
    import scala.annotation.tailrec
    @tailrec
    def _take(n:Int, xs:List[A]):Unit = xs match {
        case Nil => Unit
        case a if(n <= 0) => Unit
        case head :: tail =>
        listBuf += head
        _take(n - 1, tail)
    }
    _take(n, xs)
    listBuf.toList
  };System.out.println("""take: [A](n: Int, xs: List[A])List[A]""");$skip(15); val res$2 = 
  
  take(3,l);System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(13); val res$3 = 
  take(1,l1);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(13); val res$4 = 
  take(2,l1);System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(331); 
  
  def reverse[A](xs:List[A]):List[A] = {
    val listBuf = new ListBuffer[A]()
    import scala.annotation.tailrec
    @tailrec
    def _reverse(xs:List[A]):Unit = xs match {
        case Nil => Unit
        case head :: tail =>
        listBuf.prepend(head)
        _reverse(tail)
    }
    _reverse(xs)
    listBuf.toList
  };System.out.println("""reverse: [A](xs: List[A])List[A]""");$skip(16); val res$5 = 
  
  reverse(l);System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(410); 
  
  def zip[A,B](xs:List[A], ys:List[B]):List[(A,B)] = {
    val listBuf = new ListBuffer[(A,B)]()
    import scala.annotation.tailrec
    @tailrec
    def _zip(xs:List[A], ys:List[B]):Unit = (xs,ys) match {
        case (Nil, _) => Unit
        case (_, Nil) => Unit
        case (_,_) =>
        listBuf.append( (xs.head,ys.head) )
        _zip(xs.tail,ys.tail)
    }
    _zip(xs,ys)
    listBuf.toList
  };System.out.println("""zip: [A, B](xs: List[A], ys: List[B])List[(A, B)]""");$skip(35); 
  
  val s = List('A','B','C','D');System.out.println("""s  : List[Char] = """ + $show(s ));$skip(11); val res$6 = 
  zip(l,s);System.out.println("""res6: List[(Int, Char)] = """ + $show(res$6));$skip(313); 
  
  def elem[A](x:A, xs:List[A]):Boolean = {
    import scala.annotation.tailrec
    @tailrec
    def _elem(x:A, xs:List[A]):Boolean = (x, xs) match {
      case (_, Nil) => false
      case (x, head :: tail) =>
        if(x == head)
          true
        else
          _elem(x,tail)
    }
    _elem(x,xs)
  };System.out.println("""elem: [A](x: A, xs: List[A])Boolean""");$skip(15); val res$7 = 
  
  elem(7,l);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(12); val res$8 = 
  elem(9,l);System.out.println("""res8: Boolean = """ + $show(res$8));$skip(135); 

    def split(f:Int):Unit = {
      
      val smallerOrEqual = new ListBuffer[Int]
      val larger = new ListBuffer[Int]
    
    };System.out.println("""split: (f: Int)Unit""");$skip(31); 
    l.foreach(x => println(x));$skip(29); 
    l.foreach(x => split(x))}
    


}
