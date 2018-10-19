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


import java.util.ArrayList;


/**
 * This class represents a Deer in the JunglePark application
 * 
 * @author: Ajmain Naqib
 * @email: naqib@wisc.edu
 *
 */

public class Deer extends Animal {
  private static final int SCAN_RANGE = 175; // scan range area to check for a threat in the neighborhood
  private static final String IMAGE_FILE_NAME = "images/deer.png";
  private static int nextID = 1; // class variable that represents the identifier of the next deer
                                 // to be created

  private static final String TYPE = "DR"; // A String that represents the deer type
  private final int id; // Deer's id: positive number that represents the order of the deer


  /**
   * Creates a new Tiger object positioned at a random position of the display window and initializes
   * its instance fields
   * 
   * @param processing PApplet object that represents the display window
   */
  public Deer(JunglePark processing) {
    // Set Deer drawing parameters
    super(processing, IMAGE_FILE_NAME);

    // Set Deer identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies the current tiger
    nextID++;
  }


  /**
   * Checks if there is a threat (a Tiger for instance) at the neighborhood
   * 
   * @param scanRange is an integer that represents the range of the area to be scanned around the
   *        animal
   * @return deer if within range, null otherwise
   */

  public boolean scanForThreat(int scanRange) {

    ArrayList<ParkGUI> guiObjects = processing.listGUI; // reference to GUI objects
    for (ParkGUI tiger : guiObjects) {
      if (tiger instanceof Tiger) // if object is a Tiger type
        if (((Tiger) tiger).isClose(this, scanRange)) { // if Tiger within range of the Tiger
          // System.out.println("Close Tiger found!: "+tiger);
          return true;
        }
    }

    return false;
  }


  /**
   * Deer's behavior in the Jungle Park Scans for threat at the neighborhood of the current Deer. If
   * the deer founds any Tiger at its proximity, it displays Threat! over it's head.
   */
  @Override
  public void action() {
    if (scanForThreat(SCAN_RANGE)) { // If within range of Tiger
      this.processing.fill(0); // specify font color: black
      this.processing.text("THREAT!", this.getPositionX(),
        this.getPositionY() - this.image.height / 2 - 4); // position of the text

    }
  }


}
