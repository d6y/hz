package hz

import scalatags.JsDom._,  implicits._

trait SVGPrimitives {

  /**
  Construct an SVG nodel for a circle, centered at (x,y) with co-ordinates rotated around (0,0) by the given angle.
  **/
  def circle(
    x        : Double,
    y        : Double,
    radius   : Double,
    rotation : Degree,
    cssStyle : String = "fill: white"
  ) = {
    import svgAttrs.{style,cx,cy,r,transform}, svgTags.{circle => svgCircle}
    svgCircle(
      transform := s"rotate(${rotation.value} 0 0)",
      style := cssStyle,
      cx := x,
      cy := y,
      r := radius)
    }

  /**
  Construct an SVG node for an ellipse rotated about the centre by a given angle.
  */
  def ellipse(
    xRadius  : Double,
    yRadius  : Double,
    x        : Double,
    rotation : Degree,
    cssStyle : String = "stroke: white; stroke-width: 0.1; fill: none"
  ) = {
    import svgAttrs.{style,cx,cy,rx,ry,transform}, svgTags.{ellipse => svgEllipse}
    svgEllipse(
      transform := s"rotate(${rotation.value} 0 0)",
      cx := x,
      cy := 0,
      rx := xRadius,
      ry := yRadius,
      style := cssStyle
    )
  }

  /**
  Construct an SVG node representing an annulus (or ring),
  where
    the inner radius is the hole,
    and the outer radius is to the edge of the ring.

{{{
    Inner Radius      Outer Radius

     ,ad8888ba,        ,ad8888ba,
    d8"'    `"8b      d8"'    `"8b
   d8'        `8b    d8'        `8b
   88<----     88    <------     88
   88          88    88          88
   Y8,        ,8P    Y8,        ,8P
    Y8a.    .a8P      Y8a.    .a8P
     `"Y8888Y"'        `"Y8888Y"'
  }}}

  */
  def annulus(
    inner    : Double,
    outer    : Double,
    cssStyle : String = "fill: green; fill-opacity: 0.8"
  ) = {
    import svgAttrs.{style,d,cx,cy,r}, svgTags.{g, circle => svgCircle}
    g(
      style := cssStyle,
      svgCircle(cx := 0, cy := 0, r := outer),
      svgCircle(cx := 0, cy := 0, r := inner, style := "fill: black")
    )
  }
}
