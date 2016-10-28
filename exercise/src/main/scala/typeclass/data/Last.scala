package typeclass.data

import typeclass.Semigroup

import scalaprops.Gen

case class Last[A](value: Option[A])

object Last {
  implicit def gen[A: Gen]: Gen[Last[A]] = Gen[Option[A]].map(Last(_))

  implicit def semigroup[A]: Semigroup[Last[A]] = new Semigroup[Last[A]] {
    def combine(x: Last[A], y: Last[A]): Last[A] = Last(y.value.orElse(x.value))
  }

  def empty[A] = Last(None: Option[A])
}
