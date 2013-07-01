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
import org.scalatest.Assertions
import org.junit.Test
//import Rational._

class RationalSuite extends Assertions {
  
  val half = new Rational(1,2)
  val third = new Rational(1,3)

  @Test def RationalAddShouldReturn5sixths() {
    assert(half.numer === 1)
    assert(half.denom === 2)

  }
  
  @Test def RationalSubShouldReturn1sixth() {
    val sixth = half - third
    assert(sixth.numer === 1)
    assert(sixth.denom === 6)
  }
  
  @Test def RationalMultShouldReturn1sixth() {
    val sixth = half * third
    assert(sixth.numer === 1)
    assert(sixth.denom === 6)
  }
  
  @Test def RationalDivShouldReturn3halfs() {
    val threeHalfs = half / third
    assert(threeHalfs.numer === 3)
    assert(threeHalfs.denom === 2)
  }
}