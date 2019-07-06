class Timestamp(val seconds: Long) {}

object Timestamp {
  def apply(hours: Int, minutes: Int, seconds: Int): Timestamp =
    new Timestamp(hours * 60 * 60 + minutes * 60 + seconds)
}

Timestamp(1, 1, 1).seconds

Timestamp