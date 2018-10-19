import java.util.ArrayList;

public class ClearButton extends Button {
 
public ClearButton(float x, float y, JunglePark park) {
    super(x, y, park);
    this.label = "Clear Park";
}
 
@Override
public void mousePressed() {
  ArrayList<ParkGUI> guiObjects = processing.listGUI;
  boolean animalExists = true;
  int buttonObjects =0;
  
  if (isMouseOver()) {
    
    while(animalExists) {
      for (int i = 0; i < guiObjects.size(); i++) {
        if (guiObjects.get(i) instanceof Animal) {
          guiObjects.remove(guiObjects.get(i));
        }
      }
      
      for(ParkGUI guiObject : guiObjects) {
        if (!(guiObject instanceof Animal)) {
          buttonObjects++;
        }
      }
      
      
      if((guiObjects.size() - buttonObjects) == 0) {
        animalExists= false;}
      else {
        buttonObjects =0;
      }
    } 
    

    
//    for (ParkGUI animal : animals) {
//      if (animal instanceof Animal)
//        toEat = deer;
//    }
  }
}
}