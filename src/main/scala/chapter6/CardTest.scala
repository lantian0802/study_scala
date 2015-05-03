package chapter6

/**
 * Created by jianying.wcj on 2015/1/18 0018.
 */
object CardTest extends Enumeration with App{

    val M = Value("a")
    val T = Value("b")
    val H = Value("c")
    val F = Value("d")

    println(CardTest.M)
    println(CardTest.T)
    println(CardTest.H)
    println(CardTest.F)
}
