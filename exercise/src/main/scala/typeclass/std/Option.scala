package typeclass.std

import typeclass.{Monoid, Semigroup}

object option {

  implicit def optionSemigroup[A](implicit ev: Semigroup[A]): Semigroup[Option[A]] = new Semigroup[Option[A]] {
    def combine(x: Option[A], y: Option[A]): Option[A] = (x, y) match {
      case (None, None)       => None
      case (Some(_), None)    => x
      case (None, Some(_))    => y
      case (Some(a), Some(b)) => Some(ev.combine(a, b))
    }
  }

  implicit def optionMonoid[A](implicit ev: Monoid[A]): Monoid[Option[A]] = new Monoid[Option[A]] {
    def combine(x: Option[A], y: Option[A]): Option[A] = (x, y) match {
      case (None, None)       => None
      case (Some(_), None)    => x
      case (None, Some(_))    => y
      case (Some(a), Some(b)) => Some(ev.combine(a, b))
    }
    override def empty: Option[A] = None
  }

}
