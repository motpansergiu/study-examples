class Director(val firstName: String, val lastName: String, val yearOfBirth: Int) {

  def name() =
    firstName + " " + lastName


  override def toString = s"Director($firstName, $lastName, $yearOfBirth)"
}

//-----------------------------------------------------------------------------------------------------------------

object Director {

  def apply(firstName: String, lastName: String, yearOfBirth: Int) : Director =
    new Director(firstName, lastName, yearOfBirth)

  def older(director1: Director, director2: Director) : Director = {
    if (director1.yearOfBirth > director2.yearOfBirth)
      director2
    else
      director1
  }
}

//-----------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------


class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director) {

  def directorsAge() =
    yearOfRelease - director.yearOfBirth

  def isDirectedBy(d: Director): Boolean = {
    d == director
  }

  def copy(name: String = this.name,
           yearOfRelease: Int = this.yearOfRelease,
           imdbRating: Double = this.imdbRating,
           director: Director = this.director
          ) =
    new Film(name, yearOfRelease, imdbRating, director)

  override def toString = s"Film($name, $yearOfRelease, $imdbRating, $director)"
}

//-----------------------------------------------------------------------------------------------------------------

object Film {

  def apply(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) : Film =
    new Film(name, yearOfRelease, imdbRating, director)

  def highestRating(film1 : Film, film2: Film) : Double = {
    if (film1.imdbRating > film2.imdbRating)
      film1.imdbRating
    else
      film2.imdbRating
  }

  def oldestDirectorAtTheTime(film1 : Film, film2: Film) = {
    if (film1.directorsAge() > film2.directorsAge())
      film1.director
    else
      film2.director
  }
}