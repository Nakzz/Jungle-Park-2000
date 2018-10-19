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
 * This a Button that removes all the Animals from the park extends from Button class
 * 
 * @author: Ajmain Naqib
 * @email: naqib@wisc.edu
 *
 */

public class ClearButton extends Button {
 
  /**
   * Creates a new Button object positioned at a given position of the display window and initializes
   * its instance fields
   * 
   * @param type of the object
   * @param positionX x-coordinate of the button object in the display window
   * @param positionY y-coordinate of the button object in the display window
   * @param park PApplet object that represents the display window
   */
  
public ClearButton(float x, float y, JunglePark park) {
    super(x, y, park); // calls super class with position and the park reference
    this.label = "Clear Park"; // Sets label of the button
}
 
/**
 * Callback method called each time the user presses the mouse. Adds tiger or deer accordingly
 */

@Override
public void mousePressed() {
  
//  ArrayList<ParkGUI> guiObjects = processing.listGUI;
//  boolean animalExists = true;
//  int buttonObjects =0;
//  
  if (isMouseOver()) {
    
    processing.clear(); // Calls the method that removes all the animals
    
//    while(animalExists) {
//      for (int i = 0; i < guiObjects.size(); i++) {
//        if (guiObjects.get(i) instanceof Animal) {
//          guiObjects.remove(guiObjects.get(i));
//        }
//      }
//      
//      for(ParkGUI guiObject : guiObjects) {
//        if (!(guiObject instanceof Animal)) {
//          buttonObjects++;
//        }
//      }
//      
//      
//      if((guiObjects.size() - buttonObjects) == 0) {
//        animalExists= false;}
//      else {
//        buttonObjects =0;
//      }
//    } 
    
  }
}
}