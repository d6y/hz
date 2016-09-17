package hz

import scalatags.JsDom._,  implicits._


trait SVGPrimitives {

  def ellipse(
    xRadius  : Double,
    yRadius  : Double,
    x        : Double = 100d,
    y        : Double = 100d,
    cssStyle : String = "stroke : white; fill : none"
  ) = {
    import svgAttrs.{style,cx,cy,rx,ry}, svgTags.{ellipse => svgEllipse}
    svgEllipse(
      cx := x,
      cy := y,
      rx := xRadius,
      ry := yRadius,
      style := cssStyle
    )
  }

  /**
  Construct an SVG node representing an annulus (or ring), where
  the inner radius is the hole, and the outer radius is out to the edge of the ring.

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

  Thank you: http://stackoverflow.com/questions/8193675/draw-a-hollow-circle-in-svg#8193760
  */
  def annulus(
    inner    : Double,
    outer    : Double,
    x        : Double = 100d,
    y        : Double = 100d,
    cssStyle : String = "fill : green"
  ) = {
    import svgAttrs.{style,d}, svgTags.{g, path}
    g(
      style := cssStyle,
      path(
        d := s"M $x $y m 0 ${-1 * outer} a $outer $outer 0 1 0 1 0 Z m 0 ${outer - inner} a $inner $inner 0 1 1 -1 0 Z"
    )
    )
  }
}
