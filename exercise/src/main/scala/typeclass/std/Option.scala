package typeclass.std

import typeclass.Semigroup

object option {

  implicit def optionSemigroup[A](implicit ev: Semigroup[A]): Semigroup[Option[A]] = new Semigroup[Option[A]] {
    def combine(x: Option[A], y: Option[A]): Option[A] = (x, y) match {
      case (None, None)       => None
      case (Some(a), None)    => x
      case (None, Some(a))    => y
      case (Some(a), Some(b)) => Some(ev.combine(a, b))
    }
  }

}
