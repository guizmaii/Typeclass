package typeclass

trait Semigroup[A] {
  def combine(x: A, y: A): A
}

object Semigroup {
  def apply[A](implicit ev: Semigroup[A]): Semigroup[A] = ev
}

case class SemigroupLaws[A](implicit ev: Semigroup[A]) {
  import typeclass.syntax.semigroup._
  import scalaprops.Properties.properties
  import scalaprops.Property.forAll
  import scalaprops.{Gen, Property}
  import scalaz.std.string._

  def associative(implicit genA: Gen[A]): Property =
    forAll((x: A, y: A, z: A) => x.combine(y).combine(z) == x.combine(y.combine(z)))

  def all(implicit genA: Gen[A]) =
    properties("Semigroup")(("associative", associative))
}
