package gs.com.learn.u.scala

object BasicTypesWS {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(95); 
  println("Welcome to the Scala worksheet");$skip(9); val res$0 = 
  
  'a';System.out.println("""res0: Char('a') = """ + $show(res$0));$skip(10); val res$1 = 
  "Hello";System.out.println("""res1: String("Hello") = """ + $show(res$1));$skip(14); val res$2 = 
  (true, 'a');System.out.println("""res2: (Boolean, Char) = """ + $show(res$2));$skip(9); val res$3 = 
  4 == 5;System.out.println("""res3: Boolean(false) = """ + $show(res$3));$skip(7); val res$4 = 
  true;System.out.println("""res4: Boolean(true) = """ + $show(res$4));$skip(229); 

  def factorial(n: BigInt): BigInt = {
  import scala.annotation.tailrec
    @tailrec def _factorial(acc: BigInt, n: BigInt): BigInt = {
      if (n <= 1) acc
      else _factorial(n * acc, n - 1)
    }
    _factorial(1, n)
  };System.out.println("""factorial: (n: BigInt)BigInt""");$skip(16); val res$5 = 
  factorial(10);System.out.println("""res5: BigInt = """ + $show(res$5));$skip(69); 
  
  def circumference(r:Double): Double = {
    math.Pi * r * 2
  };System.out.println("""circumference: (r: Double)Double""");$skip(21); val res$6 = 
  circumference(0.5);System.out.println("""res6: Double = """ + $show(res$6));$skip(30); val res$7 = 

  List("hello","there").head;System.out.println("""res7: String = """ + $show(res$7));$skip(12); val res$8 = 
  
  1 == 1;System.out.println("""res8: Boolean(true) = """ + $show(res$8));$skip(9); val res$9 = 
  1 != 1;System.out.println("""res9: Boolean(false) = """ + $show(res$9));$skip(11); val res$10 = 

  1 > 2.0;System.out.println("""res10: Boolean(false) = """ + $show(res$10));$skip(18); val res$11 = 
  "less" < "then";System.out.println("""res11: Boolean = """ + $show(res$11));$skip(21); val res$12 = 
  "greater" > "then";System.out.println("""res12: Boolean = """ + $show(res$12));$skip(22); val res$13 = 
  "greater" >= "then";System.out.println("""res13: Boolean = """ + $show(res$13));$skip(22); val res$14 = 
  "greater" <= "then"
  
  
import scalaz._
import Scalaz._;System.out.println("""res14: Boolean = """ + $show(res$14));$skip(48); val res$15 = 
  3.shows;System.out.println("""res15: String = """ + $show(res$15))}
  
}
