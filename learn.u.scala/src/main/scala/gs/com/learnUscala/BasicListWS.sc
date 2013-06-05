package gs.com.learn.u.scala

object BasicListWS {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
// Concatenation
  val fstLst = List(1,2,3,4)                      //> fstLst  : List[Int] = List(1, 2, 3, 4)
  val sndLst = List(5,6,7,8)                      //> sndLst  : List[Int] = List(5, 6, 7, 8)
  val catLst = fstLst.++(sndLst)                  //> catLst  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)
  val zLst = 0 :: catLst                          //> zLst  : List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 8)
  val negLst = List(-3,-2,-1) ::: zLst            //> negLst  : List[Int] = List(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8)
  val zed = negLst.apply(3)                       //> zed  : Int = 0
// Comparing Lists
  fstLst == sndLst                                //> res0: Boolean = false
  // More List Operations
  fstLst.head                                     //> res1: Int = 1
  fstLst.tail                                     //> res2: List[Int] = List(2, 3, 4)
  fstLst.last                                     //> res3: Int = 4
  fstLst.init                                     //> res4: List[Int] = List(1, 2, 3)
  fstLst.length                                   //> res5: Int = 4
  fstLst.isEmpty                                  //> res6: Boolean = false
  fstLst.reverse                                  //> res7: List[Int] = List(4, 3, 2, 1)
  fstLst.take(3)                                  //> res8: List[Int] = List(1, 2, 3)
  fstLst.drop(3)                                  //> res9: List[Int] = List(4)
  fstLst.min                                      //> res10: Int = 1
  fstLst.max                                      //> res11: Int = 4
  fstLst.sum                                      //> res12: Int = 10
  fstLst.product                                  //> res13: Int = 24
  fstLst.contains(1)                              //> res14: Boolean = true
// Range
  1 to 3                                          //> res15: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3)
  1 until 3                                       //> res16: scala.collection.immutable.Range = Range(1, 2)
  val rng = new Range(1,10,2)                     //> rng  : scala.collection.immutable.Range = Range(1, 3, 5, 7, 9)
  
  val rngf = new Range(1,10,2).filterNot(_ == 3)  //> rngf  : scala.collection.immutable.IndexedSeq[Int] = Vector(1, 5, 7, 9)
  def cycle[T](seq: Seq[T]) = Stream.from(0).flatten(_ => seq)
                                                  //> cycle: [T](seq: Seq[T])scala.collection.immutable.Stream[T]
  val cyThree = cycle(1::2::3::Nil).take(12).toList
                                                  //> cyThree  : List[Int] = List(1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3)
  def lGen(end: Int): List[Int] =
         1 :: List.range(3, end+1, 2).map(n => 2*n)
                                                  //> lGen: (end: Int)List[Int]
  lGen(1)                                         //> res17: List[Int] = List(1)
  lGen(5)                                         //> res18: List[Int] = List(1, 6, 10)
  lGen(5).filter(_ > 6)                           //> res19: List[Int] = List(10)
  
  def lGen2(end: Int): List[Int] =
         List.range(3, end+1, 2)                  //> lGen2: (end: Int)List[Int]
  lGen2(50)                                       //> res20: List[Int] = List(3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29,
                                                  //|  31, 33, 35, 37, 39, 41, 43, 45, 47, 49)
  lGen2(50).filter(_ % 7 == 3)                    //> res21: List[Int] = List(3, 17, 31, 45)
  def boomBang(n:Int) = if (n > 10) "Boom" else "Bang"
                                                  //> boomBang: (n: Int)String
  val boomBangs = lGen2(20).map(boomBang(_))      //> boomBangs  : List[String] = List(Bang, Bang, Bang, Bang, Boom, Boom, Boom, 
                                                  //| Boom, Boom)
  val nouns = List("hobo", "frog", "pope")        //> nouns  : List[String] = List(hobo, frog, pope)
  val adjectives = List("lazy", "grouchy", "scheming")
                                                  //> adjectives  : List[String] = List(lazy, grouchy, scheming)
  for {
    a <- adjectives
    sp <- " "
    b <- nouns
  } yield a + sp + b                              //> res22: List[String] = List(lazy hobo, lazy frog, lazy pope, grouchy hobo, g
                                                  //| rouchy frog, grouchy pope, scheming hobo, scheming frog, scheming pope)
  val removeNonUppercase = List("Hahaha", "Ahahaha")
                                                  //> removeNonUppercase  : List[String] = List(Hahaha, Ahahaha)
  val flatNU = removeNonUppercase flatten         //> flatNU  : List[Char] = List(H, a, h, a, h, a, A, h, a, h, a, h, a)
  val allUps = flatNU filter(_ isUpper)           //> allUps  : List[Char] = List(H, A)
  allUps mkString                                 //> res23: String = HA
  
  val forUpper = for {
     a <- flatNU
     if(a isUpper)
  } yield a                                       //> forUpper  : List[Char] = List(H, A)
 forUpper.mkString                                //> res24: String = HA
  
// Tuple
  val aPair = (1,3)                               //> aPair  : (Int, Int) = (1,3)
  val aTriple = (1,3, "Hello")                    //> aTriple  : (Int, Int, String) = (1,3,Hello)
  aPair._1                                        //> res25: Int = 1
  aTriple._3                                      //> res26: String = Hello
  
  adjectives zip nouns                            //> res27: List[(String, String)] = List((lazy,hobo), (grouchy,frog), (scheming
                                                  //| ,pope))
  val rightTriangles = for {
    c <- 1 to 10
    a <- 1 to c
    b <- 1 to a
    if(a * a + b * b == c * c)
  } yield (a,b,c)                                 //> rightTriangles  : scala.collection.immutable.IndexedSeq[(Int, Int, Int)] = 
                                                  //| Vector((4,3,5), (8,6,10))
import scalaz._
import Scalaz._
// Comparing Lists
  fstLst > sndLst                                 //> res28: Boolean = false
  fstLst < sndLst                                 //> res29: Boolean = true
  fstLst >= sndLst                                //> res30: Boolean = false
  fstLst <= sndLst                                //> res31: Boolean = true
}