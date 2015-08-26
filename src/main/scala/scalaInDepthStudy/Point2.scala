package scalaInDepthStudy
import collection.immutable.HashMap
/**
 * Created by jianying.wcj on 2015/5/7 0007.
 */
class Point2(var x : Int, var y : Int) {

    def move(mx : Int,my : Int): Unit = {
        x = x + mx
        y = y + my
    }

    override def hashCode() : Int = y + (31 * x)
}

object Point2 {
    def main(args : Array[String]): Unit = {
        val x = new Point2(1,1)
        println(x.##)
        val y = new Point2(2,1)
        val map = HashMap(x -> "HAI",y -> "ZOMG")
        println(map(x))
        val z = new Point2(1,1)
        println(map(z))
    }
}
