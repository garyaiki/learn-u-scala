package gs.com.learn.u.scala

object BasicRecursion {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def maxium[A](ss:Seq[A])(implicit ord: Ordering[A]):A = {
	  import scala.annotation.tailrec
	    @tailrec
	  def _maxium(seq:Seq[A], currMax:A):A = seq match {
	    case Nil => currMax
	    case head :: tail => _maxium(tail, ord.max(seq.head,currMax))
	  }
	  _maxium(ss.tail,ss.head)
	}                                         //> maxium: [A](ss: Seq[A])(implicit ord: Ordering[A])A
  val l = List(1,3,7,2)                           //> l  : List[Int] = List(1, 3, 7, 2)
  maxium(l)                                       //> res0: Int = 7

  import scala.collection.mutable.ListBuffer
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
  }                                               //> replicate: (n: Int, times: Int)List[Int]

  replicate(3,3)                                  //> res1: List[Int] = List(3, 3, 3)

  val l1 = List(1)                                //> l1  : List[Int] = List(1)
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
  }                                               //> take: [A](n: Int, xs: List[A])List[A]
  
  take(3,l)                                       //> res2: List[Int] = List(1, 3, 7)
  take(1,l1)                                      //> res3: List[Int] = List(1)
  take(2,l1)                                      //> res4: List[Int] = List(1)
  
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
  }                                               //> reverse: [A](xs: List[A])List[A]
  
  reverse(l)                                      //> res5: List[Int] = List(2, 7, 3, 1)
  
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
  }                                               //> zip: [A, B](xs: List[A], ys: List[B])List[(A, B)]
  
  val s = List('A','B','C','D')                   //> s  : List[Char] = List(A, B, C, D)
  zip(l,s)                                        //> res6: List[(Int, Char)] = List((1,A), (3,B), (7,C), (2,D))
  
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
  }                                               //> elem: [A](x: A, xs: List[A])Boolean
  
  elem(7,l)                                       //> res7: Boolean = true
  elem(9,l)                                       //> res8: Boolean = false

    def split(f:Int):Unit = {
      
      val smallerOrEqual = new ListBuffer[Int]
      val larger = new ListBuffer[Int]
    
    }                                             //> split: (f: Int)Unit
    l.foreach(x => println(x))                    //> 1
                                                  //| 3
                                                  //| 7
                                                  //| 2
    l.foreach(x => split(x))
    
	def factorial(n : BigInt) = {
	  @scala.annotation.tailrec
	  def _factorial(n : BigInt, acc : BigInt ) : BigInt =
	    if(n == 1) acc else _factorial(n - 1, acc * n )
	  
	    _factorial(n,1)
	}                                         //> factorial: (n: BigInt)BigInt
  factorial(5)                                    //> res9: BigInt = 120
}