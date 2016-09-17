package hz

import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom
import org.scalajs.dom.html

@JSExport
object App extends SVGPrimitives {

  @JSExport
  def main(svgElement: dom.raw.SVGElement): Unit = {

  val hz = annulus(30, 80)
  svgElement.appendChild(hz.render)

  val earthOrbit = ellipse(40,45)
  svgElement.appendChild(earthOrbit.render)

  }
}
