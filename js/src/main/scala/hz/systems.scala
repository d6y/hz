package hz

import cats.data.NonEmptyList

object Systems {

  // Values from https://github.com/OpenExoplanetCatalogue/open_exoplanet_catalogue/blob/master/systems/Sun.xml
  // as of commit 6735e0522e9c5152260d8a3b492d04ebd19c7ef0 (11 Aug 2016)

 val mercury = Planet(
    name = Name.of("Mercury"),
    semiMajorAxis = AU(0.38709843),
    e = Eccentricity(0.20563661),
    periastron = Degree(77.45771895),
    longitude = Degree(252.25166724)
  )

 val venus = Planet(
    name = Name.of("Venus"),
    semiMajorAxis = AU(0.72332102),
    e = Eccentricity(0.00676399),
    periastron = Degree(131.76755713),
    longitude = Degree(181.97970850)
  )

 val earth = Planet(
    name = Name.of("Earth"),
    semiMajorAxis = AU(1.00000018),
    e = Eccentricity(0.01673163),
    periastron = Degree(102.93005885),
    longitude = Degree(100.46691572)
  )

 val mars = Planet(
    name = Name.of("Mars"),
    semiMajorAxis = AU(1.52371243),
    e = Eccentricity(0.09336511),
    periastron = Degree(-23.91744784),
    longitude = Degree(-4.56813164)
  )

 val jupiter = Planet(
    name = Name.of("Jupiter"),
    semiMajorAxis = AU(5.20248019),
    e = Eccentricity(0.04853590),
    periastron = Degree(14.27495244),
    longitude = Degree(34.33479152)
  )

 val saturn = Planet(
    name = Name.of("Saturn"),
    semiMajorAxis = AU(9.54149883),
    e = Eccentricity(0.05550825),
    periastron = Degree(92.86136063),
    longitude = Degree(50.07571329)
  )

 val uranus = Planet(
    name = Name.of("Uranus"),
    semiMajorAxis = AU(19.18797948),
    e = Eccentricity(0.04685740),
    periastron = Degree(172.43404441),
    longitude = Degree(314.20276625)
  )

 val neptune = Planet(
    name = Name.of("Neptune"),
    semiMajorAxis = AU(30.06952752),
    e = Eccentricity(0.00895439),
    periastron = Degree(46.68158724),
    longitude = Degree(304.22289287)
  )

 val pluto = Planet(
    name = Name.of("Pluto"),
    semiMajorAxis = AU(39.48686035),
    e = Eccentricity(0.24885238),
    periastron = Degree(224.09702598),
    longitude = Degree(238.96535011)
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
