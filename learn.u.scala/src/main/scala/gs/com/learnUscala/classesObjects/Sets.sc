package gs.com.learnUscala.classesObjects

object SetManipulation {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  trait Set[A] {
    implicit protected def toOrdered: A => Ordered[A]
    def incl(x: A): Set[A]
    def contains(x: A): Boolean
    def isEmpty: Boolean
  }

  class EmptySet[A <% Ordered[A]] extends Set[A] {
    protected def toOrdered = implicitly[A => Ordered[A]]
    def contains(x: A): Boolean = false
    def incl(x: A): Set[A] = new NonEmptySet(x, new EmptySet[A], new EmptySet[A])
    def isEmpty: Boolean = true
  }
  
  class NonEmptySet[A <% Ordered[A]](elem: A, left: Set[A], right: Set[A]) extends Set[A] {
    protected def toOrdered = implicitly[A => Ordered[A]]
    def contains(x: A): Boolean =
      if (x < elem) left contains x
      else if (x > elem) right contains x
      else true
    def incl(x: A): Set[A] =
      if (x < elem) new NonEmptySet(elem, left incl x, right)
      else if (x > elem) new NonEmptySet(elem, left, right incl x)
      else this
    def isEmpty: Boolean = false
  }

  case class Num(value: Double) extends Ordered[Num] {
    def compare(that: Num): Int =
      if (this.value < that.value) -1
      else if (this.value > that.value) 1
      else 0
  }
  
  val s = new EmptySet[Num].incl(Num(1.0)).incl(Num(2.0))
                                                  //> s  : gs.com.learnUscala.classesObjects.SetManipulation.Set[gs.com.learnUsca
                                                  //| la.classesObjects.SetManipulation.Num] = gs.com.learnUscala.classesObjects.
                                                  //| SetManipulation$$anonfun$main$1$NonEmptySet$1@3d164721
  s.contains(Num(1.5))                            //> res0: Boolean = false
  
  val aInts = List(1,2,3,4,5,6,7,8,9)             //> aInts  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val oneLeaf = new NonEmptySet[Int](1, new EmptySet, new EmptySet)
                                                  //> oneLeaf  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet[In
                                                  //| t] = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonE
                                                  //| mptySet$1@6504a503
  val threeLeaf = new NonEmptySet[Int](3, new EmptySet, new EmptySet)
                                                  //> threeLeaf  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet[
                                                  //| Int] = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$No
                                                  //| nEmptySet$1@51f3336e
  val fiveLeaf = new NonEmptySet[Int](5, new EmptySet,new EmptySet)
                                                  //> fiveLeaf  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet[I
                                                  //| nt] = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$Non
                                                  //| EmptySet$1@46abb50a
  val sevenLeaf = new NonEmptySet[Int](7, new EmptySet,new EmptySet)
                                                  //> sevenLeaf  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet[
                                                  //| Int] = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$No
                                                  //| nEmptySet$1@923ef32
  val twoNode = new NonEmptySet[Int](2, oneLeaf,threeLeaf)
                                                  //> twoNode  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet[In
                                                  //| t] = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonE
                                                  //| mptySet$1@54054c41
  val nineLeaf = new NonEmptySet[Int](9, new EmptySet,new EmptySet)
                                                  //> nineLeaf  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet[I
                                                  //| nt] = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$Non
                                                  //| EmptySet$1@52efccb1
  val sixNode = new NonEmptySet[Int](6, fiveLeaf,sevenLeaf)
                                                  //> sixNode  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet[In
                                                  //| t] = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonE
                                                  //| mptySet$1@1efe9552
  val tenNode = new NonEmptySet[Int](10, nineLeaf,new EmptySet)
                                                  //> tenNode  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet[In
                                                  //| t] = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonE
                                                  //| mptySet$1@67291453
  val fourNode = new NonEmptySet[Int](4, twoNode,sixNode)
                                                  //> fourNode  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet[I
                                                  //| nt] = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$Non
                                                  //| EmptySet$1@273abadc
  val eightNode = new NonEmptySet[Int](8, fourNode,tenNode)
                                                  //> eightNode  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet[
                                                  //| Int] = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$No
                                                  //| nEmptySet$1@35b0c0b8

  
  //             8
  //           4     10
  //         2   6
  //        1 3 5 7 9
  
  val counting = eightNode                        //> counting  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet[I
                                                  //| nt] = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$Non
                                                  //| EmptySet$1@35b0c0b8
counting contains 0                               //> res1: Boolean = false
counting contains 1                               //> res2: Boolean = true
counting contains 2                               //> res3: Boolean = true
counting contains 3                               //> res4: Boolean = true
counting contains 4                               //> res5: Boolean = true
counting contains 5                               //> res6: Boolean = true

  val eInts = List(2,4,6,8,10)                    //> eInts  : List[Int] = List(2, 4, 6, 8, 10)
//    6
//  2   10
//   4 8
  val fourLeaf = new NonEmptySet[Int](4, new EmptySet,new EmptySet)
                                                  //> fourLeaf  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet[I
                                                  //| nt] = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$Non
                                                  //| EmptySet$1@2cbcecc7
  val eightLeaf = new NonEmptySet[Int](8, new EmptySet,new EmptySet)
                                                  //> eightLeaf  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet[
                                                  //| Int] = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$No
                                                  //| nEmptySet$1@45500f57
  val twoNodeEven = new NonEmptySet[Int](2, new EmptySet,fourLeaf)
                                                  //> twoNodeEven  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySe
                                                  //| t[Int] = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$
                                                  //| NonEmptySet$1@56bbf64f
  val tenNodeEven = new NonEmptySet[Int](10, eightLeaf, new EmptySet)
                                                  //> tenNodeEven  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySe
                                                  //| t[Int] = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$
                                                  //| NonEmptySet$1@42d34b8c
  val sixNodeEven = new NonEmptySet[Int](6, twoNodeEven,tenNodeEven)
                                                  //> sixNodeEven  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySe
                                                  //| t[Int] = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$
                                                  //| NonEmptySet$1@37da1845
  val even = sixNodeEven                          //> even  : gs.com.learnUscala.classesObjects.SetManipulation.NonEmptySet[Int] 
                                                  //| = gs.com.learnUscala.classesObjects.SetManipulation$$anonfun$main$1$NonEmpt
                                                  //| ySet$1@37da1845
  val as = for  {
    a <- aInts if counting contains a
  } yield a                                       //> as  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val bs = for  {
    b <- eInts if even contains b
  } yield b                                       //> bs  : List[Int] = List(2, 4, 6, 8, 10)
/*  val intersection = as.to[Set] & bs.to[Set]
  val union:Set[Int] = as.to[Set] ++ bs.to[Set]
  even.left
*/
}