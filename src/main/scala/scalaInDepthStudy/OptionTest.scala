package scalaInDepthStudy

/**
 * Created by jianying.wcj on 2015/5/8 0008.
 */
object OptionTest {

    def getTemporaryDirectory(tmpArg : Option[String]) : java.io.File = {
        tmpArg.map(name => new java.io.File(name)).
            filter(_.isDirectory).
            getOrElse(new java.io.File(System.getProperty("java.io.tmpdir")));
    }

    def main(args : Array[String]): Unit = {
        val a = List("a1","a2","a3")
        val b = List("b1","b2","b3")
        val c = List("c1","c2","c3")

        for{
            tempa <- a
            tempb <- b
            tempc <- c
        } yield println(tempa+" "+tempb+" "+tempc)
    }

}
