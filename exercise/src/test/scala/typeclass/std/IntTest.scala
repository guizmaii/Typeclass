package typeclass.std

import typeclass.{MonoidLaws, SemigroupLaws}

import scalaprops.Scalaprops

object IntTest extends Scalaprops {

  import typeclass.std.int._

  val semigroup = SemigroupLaws[Int].all
  val monoid = MonoidLaws[Int].all

}
