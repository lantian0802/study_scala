package chapter6

/**
 * Created by jianying.wcj on 2015/1/18 0018.
 */
class Point(var x:Int,var y:Int) {
    override def toString: String = super.toString
}

object Point {

    def apply(x:Int,y:Int): Unit = {
        new Point(x,y)
    }

    def main(args : Array[String]) ={
        val p = Point(1,2)
    }
}
