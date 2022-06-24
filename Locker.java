//Ruqayyah Muse

import java.util.Scanner;
import java.util.ArrayList;

public class Locker {

  //instance variables
  private int number;
  private String status;
  private String studentName;
  
  //constructor
  public Locker (int n, String s, String sN) {
    number = n;
    status = s;
    studentName = sN;
  }
  
  //accessor methods
  public int getNumber () {
    return number;
  }
  
  public String getStatus () {
    return status;
  }
  
  public String getStudentName () {
    return studentName;
  }
  
  //mutator methods
  public void setNumber (int x) {
    number = x;
  }
  
  public void setStatus (String s) {
    status = s;
  }
  
  public void setStudentName (String sN) {
    studentName = sN;
  }
  
  //method to solve locker puzzle
  public static String lockerPuzzle (int numOfLockers) {
  
    //creates necessary variables
    ArrayList<Locker> schoolLockers = new ArrayList<Locker>();
    int x = 0;
    int changeEveryNum = 0;
    
    //first loop to create the number of lockers and make their status closed
    for (int i = 0; i < numOfLockers; i++) {
      int num = i+1;
      Locker lock = new Locker(num, "closed", "S"+num);
      schoolLockers.add(i, lock);
    }
    
    //second loop to change status based on student passing through
    for (int i = 0; i < numOfLockers; i++) {
      x = i;
      changeEveryNum = i+1;
      
      //while loop for each student to go through and change the status
      while (x < numOfLockers) {
        if(schoolLockers.get(x).getStatus().equals("closed")) {
          schoolLockers.get(x).setStatus("open");
          x+=changeEveryNum;
        }
        else if (schoolLockers.get(x).getStatus().equals("open")) {
          schoolLockers.get(x).setStatus("closed");
          x+=changeEveryNum;
        }
      }
    }
    
    
    //creating new array
    ArrayList<Locker> arr = new ArrayList<Locker>();
    
    //for-each loop to go through original arrayList
    //and add all lockers that are open to new arrayList arr
    for (Locker l: schoolLockers) {
      if(l.getStatus().equals("open")) {
        arr.add(l);
      }
    }
    
    //return statement
    return arr.toString();
  }

  //toString method
  public String toString() {
    return "\nLocker " + number + " is " + status + " and was last changed by Student " + studentName;
  }
  
  //main method
  public static void main (String[] args) {
    
    //scanner to take number of lockers
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter the number of lockers: ");
    int x = input.nextInt();
    
    //method run
    System.out.println("These are the lockers that are open: " + lockerPuzzle(x));
  }
}