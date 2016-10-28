package typeclass.std

import typeclass.{Monoid, Semigroup}

object list {

  implicit def listSemigroup[A]: Semigroup[List[A]] = new Semigroup[List[A]] {
    def combine(x: List[A], y: List[A]): List[A] = x ::: y
  }

  implicit def listMonoid[A]: Monoid[List[A]] = new Monoid[List[A]] {
    def combine(x: List[A], y: List[A]): List[A] = x ::: y
    def empty: List[A] = List.empty
  }

}
