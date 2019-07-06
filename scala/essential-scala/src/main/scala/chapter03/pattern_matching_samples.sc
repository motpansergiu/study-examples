case class Person(firstName: String, lastName: String) {}

object Stormtrooper {

  def inspect(person: Person): String =
    person match {
      case Person("Jon", "Snow") => "He must live"
      case Person("Jamie", "Lanister") => "Hmmm, I do not know"
      case Person(firstName, lastName) => s"We will continue seeing $firstName"
    }
}

// -------------------------------------------------------------------------------
Stormtrooper.inspect(Person("Jon", "Snow"))
Stormtrooper.inspect(Person("Jamie", "Lanister"))
Stormtrooper.inspect(Person("Cercei", "Laniester"))
Stormtrooper.inspect(Person("Cercei", null))