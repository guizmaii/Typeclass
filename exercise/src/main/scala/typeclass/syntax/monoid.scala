package typeclass.syntax

import typeclass.Monoid

object monoid {
  implicit class MonoidOps[A](a: A)(implicit ev: Monoid[A]){
    def isEmpty: Boolean = ev.isEmpty(a)
    def ifEmpty[B](t: => B)(f: => B): B = ev.ifEmpty(a)(t)(f)
  }
}


