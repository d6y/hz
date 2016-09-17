package hz

sealed trait Distance {
}

sealed trait Mass {
}

final case class Kilogram(value: Double) extends AnyVal
final case class JupiterMass(value: Double) extends AnyVal
final case class SolarMass(value: Double) extends AnyVal

final case class JupiterRadius(value: Double) extends AnyVal
final case class SolarRadius(value: Double) extends AnyVal {
  def asAU: AU = AU(value * 0.00465047) // https://en.wikipedia.org/wiki/Solar_radius (17 Sep 2016)
  def *(n: Double): SolarRadius = SolarRadius(value * n)
}

final case class AU(value: Double) extends AnyVal {
  def *(n: Double): AU = AU(value * n)
}


final case class Degree(value: Double) extends AnyVal

final case class Eccentricity(value: Double) {
  def *(n: Eccentricity): Eccentricity = Eccentricity(value * n.value)
}

object UnitOps {
  implicit class DoubleOps(n: Double) {
    def -(e: Eccentricity): Double = n - e.value
  }
}

