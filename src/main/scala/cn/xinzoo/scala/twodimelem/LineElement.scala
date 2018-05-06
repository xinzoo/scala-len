package cn.xinzoo.scala.twodimelem

class LineElement(s:String) extends Element (){

  override def width: Int = s.length
  override val height: Int = 1

  override def contents: Array[String] = Array(s)
}
