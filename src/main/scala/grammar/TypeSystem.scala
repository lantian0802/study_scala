package grammar

import com.sun.org.apache.xml.internal.security.transforms.params.XPath2FilterContainer

/**
 * Created by jianying.wcj on 2015/5/3 0003.
 */
object TypeSystem {

    def main(args : Array[String]): Unit = {
        typeSystem5()
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
    //类型投影
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
    //传递一个方法,不需要一定是实现closable接口
    def typeSystem4(): Unit = {
        def free(res:{def close():Unit}): Unit = {
            res.close()
        }

        free(new {def close() = println("closed")})
    }
    //符合类型
    def typeSystem5(): Unit = {
        trait X1; trait X2;
        type X = X1 with X2
        def test(x:X) = println("OK")
        class A extends X1 with X2
        val a = new A
        test(a)
    }
    //this 的别名
    def typeSystem6(): Unit = {

        class A {
            self => //这里相当于A的别名
                val x = 2
                def foo = self.x + this.x
        }

        class Outer {
            outer => //这里相当于Outer的别名
                class Inner {
                    println(outer)
                }
        }

        trait X
        class C {
            this:X => //当指定了类型X后，表示在实例化C是必须混入类型X
        }
        //要求某个class或object要继承或混入T时，也必须要混入X
        trait T {this:X => }
    }
    //实现union type
    def typeSystem7(): Unit = {

        class StringOrInt[T]

        object StringOrInt {
            implicit object IntWitness extends StringOrInt[Int]
            implicit object StringWitness extends StringOrInt[String]
        }

        object Bar{
            def foo[T:StringOrInt](x:T) = x match {
                case _:String => println("str")
                case _:Int => println("int")
            }
        }
    }
}
