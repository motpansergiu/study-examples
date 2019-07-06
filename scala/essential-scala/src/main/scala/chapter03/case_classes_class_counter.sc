case class Counter(counter: Int) {
  def dec = copy(counter - 1)

  def inc = copy(counter + 1)
}

Counter(0)

Counter(0).inc

Counter(0).dec

Counter(0).inc.dec == Counter(0).dec.inc