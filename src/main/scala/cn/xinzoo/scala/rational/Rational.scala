package cn.xinzoo.scala.rational

class Rational(n: Int, d: Int) {
  require(d != 0)

  private def gcd(a: Int, b: Int): Int = {
    // 66 42 66%42 42 24 | 24 18 | 18 6|6 0 // 42 66| 66 42 |
    if (b == 0) a else gcd(b, a % b)
  }

  private def gcdLoop(x:Long,y:Long)={
    var a = x
    var b = y
    while(a != 0){
      val temp = a
      a = b%a
      b = temp
    }
    b
  }

  private val g = gcd(n.abs, d.abs)
  val number: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1)

  def this() = this(1)

  def add(that: Rational): Rational = {

    new Rational(
      number * that.denom + that.number * denom,
      denom * that.denom
    )
  }

  def +(that: Rational): Rational = {

    new Rational(
      number * that.denom + that.number * denom,
      denom * that.denom
    )
  }

  def +(i: Int): Rational = {

    new Rational(i) + this
  }

  def unary_-(): Rational = {

    new Rational(
      number * -1,
      denom
    )
  }

  def unary_+(): Rational = this

  def -(that: Rational): Rational = {

    new Rational(
      number * that.denom - that.number * denom,
      denom * that.denom
    )
  }

  def *(that: Rational): Rational = {

    new Rational(
      number * that.number,
      denom * that.denom
    )
  }

  def *(i: Int): Rational = {

    new Rational(
      number * i,
      denom
    )
  }

  def / (that: Rational): Rational = {

    new Rational(
      number * that.denom,
      denom * that.number
    )
  }

  def / (i: Int): Rational = {

    new Rational(
      number,
      denom * i
    )
  }

  def lessThan(that: Rational) =
  // 1/2 < 2/3 => 1*3 < 2*2
    this.number * that.denom < that.number * this.denom

  def max(that: Rational) = {
    if (lessThan(that))
      that
    else
      this
  }

  def min (that: Rational) = {
    if (lessThan(that))
      this
    else
      that
  }

  override def toString = number + "/" + denom
}
