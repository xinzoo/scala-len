package cn.xinzoo.scala.twodimelem.last

object Test {
  def main(args: Array[String]): Unit = {
    val e1:Element = Element.elem(Array("hello"))
    val e2:Element = Element.elem(Array("world!11"))
    val s = e1 above e2
    println(s)
  }
}
