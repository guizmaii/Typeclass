package typeclass.std

import typeclass.{Monoid, Semigroup}

object string {

  implicit val stringSemigroup: Semigroup[String] = new Semigroup[String] {
    def combine(x: String, y: String): String = x + y
  }

  implicit val stringMonoid: Monoid[String] = new Monoid[String] {
    def combine(x: String, y: String): String = x + y
    def empty = ""
  }

}
