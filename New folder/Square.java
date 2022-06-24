public class Square {

  private double squareSide;
  
  public Square (double side) {
    squareSide = side;
  }
  
  public void setSquareSide (double sqSide) {
    squareSide = sqSide;
  }
  
  public double getSquareSide () {
    return squareSide;
  }
  
  public static double squareArea (double squareSide) {
    double areaOfSquare = squareSide * squareSide;
    return areaOfSquare;
  }
  
  public static double squarePerimeter (double squareSide) {
    double perimeterOfSquare = squareSide * 4;
    return perimeterOfSquare;
  }
}