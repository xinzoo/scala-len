package cn.xinzoo.scala.twodimelem.last

object Element{
  class ArrayElement(
       val contents:Array[String]
  )extends Element

  class LineElement(s:String) extends Element{
    val contents = Array(s:String)
    override def width: Int = s.length
    override def height: Int = 1
  }
  class UniformElement(
         chr:Char,
         override val width:Int,
         override val height:Int) extends Element{
      private val line = chr.toString * width
    override def contents = Array.fill(height)(line)
  }

  def elem(contents:Array[String])=
    new ArrayElement(contents)
  def elem(s:String)=
    new LineElement(s)
  def elem(chr:Char,width:Int,height:Int)=
    new UniformElement(chr,width,height)
}

import Element.elem
abstract class Element {
  def contents:Array[String]
  def width : Int =
    if (height == 0) 0 else contents(0).length
  def height:Int=contents.length
  def above(that:Element):Element=
    elem(this.contents ++ that.contents)
  def beside(that:Element) =
    elem(
      for (
        (line1,line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )

  override def toString: String = contents.mkString("\n")
}
