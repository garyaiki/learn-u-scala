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

object Product {

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
   */
  def product(f: Int => Int)(a: Int, b: Int): Int = {
  import scala.annotation.tailrec
    @tailrec
    def productAcc(a: Int, result: Int): Int = {
      if (a > b) result else productAcc(a + 1, result * f(a))
    }
    productAcc(a, 1)
  }

  def factorial(b:Int):Int = product(x => x)(1,b)
}
