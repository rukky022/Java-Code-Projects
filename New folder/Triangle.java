public class Triangle {
  
  private double triBase;
  private double triHeight;
  
  public Triangle (double tb, double th) {
    triBase = tb;
    triHeight = th;
  }
  
  public void setTriBase(double triB) {
    triBase = triB; 
  }
  
  public void setTriHeight(double triHei) {
    triHeight = triHei;
  }
  
  public double getTriBase () {
    return triBase;
  }
  
  public double getTriHeight () {
    return triHeight;
  }
  
  public static double triangleArea(double triHeight, double triBase) {
    double areaOfTriangle = 0.5 * triBase * triHeight;
    return areaOfTriangle;
  }
  
  public static double trianglePerimeter(double x, double y, double z) {
    double perimeterOfTriangle = x + y + z;
    return perimeterOfTriangle;
  }
}