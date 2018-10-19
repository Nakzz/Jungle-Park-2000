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
 * This a super class for any Button that can be added to a PApplet application This class
 * implements the ParkGUI interface
 * 
 * @author: Ajmain Naqib, Mouna Kacem
 * @email: naqib@wisc.edu
 *
 */

public class Button implements ParkGUI {
  private static final int WIDTH = 85; // Width of the Button
  private static final int HEIGHT = 32; // Height of the Button
  protected JunglePark processing; // PApplet object where the button will be displayed
  private float[] position; // array storing x and y positions of the Button with respect to
                            // the display window
  protected String label; // text/label that represents the button

  /**
   * Creates a new Button object positioned at a given position of the display window and initializes
   * its instance fields
   * 
   * @param positionX x-coordinate of the button object in the display window
   * @param positionY y-coordinate of the button object in the display window
   * @param processing PApplet object that represents the display window
   */
  public Button(float x, float y, JunglePark processing) {
    this.processing = processing; // set the PApplet Object where the animal will be drawn
    this.position = new float[2]; // creates a float Array
    this.position[0] = x; // sets the x position of the button object
    this.position[1] = y; // sets the y position of the button object
    this.label = "Button"; // sets label of the object to Button
  }

  /**
   * Draws the button to the display window.
   */
  @Override
  public void draw() {
    this.processing.stroke(0);// set line value to black
    if (isMouseOver())
      processing.fill(100); // set the fill color to dark gray if the mouse is over the button
    else
      processing.fill(200); // set the fill color to light gray otherwise

    // draw the button (rectangle with a centered text)
    processing.rect(position[0] - WIDTH / 2.0f, position[1] - HEIGHT / 2.0f,
      position[0] + WIDTH / 2.0f, position[1] + HEIGHT / 2.0f);
    processing.fill(0); // set the fill color to black
    processing.text(label, position[0], position[1]); // display the text of the current button
  }

  /**
   * Callback method called each time the user presses the mouse. Print's a button was pressed
   */
  @Override
  public void mousePressed() {
    if (isMouseOver())
      System.out.println("A button was pressed.");
  }

  /**
   * Callback method called each time the mouse is released.
   */
  @Override
  public void mouseReleased() {}

  /**
   * Checks if the mouse is over the given button object
   * 
   * @return true if the mouse is over the given button object, false otherwise
   */
  @Override
  public boolean isMouseOver() {
    if (this.processing.mouseX > this.position[0] - WIDTH / 2
      && this.processing.mouseX < this.position[0] + WIDTH / 2
      && this.processing.mouseY > this.position[1] - HEIGHT / 2
      && this.processing.mouseY < this.position[1] + HEIGHT / 2)
      return true;
    return false;
  }
}
