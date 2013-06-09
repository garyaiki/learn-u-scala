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