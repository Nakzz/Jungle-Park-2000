//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Jungle Park 200
// Files: JunglePark.java, ParkGUI.java, Animal.java, Button.java, Tiger.java,
// Deer.java, AddAnimalButton.java, ClearButton.java, JungleParkTests.java
// Course: CS300, Fall 2018
//
// Author: Ajmain Naqib
// Email: naqib@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:
// Partner Email:
// Partner Lecturer's Name:
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// __ Write-up states that pair programming is allowed for this assignment.
// __ We have both read and understand the course Pair Programming Policy.
// __ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: None
// Online Sources: None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


/**
 * This a Button that adds different Animal to the park extends from Button class
 * 
 * @author: Ajmain Naqib, Mouna Kacem
 * @email: naqib@wisc.edu
 *
 */

public class AddAnimalButton extends Button {

  private String type; // type of the animal to add

  /**
   * Creates a new Button object positioned at a given position of the display window and initializes
   * its instance fields
   * 
   * @param type of the object
   * @param positionX x-coordinate of the button object in the display window
   * @param positionY y-coordinate of the button object in the display window
   * @param park PApplet object that represents the display window
   */
  
  public AddAnimalButton(String type, float x, float y, JunglePark park) {
    super(x, y, park); // calls super class with position and the park reference
    this.type = type.toLowerCase();
    this.label = "Add " + type; // sets label of the button accordingly to type
  }

  /**
   * Callback method called each time the user presses the mouse. Adds tiger or deer accordingly
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      switch (type) {
        case "tiger":
          processing.listGUI.add(new Tiger(processing)); // Initializes new tiger object to the GUI objects
          break;
        case "deer":
          processing.listGUI.add(new Deer(processing));// Initializes new deer object to the GUI objects
          break;
      }
    }
  }
}
