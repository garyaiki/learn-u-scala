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
import org.scalatest.Assertions
import org.junit.Test
import Sum.sum,Sum.sumInts,Sum.sumSquares,Sum.sumPowersOfTwo,Sum.powersOfTwo

class SumSuite extends Assertions {
  val a = 4
  val b = 6
  @Test def sumIntShouldReturn15() {
    assert(sumInts(a,b) === 15)
    assert(sum(x => x)(a,b) === 15)
  }

  @Test def sumSquaresShouldReturn77() {
    assert(sumSquares(a,b) === 77)
    assert(sum(x => x * x)(a,b) === 77)
  }

  @Test def sumPowersOfTwoShouldReturn112() {
    assert(sumPowersOfTwo(a,b) === 112)
    assert(sum(powersOfTwo)(a,b) === 112)
  }
}
