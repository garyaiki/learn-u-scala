// Copyright (C) 2011-2012 the original author or authors.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package gs.com.learnUscala.higherOrder

object FixedPoint {
  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  import math.abs
  def isCloseEnough(x: Double, y: Double):Boolean = abs((x - y) / x) < tolerance
                                                  //> isCloseEnough: (x: Double, y: Double)Boolean
  def fixedPoint(f: Double => Double)(firstGuess: Double):Double = {
    import scala.annotation.tailrec
    @tailrec
    def fixedPointAcc(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next else fixedPointAcc(next)
    }
    fixedPointAcc(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
  def averageDamp(f: Double => Double)(x: Double):Double = (x + f(x)) / 2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double
  def sqrt(x: Double):Double = fixedPoint(averageDamp(y => x/y))(1.0)
                                                  //> sqrt: (x: Double)Double
  def cubert(x: Double):Double = fixedPoint(averageDamp(y => x/y/y))(1.0)
}
