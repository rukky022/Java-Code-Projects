public class Rectangle {

  private double rectSideLong;
  private double rectSideShort;
  
  public Rectangle (double sideL, double sideS) {
    rectSideLong = sideL;
    rectSideShort = sideS;
  }
  
  public void setRectSideLong (double rcSideL) {
    rectSideLong = rcSideL;
  }
  
  public void setRectSideShort (double rcSideS) {
    rectSideShort = rcSideS;
  }
  
  public double getRectSideLong () {
    return rectSideLong;
  }
  
  public double getRectSideShort () {
    return rectSideShort;
  }
  
  public static double rectangleArea (double rectSideLong, double rectSideShort) {
    double areaOfRectangle = rectSideLong * rectSideShort;
    return areaOfRectangle;
  }
  
  public static double rectanglePerimeter (double rectSideLong, double rectSideShort) {
    double perimeterOfRectangle = (rectSideLong * 2) + (rectSideShort * 2);
    return perimeterOfRectangle;
  }
}