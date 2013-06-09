package gs.com.learnUscala.recursion

import org.scalatest.Assertions
import org.junit.Test
import Factorial._

class FactorialSuite extends Assertions {

  @Test def FactorialShouldReturn120() {
    val result = factorial(5)
    assert(result === 120)
  }
}