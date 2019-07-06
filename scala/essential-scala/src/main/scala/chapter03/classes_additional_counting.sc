class Adder(amount: Int) {
  def add(in: Int) = in + amount
}

class Counter(val count: Int = 1) {

  def inc() =
    new Counter(count + 1)

  def dec() =
    new Counter(count - 1)
  
  def adjust(adder: Adder) =
    new Counter(adder.add(count))
}

new Counter(7).adjust(new Adder(3)).count