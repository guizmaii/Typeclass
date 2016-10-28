package typeclass.data

import typeclass.{MonoidLaws, SemigroupLaws}

import scalaprops.Scalaprops

object LastTest extends Scalaprops {

  import typeclass.data.Last._

  val semigroup = SemigroupLaws[Last[Int]].all

  val monoid = MonoidLaws[Last[Int]].all


}
