package typeclass.syntax

import typeclass.Functor

object functor {
  // implicit class FunctorOps

  implicit class FunctorOps[F[_], A](fa: F[A])(implicit ev: Functor[F]) {
    def map[B](f: A => B) = ev.map(fa)(f)
    def void[B] = ev.void(fa)
    def as[B](b: B): F[B] = ev.as(fa, b)
    def lift[B](f: A => B): F[A] => F[B] = ev.lift(f)
  }
}
