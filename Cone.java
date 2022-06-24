/* Made by Ruqayyah M on September 16, 2020 */

import java.util.Scanner;

public class Cone {
  
  //fields, or instance variables
  private double radius;
  private double height;
  
  //constructor
  public Cone() {
    
  }
  
  //initializing constructor with paramenters of r and h
  public Cone(double r, double h) {
    radius = r;
    height = h;
  }
  
  //method for calculating the volume of the cone
  public double coneVolume() {
    double volumeOfCone = (3.14)*(Math.pow(radius, 2))*(height/3.0);
    return volumeOfCone;
  }
  
  //method for calculating the area of the cone
  public double coneArea() {
    double areaOfCone = (3.14)*(radius)*(radius + (Math.sqrt((Math.pow(height, 2)) + (Math.pow(radius, 2)))));
    return areaOfCone;
  }
  
  //method for determining if an input is a number
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
    return true;
  }
  
  //all the action here
  public static void main(String[] args) {
    
    //FIRST scanner to answer yes or no
    Scanner yesOrNo = new Scanner(System.in);
    System.out.print("Would you like to do some equations with cones? Please enter 'yes' or 'no': ");
    String answer = yesOrNo.nextLine().toLowerCase();  //makes all responses lowercase
    
    //if they answer with maybe, idk, or idek, it rebukes them lol and asks for them to pick yes or no
    if (answer.equals("maybe") || answer.equals("idk") || answer.equals("idek") || answer.equals("may be")) {
      System.out.print("You have to be decisive! Yes or No?");
      answer = yesOrNo.nextLine().toLowerCase();
    }
    else if (!answer.equals("yes") && !answer.equals("no")) {    //but if they say anything other than yes/no/maybe/idk/idek, it asks them to put yes or no
      System.out.print("Please enter yes or no.");
      answer = yesOrNo.nextLine().toLowerCase();
    }
    
    //So long as the answer is yes...
    while (answer.equals("yes")) {
      
      //create a scanner to decide whether to solve for volume or area
      Scanner initialInput = new Scanner(System.in);
      System.out.print("What operation would you like to perform with your cone? Please enter V for volume, or A for area: ");
      String response = initialInput.nextLine();
      response = response.toLowerCase();
      
      //So long as thier responses are not a or v (we switched their answer to lower), keep asking for them to enter v or a
      while (!response.equals("a") && !response.equals("v")) {
        System.out.print("Please enter either V for volume or A for area.");
        response = initialInput.nextLine().toLowerCase(); 
      }
      
      //create a scanner to determine the radius
      Scanner inputRadius = new Scanner(System.in);
      System.out.print("Please enter the radius of the cone in integer form, such as 1, or as a decimal rounded to the nearest tenth, such as 3.5: ");
      
      //make it a String so that the isNumber method can determine if it's a num or text
      String rad = inputRadius.nextLine();
      
      //So long as the boolen returns false, it will ask for a number
      while (isNumber(rad) == false) {
        System.out.print("Please enter a number in integer form, such as 1, or as a decimal rounded to the nearest tenth, such as 3.5.");
        rad = inputRadius.nextLine();
      }
      
      //If boolean is true, turn the text into a number to be used later
      double radi = Double.parseDouble(rad); 
      
      //create a scanner to determine the height
      Scanner inputHeight = new Scanner(System.in);
      System.out.print("Please enter the height of the cone in integer form, such as 1, or as a decimal rounded to the nearest tenth, such as 3.5: ");
      
      //make it a String so that the isNumber method can determine if it's a num or text
      String hei = inputRadius.nextLine();

      //So long as the boolen returns false, it will ask for a number
      while (isNumber(hei) == false) {
        System.out.print("Please enter a number in integer form, such as 1, or as a decimal rounded to the nearest tenth, such as 3.5.");
        hei = inputHeight.nextLine();
      }

      //If boolean is true, turn the text into a number to be used later
      double height = Double.parseDouble(hei); 
      
      //Now, thinking back to where we asked for volume or area, if they chose Volume, then...
      if (response.equals("v")) {
        //share a disclaimer that 3.14 is being used for pi
        System.out.println("Disclaimer: 3.14 will be used in place of pi. This is not always the most accurate answer.");
        //create a new Cone object that uses the numbers that were inputted
        Cone coneNum1 = new Cone(radi, height);
        //print the volume of the cone
        System.out.println("\nThe volume of the cone is: " + coneNum1.coneVolume());  
      }
      //else, if the response was Area, then...
      else if (response.equals("a")) {
        //print the disclaimer about 3.14 being used for pi
        System.out.println("Disclaimer: 3.14 will be used in place of pi. This is not always the most accurate answer.");
        //create a new Cone object that uses the numbers that were inputted
        Cone coneNum2 = new Cone(radi, height);
        //print the area of the cone
        System.out.println("\nThe area of the cone is: " + coneNum2.coneArea());
      }
      
      //After that, ask if they'd like to perform another operation
      System.out.print("\n\nWould you like to do another problem with your cone? Please enter 'yes' or 'no': ");
      //take their answer with a scanner, and place it in a String that has been lower cased
      Scanner repeatOrNot = new Scanner(System.in);
      String toRepeat = repeatOrNot.nextLine().toLowerCase();
      //if they said they don't want to perform another operation, then break out of the large while loop to...
      if (toRepeat.equals("no"))
        break;
    }
    
    //...let them know you'd like to see them next time!
    System.out.println("See you next time then!");
  }
}