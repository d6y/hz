package hz

import cats.data.NonEmptyList

object Systems {

  // Values from https://github.com/OpenExoplanetCatalogue/open_exoplanet_catalogue/blob/master/systems/Sun.xml
  // as of commit 6735e0522e9c5152260d8a3b492d04ebd19c7ef0 (11 Aug 2016)

 val mercury = Planet(
    name = Name.of("Mercury"),
    semiMajorAxis = AU(0.38709843),
    e = Eccentricity(0.20563661)
  )

 val venus = Planet(
    name = Name.of("Venus"),
    semiMajorAxis = AU(0.72332102),
    e = Eccentricity(0.00676399)
  )

 val earth = Planet(
    name = Name.of("Earth"),
    semiMajorAxis = AU(1.00000018),
    e = Eccentricity(0.01673163)
  )

 val mars = Planet(
    name = Name.of("Mars"),
    semiMajorAxis = AU(1.52371243),
    e = Eccentricity(0.09336511)
  )

 val jupiter = Planet(
    name = Name.of("Jupiter"),
    semiMajorAxis = AU(5.20248019),
    e = Eccentricity(0.04853590)
  )

 val saturn = Planet(
    name = Name.of("Saturn"),
    semiMajorAxis = AU(9.54149883),
    e = Eccentricity(0.05550825)
  )

 val uranus = Planet(
    name = Name.of("Uranus"),
    semiMajorAxis = AU(19.18797948),
    e = Eccentricity(0.04685740)
  )

 val neptune = Planet(
    name = Name.of("Neptune"),
    semiMajorAxis = AU(30.06952752),
    e = Eccentricity(0.00895439)
  )

 val pluto = Planet(
    name = Name.of("Pluto"),
    semiMajorAxis = AU(39.48686035),
    e = Eccentricity(0.24885238)
  )

  val sun = 
    System(
      star = Star(
        name   = Name.of("Sun"),
        mass   = SolarMass(1d),
        radius = SolarRadius(1d)
      ),
      planets = List(
        mercury, 
        venus,
        earth,
        mars,
        jupiter,
        saturn,
        uranus,
        neptune
      )
    )

}
