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
import Sum._

class SumSuite extends Assertions {
  @Test def SumIntShouldReturn15() {
    assert(sumInts(4,6) === 15)
    assert(sum(x => x)(4,6) === 15)
  }
  
  @Test def SumSquaresShouldReturn77() {
    assert(sumSquares(4,6) === 77)
    assert(sum(x => x * x)(4,6) === 77)
  }
  
  @Test def SumPowersOfTwoShouldReturn112() {
    assert(sumPowersOfTwo(4,6) === 112)
    assert(sum(powersOfTwo)(4,6) === 112)
  }
}