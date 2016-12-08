package com.dankook.bsi.util.IDF;

import com.dankook.bsi.util.geometry.EDIVector3;
import java.util.Vector;

public class FenestrationSurface
{
  public String name;
  public String surfaceType;
  public String constructionName;
  public String buildingSurfaceName;
  public Double viewFactorToGround;
  public Double multiplier;
  public Integer numberOfVerrices;
  public Vector<EDIVector3> vertexCoordinate;
}

/* Location:           C:\Users\LG\workspace\Django-server\EDI.jar
 * Qualified Name:     bsi.dankook.IDF.FenestrationSurface
 * JD-Core Version:    0.6.0
 */