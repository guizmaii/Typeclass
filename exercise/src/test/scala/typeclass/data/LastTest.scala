package typeclass.data

import typeclass.SemigroupLaws

import scalaprops.Scalaprops

object LastTest extends Scalaprops {

  import typeclass.data.Last._

  val semigroup = SemigroupLaws[Last[Int]].all

}
