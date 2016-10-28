package typeclass.std

import typeclass.{MonoidLaws, SemigroupLaws}

import scalaprops.Scalaprops

object ListTest extends Scalaprops {

  import typeclass.std.list._

  val semigroup = SemigroupLaws[List[Int]].all
  val monoid = MonoidLaws[List[Int]].all

}
