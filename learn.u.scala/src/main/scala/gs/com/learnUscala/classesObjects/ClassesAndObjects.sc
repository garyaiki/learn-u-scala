package gs.com.learnUscala.classesObjects

object ClassesAndObjects {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  class Rational(n: Int, d: Int) {
    private def gcd(x: Int, y: Int): Int = {
      if (x == 0) y
      else if (x < 0) gcd(-x, y)
           else if (y < 0) -gcd(x, -y)
                else gcd(y % x, x)
    }
    private val g = gcd(n, d)
    val numer: Int = n/g
    val denom: Int = d/g
    def +(that: Rational) =
      new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
    def -(that: Rational) =
      new Rational(numer * that.denom - that.numer * denom,
        denom * that.denom)
    def *(that: Rational) =
      new Rational(numer * that.numer, denom * that.denom)
    def /(that: Rational) =
      new Rational(numer * that.denom, denom * that.numer)
      
    override def toString = "" + numer + "/" + denom
  }
  val half = new Rational(1,2)                    //> half  : gs.com.learnUscala.classesObjects.ClassesAndObjects.Rational = 1/2
  val third = new Rational(1,3)                   //> third  : gs.com.learnUscala.classesObjects.ClassesAndObjects.Rational = 1/3
  def halfPlusthird = half + third                //> halfPlusthird: => gs.com.learnUscala.classesObjects.ClassesAndObjects.Ration
                                                  //| al
  halfPlusthird                                   //> res0: gs.com.learnUscala.classesObjects.ClassesAndObjects.Rational = 5/6
  
  def halfMinusthird = half - third               //> halfMinusthird: => gs.com.learnUscala.classesObjects.ClassesAndObjects.Rati
                                                  //| onal
  halfMinusthird                                  //> res1: gs.com.learnUscala.classesObjects.ClassesAndObjects.Rational = 1/6
  
  def halfTimesthird = half * third               //> halfTimesthird: => gs.com.learnUscala.classesObjects.ClassesAndObjects.Rati
                                                  //| onal
  halfTimesthird                                  //> res2: gs.com.learnUscala.classesObjects.ClassesAndObjects.Rational = 1/6
  
  def halfDivthird = half / third                 //> halfDivthird: => gs.com.learnUscala.classesObjects.ClassesAndObjects.Ration
                                                  //| al
  halfDivthird                                    //> res3: gs.com.learnUscala.classesObjects.ClassesAndObjects.Rational = 3/2
}