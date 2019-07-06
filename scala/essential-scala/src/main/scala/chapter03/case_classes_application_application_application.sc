case class Person(firstName: String, lastName: String) {
  def name = s"$firstName $lastName"
}

object Person {
  def apply(name: String) = {
    val input = name.split(" ")
    new Person(input(0), input(1))
  }
}

val person1 = Person.apply("Jon Snow")
val person2 = Person.apply("Jon", "Snow")

person1 == person2
person1.equals(person2)
person1 eq person2