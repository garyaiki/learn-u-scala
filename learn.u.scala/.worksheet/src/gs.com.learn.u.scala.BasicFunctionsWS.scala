package gs.com.learn.u.scala

object BasicFunctionsWS {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(99); 
  println("Welcome to the Scala worksheet");$skip(132); 
  
  def luckyNumberSeven(n:Int) = {
    if (n == 7)
      "Lucky Number Seven"
    else
      "sorry, you're out of luck pal!"
  };System.out.println("""luckyNumberSeven: (n: Int)String""");$skip(25); val res$0 = 
  
  luckyNumberSeven(7);System.out.println("""res0: String = """ + $show(res$0));$skip(22); val res$1 = 
  luckyNumberSeven(6);System.out.println("""res1: String = """ + $show(res$1));$skip(96); 
  
  def addVectors(x:(Double,Double),y:(Double,Double)) = {
    (x._1 + x._2, y._1 + y._2)
  };System.out.println("""addVectors: (x: (Double, Double), y: (Double, Double))(Double, Double)""");$skip(38); val res$2 = 
  
  addVectors((1.5,2.5),(3.4, 3.6));System.out.println("""res2: (Double, Double) = """ + $show(res$2));$skip(56); 
  
  val xs = List((1,3),(4,3),(2,4),(5,3),(5,6),(3,1));System.out.println("""xs  : List[(Int, Int)] = """ + $show(xs ));$skip(37); 
  val ys = xs.map( a => a._1 + a._2);System.out.println("""ys  : List[Int] = """ + $show(ys ));$skip(292); 
  
  def tell[A](xs: List[A]) = xs match {
          case Nil => "The list is empty"
          case a if(xs.length == 1) => "The list has 1 element " + xs.head
          case b if(xs.length == 2) => "The list has 2 elements "  + " " + xs.take(2)
          case c => "This is a long list"
  };System.out.println("""tell: [A](xs: List[A])String""");$skip(18); val res$3 = 
  
  tell(List());System.out.println("""res3: String = """ + $show(res$3));$skip(11); val res$4 = 
  tell(xs);System.out.println("""res4: String = """ + $show(res$4));$skip(16); val res$5 = 
  tell(List(1));System.out.println("""res5: String = """ + $show(res$5));$skip(18); val res$6 = 
  tell(List(1,2));System.out.println("""res6: String = """ + $show(res$6));$skip(20); val res$7 = 
  tell(List(1,2,3))
  import math._;System.out.println("""res7: String = """ + $show(res$7));$skip(150); 
  def bmi(pounds:Double,inches:Double) = {
    val weight = pounds/2.2
    val height = inches/39.3
    weight/Math.pow(height,2)
  };System.out.println("""bmi: (pounds: Double, inches: Double)Double""");$skip(194); 
  
  def bmiTell(bmi:Double):String = bmi match {
    case a if(bmi <= 18.5) => "underweight"
    case b if(bmi <= 25.0) => "fit"
    case c if(bmi <= 30.0) => "fat"
    case _ => "too fat"
  };System.out.println("""bmiTell: (bmi: Double)String""");$skip(30); 
  
  val myBmi = bmi(168, 69);System.out.println("""myBmi  : Double = """ + $show(myBmi ));$skip(17); val res$8 = 
  bmiTell(myBmi);System.out.println("""res8: String = """ + $show(res$8));$skip(181); 

  def cylinder(radius:Double,height:Double) = {
    val sideArea = 2 * Math.PI * radius * height
    val topArea = Math.PI * Math.pow(radius,2)
    sideArea + 2 * topArea
    
  };System.out.println("""cylinder: (radius: Double, height: Double)Double""");$skip(19); val res$9 = 
  
  cylinder(1,1);System.out.println("""res9: Double = """ + $show(res$9))}
}
