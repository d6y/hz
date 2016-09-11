package hz

sealed trait Distance {
}

sealed trait Mass {
}

final case class Kilogram(value: Double) extends AnyVal
final case class JupiterMass(value: Double) extends AnyVal
final case class SolarMass(value: Double) extends AnyVal

final case class Metre(value: Double) extends AnyVal
final case class JupiterRadius(value: Double) extends AnyVal
final case class SolarRadius(value: Double) extends AnyVal
final case class AU(value: Double) extends AnyVal

/*
https://github.com/hannorein/oec_outreach

Constant used in catalogue 	Definition in SI units
Jupiter mass 	1.8991766e+27 kg
Solarmass 	1.9891e+30 kg
Jupiter radius 	69911000 m
Solarradius 	6.96e+08 m
*/

final case class Eccentricity(value: Double)

