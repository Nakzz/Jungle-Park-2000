import java.util.ArrayList;

/**
 * File Header comes here
 */

/**
 * This class represents a Tiger in the JunglePark application
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

//    if(!this.isDragging()) {
//      this.mousePressed();
//    }
    
    ParkGUI food = scanForFood();

    if (food != null) {
//      this.mousePressed();
      hop((Deer) food);
    }
    
    if(deerEatenCount > 0)
      displayDeerEatenCount(); // display deerEatenCount
  }

  // Checks if there is a food (a deer for instance) at the neighborhood
  // TODO: write method header
  private ParkGUI scanForFood() {

    ArrayList<ParkGUI> animals = processing.listGUI;
    for (ParkGUI food : animals) {
      if (food instanceof Deer)
        if ((this).isClose((Deer) food, this.SCAN_RANGE)) {
//          System.out.println("Food found!: " + food);
          return food;
        }
    }

    return null;
  }

  /**
   * the tiger moves forward the position of food, and eats it. Make sure to release the mouse if it
   * is over the Tiger as it will take the position of food straight away. Make sure also to remove
   * the eaten food from the JunglePark (listGUI).
   * 
   * @param food
   * 
   * TODO: method header and implementation
   */
  public void hop(Deer food) {
    
    ParkGUI toEat = null;
    
    this.setPositionX(food.getPositionX());     // moves to x position of the food
    this.setPositionY(food.getPositionY());     // moves to y position of the food
    
    this.mouseReleased();   // mouse released
    
    ArrayList<ParkGUI> animals = processing.listGUI;
    for (ParkGUI deer : animals) {
      if (food.equals(deer))
        toEat = deer;
    }
    
    animals.remove(toEat);
    
    this.deerEatenCount++;
    

  }


  public int getDeerEatenCount() {
    return this.deerEatenCount;
  }
  
  public void displayDeerEatenCount() {
    this.processing.fill(0); // specify font color: black
    // display deerEatenCount on the top of the Tiger's image
    this.processing.text(deerEatenCount, this.getPositionX(), this.getPositionY() - this.image.height / 2 - 4);  
  }


}
