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

object Sum {


  /**
   * function application associates to the left. That is,
   * if args1 and args2 are argument lists, then
   * f (args1)(args2) is equivalent to (f (args1))(args2)
   *
   * function types associate to the right. I.e.
   * T1 => T2 => T3 is equivalent to T1 => (T2 => T3)
   *
   * @param f
   * @param a
   * @param b
   * @return
   *   def sum(f: Int => Int)(a:Int, b:Int): Int = {
   *     if (a > b) 0 else f(a) + sum(f)(a + 1, b)
   *   }
   */
  def sum(f: Int => Int)(a: Int, b: Int):Int = {
  import scala.annotation.tailrec
    @tailrec
    def sumAcc(a: Int, result: Int): Int = {
      if (a > b) result else sumAcc(a + 1, result + f(a))
    }
    sumAcc(a, 0)
  }
  def sumSquares:(Int, Int) => Int = sum(x => x * x) _               //> sumSquares: => (Int, Int) => Int

  def sumInts:(Int, Int) => Int = sum(x => x) _                      //> sumInts: => (Int, Int) => Int

  def powersOfTwo(x: Int): Int =
    if (x == 0) 1 else 2 * powersOfTwo(x - 1)     //> powersOfTwo: (x: Int)Int
  def sumPowersOfTwo:(Int, Int) => Int = sum(powersOfTwo) _          //> sumPowersOfTwo: => (Int, Int) => Int
}
