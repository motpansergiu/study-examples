class Adder(amount: Int) {
  def apply(in: Int) = in + amount
}

val adder = new Adder(10)


adder.apply(10)

adder(5)