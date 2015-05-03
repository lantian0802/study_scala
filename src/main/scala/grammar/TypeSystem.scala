package grammar
/**
 * Created by jianying.wcj on 2015/5/3 0003.
 */
object TypeSystem {

    def main(args : Array[String]): Unit = {
        typeSystem3()
    }

   /* def typeSystem1(): Unit = {
        case class A(){}
        object A {}
    }*/
    //一下链式调用成立，利用了this的动态特性
    def typeSystem2(): Unit = {
        class A {def method1:this.type = this}
        class B extends A{def method2:this.type  = this}
        val b = new B
        b.method1.method2
    }

    def typeSystem3(): Unit = {
        class A1 {
            class B;
            //定义为类的投影
            def foo(b:A1#B) = println(b)
        }
        val a1 = new A1
        val a2 = new A1

        val b1 = new a1.B
        val b2 = new a2.B

       a1.foo(b2)
    }
}
