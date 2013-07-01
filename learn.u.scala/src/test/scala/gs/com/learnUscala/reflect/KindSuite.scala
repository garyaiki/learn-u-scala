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
package gs.com.learnUscala.reflect

import scala.collection.mutable.Stack
import org.scalatest.Assertions
import org.junit.Test

class KindSuite extends Assertions {

  @Test def kindShouldReturnAProperType() {
    val k = new Kind()
    val resultInt = k.apply[Int]
    assert(resultInt.contentEquals("Int's kind is *. This is a proper type."))
    assert("Option's kind is * -> *. This is a type constructor: a 1st-order-kinded type.".contentEquals(k.apply[Option.type]))
    assert(k.apply[Either.type].contentEquals("Either's kind is * -> * -> *. This is a type constructor: a 1st-order-kinded type."))
    import scalaz._
    import Scalaz._
    assert(k.apply[Equal.type].contentEquals("Equal's kind is * -> *. This is a type constructor: a 1st-order-kinded type."))
    assert(k.apply[Functor.type].contentEquals("Functor's kind is (* -> *) -> *. This is a type constructor that takes type constructor(s): " +
        "a higher-kinded type."))
  }

}
