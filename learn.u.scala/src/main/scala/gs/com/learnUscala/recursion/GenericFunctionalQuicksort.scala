package gs.com.learnUscala.recursion

object GenericFunctionalQuicksort {
  /*
  * from Scala by Example changed to be generic for Ordered types
  * clean code but less than and greater then sorts each traverse the array
  */
	class Quicksort[A <% Ordered[A]] {
import scala.collection.mutable.ArraySeq
	    	    
		def sort(a:ArraySeq[A]): ArraySeq[A] =
			if (a.length < 2) a
			else {
				val pivot = a(a.length / 2)
				sort (a filter (pivot >)) ++ (a filter (pivot == )) ++
				sort (a filter(pivot <))
			}
		}
	}