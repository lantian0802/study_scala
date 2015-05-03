package chapter6
import java.util.{HashMap => JavaHashMap}
import scala.collection.mutable.HashMap
/**
 * Created by jianying.wcj on 2015/1/18 0018.
 */
object HashMapTest extends App {

    val map = new JavaHashMap[String,String]()
    map.put("1","a")
    map.put("2","b")
    map.put("3","c")

    val smap = new HashMap[String,String]()
    for(key <- map.keySet().toArray) {
        smap += (key.toString -> map.get(key))
    }

   // println(smap.mkString(,))
}
