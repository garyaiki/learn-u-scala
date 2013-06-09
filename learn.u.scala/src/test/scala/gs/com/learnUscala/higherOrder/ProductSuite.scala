package gs.com.learnUscala.higherOrder
import org.scalatest.Assertions
import org.junit.Test
import Product._

class ProductSuite extends Assertions {
  @Test def ProductShouldReturn120() {
    assert(product(x => x)(1,5) === 120)
  }
  
  @Test def FactorialShouldReturn120() {
    assert(factorial(5) === 120)
  }
  

}