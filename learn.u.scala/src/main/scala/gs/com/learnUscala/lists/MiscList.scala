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
package gs.com.learnUscala.lists

object MiscList {
  def isort(xs: List[Int]): List[Int] = {
    def insert(x: Int, xs: List[Int]): List[Int] =
      xs match {
        case List() => List(x)
        case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
      }
    if (xs.isEmpty) Nil else insert(xs.head, isort(xs.tail))
  }

  def msort[A](less: (A, A) => Boolean)(xs: List[A]): List[A] = {
    def merge(xs1: List[A], xs2: List[A]): List[A] =
      if (xs1.isEmpty) xs2 else if (xs2.isEmpty) {
        xs1
      } else {
        if (less(xs1.head, xs2.head)) xs1.head :: merge(xs1.tail, xs2) else xs2.head :: merge(xs1, xs2.tail)
      }


    val n = xs.length/2
    if (n == 0) xs else merge(msort(less)(xs take n), msort(less)(xs drop n))
  }

  def isPrime(n: Int):Boolean =
    List.range(2, n) forall (x => n % x != 0)

  def hasFactor(n:Int,f: (Int, List[Int]) => List[Int]):Boolean = {

    val p = f(n,List.range(2, n))
    println(p)
    !p.isEmpty
  }
}
