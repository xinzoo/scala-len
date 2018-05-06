package cn.xinzoo.scala


import cn.xinzoo.scala.highorder.FileMatcher
import cn.xinzoo.scala.rational.Rational
import cn.xinzoo.scala.twodimelem.{ArrayElement, Element, UniformElement}

object Test {
  def main(args: Array[String]): Unit = {
    //val files = FileMatcher.filesContaining("E:\\workspace\\spark-myex\\src\\main\\scala\\cn\\xinzoo\\spark\\ex","scala")
    val elem:ArrayElement = new ArrayElement(Array("abc","def"))
    elem.sayHello
    val e1:Element = new UniformElement('A',2,3)
    e1.sayHello

    println(e1.height + ","+e1.width)
  }

  def containsNeg(nums:List[Int])={
    var exists:Boolean = false
    for (num <- nums)
      if (num < 0){
        println(num)
        exists = true
      }
    exists
  }

  def containsNegShort(nums:List[Int])= nums.exists(_<0)
  def containsOdd(nums:List[Int])=nums.exists(_%2==1)
}
