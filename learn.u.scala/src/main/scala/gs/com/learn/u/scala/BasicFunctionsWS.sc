package gs.com.learn.u.scala

object BasicFunctionsWS {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def luckyNumberSeven(n:Int) = {
    if (n == 7)
      "Lucky Number Seven"
    else
      "sorry, you're out of luck pal!"
  }                                               //> luckyNumberSeven: (n: Int)String
  
  luckyNumberSeven(7)                             //> res0: String = Lucky Number Seven
  luckyNumberSeven(6)                             //> res1: String = sorry, you're out of luck pal!
  
  def addVectors(x:(Double,Double),y:(Double,Double)) = {
    (x._1 + x._2, y._1 + y._2)
  }                                               //> addVectors: (x: (Double, Double), y: (Double, Double))(Double, Double)
  
  addVectors((1.5,2.5),(3.4, 3.6))                //> res2: (Double, Double) = (4.0,7.0)
  
  val xs = List((1,3),(4,3),(2,4),(5,3),(5,6),(3,1))
                                                  //> xs  : List[(Int, Int)] = List((1,3), (4,3), (2,4), (5,3), (5,6), (3,1))
  val ys = xs.map( a => a._1 + a._2)              //> ys  : List[Int] = List(4, 7, 6, 8, 11, 4)
  
  def tell[A](xs: List[A]) = xs match {
          case Nil => "The list is empty"
          case a if(xs.length == 1) => "The list has 1 element " + xs.head
          case b if(xs.length == 2) => "The list has 2 elements "  + " " + xs.take(2)
          case c => "This is a long list"
  }                                               //> tell: [A](xs: List[A])String
  
  tell(List())                                    //> res3: String = The list is empty
  tell(xs)                                        //> res4: String = This is a long list
  tell(List(1))                                   //> res5: String = The list has 1 element 1
  tell(List(1,2))                                 //> res6: String = The list has 2 elements  List(1, 2)
  tell(List(1,2,3))                               //> res7: String = This is a long list
  import math._
  def bmi(pounds:Double,inches:Double) = {
    val weight = pounds/2.2
    val height = inches/39.3
    weight/Math.pow(height,2)
  }                                               //> bmi: (pounds: Double, inches: Double)Double
  
  def bmiTell(bmi:Double):String = bmi match {
    case a if(bmi <= 18.5) => "underweight"
    case b if(bmi <= 25.0) => "fit"
    case c if(bmi <= 30.0) => "fat"
    case _ => "too fat"
  }                                               //> bmiTell: (bmi: Double)String
  
  val myBmi = bmi(168, 69)                        //> myBmi  : Double = 24.772710087643922
  bmiTell(myBmi)                                  //> res8: String = fit

  def cylinder(radius:Double,height:Double) = {
    val sideArea = 2 * Math.PI * radius * height
    val topArea = Math.PI * Math.pow(radius,2)
    sideArea + 2 * topArea
    
  }                                               //> cylinder: (radius: Double, height: Double)Double
  
  cylinder(1,1)                                   //> res9: Double = 12.566370614359172
}