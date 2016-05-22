package typeclass

trait Monad[F[_]] extends Applicative[F]{
  def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]

  def flatten[A](ffa: F[F[A]]): F[A] = flatMap(ffa)(identity)

  def ap[A, B](fab: F[A => B], fa: F[A]): F[B] =
    flatMap(fab)(map(fa)(_))

  override def map[A, B](fa: F[A])(f: A => B): F[B] = flatMap(fa)(f andThen pure)
}

object Monad {
  /** syntax to summon an Monad instance using Monad[Foo] instead of implicitly[Monad[Foo]] */
  def apply[F[_]](implicit ev: Monad[F]): Monad[F] = ev
}

/** All Monad instance must respect the following laws */
case class MonadLaws[F[_]](implicit F: Monad[F]) {
  import scalaprops.Property.forAll
  import scalaprops.Properties.properties
  import scalaprops.Gen
  import scalaz.std.string._

  def consistentAp[A, B](implicit genA: Gen[F[A]], genAB: Gen[F[A => B]]) =
    forAll((ff: F[A => B], fa: F[A]) =>
      F.flatMap(ff)(f => F.map(fa)(f)) == F.ap(ff, fa)
    )

  def all(implicit genFI: Gen[F[Int]], genF: Gen[F[Int => Int]]) =
    properties("Monad")(
      "consistentAp" -> consistentAp[Int, Int]
    )
}