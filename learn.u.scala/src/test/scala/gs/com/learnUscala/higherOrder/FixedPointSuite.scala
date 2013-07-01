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
import FixedPoint._

class FixedPointSuite extends Assertions {
  @Test def SquareRoot16ShouldReturn4() {
    val root = sqrt(16)
    println("sqrt 16 " + root)
    assert(root < 4 + tolerance)
    assert(root > 4 - tolerance)

  }
  
  @Test def CubeRoot64ShouldReturn4() {
    val root = cubert(64)
    println( "root 64 " + root + " floor " + root.floor + " ceil " + root.ceil)
    assert(root < 4 + tolerance)
    assert(root > 4 - tolerance)
  }
  

}