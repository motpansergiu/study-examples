// --- Case Classes
case class Person (firstName : String , lastName : String) {
  def name() = firstName + " " + lastName
}

val jonSnow = new Person("Jon" , "Snow")

val person = Person.apply("Jon", "Samagon")
val maybeTuple = Person.unapply(jonSnow)


// --- Case object
case object Citizen {
  def firstName = "Jon"
  def lastName = "Snow"
  def name = firstName + " " + lastName
}

Citizen.toString