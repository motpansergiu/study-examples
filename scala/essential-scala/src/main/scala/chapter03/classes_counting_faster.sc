class Counter(val count : Int = 1) {

  def inc() = {
    new Counter(count + 1)
  }

  def dec() = {
    new Counter(count - 1)
  }
}

new Counter().inc().dec().inc().inc().count
