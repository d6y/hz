package hz

import cats.data.NonEmptyList

object SpectralType {
  // Source: "A note on the spectral atlas and spectral classification"
  // https://www.cfa.harvard.edu/~pberlind/atlas/htmls/note.html accessed 11 Sep 2016

  object luminosity {
    sealed trait Luminosity
    case object `0` extends Luminosity
    case object Ia  extends Luminosity
    case object Ib  extends Luminosity
    case object II  extends Luminosity
    case object III extends Luminosity
    case object IV  extends Luminosity
    case object V   extends Luminosity
    case object sd  extends Luminosity
    case object D   extends Luminosity
  }

  object temperature {
    sealed trait Temperature
    case object `0` extends Temperature // Hotter
    case object `1` extends Temperature
    case object `2` extends Temperature
    case object `3` extends Temperature
    case object `4` extends Temperature
    case object `5` extends Temperature
    case object `6` extends Temperature
    case object `7` extends Temperature
    case object `8` extends Temperature
    case object `9` extends Temperature // Cooler
  }

  sealed trait MK
  case class O(t: temperature.Temperature, l: luminosity.Luminosity) extends MK
  case class B(t: temperature.Temperature, l: luminosity.Luminosity) extends MK
  case class A(t: temperature.Temperature, l: luminosity.Luminosity) extends MK
  case class F(t: temperature.Temperature, l: luminosity.Luminosity) extends MK
  case class G(t: temperature.Temperature, l: luminosity.Luminosity) extends MK
  case class K(t: temperature.Temperature, l: luminosity.Luminosity) extends MK
  case class M(t: temperature.Temperature, l: luminosity.Luminosity) extends MK
  case class C(t: temperature.Temperature, l: luminosity.Luminosity) extends MK
}


final case class Name[T](value: String)

object Name {
  def of[T](name: String): NonEmptyList[Name[T]] = NonEmptyList.of(Name[T](name))
}

final case class System(
  star    : Star,
  planets : List[Planet]
)

final case class Star(
  name         : NonEmptyList[Name[Star]],
  mass         : SolarMass,
  radius       : SolarRadius
  //spectralType : SpectralType.MK
)

final case class Planet(
  name          : NonEmptyList[Name[Planet]],
  semiMajorAxis : AU,
  e             : Eccentricity
) {

  import UnitOps._
  // From Table 2.1, p. 59 of Fleisch & Kregenow (2012) _A students guide to the Mathematics of Astronomy_.
  lazy val semiMinorAxis: AU = semiMajorAxis * Math.sqrt( 1d - (e * e) )
}

