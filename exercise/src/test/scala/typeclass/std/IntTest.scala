package typeclass.std

import typeclass.SemigroupLaws

import scalaprops.Scalaprops

object IntTest extends Scalaprops {

  import typeclass.std.int._

  val semigroup = SemigroupLaws[Int].all

}
