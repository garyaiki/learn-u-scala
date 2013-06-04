package gs.com.learn.u.scala

object BasicListWS {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(94); 
  println("Welcome to the Scala worksheet");$skip(46); 
// Concatenation
  val fstLst = List(1,2,3,4);System.out.println("""fstLst  : List[Int] = """ + $show(fstLst ));$skip(29); 
  val sndLst = List(5,6,7,8);System.out.println("""sndLst  : List[Int] = """ + $show(sndLst ));$skip(33); 
  val catLst = fstLst.++(sndLst);System.out.println("""catLst  : List[Int] = """ + $show(catLst ));$skip(25); 
  val zLst = 0 :: catLst;System.out.println("""zLst  : List[Int] = """ + $show(zLst ));$skip(39); 
  val negLst = List(-3,-2,-1) ::: zLst;System.out.println("""negLst  : List[Int] = """ + $show(negLst ));$skip(28); 
  val zed = negLst.apply(3);System.out.println("""zed  : Int = """ + $show(zed ));$skip(38); val res$0 = 
// Comparing Lists
  fstLst == sndLst;System.out.println("""res0: Boolean = """ + $show(res$0));$skip(40); val res$1 = 
  // More List Operations
  fstLst.head;System.out.println("""res1: Int = """ + $show(res$1));$skip(14); val res$2 = 
  fstLst.tail;System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(14); val res$3 = 
  fstLst.last;System.out.println("""res3: Int = """ + $show(res$3));$skip(14); val res$4 = 
  fstLst.init;System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(16); val res$5 = 
  fstLst.length;System.out.println("""res5: Int = """ + $show(res$5));$skip(17); val res$6 = 
  fstLst.isEmpty;System.out.println("""res6: Boolean = """ + $show(res$6));$skip(17); val res$7 = 
  fstLst.reverse;System.out.println("""res7: List[Int] = """ + $show(res$7));$skip(17); val res$8 = 
  fstLst.take(3);System.out.println("""res8: List[Int] = """ + $show(res$8));$skip(17); val res$9 = 
  fstLst.drop(3);System.out.println("""res9: List[Int] = """ + $show(res$9));$skip(13); val res$10 = 
  fstLst.min;System.out.println("""res10: Int = """ + $show(res$10));$skip(13); val res$11 = 
  fstLst.max;System.out.println("""res11: Int = """ + $show(res$11));$skip(13); val res$12 = 
  fstLst.sum;System.out.println("""res12: Int = """ + $show(res$12));$skip(17); val res$13 = 
  fstLst.product;System.out.println("""res13: Int = """ + $show(res$13));$skip(21); val res$14 = 
  fstLst.contains(1);System.out.println("""res14: Boolean = """ + $show(res$14));$skip(18); val res$15 = 
// Range
  1 to 3;System.out.println("""res15: scala.collection.immutable.Range.Inclusive = """ + $show(res$15));$skip(12); val res$16 = 
  1 until 3;System.out.println("""res16: scala.collection.immutable.Range = """ + $show(res$16));$skip(30); 
  val rng = new Range(1,10,2);System.out.println("""rng  : scala.collection.immutable.Range = """ + $show(rng ));$skip(52); 
  
  val rngf = new Range(1,10,2).filterNot(_ == 3);System.out.println("""rngf  : scala.collection.immutable.IndexedSeq[Int] = """ + $show(rngf ));$skip(63); 
  def cycle[T](seq: Seq[T]) = Stream.from(0).flatten(_ => seq);System.out.println("""cycle: [T](seq: Seq[T])scala.collection.immutable.Stream[T]""");$skip(52); 
  val cyThree = cycle(1::2::3::Nil).take(12).toList;System.out.println("""cyThree  : List[Int] = """ + $show(cyThree ));$skip(86); 
  def lGen(end: Int): List[Int] =
         1 :: List.range(3, end+1, 2).map(n => 2*n);System.out.println("""lGen: (end: Int)List[Int]""");$skip(10); val res$17 = 
  lGen(1);System.out.println("""res17: List[Int] = """ + $show(res$17));$skip(10); val res$18 = 
  lGen(5);System.out.println("""res18: List[Int] = """ + $show(res$18));$skip(24); val res$19 = 
  lGen(5).filter(_ > 6);System.out.println("""res19: List[Int] = """ + $show(res$19));$skip(71); 
  
  def lGen2(end: Int): List[Int] =
         List.range(3, end+1, 2);System.out.println("""lGen2: (end: Int)List[Int]""");$skip(12); val res$20 = 
  lGen2(50);System.out.println("""res20: List[Int] = """ + $show(res$20));$skip(31); val res$21 = 
  lGen2(50).filter(_ % 7 == 3);System.out.println("""res21: List[Int] = """ + $show(res$21));$skip(55); 
  def boomBang(n:Int) = if (n > 10) "Boom" else "Bang";System.out.println("""boomBang: (n: Int)String""");$skip(45); 
  val boomBangs = lGen2(20).map(boomBang(_));System.out.println("""boomBangs  : List[String] = """ + $show(boomBangs ));$skip(43); 
  val nouns = List("hobo", "frog", "pope");System.out.println("""nouns  : List[String] = """ + $show(nouns ));$skip(55); 
  val adjectives = List("lazy", "grouchy", "scheming");System.out.println("""adjectives  : List[String] = """ + $show(adjectives ));$skip(78); val res$22 = 
  for {
    a <- adjectives
    sp <- " "
    b <- nouns
  } yield a + sp + b;System.out.println("""res22: List[String] = """ + $show(res$22));$skip(53); 
  val removeNonUppercase = List("Hahaha", "Ahahaha");System.out.println("""removeNonUppercase  : List[String] = """ + $show(removeNonUppercase ));$skip(42); 
  val flatNU = removeNonUppercase flatten;System.out.println("""flatNU  : List[Char] = """ + $show(flatNU ));$skip(40); 
  val allUps = flatNU filter(_ isUpper);System.out.println("""allUps  : List[Char] = """ + $show(allUps ));$skip(18); val res$23 = 
  allUps mkString;System.out.println("""res23: String = """ + $show(res$23));$skip(74); 
  
  val forUpper = for {
     a <- flatNU
     if(a isUpper)
  } yield a;System.out.println("""forUpper  : List[Char] = """ + $show(forUpper ));$skip(19); val res$24 = 
 forUpper.mkString;System.out.println("""res24: String = """ + $show(res$24));$skip(32); 
  
// Tuple
  val aPair = (1,3);System.out.println("""aPair  : (Int, Int) = """ + $show(aPair ));$skip(31); 
  val aTriple = (1,3, "Hello");System.out.println("""aTriple  : (Int, Int, String) = """ + $show(aTriple ));$skip(11); val res$25 = 
  aPair._1;System.out.println("""res25: Int = """ + $show(res$25));$skip(13); val res$26 = 
  aTriple._3;System.out.println("""res26: String = """ + $show(res$26));$skip(26); val res$27 = 
  
  adjectives zip nouns;System.out.println("""res27: List[(String, String)] = """ + $show(res$27));$skip(127); 
  val rightTriangles = for {
    c <- 1 to 10
    a <- 1 to c
    b <- 1 to a
    if(a * a + b * b == c * c)
  } yield (a,b,c)
import scalaz._
import Scalaz._;System.out.println("""rightTriangles  : scala.collection.immutable.IndexedSeq[(Int, Int, Int)] = """ + $show(rightTriangles ));$skip(69); val res$28 = 
// Comparing Lists
  fstLst > sndLst;System.out.println("""res28: Boolean = """ + $show(res$28));$skip(18); val res$29 = 
  fstLst < sndLst;System.out.println("""res29: Boolean = """ + $show(res$29));$skip(19); val res$30 = 
  fstLst >= sndLst;System.out.println("""res30: Boolean = """ + $show(res$30));$skip(19); val res$31 = 
  fstLst <= sndLst;System.out.println("""res31: Boolean = """ + $show(res$31))}
}
