package gs.com.learnUscala.lists

object MoreLists {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val diag3 =(1::(0::(0::Nil)))::
      (0 :: (1 :: (0 :: Nil))) ::
      (0 :: (0 :: (1 :: Nil))) :: Nil             //> diag3  : List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
                                                  //| 
  val diag3np =(1::0::0::Nil)::
      (0 :: 1 :: 0 :: Nil) ::
      (0 :: 0 :: 1 :: Nil) :: Nil                 //> diag3np  : List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1
                                                  //| ))
  diag3np.isEmpty                                 //> res0: Boolean = false
  diag3np.head                                    //> res1: List[Int] = List(1, 0, 0)
  diag3np.tail.head                               //> res2: List[Int] = List(0, 1, 0)

  def isort(xs: List[Int]): List[Int] = {
    def insert(x: Int, xs: List[Int]): List[Int] =
      xs match {
        case List() => List(x)
        case y :: ys => if (x <= y) x :: xs
                        else y :: insert(x, ys)
      }
    if (xs.isEmpty) Nil
    else insert(xs.head, isort(xs.tail))
  }                                               //> isort: (xs: List[Int])List[Int]
  
  val unsorted = List(3,6,8,2,5,9,1,0,3,2)        //> unsorted  : List[Int] = List(3, 6, 8, 2, 5, 9, 1, 0, 3, 2)
  val sorted = isort(unsorted)                    //> sorted  : List[Int] = List(0, 1, 2, 2, 3, 3, 5, 6, 8, 9)
  
  def msort[A](less: (A, A) => Boolean)(xs: List[A]): List[A] = {
    def merge(xs1: List[A], xs2: List[A]): List[A] =
      if (xs1.isEmpty) xs2
      else if (xs2.isEmpty) xs1
           else if (less(xs1.head, xs2.head)) xs1.head :: merge(xs1.tail, xs2)
           else xs2.head :: merge(xs1, xs2.tail)
    
    val n = xs.length/2
    if (n == 0) xs
    else merge(msort(less)(xs take n), msort(less)(xs drop n))
  }                                               //> msort: [A](less: (A, A) => Boolean)(xs: List[A])List[A]
  msort((x: Int, y: Int) => x < y)(List(5, 7, 1, 3))
                                                  //> res3: List[Int] = List(1, 3, 5, 7)
  val intSort = msort((x: Int, y: Int) => x < y) _//> intSort  : List[Int] => List[Int] = <function1>
  intSort(List(5, 7, 1, 3))                       //> res4: List[Int] = List(1, 3, 5, 7)
  val reverseSort = msort((x: Int, y: Int) => x > y) _
                                                  //> reverseSort  : List[Int] => List[Int] = <function1>
  reverseSort(List(5, 7, 1, 3))                   //> res5: List[Int] = List(7, 5, 3, 1)
  
  def squareList(xs: List[Int]): List[Int] = xs match {
    case List() => Nil
    case y :: ys => y * y :: squareList(ys)
  }                                               //> squareList: (xs: List[Int])List[Int]
  val sq = squareList(unsorted)                   //> sq  : List[Int] = List(9, 36, 64, 4, 25, 81, 1, 0, 9, 4)
  def squareList2(xs: List[Int]): List[Int] =
    xs map (x => x * x)                           //> squareList2: (xs: List[Int])List[Int]

  val sq2 = squareList2(unsorted)                 //> sq2  : List[Int] = List(9, 36, 64, 4, 25, 81, 1, 0, 9, 4)
  
  def isPrime(n: Int) =
    List.range(2, n) forall (x => n % x != 0)     //> isPrime: (n: Int)Boolean
  val iP = isPrime(101)                           //> iP  : Boolean = true

  def factors(n: Int, xs:List[Int]):List[Int] =
      xs filter(x => n % x == 0)                  //> factors: (n: Int, xs: List[Int])List[Int]
  def isPrime2(n:Int,f: (Int, List[Int]) => List[Int]):Boolean = {
    
    val p = f(n,List.range(2, n))
    println(p)
    p.isEmpty
  }                                               //> isPrime2: (n: Int, f: (Int, List[Int]) => List[Int])Boolean
  
  isPrime2(100,factors)                           //> List(2, 4, 5, 10, 20, 25, 50)
                                                  //| res6: Boolean = false
  
  def hasFactor(n:Int,f: (Int, List[Int]) => List[Int]):Boolean = {
    
    val p = f(n,List.range(2, n))
    println(p)
    !p.isEmpty
  }                                               //> hasFactor: (n: Int, f: (Int, List[Int]) => List[Int])Boolean
  
  hasFactor(100,factors)                          //> List(2, 4, 5, 10, 20, 25, 50)
                                                  //| res7: Boolean = true
  
  def flatten[A](xs: List[List[A]]): List[A] = (xs :\ (Nil: List[A])) {
    (x, xs) => x ::: xs
  }                                               //> flatten: [A](xs: List[List[A]])List[A]
  val toFlat = List(List(1,2),List(3,4),List(5,6))//> toFlat  : List[List[Int]] = List(List(1, 2), List(3, 4), List(5, 6))
  flatten(toFlat)                                 //> res8: List[Int] = List(1, 2, 3, 4, 5, 6)
  
  def flatten2[A](xs: List[List[A]]): List[A] = ((Nil: List[A]) /:xs ) {
    (xs, x) => xs ::: x
  }                                               //> flatten2: [A](xs: List[List[A]])List[A]
  flatten2(toFlat)                                //> res9: List[Int] = List(1, 2, 3, 4, 5, 6)
  
  def mapFun[A, B](xs: List[A], f: A => B): List[B] = (xs :\ List[B]()){ (x, xs) => f(x) :: xs }
                                                  //> mapFun: [A, B](xs: List[A], f: A => B)List[B]
  def lengthFun[A](xs: List[A]): Int = (0 /: xs){ (sum, _) => sum + 1 }
                                                  //> lengthFun: [A](xs: List[A])Int
  def primeTups(n:Int) = List.range(1, n)
    .flatMap(i => List.range(1,i).map(x => (i, x)))
    .filter(pair => isPrime(pair._1 + pair._2))   //> primeTups: (n: Int)List[(Int, Int)]
    primeTups(7)                                  //> res10: List[(Int, Int)] = List((2,1), (3,2), (4,1), (4,3), (5,2), (6,1), (6
                                                  //| ,5))
}