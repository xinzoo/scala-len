package cn.xinzoo.scala.twodimelem.last

import cn.xinzoo.scala.twodimelem.last.Element.ArrayElement

object Test {
  def main(args: Array[String]): Unit = {
    val e1:Element = Element.elem(Array("hello"))
    val e2:Element = Element.elem(Array("world!11","ssss"))
    val s = e1 above e2
    val e3 = Element.elem("aaaa")
    val b = e2.beside(e1)
    //val e4 = new ArrayElement(Array("aaa","bbb"))
    //println(s)
    println("-------")
    println(b)
  }
}
