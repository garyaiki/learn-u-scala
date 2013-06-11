package gs.com.learnUscala.classesObjects

object SetManipulation {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  trait IntSet {
    def incl(x: Int): IntSet
    def contains(x: Int): Boolean
  }
  object EmptySet extends IntSet {
    def contains(x: Int): Boolean = false
    def incl(x: Int): IntSet = new NonEmptySet(x, EmptySet, EmptySet)
  }

  
  class NonEmptySet(elem: Int, left: IntSet, right: IntSet) extends IntSet {
    def contains(x: Int): Boolean =
      if (x < elem) left contains x
      else if (x > elem) right contains x else true
    def incl(x: Int): IntSet = {
      println("incl < " + x + " left " + left + " right " + right)
      if (x < elem) new NonEmptySet(elem, left incl x, right)
      else if (x > elem) new NonEmptySet(elem, left, right incl x)
      else this
    }
  }


    
  val aInts = List(1,2,3,4,5,6,7,8,9)             //> aInts  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val oneLeaf = new NonEmptySet(1, EmptySet,EmptySet)
                                                  //> oneLeaf  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet = g
                                                  //| s.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonEmptySet
                                                  //| $1@5a0deddc
  val threeLeaf = new NonEmptySet(3, EmptySet,EmptySet)
                                                  //> threeLeaf  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet =
                                                  //|  gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonEmptyS
                                                  //| et$1@487b34b4
  val fiveLeaf = new NonEmptySet(5, EmptySet,EmptySet)
                                                  //> fiveLeaf  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet =
                                                  //|  gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonEmpty
                                                  //| Set$1@10c13a99
  val sevenLeaf = new NonEmptySet(7, EmptySet,EmptySet)
                                                  //> sevenLeaf  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet 
                                                  //| = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonEmpt
                                                  //| ySet$1@7dee1b66
  val twoNode = new NonEmptySet(2, oneLeaf,threeLeaf)
                                                  //> twoNode  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet = 
                                                  //| gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonEmptyS
                                                  //| et$1@1b490621
  val nineLeaf = new NonEmptySet(9, EmptySet,EmptySet)
                                                  //> nineLeaf  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet =
                                                  //|  gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonEmpty
                                                  //| Set$1@57316e85
  val sixNode = new NonEmptySet(6, fiveLeaf,sevenLeaf)
                                                  //> sixNode  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet = 
                                                  //| gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonEmptyS
                                                  //| et$1@6e4f0a7b
  val tenNode = new NonEmptySet(10, nineLeaf,EmptySet)
                                                  //> tenNode  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet = 
                                                  //| gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonEmptyS
                                                  //| et$1@73949d1
  val fourNode = new NonEmptySet(4, twoNode,sixNode)
                                                  //> fourNode  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet =
                                                  //|  gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonEmpty
                                                  //| Set$1@421d3c0b
  val eightNode = new NonEmptySet(8, fourNode,tenNode)
                                                  //> eightNode  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet 
                                                  //| = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonEmpt
                                                  //| ySet$1@d511816

  
  //             8
  //           4     10
  //         2   6
  //        1 3 5 7 9
  
  val counting = eightNode                        //> counting  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet =
                                                  //|  gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonEmpty
                                                  //| Set$1@d511816

  //initSet(aInts)(counting)
counting contains 0                               //> res0: Boolean = false
counting contains 1                               //> res1: Boolean = true
counting contains 2                               //> res2: Boolean = true
counting contains 3                               //> res3: Boolean = true
counting contains 4                               //> res4: Boolean = true
counting contains 5                               //> res5: Boolean = true

  val eInts = List(2,4,6,8,10)                    //> eInts  : List[Int] = List(2, 4, 6, 8, 10)
//    6
//  2   10
//   4 8
  val fourLeaf = new NonEmptySet(4, EmptySet,EmptySet)
                                                  //> fourLeaf  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet =
                                                  //|  gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonEmpty
                                                  //| Set$1@4704532e
  val eightLeaf = new NonEmptySet(8, EmptySet,EmptySet)
                                                  //> eightLeaf  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet 
                                                  //| = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonEmpt
                                                  //| ySet$1@6cf1156e
  val twoNodeEven = new NonEmptySet(2, EmptySet,fourLeaf)
                                                  //> twoNodeEven  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySe
                                                  //| t = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonEm
                                                  //| ptySet$1@47b620a2
  val tenNodeEven = new NonEmptySet(10, eightLeaf, EmptySet)
                                                  //> tenNodeEven  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySe
                                                  //| t = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonEm
                                                  //| ptySet$1@6189076
  val sixNodeEven = new NonEmptySet(6, twoNodeEven,tenNodeEven)
                                                  //> sixNodeEven  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySe
                                                  //| t = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonEm
                                                  //| ptySet$1@36b4361a
  val even = sixNodeEven                          //> even  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet = gs.
                                                  //| com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonEmptySet$
                                                  //| 1@36b4361a
  val as = for  {
    a <- aInts if counting contains a
  } yield a                                       //> as  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val bs = for  {
    b <- eInts if even contains b
  } yield b                                       //> bs  : List[Int] = List(2, 4, 6, 8, 10)
  val intersection = as.to[Set] & bs.to[Set]      //> intersection  : scala.collection.immutable.Set[Int] = Set(6, 2, 8, 4)
  val union:Set[Int] = as.to[Set] ++ bs.to[Set]   //> union  : Set[Int] = Set(5, 10, 1, 6, 9, 2, 7, 3, 8, 4)
}