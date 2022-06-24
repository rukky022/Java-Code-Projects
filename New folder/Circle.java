public class Circle {
  
  private double radius;
  
  public Circle () {
    radius = 0;
  }
  
  public void setRadius(double rad) {
    radius = rad;
  }
  
  public double getRadius () {
    return radius;
  }
  
  public static double circleArea(double radius) {
    double areaOfCircle = Math.PI * Math.pow(radius, 2);
    return areaOfCircle;
  }
  
  public static double circlePerimeter(double radius) {
    double perimeterOfCircle = 2 * Math.PI * radius;
    return perimeterOfCircle;
  }
}