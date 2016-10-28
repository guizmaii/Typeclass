package typeclass.std

import typeclass.SemigroupLaws

import scalaprops.{Gen, Scalaprops}

object StringTest extends Scalaprops {

  import typeclass.std.string._

  implicit val genString: Gen[String] = Gen.asciiString

  val semigroup = SemigroupLaws[String].all

}
