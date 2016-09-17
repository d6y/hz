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

  // Astronimical bodies are tiny compared to the size of the system,
  // so we enlarge when drawing
  implicit class enlargeStarSize(r: SolarRadius) {
    def enlarged: SolarRadius = r * 10
  }

  val hz = annulus( AU(0.99).scaled, AU(1.688).scaled )
  svgElement.appendChild(hz.render)

  val star = ellipse( SolarRadius(1).enlarged.asAU.scaled, SolarRadius(1).enlarged.asAU.scaled, Degree(0), cssStyle="fill: yellow")
  svgElement.appendChild(star.render)

  val marsOrbit = ellipse( AU(1.523).scaled, AU(1.516).scaled, Degree(-24) )
  svgElement.appendChild(marsOrbit.render)

  }
}
