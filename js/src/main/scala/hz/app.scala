package hz

import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom
import org.scalajs.dom.html

@JSExport
object App extends SVGPrimitives {

  @JSExport
  def main(svgElement: dom.raw.SVGElement): Unit = {

  // Scaling of astronomical units into user co-ordinates
  // Our view is from -100 to plus 100, with (0,0) the center
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

  val star = ellipse( SolarRadius(1).exaggerate.asAU.scaled, SolarRadius(1).exaggerate.asAU.scaled, 0d, Degree(0), cssStyle="fill: yellow")
  svgElement.appendChild(star.render)

  val marsOrbit = ellipse(
    Systems.mars.semiMajorAxis.scaled,
    Systems.mars.semiMinorAxis.scaled,
    Systems.mars.f.scaled,
    Degree(-24) )
  svgElement.appendChild(marsOrbit.render)

  }
}
