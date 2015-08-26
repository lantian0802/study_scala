package scalaInDepthStudy

/**
 * Created by jianying.wcj on 2015/5/5 0005.
 */
object quicksort {

    def main(args : Array[String]): Unit = {
        val myList = List(1,2,4,3)
        val result = qsort(myList)
        for(item <- result) {
            print(item+" ")
        }
    }

    def qsort[T <% Ordered[T]](list : List[T]) : List[T] = list match {
        case Nil => Nil
        case x :: xs =>
            val (before,after) = xs.partition( _ < x)
            qsort(before) ++ (x :: qsort(after))
    }
}
