import java.util.ArrayList;

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
 * This class represents a Tiger in the JunglePark application
 * 
 * @author: Ajmain Naqib, Mouna Kacem
 * @email: naqib@wisc.edu
 *
 */
public class Tiger extends Animal {
  private static final int SCAN_RANGE = 100; // range dimension for scanning the neighborhood for food
  private static final String IMAGE_FILE_NAME = "images/tiger.png";
  private static int nextID = 1; // class variable that represents the identifier of the next tiger
                                 // to be created
  // Tiger's identification fields
  private static final String TYPE = "TGR"; // A String that represents the tiger type
  private final int id; // Tiger's id: positive number that represents the order of the tiger
  private int deerEatenCount; // Number of Deers that the current tiger has eaten so far


  /**
   * Creates a new Tiger object positioned at a random position of the display window
   * and initializes its instance fields 
   * 
   * @param processing PApplet object that represents the display window
   */
  public Tiger(JunglePark processing) {
    // Set Tiger drawing parameters
    super(processing, IMAGE_FILE_NAME);

    // Set Tiger identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies the current tiger
    nextID++;
    this.deerEatenCount = 0; // initializes deerEatenCount to 0 for the current tiger
  }


  /**
   * Tiger's behavior in the Jungle Park Scans for food at the neighborhood of the current tiger. If
   * the Tiger founds any deer at its proximity, it hops on it, and eats it
   */
  @Override
  public void action() {

    ParkGUI food = scanForFood(); // Check's if any deer in range

    if (food != null) { // if food is available within range
      hop((Deer) food); // hops onto the food
    }

    if (deerEatenCount > 0)
      displayDeerEatenCount(); // display deerEatenCount
  }


  /**
   * Checks if there is a food (a deer for instance) at the neighborhood
   * 
   * @return deer if within range, null otherwise
   */

  private ParkGUI scanForFood() {

    ArrayList<ParkGUI> guiObjects = processing.listGUI; // reference to GUI objects
    for (ParkGUI food : guiObjects) {
      if (food instanceof Deer) // if object is a Deer type
        if ((this).isClose((Deer) food, Tiger.SCAN_RANGE)) { // if Deer within range of the Tiger
          // System.out.println("Food found!: " + food);
          return food;
        }
    }

    return null;
  }

  /**
   * The tiger moves forward the position of food, and "eats" it.
   * 
   * @param food
   */
  public void hop(Deer food) {

    ParkGUI toEat = null;

    this.setPositionX(food.getPositionX()); // moves to x position of the food
    this.setPositionY(food.getPositionY()); // moves to y position of the food

    this.mouseReleased(); // mouse released

    ArrayList<ParkGUI> guiObjects = processing.listGUI; // reference to GUI objects
    for (ParkGUI deer : guiObjects) { // itterates through objects
      if (food.equals(deer)) // if object is food
        toEat = deer; // reference to food that will be "eaten"
    }

    guiObjects.remove(toEat); // "eats" object

    this.deerEatenCount++; // increments number of deer eaten for this object


  }

  /**
   * Gets the number of Deer eaten for this Tiger object
   * 
   * @return number of Deer eaten
   */

  public int getDeerEatenCount() {
    return this.deerEatenCount;
  }

  public void displayDeerEatenCount() {
    this.processing.fill(0); // specify font color: black
    // display deerEatenCount on the top of the Tiger's image
    this.processing.text(deerEatenCount, this.getPositionX(),
      this.getPositionY() - this.image.height / 2 - 4);
  }


}
