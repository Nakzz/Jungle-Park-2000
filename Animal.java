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

import java.util.Random;

/**
 * This class represents an animal in the Jungle Park application It implements the interface
 * ParkGUI
 * 
 * @author: Ajmain Naqib, Mouna Kacem
 * @email: naqib@wisc.edu
 */
public class Animal implements ParkGUI {

  private static Random randGen = new Random(); // Generator of random numbers
  protected String label; // represents the animal's identifier
  // Fields defined to draw the animal in the application display window
  protected JunglePark processing; // PApplet object that represents the display window
  protected PImage image; // animal's image

  private float[] position; // animal's position in the display window
                            // Usage: position[0: x-coordinate, or 1: y-coordinate]
  private boolean isDragging; // indicates whether the animal is being dragged or not


  /**
   * Creates a new Animal object positioned at a given position of the display window
   * 
   * @param processing PApplet object that represents the display window
   * @param positionX x-coordinate of the animal's image in the display window
   * @param positionY y-coordinate of the animal's image in the display window
   * @param imageFileName filename of the animal image
   */
  public Animal(JunglePark processing, float positionX, float positionY, String imageFileName) {

    // Set Animal drawing parameters
    this.processing = processing; // set the PApplet Object where the animal will be drawn
    this.position = new float[] {positionX, positionY}; // sets the position of the animal object
    this.image = processing.loadImage(imageFileName);
    isDragging = false; // initially the animal is not dragging
  }

  /**
   * Creates a new Animal object positioned at a random position of the display window
   * 
   * @param processing PApplet object that represents the display window
   * @param imageFileName filename of the animal image
   */
  public Animal(JunglePark processing, String imageFileName) {
    this(processing, (float) randGen.nextInt(processing.width),
      Math.max((float) randGen.nextInt(processing.height), 100), imageFileName);
    // places Animal at random position within the range of the window
  }

  /**
   * Draws the animal to the display window. It sets also its position to the mouse position if the
   * tiger is being dragged (i.e. if its isDragging field is set to true).
   */
  @Override
  public void draw() {
    // if the tiger is dragging, set its position to the mouse position with respect to the display
    // window (processing) dimension
    if (this.isDragging) {
      if (this.processing.mouseX < 0) // mouse outside the screen
        this.position[0] = 0;
      else if (this.processing.mouseX > this.processing.width) // mouse outside the screen
        this.position[0] = this.processing.width;
      else
        this.position[0] = this.processing.mouseX;

      if (this.processing.mouseY < 0) // mouse outside the screen
        this.position[1] = 0;
      else if (this.processing.mouseY > this.processing.height) // mouse outside the screen
        this.position[1] = this.processing.height;
      else
        this.position[1] = this.processing.mouseY;
    }

    // draw the tiger at its current position
    this.processing.image(this.image, this.position[0], position[1]);
    // display label
    displayLabel();

  }


  /**
   * display's the Tiger object label on the application window screen
   */
  private void displayLabel() {
    this.processing.fill(0); // specify font color: black
    this.processing.text(label, this.position[0], this.position[1] + this.image.height / 2 + 4);// display
                                                                                                // label // text
  }

  /**
   * Checks if the mouse is over this tiger object
   * 
   * @return true if the mouse is over the given tiger object, false otherwise
   */
  @Override
  public boolean isMouseOver() {
    int tigerWidth = image.width; // image width
    int tigerHeight = image.height; // image height

    // checks if the mouse is over the tiger
    if (processing.mouseX > position[0] - tigerWidth / 2
      && processing.mouseX < position[0] + tigerWidth / 2
      && processing.mouseY > position[1] - tigerHeight / 2
      && processing.mouseY < position[1] + tigerHeight / 2) {
      return true;
    }
    return false;
  }

  /**
   * Callback method called each time the user presses the mouse. Set's object's dragging status to
   * true.
   */
  @Override
  public void mousePressed() {
    if (isMouseOver())
      isDragging = true;
  }

  /**
   * Callback method called each time the mouse is released Set's object's dragging status to false.
   */
  @Override
  public void mouseReleased() {
    isDragging = false;
  }

  /**
   * Returns the label of the object
   * 
   * @return the label that represents the animal's identifier
   */
  public String getLabel() {
    return label;
  }


  /**
   * Returns the label of the object
   * 
   * @return the image of type PImage of the animal's object
   */
  public PImage getImage() {
    return image;
  }


  /**
   * Returns X coordinate of the animal's position
   * 
   * @return the X coordinate of the animal's position
   */
  public float getPositionX() {
    return position[0];
  }

  /**
   * Returns Y coordinate of the animal's position
   * 
   * @return the Y coordinate of the animal position
   */
  public float getPositionY() {
    return position[1];
  }


  /**
   * Sets X coordinate of the animal's position
   * 
   * @param position the XPosition to set
   */
  public void setPositionX(float position) {
    this.position[0] = position;
  }

  /**
   * Sets Y coordinate of the animal's position
   * 
   * @param position the YPosition to set
   */
  public void setPositionY(float position) {
    this.position[1] = position;
  }

  /**
   * Returns the state of animal's dragging condition
   * 
   * @return true if the animal is being dragged, false otherwise
   */
  public boolean isDragging() {
    return isDragging;
  }

  /**
   * Computes the euclidean distance between the current animal and another one
   * 
   * @param otherAnimal reference to another animal
   * @return distance between the current animal and otherAnimal
   */
  public double distance(Animal otherAnimal) {
    return Math.sqrt(Math.pow(this.getPositionX() - otherAnimal.getPositionX(), 2)
      + Math.pow(this.getPositionY() - otherAnimal.getPositionY(), 2));
  }

  /**
   * Defines the behavior of the current animal in the jungle park
   */
  public void action() {
    // This method should be overridden by a subclasse
  }

  /**
   * Check's if otherAnimal is located within range distance around the current animal.
   * 
   * @param otherAnimal reference to another animal
   * @param range proximity range given
   * @return true if the animal is being within range, false otherwise
   * 
   */
  public boolean isClose(Animal otherAnimal, int range) {


    if (distance(otherAnimal) < range) // if within range
      return true;
    else
      return false;
  }

}
