package hz

import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom
import org.scalajs.dom.html

@JSExport
object ScalaJSExample {
  @JSExport
  def main(canvas: html.Canvas): Unit = {
 
    val ctx = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]

    // Use the full browser window for the canvas
    // Thank you: http://stackoverflow.com/a/3078427/154248
    ctx.canvas.width = dom.window.innerWidth
    ctx.canvas.height = dom.window.innerHeight

    val width = canvas.width.toFloat
    val height = canvas.height.toFloat

    val x = width / 2.0
    val y = height / 2.0

    val innerRadius = width / 8.0
    val outerRadius = width / 4.0 

    ctx.beginPath()
    ctx.fillStyle = "green"
    ctx.arc(x, y, outerRadius, 0, 2 * Math.PI)
    ctx.fill()

    ctx.beginPath()
    ctx.fillStyle = "black"
    ctx.arc(x, y, innerRadius, 0, 2 * Math.PI)

    ctx.fill()

  }
}
