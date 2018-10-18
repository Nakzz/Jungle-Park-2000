import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Naqib
 *
 */
public class Deer extends Animal{
  private static final int SCAN_RANGE = 175; // scan range area to check for a threat in the neighborhood
  private static final String IMAGE_FILE_NAME = "images/deer.png";
  private static int nextID = 1; // class variable that represents the identifier of the next deer
                                 // to be created
    
  private static final String TYPE = "DR"; // A String that represents the deer type
  private final int id; // Deer's id: positive number that represents the order of the deer
   
    
  // Constructor that creates a new Deer object positioned at a random position of the display window and and initializes its instance fields
  public Deer(JunglePark processing) { 
 // Set Deer drawing parameters
    super(processing, IMAGE_FILE_NAME);

    // Set Deer identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies the current tiger
    nextID++;
  }
   
  // Checks if there is a threat (a Tiger for instance) at the neighborhood
  // scanRange is an integer that represents the range of the area to be scanned around the animal
  //TODO: write method header
  public boolean scanForThreat(int scanRange) {
    
    ArrayList<ParkGUI> animals = processing.listGUI;
    for(ParkGUI tiger : animals) {
      if ( tiger instanceof Tiger) 
        if(((Tiger) tiger).isClose(this, scanRange)) {
//          System.out.println("Close Tiger found!: "+tiger);
          return true;
        }
    }
    
    return false;  }
   
   
  // Defines the behavior of a Deer object in the Jungle park
    @Override
  public void action() { 
      if(scanForThreat(SCAN_RANGE)) {   // If within range of Tiger
        this.processing.fill(0); // specify font color: black
        this.processing.text("THREAT!", this.getPositionX(), this.getPositionY() - this.image.height / 2 - 4);

      }
    }
    
    
    
}
