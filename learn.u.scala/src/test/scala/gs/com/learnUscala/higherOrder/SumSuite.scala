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