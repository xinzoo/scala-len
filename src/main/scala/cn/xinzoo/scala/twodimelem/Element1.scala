package cn.xinzoo.scala.twodimelem

import Element.elem
abstract class Element {
  def contents: Array[String]

  val height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

  def above (that:Element):Element=
    elem(this.contents ++ that.contents)

  def beside(that:Element):Element={
    val contents = new Array[String](this.contents.length)
    for (i <- 0 until this.contents.length)
      contents(i) = this.contents(i)+that.contents(i)
      elem(contents)
  }

  def besideShort(that:Element)=
    /*
      val a = Array("abc","def")  val b=   Array("123","456")
       val c = a zip b
       for (
        (line1,line2) <- c
       ) yield line1 +line2
       Array(abc123, def456)
      ((abc,123),(def,456))
     */
    elem(
      for (
        (line1,line2) <- this.contents zip that.contents
      ) yield line1 +line2
    )

  override def toString ={
    contents mkString "\n"
  }

  final def sayHello=println("hello,I'm base Element.")
}

object Element{
  def elem (contents : Array[String]) : Element=
    new ArrayElement(contents)
  def elem(chr:Char,width:Int,height:Int):Element=
    new UniformElement(chr,width ,height)
  def elem(line:String):Element=
    new LineElement(line)
}
