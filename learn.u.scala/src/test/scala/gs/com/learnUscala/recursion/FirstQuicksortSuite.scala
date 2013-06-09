package gs.com.learnUscala.recursion


import org.scalatest.Assertions
import org.junit.Test

class FirstQuicksortSuite extends Assertions {
  
  @Test def FirstQuicksortShouldSortAListOfIntegers() {
	  val unsorted = List(8,4,6,9,3,6,8,2,6,8,1,0)
	  val sorted = List(0, 1, 2, 3, 4, 6, 6, 6, 8, 8, 8, 9)
	  val qs = new FirstQuicksort()
	  assert(qs.apply(unsorted) === sorted)
  }

}