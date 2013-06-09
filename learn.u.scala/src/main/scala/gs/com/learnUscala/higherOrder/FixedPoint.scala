package gs.com.learnUscala.higherOrder

object FixedPoint {
  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  import math._
  def isCloseEnough(x: Double, y: Double) = abs((x - y) / x) < tolerance
                                                  //> isCloseEnough: (x: Double, y: Double)Boolean
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    import scala.annotation.tailrec
    @tailrec
    def _fixedPoint(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else _fixedPoint(next)
    }
    _fixedPoint(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double
  def sqrt(x: Double) = fixedPoint(averageDamp(y => x/y))(1.0)
                                                  //> sqrt: (x: Double)Double
  def cubert(x: Double) = fixedPoint(averageDamp(y => x/y/y))(1.0)
}