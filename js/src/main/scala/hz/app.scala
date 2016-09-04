package hz

import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom
import org.scalajs.dom.svg
import org.scalajs.dom.html

@JSExport
object App {


  /*
  Construct an SVG node representing an annulus (or doughnut), where
  the inner radius is the hole, and the outer radius defines the dough.

  Thank you:
  - http://stackoverflow.com/questions/8193675/draw-a-hollow-circle-in-svg#8193760
  - http://my.safaribooksonline.com/book/web-development/xml/9781491945308/1dot-getting-started/graphics_systems_section_html#X2ludGVybmFsX0h0bWxWaWV3P3htbGlkPTk3ODE0OTE5NDUzMDglMkZjb252ZXJ0X2FyY190b19zdmdfc2VjdGlvbl9odG1sJnF1ZXJ5PQ==
  */
  def annulus(inner: Float, outer: Float, x: Float = 100f, y: Float = 100f) = {
    import scalatags.JsDom._, svgTags._, svgAttrs.{style,d}, implicits._
    g(
      style := "fill: green",
      path(
        d := s"M $x $y m 0 ${-1 * outer} a $outer $outer 0 1 0 1 0 Z m 0 ${outer - inner} a $inner $inner 0 1 1 -1 0 Z"
    )
    )
  }

  @JSExport
  def main(svgElement: dom.raw.SVGElement): Unit = {

  val hz = annulus(30, 80)
  svgElement.appendChild(hz.render)

  }
}
