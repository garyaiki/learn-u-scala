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
package gs.com.learnUscala.classesObjects

  class Rational(n: Int, d: Int) {
    private def gcd(x: Int, y: Int): Int = {
      if (x == 0) y else if (x < 0) {
        gcd(-x, y)
      } else {
        if (y < 0) -gcd(x, -y) else gcd(y % x, x)
      }
    }
    private val g = gcd(n, d)
    val numer: Int = n/g
    val denom: Int = d/g
    def + (that: Rational):Rational =
      new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
    def -(that: Rational):Rational =
      new Rational(numer * that.denom - that.numer * denom,
        denom * that.denom)
    def * (that: Rational):Rational =
      new Rational(numer * that.numer, denom * that.denom)
    def / (that: Rational):Rational =
      new Rational(numer * that.denom, denom * that.numer)

    override def toString:String = "" + numer + "/" + denom
}
