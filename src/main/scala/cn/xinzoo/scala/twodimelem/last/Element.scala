package cn.xinzoo.scala.twodimelem.last


import Element.elem

abstract class Element {
  def contents: Array[String]

  def width: Int =
    if (height == 0) 0 else contents(0).length

  def height: Int = contents.length

  def widen(w: Int) =
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }

  def heighten(h: Int) =
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }

  def above(that: Element): Element = {
    if (this.width > that.width)
      elem(this.contents ++ (that.widen(this.width)).contents)
    else
      elem((this.widen(that.width)).contents ++ that.contents)
  }

  //elem(this.contents ++ that.contents)

  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(
      for ((line1, line2) <- this1.contents zip that1.contents)
        yield line1 + line2
    )
  }

  /*  elem(
      for (
        (line1, line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )*/

  override def toString: String = contents.mkString("\n")
}

object Element {

  class ArrayElement(
                      val contents: Array[String]
                    ) extends Element

  class LineElement(s: String) extends Element {
    val contents = Array(s: String)

    override def width: Int = s.length

    override def height: Int = 1
  }

  class UniformElement(
                        chr: Char,
                        override val width: Int,
                        override val height: Int) extends Element {
    private val line = chr.toString * width

    override def contents = Array.fill(height)(line)
  }

  def elem(contents: Array[String]) =
    new ArrayElement(contents)

  def elem(s: String) =
    new LineElement(s)

  def elem(chr: Char, width: Int, height: Int) =
    new UniformElement(chr, width, height)
}
