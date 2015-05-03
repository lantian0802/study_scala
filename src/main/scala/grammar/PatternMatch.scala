package grammar

/**
 * Created by jianying.wcj on 2015/5/2 0002.
 */
object PatternMatch {

    def main(args : Array[String]): Unit = {
        matchType11()
    }
    //某种类型模式的匹配
    def matchType1(): Unit = {
        val myArray = Array(1,2,3)
        myArray match {
            case Array(1,2,3) => print("1")
            case Array(1,_,3) => print("2")
            case _ => print("default")
        }
    }
    //常量的匹配
    def matchType2(): Unit ={
        val a = 100
        a match {
            case 100 => print("1")
        }
    }
    //类型的匹配
    def matchType3(): Unit ={
        val a = 100
        a match {
            case _:Int => print(a)
        }
    }
    //变量的模式匹配
    def matchType4(): Unit = {
        val myList = Array(1,2,3)
        myList match {
            case Array(x,2,3) => print(x)
        }
    }
    //构造器匹配
    def matchType5(): Unit = {
        trait Node
        case class TreeNode(v:String,left:Node,right:Node) extends Node
        case class Tree(root:TreeNode)

        val tree = Tree(TreeNode("root",TreeNode("left",null,null),TreeNode("right",null,null)))
        tree.root match {
            //@符号代表变量的绑定
            case TreeNode(_,TreeNode("left",_,_),rightNode@TreeNode("right",_,_)) => print(rightNode)
            case _ => println("default")
        }
    }
    //泛型擦除
    def matchType6(): Unit = {

        val a = List(1,3,4)
        a match {
            case _:List[String] => print("type1")
        }
    }
    //类型解构
    def matchType7(): Unit ={
        trait A
        class B(val p1:String,val p2:String) extends A

        object MM {
            def apply(p1:String,p2:String) : A = new B(p1,p2)
            def unapply(a:A) : Option[(String,String,String)] = {
                if(a.isInstanceOf[B]) {
                    val b = a.asInstanceOf[B]
                    return Some(b.p1,b.p2,"test")
                } else {
                    None
                }
            }
        }

        val b = new B("a","b")
        b match {
            case MM(a) => print(a)
        }
    }

    def matchType8(): Unit = {
        val a1 = 100
        val A = 100
        val a2@b2 = 100
        val (a3,b3) = (100,200)
        //第二个变量大写通不过编译，大写的变量，这里会当做常量来解析
        //val (a4,B4) = (100,200)
        val Array(a5,b5) = Array(100,200)
        val Array(a6,b6) = Array(100,200)

        object Test1 { val 2 = 2}
        object Test2 { val 2 = 3}
    }

    def matchType9(): Unit = {
        //模式匹配
        for(i@2 <- List(1,2,3)) {
            println(i)
        }
        //模式匹配
        for((name,"female") <- Set("wang" -> "male","zhang"->"female")) {
            println(name)
        }
        //类型模式匹配
        for((k,v:Int) <- List(("A" -> 2),("B"->"C"))) {
            println(k)
        }
    }

    def matchType10 (): Unit = {

        abstract class MyList[+A]
        case class Cons[B](init:MyList[B],last:B) extends MyList[B]
        case object Empty extends MyList[Nothing]

        val a = Cons(Empty,1)
        println(a)

        val b = Cons(Cons(Empty,1),2)
        println(b)
        //这里可以用中缀表达式表达，x代表上文中的Empty
        b match {
            case x Cons 1 Cons 2 => print(x)
        }

        object MyList {
            def apply[A](xs:A*):MyList[A] ={
                var r:MyList[A] = null
                var t:MyList[A] = Empty
                for(x <- xs) {
                    r = Cons(t,x)
                    t = r
                }
                r
            }
        }
    }

    def matchType11(): Unit = {
        val myList = List(1,2,3,4)
        //list的init方法返回序列除了末尾元素的所有元素。
        println(myList.init,myList.last)

        object Append{
            def unapply[A](l:List[A]) = {
                Some((l.init,l.last))
            }
        }
        //myList对应unapply的入参，x,y对应unapply的出参
        myList match {
            case Append(x,y) => println(x,y)
        }

        (1 to 9).toList match {
            case _ Append 9 => println("OK")
        }

        (1 to 9).toList match {
            case x Append 8 Append 9 => println("ok")
        }

        (1 to 9).toList match {
            case Append(Append(_,8),9) => println("ok")
        }
        //可以用符号定义一个object
        object :> {

        }
    }


}
