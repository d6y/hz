package hz

import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom
import org.scalajs.dom.html

@JSExport
object App extends SVGPrimitives {

  @JSExport
  def main(svgElement: dom.raw.SVGElement): Unit = {

  // Scaling of astronomical units into user co-ordinates
  // Our view is from -100 to plus 100, with (0,0) the centre (and barycenter).
  // Zero degrees is at 3 o'clock.

  // We scale the system into these units when drawing
  val viewRadius: Double = 100
  val systemRadius = AU(2)
  val auScaleFactor = viewRadius / systemRadius.value
  implicit class scaleDistance(au: AU) {
    def scaled: Double = au.value * auScaleFactor
  }

  // Astronimical bodies are tiny compared to the size of the system, so we exaggerate when drawing
  implicit class enlargeStarSize(r: SolarRadius) {
    def exaggerate: SolarRadius = r * 10
  }

  val hz = annulus( AU(0.95).scaled, AU(1.66).scaled )
  svgElement.appendChild(hz.render)

  val star = circle(
    0, 0, SolarRadius(1).exaggerate.asAU.scaled,
    Degree(0),
    cssStyle="fill: yellow"
  )
  svgElement.appendChild(star.render)

  def draw(p: Planet): Unit = {
    val orbit = ellipse(
      p.semiMajorAxis.scaled,
      p.semiMinorAxis.scaled,
      p.f.scaled,
      p.periastron
    )
    svgElement.appendChild(orbit.render)

    // Position the planet on the orbit at the sample longitude
    val radians = p.longitude.value * 0.0174
    val x = p.semiMajorAxis * Math.cos(radians)
    val y = p.semiMinorAxis * Math.sin(radians)
    
    val body = circle(x.scaled + p.f.scaled, y.scaled, 1, p.periastron)
    svgElement.appendChild(body.render)
  }

  Systems.sun.planets.foreach(draw)

  }
}
