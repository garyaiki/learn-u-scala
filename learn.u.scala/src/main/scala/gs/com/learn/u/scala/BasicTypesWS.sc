package gs.com.learn.u.scala

object BasicTypesWS {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  'a'                                             //> res0: Char('a') = a
  "Hello"                                         //> res1: String("Hello") = Hello
  (true, 'a')                                     //> res2: (Boolean, Char) = (true,a)
  4 == 5                                          //> res3: Boolean(false) = false
  true                                            //> res4: Boolean(true) = true

  def factorial(n: BigInt): BigInt = {
  import scala.annotation.tailrec
    @tailrec def _factorial(acc: BigInt, n: BigInt): BigInt = {
      if (n <= 1) acc
      else _factorial(n * acc, n - 1)
    }
    _factorial(1, n)
  }                                               //> factorial: (n: BigInt)BigInt
  factorial(10)                                   //> res5: BigInt = 3628800
  
  def circumference(r:Double): Double = {
    math.Pi * r * 2
  }                                               //> circumference: (r: Double)Double
  circumference(0.5)                              //> res6: Double = 3.141592653589793

  List("hello","there").head                      //> res7: String = hello
  
  1 == 1                                          //> res8: Boolean(true) = true
  1 != 1                                          //> res9: Boolean(false) = false

  1 > 2.0                                         //> res10: Boolean(false) = false
  "less" < "then"                                 //> res11: Boolean = true
  "greater" > "then"                              //> res12: Boolean = false
  "greater" >= "then"                             //> res13: Boolean = false
  "greater" <= "then"                             //> res14: Boolean = true
  
  
import scalaz._
import Scalaz._
  3.shows                                         //> res15: String = 3
  
}