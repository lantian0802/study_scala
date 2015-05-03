package chapter6
import scala.io.StdIn
/**
 * Created by jianying.wcj on 2015/1/18 0018.
 */
object ReadTest extends App {

    val password = StdIn.readLine()
    if(password equals "secret") {
        println("hello"+System.getProperty("user.name"))
    } else {
        System.err.println("error")
    }
}
