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