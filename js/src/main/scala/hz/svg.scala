package hz

import scalatags.JsDom._,  implicits._


trait SVGPrimitives {

  /**
  Construct an SVG node for an ellipse rotated about the centre by a given angle.
  */
  def ellipse(
    xRadius  : Double,
    yRadius  : Double,
    rotation : Degree,
    cssStyle : String = "stroke : white; fill : none"
  ) = {
    import svgAttrs.{style,cx,cy,rx,ry,transform}, svgTags.{ellipse => svgEllipse}
    svgEllipse(
      transform := s"rotate(${rotation.value} 0 0)",
      cx := 0,
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

  Thank you: http://stackoverflow.com/questions/8193675/draw-a-hollow-circle-in-svg#8193760
  */
  def annulus(
    inner    : Double,
    outer    : Double,
    cssStyle : String = "fill : green"
  ) = {
    import svgAttrs.{style,d}, svgTags.{g, path}
    g(
      style := cssStyle,
      path(
        d := s"M 0 0 m 0 ${-1 * outer} a $outer $outer 0 1 0 1 0 Z m 0 ${outer - inner} a $inner $inner 0 1 1 -1 0 Z"
    )
    )
  }
}
