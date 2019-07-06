package chapter02

object CubeCalculator {

  def square(x : Int) = {
    x * x
  }

  def cube(x: Int) = {
    square(x) * x
  }
}
