package typeclass.data

import typeclass.Semigroup

import scalaprops.Gen

case class Last[A](value: Option[A])

object Last {
  implicit def gen[A: Gen]: Gen[Last[A]] = Gen[Option[A]].map(Last(_))

  implicit def semigroup[A]: Semigroup[Last[A]] = new Semigroup[Last[A]] {
    def combine(x: Last[A], y: Last[A]): Last[A] = (x.value, y.value) match {
      case (None, None) => Last.empty
      case (Some(_), None) => x
      case (None, Some(_)) => y
      case (Some(_), Some(_)) => y
    }
  }

  def empty[A] = Last(None: Option[A])
}
