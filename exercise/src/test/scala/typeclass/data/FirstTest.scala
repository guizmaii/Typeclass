package typeclass.data

import typeclass.SemigroupLaws

import scalaprops.Scalaprops

object FirstTest extends Scalaprops {

  import typeclass.data.First._

  val semigroup = SemigroupLaws[First[Int]].all

}
