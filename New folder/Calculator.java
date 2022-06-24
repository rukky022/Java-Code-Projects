//Ruqayyah Muse, Sept. 28, 2020

import java.util.Scanner;

public class Calculator {
  
  public static String separateStringX (String str) {
    int comma = str.indexOf(",");
    String x = str.substring(0, comma);
    return x;
  }
  
  public static String separateStringY (String str) {
    int comma = str.indexOf(",");
    int textLength = str.length();
    String y = str.substring(comma+1, textLength);
    return y;
  }
  
  public static boolean isNumber(String x) {
    //if it's empty, it returns false
    if (x == null || x.equals("")) {
      return false;
    }
    
    //for every character in the String, test to see if it's between 0 and 9 or if it's a . If not, then return false
    for (int i = 0; i < x.length(); i++) {
      Character num = new Character(x.charAt(i));
      if (!(num >= '0' && num <= '9' || num.equals('.'))) {
        return false;
      }
    }
    //if nothing above returns false, return true
    return true;
  }
  
  public static void main(String[] args) { 
  
    //Welcome
    Scanner welcome = new Scanner(System.in);
    System.out.print("Hello, and welcome to the All Purpose Calculator. Would you like to do some equations today? Please enter Y for yes or N for no: ");
    String ans = welcome.nextLine().toLowerCase();
    
    //while their answer isn't a Y or an N
    while(!ans.equals("y") && !ans.equals("n")) {
      System.out.print("Please enter either Y for yes, or N for no: ");
      ans = welcome.nextLine().toLowerCase();
    }
    
    //while their answer is yes
    while (ans.equals("y")){
      //Asks what the user wants to do and stores that in variable
      System.out.println("What kind of shape are you working with today?");
      System.out.print("Please enter C for Circle, R for Rectangle, S for Square, or T for Triangle: ");
      Scanner firstQuestion = new Scanner(System.in);
      String firstQuestionReply = firstQuestion.nextLine().toLowerCase();
      
      //IF REPLY IS NOT C, R, S, or T
      if (!firstQuestionReply.equals("c") && !firstQuestionReply.equals("r") && !firstQuestionReply.equals("s") && !firstQuestionReply.equals("t")) {
        System.out.println("That is not a valid response. Please enter C for Circle, R for Rectangle, S for Square, or T for Triangle: ");
        firstQuestionReply = firstQuestion.nextLine().toLowerCase();
      }
      
      //FIRST IF DESIGNED FOR CIRCLE OPERATIONS
      if (firstQuestionReply.equals("c")) {
        
        //Ask for the radius of the circle
        System.out.print("What is the radius of your circle? Please enter an integer or a decimal number: ");
        Scanner radi = new Scanner(System.in);
        String radiusText = radi.nextLine();
        
        //Test to see if this is a number, by using the isNumber method
        while (isNumber(radiusText) == false) {
          //if it's false, then say:
          System.out.print("Please enter an integer such as 1, or a decimal number such as 1.5: ");
          radiusText = radi.nextLine();
        }
        
        //if it is a number, then turn it into a double
        double radius = Double.parseDouble(radiusText);
        
        //Ask what kind of operation the user would like to perform
        System.out.print("What kind of operation would you like to perform with your circle? Enter A for area, or C for circumference: ");
        Scanner areaOrCircumference = new Scanner(System.in);
        String aOrC = areaOrCircumference.nextLine().toLowerCase();
        
        //while the answer is neither A nor C
        while (!aOrC.equals("a") && !aOrC.equals("c")) {
          System.out.print("Please enter either A for area, or C for circumference: ");
          aOrC =  areaOrCircumference.nextLine().toLowerCase();
        }
        
        //if the answer is A
        if (aOrC.equals("a")) {
          System.out.println("The area of a circle with a radius of " + radius + " is " + Circle.circleArea(radius));
        }
        
        //else if the answer is C
        else if (aOrC.equals("c")) {
          System.out.println("The circumference of a circle with a radius of " + radius + " is " + Circle.circlePerimeter(radius));
        }
        
      }
      
      //SECOND IF DESIGNED FOR RECTANGLE OPERATIONS
      else if (firstQuestionReply.equals("r")) {
        
        //Asks for the first and second length of the rectangle
        System.out.print("Please enter the length of the long side then the length of the short side separated by a comma. For example: 6,3  ");
        Scanner rectSideLength = new Scanner(System.in);
        String rSideLengths = rectSideLength.nextLine();
        
        //separate the two numbers into two String variables using the methods separateStringX & separateStringY
        String longSideText = separateStringX(rSideLengths);
        String shortSideText = separateStringY(rSideLengths);
        String testingIsNum = longSideText + shortSideText;
        
        //while isNumber is false, keep testing
        while(isNumber(testingIsNum) == false) {
          System.out.print("Please enter integers such as 1, or a decimal numbers such as 1.5 in the format: 6,3  ");
          rSideLengths = rectSideLength.nextLine();
          longSideText = separateStringX(rSideLengths);
          shortSideText = separateStringY(rSideLengths);
          testingIsNum = longSideText + shortSideText;
        }
        
        //Change the separated String numbers to doubles
        double longSide = Double.parseDouble(longSideText);
        double shortSide = Double.parseDouble(shortSideText);
        
        //Ask what kind of operation they would like to perform
        System.out.print("What kind of operation would you like to perform? Enter A for area, or P for perimeter: ");
        Scanner areaOrPerimeterR = new Scanner(System.in);
        String aOrPR = areaOrPerimeterR.nextLine().toLowerCase();
        
        //if aOrPR is anything other than a or p
        while (!aOrPR.equals("a") && !aOrPR.equals("p")) {
          System.out.print("Please enter either A for area, or P for perimeter: ");
          aOrPR =  areaOrPerimeterR.nextLine().toLowerCase();
        }
        
        //if aOrPR equals a
        if (aOrPR.equals("a")) {
          System.out.println("The area of a rectangle with side lengths of " + longSide + " & " + shortSide + " is " + Rectangle.rectangleArea(longSide, shortSide));
        }
        
        //else if aOrPR equals p
        else if (aOrPR.equals("p")) {
          System.out.println("The perimeter of a rectangle with side lengths of " + longSide + " & " + shortSide + " is " + Rectangle.rectanglePerimeter(longSide, shortSide));
        }
        
      }
      
      //THIRD IF DESIGNED FOR SQUARE OPERATIONS
      else if (firstQuestionReply.equals("s")) {
        
        //Asks for the side length of the square
        System.out.print("What is the side length of the square? Please enter an integer or a decimal number: ");
        Scanner squareSideLength = new Scanner(System.in);
        String sqrSideLengthText = squareSideLength.nextLine();
        
        //Test if it is a number
        while (isNumber(sqrSideLengthText) == false) {
          System.out.print("Please enter an integer such as 1, or a decimal number such as 1.5: ");
          sqrSideLengthText = squareSideLength.nextLine();
        }
        
        //Turn it into a double
        double sqSideLength = Double.parseDouble(sqrSideLengthText);
        
        //Ask what operation should be performed
        System.out.print("What kind of operation would you like to perform? Please enter A for area or P for perimeter: ");
        Scanner areaOrPerimeterS = new Scanner(System.in);
        String aOrPS = areaOrPerimeterS.nextLine().toLowerCase();
        
        //while aOrPS is not equal to A or P
        while (!aOrPS.equals("a") && !aOrPS.equals("p")) {
          System.out.print("Please enter either A for area, or P for perimeter: ");
          aOrPS = areaOrPerimeterS.nextLine().toLowerCase();
        }
        
        //if aOrPS is equal to A
        if (aOrPS.equals("a")) {
          System.out.println("The area of a square with a side length of " + sqSideLength + " is " + Square.squareArea(sqSideLength));
        }
        
        //else if aOrPS is equal to P
        else if (aOrPS.equals("p")) {
          System.out.println("The perimeter of a square with a side length of " + sqSideLength + " is " + Square.squarePerimeter(sqSideLength));
        }
        
      }
      
      //FOURTH IF DESIGNED FOR TRIANGLE OPERATIONS
      else if (firstQuestionReply.equals("t")) {
        
        //Asks what kind of operation to perform
        System.out.print("What kind of operation would you like to perform? Please enter A for area of P for perimeter: ");
        Scanner areaOrPerimeterT = new Scanner(System.in);
        String aOrPT = areaOrPerimeterT.nextLine().toLowerCase();
        
        //while it isn't A or P
        while(!aOrPT.equals("a") && !aOrPT.equals("p")) {
          System.out.print("Please enter either A for area, or P for perimeter: ");
          aOrPT = areaOrPerimeterT.nextLine().toLowerCase();
        }
        
        //if aOrPT is A
        if(aOrPT.equals("a")){
          System.out.print("Please enter the height and base of the triangle separated by a comma, such as 6,3 : ");
          Scanner baseHeightT = new Scanner(System.in);
          String baseHeightTText = baseHeightT.nextLine();
          
          //separate the two numbers into two String variables using the method
          String tHeightText = separateStringX(baseHeightTText);
          String tBaseText = separateStringY(baseHeightTText);
          String testingIsNumTA = tHeightText + tBaseText;
          
          //while isNumber is false, keep testing
          while(isNumber(testingIsNumTA) == false) {
            System.out.print("Please enter integers such as 1, or decimal numbers such as 1.5 in the format 6,3 : ");
            baseHeightTText = baseHeightT.nextLine();
            tHeightText = separateStringX(baseHeightTText);
            tBaseText = separateStringY(baseHeightTText);
            testingIsNumTA = tHeightText + tBaseText;
          }
          
          //Change the variables to doubles
          double tHeight = Double.parseDouble(tHeightText);
          double tBase = Double.parseDouble(tBaseText);
          
          System.out.println("The area of a triangle with a height of " + tHeight + " and a base of " + tBase + " is " + Triangle.triangleArea(tHeight, tBase)); 
        }
        
        //else if aOrPT is P
        if(aOrPT.equals("p")) {
          System.out.print("Please enter the side lengths of the triangle in the format 6,4,2 : ");
          Scanner sidesT = new Scanner(System.in);
          String sidesTtext = sidesT.nextLine();
          
          //separate the three numbers
          String xText = separateStringX(sidesTtext);
          String z1 = separateStringY(sidesTtext);
          String yText = separateStringX(separateStringY(sidesTtext));
          String zText = separateStringY(z1);
          String testingIsNumTP = xText + yText + zText;
          
          //while isNumber is false, keep testing
          while(isNumber(testingIsNumTP) == false) {
            System.out.print("Please enter integers such as 1, or a decimal numbers such as 1.5 in the format 6,4,2 : ");
            sidesTtext = sidesT.nextLine();
            xText = separateStringX(sidesTtext);
            z1 = separateStringY(sidesTtext);
            yText = separateStringX(separateStringY(sidesTtext));
            zText = separateStringY(z1);
            testingIsNumTP = xText + yText + zText;
          }
          
          //Change the variables to doubles
          double x = Double.parseDouble(xText);
          double y = Double.parseDouble(yText);
          double z = Double.parseDouble(zText);
          
          System.out.println("The perimeter of a triangle with side lengths of " + x + ", " + y + ", " + z + " is " + Triangle.trianglePerimeter(x, y, z));
        }
        
      }
      
      //Asks if they'd like to perform another operation
      System.out.print("\n\nWould you like to do another equation? Please enter Y for yes or N for no: ");
      Scanner repeatOrNot = new Scanner(System.in);
      String toRepeat = repeatOrNot.nextLine().toLowerCase();
      //if not, then break out of the large while loop
      if (toRepeat.equals("n"))
        break;
    }
    
    System.out.println("See you next time then!");
  }
  
}