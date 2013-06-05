package gs.com.learnUscala.reflect

import scala.collection.mutable.Stack
import scala.reflect.runtime._
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
    assert(k.apply[Functor.type].contentEquals("Functor's kind is (* -> *) -> *. This is a type constructor that takes type constructor(s): a higher-kinded type."))
  }

}