class Person(val firstName : String, val lastName : String) {
  override def toString = s"Person($firstName, $lastName)"
}

object Person {
  def apply(name : String) = {
    val input = name.split(" ")
    new Person(input(0), input(1))
  }
}

Person("Jon Snow")

