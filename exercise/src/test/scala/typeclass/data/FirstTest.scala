package typeclass.data

import typeclass.{MonoidLaws, SemigroupLaws}

import scalaprops.Scalaprops

object FirstTest extends Scalaprops {

  import typeclass.data.First._

  val semigroup = SemigroupLaws[First[Int]].all

  val monoid = MonoidLaws[First[Int]].all

}
