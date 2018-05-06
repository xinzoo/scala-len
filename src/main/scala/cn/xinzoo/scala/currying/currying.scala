package cn.xinzoo.scala.currying

import java.io.{File, PrintWriter}

object currying {
  def planOldSum(x:Int,y:Int) = x+y
  def curriedSum(x:Int)(y:Int)=x+y
  def first(x:Int) = (y:Int) => x+y
  def twice(op:Double => Double,x:Double) = op(op(x))

  def withPrintWrite(file:File,op:PrintWriter=>Unit)={
    val writer = new PrintWriter(file)
    try{
      op(writer)
    }finally{
      writer.close()
    }
  }

  def withPrintWriteNew(file:File)(op:PrintWriter=>Unit)={
    val writer = new PrintWriter(file)
    try{
      op(writer)
    }finally{
      writer.close()
    }
  }

  var assertionsEnabled = false
  def myAssert(predicate:()=>Boolean)=
    if(assertionsEnabled && !predicate())
      throw new AssertionError()
  def myAssertShort(predicate: =>Boolean)=
    if(assertionsEnabled && !predicate)
      throw new AssertionError()
  def myAssert(predicate:Boolean)=
    if(assertionsEnabled && !predicate)
      throw new AssertionError()
  def main(args: Array[String]): Unit = {
    /*val file = new File("E:\\test1.txt")
    withPrintWriteNew(file){
      writer =>writer.print(111133)
    }*/
    println(myAssertShort(2/0 ==1))
    //println(twice(_+5,6))
  }
}
