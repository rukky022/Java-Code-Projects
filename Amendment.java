//Ruqayyah Muse, Data Lab

import core.data.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Amendment {
  
  //instance variables
  private String name;
  private int year;
  private String state;
  private String sponsor;
  
  //constructor
  public Amendment(String name, int year, String state, String sponsor) {
    this.name = name;
    this.year = year;
    this.state = state;
    this.sponsor = sponsor;
  }
  
  //returns name
  public String getName() {
    return name;
  }
  
  //returns year
  public int getYear() {
    return year;
  }
  
  //returns state
  public String getState() {
    return state;
  }
  
  //returns sponsor
  public String getSponsor() {
    return sponsor;
  }
  
  //returns number of amendments that have the required state name
  public static int findNumByState(ArrayList<Amendment> array, String state) {
    int counter = 0;
    for (Amendment amendment: array) {
      if (amendment.getState().equals(state)) {
        counter++;
      }
    }
    if (counter == 0) {
      return 0;
    }
    return counter;
  }
  
  //returns most recent amendment proposal from a certain state and the year of its proposal
  public static String mostRecentProposal(ArrayList<Amendment> array, String state) {
    ArrayList<Amendment> sample = new ArrayList<Amendment>();
    for (Amendment amendment: array) {
      if (amendment.getState().equals(state)) {
        sample.add(amendment);
      }
    }
    
    if (sample.size() == 0) {
      return "There is no data for the entered state.";
    }
    String title = sample.get(sample.size()-1).getName();
    if (title.charAt(title.length()-1) == '.') {
      title = title.substring(0, title.length()-1);
    }
    
    String info = "\"" + title + "\" in " + sample.get(sample.size()-1).getYear();
    return "The last proposed amendment was " + info + ".";
  }
  
  //returns a string of the Amendment object
  public String toString() {
    return name + "; " + year + "; " + state + "; " + sponsor;
  }
  
  public static void main (String[] args) {
    DataSource amend = DataSource.connectAs("csv", "http://www.archives.gov/open/amending-america/us-nara-amending-america-dataset-raw-2016-02-25.csv").load();
    
    ArrayList<Amendment> allAmend= amend.fetchList("Amendment", "title_or_description_from_source", "year", "sponsor_state_or_territory", "sponsor_name");
    
    Scanner yesOrNo = new Scanner(System.in);
    System.out.print("Please enter 'yes' if you'd like to start this application: ");
    String answer = yesOrNo.nextLine().toLowerCase();
    
    while(answer.equals("yes")){
      Scanner sc = new Scanner(System.in);
      System.out.print("Please enter the spelled out name of a State (for example, \"Georgia\"): ");
      String state = sc.nextLine();
      
      System.out.println("Congressmen and women from " + state + " proposed " + findNumByState(allAmend, state) + " amendments.");
      System.out.println(mostRecentProposal(allAmend, state));
      
      System.out.print("\nWould you like to check another State? Please enter 'yes' or 'no': ");
      Scanner repeatOrNot = new Scanner(System.in);
      String toRepeat = repeatOrNot.nextLine().toLowerCase();
      if (toRepeat.equals("no"))
        break;
    }
    System.out.println("Goodbye");
  }
}